package es.urjc.code.products.infrastructure.adapter.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import es.urjc.code.products.application.dto.ProductDto;
import es.urjc.code.products.application.port.incoming.ProductsUseCase;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@Tag(name = "product", description = "the Product catalog API")
public class ProductsController {

	private final ProductsUseCase productsUseCase;

	@Autowired
	public ProductsController(ProductsUseCase productsUseCase) {
		this.productsUseCase = productsUseCase;
	}

	@Operation(summary = "Find product by code", description = "Returns a single product", tags = { "product" })
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "successful operation", content = @Content(schema = @Schema(implementation = ProductDto.class))),

			@ApiResponse(responseCode = "404", description = "Product not found") })
	@GetMapping("/api/v1/products/{productCode}")
	public ResponseEntity<ProductDto> getProduct(
			@Parameter(description = "code of the product to be obtained. Cannot be empty.", required = true) @PathVariable("productCode") String productCode) {
		return ResponseEntity.status(HttpStatus.OK).body(productsUseCase.get(productCode));
	}

	@Operation(summary = "Find products", description = "Get all products in catalog", tags = { "product" })
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "successful operation", content = @Content(array = @ArraySchema(schema = @Schema(implementation = ProductDto.class)))) })
	@GetMapping("/api/v1/products")
	public ResponseEntity<List<ProductDto>> getProducts() {
		return ResponseEntity.status(HttpStatus.OK).body(productsUseCase.findAll());
	}
}
