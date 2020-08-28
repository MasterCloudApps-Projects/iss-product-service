package es.urjc.code.products.application.port.outgoing;

import java.util.List;

import es.urjc.code.products.application.domain.Product;

public interface LoadProductPort {

	Product get(String productCode);
	List<Product> findAll();
}
