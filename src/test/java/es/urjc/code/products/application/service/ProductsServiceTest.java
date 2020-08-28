package es.urjc.code.products.application.service;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Arrays;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import es.urjc.code.products.application.domain.Product;
import es.urjc.code.products.application.port.outgoing.LoadProductPort;

public class ProductsServiceTest {

	private static final String CODE_CAR = "CAR";
	private LoadProductPort loadProductPort;
	private ProductsService sut;
	
	@BeforeEach
	public void setUp() {
		this.loadProductPort = Mockito.mock(LoadProductPort.class);
		this.sut = new ProductsService(loadProductPort);
	}
	
	@Test
	void shouldBeGetProduct() {
		// given
		final var product = getProduct();
		when(loadProductPort.get(CODE_CAR)).thenReturn(product);
		// when
		final var result = this.sut.get(CODE_CAR);
		// then
		verify(loadProductPort).get(CODE_CAR);
		assertEquals(CODE_CAR,result.getCode());
	}

	@Test
	void shouldBeGetAllProducts() {
		// given
	    final var products = Arrays.asList(getProduct());
	    when(loadProductPort.findAll()).thenReturn(products);
	    // when
	 	final var result = this.sut.findAll();
	    // then
	 	verify(loadProductPort).findAll();
	 	assertTrue(1==result.size());
	}

	private Product getProduct() {
		return new Product.Builder().withCode(CODE_CAR).build();
	}
}
