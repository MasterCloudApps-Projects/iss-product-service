package es.urjc.code.products.application.port.incoming;

import java.util.List;

import es.urjc.code.products.application.dto.ProductDto;

public interface FindAllProductsUseCase {

	List<ProductDto> findAll();
}
