package es.urjc.code.products.application.port.incoming;

import es.urjc.code.products.application.dto.ProductDto;

public interface GetProductUseCase {

	ProductDto get(String productCode);
}
