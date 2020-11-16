package es.urjc.code.products.infrastructure.adapter.controller;

import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.testcontainers.containers.Network;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

@Testcontainers
public class AbstractContainerIntegrationTest {
	
    @Container
    private static final MongoDbContainer mongoDBContainer = new MongoDbContainer();

    @DynamicPropertySource
    private static void mongoDBProperties(final DynamicPropertyRegistry registry) {
    	
        Network network = Network.SHARED;
        
        // MongoDb
        mongoDBContainer.withNetwork(network).withNetworkAliases("mongodb");
        mongoDBContainer.start();
        
        registry.add("spring.data.mongodb.uri", mongoDBContainer::getUri);
    }
    
	@BeforeAll
	static void setUpAll() {
		if (!mongoDBContainer.isRunning()) {
			mongoDBContainer.start();
		}

	}
	
	@Test
	void shouldBeRunning() {
		assertTrue(mongoDBContainer.isRunning());
	}
}
