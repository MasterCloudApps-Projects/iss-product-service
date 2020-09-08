package es.urjc.code.products.testdata;

import java.util.Arrays;
import java.util.List;

import es.urjc.code.products.application.domain.Cover;
import es.urjc.code.products.application.domain.NumericQuestion;
import es.urjc.code.products.application.domain.Product;
import es.urjc.code.products.application.domain.Question;

public class TestData {

	public static final String ICON = "car";
	public static final String DESCRIPTION = "Car insurance";
	public static final String IMAGE = "/static/car.jpg";
	public static final String NAME = "Happy Driver";
	public static final String CODE_CAR = "CAR";
	
	public static Product createProduct() {
		List<Cover> covers = Arrays.asList(new Cover.Builder().withCode("C1").withName("Assistance").withDescription("")
				.withOptional(true).withSumInsured(null).build());
		List<Question> questions = Arrays.asList(new NumericQuestion.Builder().withCode("NUM_OF_CLAIM").withIndex(3)
				.withText("Number of claims in last 5 years").build());

		var entity = new Product.Builder().withCode(CODE_CAR).withName(NAME).withImage(IMAGE)
				.withDescription(DESCRIPTION).withMaxNumberOfInsured(1).withIcon(ICON).withCovers(covers)
				.withQuestions(questions).build();
		
		return entity;
	}
}
