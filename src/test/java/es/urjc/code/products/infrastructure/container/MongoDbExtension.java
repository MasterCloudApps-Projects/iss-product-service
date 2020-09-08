package es.urjc.code.products.infrastructure.container;

import org.junit.jupiter.api.extension.AfterAllCallback;
import org.junit.jupiter.api.extension.BeforeAllCallback;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MongoDbExtension implements BeforeAllCallback, AfterAllCallback {

	private static final Logger logger = LoggerFactory.getLogger(MongoDbExtension.class);
    public static MongoDbContainer mongoDbContainer;

    @Override
    public void beforeAll(ExtensionContext context) {
        mongoDbContainer = new MongoDbContainer();
        logger.info("Starting MongoDb Container");
        mongoDbContainer.start();
        System.setProperty("MONGO_DB_HOST", mongoDbContainer.getContainerIpAddress());
        System.setProperty("MONGO_DB_PORT", String.valueOf(mongoDbContainer.getPort()));
        System.setProperty("MONGO_DB_NAME", "MDB");
        logger.info("Finished starting MongoDb Container");
    }

    @Override
    public void afterAll(ExtensionContext context) {
        logger.info("Stopping MongoDb Container");
        mongoDbContainer.stop();
        System.clearProperty("MONGO_DB_HOST");
        System.clearProperty("MONGO_DB_PORT");
        System.clearProperty("MONGO_DB_NAME");
        logger.info("Finished stopping MongoDb Container");
    }
}
