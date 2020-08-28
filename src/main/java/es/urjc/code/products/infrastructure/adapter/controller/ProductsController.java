package es.urjc.code.products.infrastructure.adapter.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import es.urjc.code.products.application.dto.ProductDto;
import es.urjc.code.products.application.port.incoming.FindAllProductsUseCase;
import es.urjc.code.products.application.port.incoming.GetProductUseCase;

@RestController
public class ProductsController {

	private final GetProductUseCase getProductUseCase;
	private final FindAllProductsUseCase findAllProductsUseCase;
	
	@Autowired
	public ProductsController (GetProductUseCase getProductUseCase,FindAllProductsUseCase findAllProductsUseCase) {
		this.getProductUseCase = getProductUseCase;
		this.findAllProductsUseCase = findAllProductsUseCase;
	}
	
	@GetMapping("/api/v1/products/{productCode}")
	public ResponseEntity<ProductDto> getProduct(@PathVariable("productCode") String productCode) {
		return ResponseEntity.status(HttpStatus.OK).body(getProductUseCase.get(productCode));
	}
	
	@GetMapping("/api/v1/products")
	public ResponseEntity<List<ProductDto>> getProducts() {
		return ResponseEntity.status(HttpStatus.OK).body(findAllProductsUseCase.findAll());
	}
}
