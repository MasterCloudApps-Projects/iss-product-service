package es.urjc.code.products.infrastructure.adapter.repository.mongodb;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import es.urjc.code.products.application.domain.Product;

@Repository
public interface ProductMongoRepository extends MongoRepository<Product, String> {

	public Optional<Product> findByCode(String code);
}
