package es.urjc.code.products.application.port.incoming;

import java.util.List;

import es.urjc.code.products.application.dto.ProductDto;

public interface ProductsUseCase {

	List<ProductDto> findAll();
	ProductDto get(String productCode);
}
