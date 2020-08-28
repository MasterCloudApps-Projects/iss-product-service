package es.urjc.code.products.infrastructure.adapter.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.http.ResponseEntity;

import es.urjc.code.products.application.dto.ProductDto;
import es.urjc.code.products.application.port.incoming.FindAllProductsUseCase;
import es.urjc.code.products.application.port.incoming.GetProductUseCase;

public class ProductsControllerTest {
	
	private static final String CODE_CAR = "CAR";
	private GetProductUseCase getProductUseCase;
	private FindAllProductsUseCase findAllProductsUseCase;
	private ProductsController sut;

	@BeforeEach
	public void setUp() {
		this.getProductUseCase = Mockito.mock(GetProductUseCase.class);
		this.findAllProductsUseCase  = Mockito.mock(FindAllProductsUseCase.class);
		this.sut = new ProductsController(getProductUseCase, findAllProductsUseCase);
	}
	
	@Test
	public void shouldBeGetProductUseCase() {
		// given
		final var productDto = getProductDto();
		when(getProductUseCase.get(CODE_CAR)).thenReturn(productDto);
		// when
		ResponseEntity<ProductDto> response = sut.getProduct(CODE_CAR);
		// then
		verify(getProductUseCase).get(CODE_CAR);
		assertEquals(productDto, response.getBody());
	}

	@Test
	public void shouldBeFindAllProductsUseCase() {
		// given
	    final var productDtos = Arrays.asList(getProductDto());
	    when(findAllProductsUseCase.findAll()).thenReturn(productDtos);
		// when
	    ResponseEntity<List<ProductDto>> response  = sut.getProducts();
		// then
	    verify(findAllProductsUseCase).findAll();
		assertEquals(productDtos, response.getBody());
	}
	
	private ProductDto getProductDto() {
		return new ProductDto.Builder().withCode(CODE_CAR).build();
	}
}
