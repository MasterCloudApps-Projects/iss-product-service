package es.urjc.code.products.application.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import es.urjc.code.products.application.dto.ProductDto;
import es.urjc.code.products.application.port.incoming.FindAllProductsUseCase;
import es.urjc.code.products.application.port.incoming.GetProductUseCase;
import es.urjc.code.products.application.port.outgoing.LoadProductPort;
import es.urjc.code.products.infrastructure.adapter.mapper.ProductsAssembler;


@Service
@Transactional
public class ProductsService implements GetProductUseCase, FindAllProductsUseCase {
	
	private final LoadProductPort loadProductPort;
	
	@Autowired
	public ProductsService(LoadProductPort loadProductPort) {
		this.loadProductPort = loadProductPort;
	}

	@Override
	public ProductDto get(String productCode) {
		return ProductsAssembler.map(loadProductPort.get(productCode));
	}

	@Override
	public List<ProductDto> findAll() {
		return ProductsAssembler.map(loadProductPort.findAll());
	}

}
