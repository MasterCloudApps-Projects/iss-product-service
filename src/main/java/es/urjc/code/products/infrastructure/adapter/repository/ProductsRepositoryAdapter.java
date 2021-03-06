package es.urjc.code.products.infrastructure.adapter.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import es.urjc.code.products.application.domain.Product;
import es.urjc.code.products.application.port.outgoing.LoadProductPort;
import es.urjc.code.products.exception.EntityNotFoundException;
import es.urjc.code.products.infrastructure.adapter.repository.mongodb.ProductMongoRepository;

@Service
@Transactional
public class ProductsRepositoryAdapter implements LoadProductPort {

	private final ProductMongoRepository productMongoRepository;
	
	@Autowired
	public ProductsRepositoryAdapter(ProductMongoRepository productMongoRepository) {
		this.productMongoRepository = productMongoRepository;
	}
	
	@Override
	public Product get(String productCode) {
		return productMongoRepository.findByCode(productCode).orElseThrow(()-> new EntityNotFoundException("Product not found. Looking for product with code: " + productCode));
	}

	@Override
	public List<Product> findAll() {
		return productMongoRepository.findAll();
	}

}
