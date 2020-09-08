package es.urjc.code.products.init;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import es.urjc.code.products.infrastructure.adapter.repository.mongodb.ProductMongoRepository;

@Component
public class DataLoader implements ApplicationListener<ContextRefreshedEvent> {

	private final ProductMongoRepository productMongoRepository;

	@Autowired
	public DataLoader(ProductMongoRepository productMongoRepository) {
		this.productMongoRepository = productMongoRepository;
	}
	
	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {
        if (!productMongoRepository.findByCode("HSI").isPresent()) {
        	productMongoRepository.save(DemoProductsFactory.house());
        }
        
        if (!productMongoRepository.findByCode("TRI").isPresent()) {
        	productMongoRepository.save(DemoProductsFactory.travel());
        }

        if (!productMongoRepository.findByCode("FAI").isPresent()) {
        	productMongoRepository.save(DemoProductsFactory.farm());
        }

        if (!productMongoRepository.findByCode("CAR").isPresent()) {
        	productMongoRepository.save(DemoProductsFactory.car());
        }
		
	}

}
