package es.urjc.code.products.infrastructure.adapter.mapper;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;

import es.urjc.code.products.application.domain.Choice;
import es.urjc.code.products.application.domain.ChoiceQuestion;
import es.urjc.code.products.application.domain.Cover;
import es.urjc.code.products.application.domain.NumericQuestion;
import es.urjc.code.products.application.domain.Product;
import es.urjc.code.products.application.domain.Question;

class ProductsAssemblerTest {

	@Test
	void shouldBeMapProductToProductDto() {
		final var product = getProduct();
		final var productDto = ProductsAssembler.map(product);
		assertEquals(product.getCode(), productDto.getCode());
		assertEquals(product.getName(), productDto.getName());
		assertEquals(product.getDescription(), productDto.getDescription());
		assertEquals(product.getImage(), productDto.getImage());
		assertEquals(product.getMaxNumberOfInsured(), productDto.getMaxNumberOfInsured());
		assertEquals(product.getIcon(), productDto.getIcon());
		assertEquals(product.getCovers().size(),productDto.getCovers().size());
		assertEquals(product.getQuestions().size(),productDto.getQuestions().size());
	}
	
	@Test
	void shouldBeMapListProductToListProductDto() {
		 final var products = Arrays.asList(getProduct());
		 final var productDtos = ProductsAssembler.map(products);
		 assertEquals(products.get(0).getCode(), productDtos.get(0).getCode());
			assertEquals(products.get(0).getName(), productDtos.get(0).getName());
			assertEquals(products.get(0).getDescription(), productDtos.get(0).getDescription());
			assertEquals(products.get(0).getImage(), productDtos.get(0).getImage());
			assertEquals(products.get(0).getMaxNumberOfInsured(), productDtos.get(0).getMaxNumberOfInsured());
			assertEquals(products.get(0).getIcon(), productDtos.get(0).getIcon());
			assertEquals(products.get(0).getCovers().size(),productDtos.get(0).getCovers().size());
			assertEquals(products.get(0).getQuestions().size(),productDtos.get(0).getQuestions().size());
	}
	
	private Product getProduct() {
		List<Cover> covers = Arrays.asList(
				new Cover.Builder().withCode("C1").withName("Luggage").withDescription("").withOptional(false)
						.withSumInsured(new BigDecimal("5000")).build(),
				new Cover.Builder().withCode("C2").withName("Illness").withDescription("").withOptional(false)
						.withSumInsured(new BigDecimal("5000")).build(),
				new Cover.Builder().withCode("C3").withName("Assistance").withDescription("").withOptional(true)
						.withSumInsured(null).build());

		List<Choice> choices = Arrays.asList(new Choice.Builder().withCode("EUR").withLabel("Europe").build(),
				new Choice.Builder().withCode("WORLD").withLabel("World").build(),
				new Choice.Builder().withCode("PL").withLabel("Poland").build());
		List<Question> questions = Arrays.asList(
				new ChoiceQuestion.Builder().withCode("DESTINATION").withIndex(1).withText("Destination")
						.withChoices(choices).build(),
				new NumericQuestion.Builder().withCode("NUM_OF_ADULTS").withIndex(2).withText("Number of adults")
						.build(),
				new NumericQuestion.Builder().withCode("NUM_OF_CHILDREN").withIndex(3).withText("Number of children")
						.build());

		Product p = new Product.Builder().withCode("TRI").withName("Safe Traveller").withImage("/static/travel.jpg")
				.withDescription("Travel insurance").withMaxNumberOfInsured(10).withIcon("plane").withCovers(covers)
				.withQuestions(questions).build();

		return p;
	}
}
