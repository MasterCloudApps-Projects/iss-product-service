package es.urjc.code.products.infrastructure.adapter.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.Optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import es.urjc.code.products.application.domain.Product;
import es.urjc.code.products.exception.EntityNotFoundException;
import es.urjc.code.products.infrastructure.adapter.repository.mongodb.ProductMongoRepository;

class ProductsRepositoryAdapterTest {
	
	private static final String CODE_CAR = "CAR";
	private static final String CODE_NOT_EXIST="FAKE_CODE";
	private ProductMongoRepository productMongoRepository;
	private ProductsRepositoryAdapter sut;
	
	@BeforeEach
	public void setUp() {
		this.productMongoRepository = Mockito.mock(ProductMongoRepository.class);
		this.sut = new ProductsRepositoryAdapter(productMongoRepository);
	}
	
	@Test
	void shouldBeReturnEntityNotFound() {
		// given
		when(productMongoRepository.findByCode(CODE_NOT_EXIST)).thenReturn(Optional.empty());
		
		Assertions.assertThrows(EntityNotFoundException.class, () -> {
		// when
		sut.get(CODE_NOT_EXIST);
		});
	}
	
	@Test
	void shouldBeReturnProduct() {
		// given
		final var product = getProduct();
		when(productMongoRepository.findByCode(CODE_CAR)).thenReturn(Optional.of(product));
		// when
		final var result = sut.get(CODE_CAR);
		// then
		verify(productMongoRepository).findByCode(CODE_CAR);
		assertEquals(CODE_CAR,result.getCode());
	}

	@Test
	void shouldBeReturnAllProduct() {
		// given
	    final var products = Arrays.asList(getProduct());
	    when(productMongoRepository.findAll()).thenReturn(products);
	    // when
	 	final var result = this.sut.findAll();
	    // then
	 	verify(productMongoRepository).findAll();
	 	assertEquals(1,result.size());
	 	assertEquals(CODE_CAR, result.get(0).getCode());
	}
	
	private Product getProduct() {
		return new Product.Builder().withCode(CODE_CAR).build();
	}
}
