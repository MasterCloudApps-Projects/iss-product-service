package es.urjc.code.products.init;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import es.urjc.code.products.infrastructure.adapter.repository.mongodb.ProductMongoRepository;

@Component
public class DataLoader implements ApplicationListener<ContextRefreshedEvent> {

	private final ProductMongoRepository springDataProductRepository;

	@Autowired
	public DataLoader(ProductMongoRepository springDataProductRepository) {
		this.springDataProductRepository = springDataProductRepository;
	}
	
	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {
        if (!springDataProductRepository.findById("HSI").isPresent()) {
        	springDataProductRepository.save(DemoProductsFactory.house());
        }
        
        if (!springDataProductRepository.findById("TRI").isPresent()) {
        	springDataProductRepository.save(DemoProductsFactory.travel());
        }

        if (!springDataProductRepository.findById("FAI").isPresent()) {
        	springDataProductRepository.save(DemoProductsFactory.farm());
        }

        if (!springDataProductRepository.findById("CAR").isPresent()) {
        	springDataProductRepository.save(DemoProductsFactory.car());
        }
		
	}

}
