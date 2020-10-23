package es.urjc.code.products.application.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.urjc.code.products.application.dto.ProductDto;
import es.urjc.code.products.application.port.incoming.ProductsUseCase;
import es.urjc.code.products.application.port.outgoing.LoadProductPort;
import es.urjc.code.products.infrastructure.adapter.mapper.ProductsAssembler;


@Service
public class ProductsService implements ProductsUseCase {
	
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
