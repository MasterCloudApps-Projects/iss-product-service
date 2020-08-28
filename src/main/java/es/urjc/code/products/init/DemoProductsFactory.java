package es.urjc.code.products.init;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

import es.urjc.code.products.application.domain.Choice;
import es.urjc.code.products.application.domain.ChoiceQuestion;
import es.urjc.code.products.application.domain.Cover;
import es.urjc.code.products.application.domain.NumericQuestion;
import es.urjc.code.products.application.domain.Product;
import es.urjc.code.products.application.domain.Question;

public class DemoProductsFactory {

	private DemoProductsFactory() {
	}

	static Product travel() {

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

	static Product house() {

		List<Cover> covers = Arrays.asList(
				new Cover.Builder().withCode("C1").withName("Fire").withDescription("").withOptional(false)
						.withSumInsured(new BigDecimal("200000")).build(),
				new Cover.Builder().withCode("C2").withName("Flood").withDescription("").withOptional(false)
						.withSumInsured(new BigDecimal("100000")).build(),
				new Cover.Builder().withCode("C3").withName("Theft").withDescription("").withOptional(false)
						.withSumInsured(new BigDecimal("50000")).build(),
				new Cover.Builder().withCode("C4").withName("Assistance").withDescription("").withOptional(true)
						.withSumInsured(null).build());

		List<Choice> choices = Arrays.asList(new Choice.Builder().withCode("APT").withLabel("Apartment").build(),
				new Choice.Builder().withCode("HOUSE").withLabel("House").build());

		List<Question> questions = Arrays.asList(
				new ChoiceQuestion.Builder().withCode("TYP").withIndex(1).withText("Apartment / House")
						.withChoices(choices).build(),
				new NumericQuestion.Builder().withCode("AREA").withIndex(2).withText("Area").build(),
				new NumericQuestion.Builder().withCode("NUM_OF_CLAIM").withIndex(3)
						.withText("Number of claims in last 5 years").build(),
				new ChoiceQuestion.Builder().withCode("FLOOD").withIndex(4).withText("Located in flood risk area")
						.withChoices(ChoiceQuestion.yesNoChoice()).build());

		Product p = new Product.Builder().withCode("HSI").withName("Happy House").withImage("/static/house.jpg")
				.withDescription("House insurance").withMaxNumberOfInsured(5).withIcon("building").withCovers(covers)
				.withQuestions(questions).build();

		return p;
	}

	static Product farm() {

		List<Cover> covers = Arrays.asList(
				new Cover.Builder().withCode("C1").withName("Crops").withDescription("").withOptional(false)
						.withSumInsured(new BigDecimal("200000")).build(),
				new Cover.Builder().withCode("C2").withName("Flood").withDescription("").withOptional(false)
						.withSumInsured(new BigDecimal("100000")).build(),
				new Cover.Builder().withCode("C3").withName("Fire").withDescription("").withOptional(false)
						.withSumInsured(new BigDecimal("50000")).build(),
				new Cover.Builder().withCode("C4").withName("Equipment").withDescription("").withOptional(true)
						.withSumInsured(new BigDecimal("300000")).build());

		List<Choice> choices = Arrays.asList(new Choice.Builder().withCode("ZB").withLabel("Crop").build(),
				new Choice.Builder().withCode("KW").withLabel("Vegetable").build());

		List<Question> questions = Arrays.asList(
				new ChoiceQuestion.Builder().withCode("TYP").withIndex(1).withText("Cultivation type")
						.withChoices(choices).build(),
				new NumericQuestion.Builder().withCode("AREA").withIndex(2).withText("Area").build(),
				new NumericQuestion.Builder().withCode("NUM_OF_CLAIM").withIndex(3)
						.withText("Number of claims in last 5 years").build(),
				new ChoiceQuestion.Builder().withCode("FLOOD").withIndex(4).withText("Located in flood risk area")
						.withChoices(ChoiceQuestion.yesNoChoice()).build());

		Product p = new Product.Builder().withCode("FAI").withName("Happy farm").withImage("/static/farm.jpg")
				.withDescription("Farm insurance").withMaxNumberOfInsured(1).withIcon("apple").withCovers(covers)
				.withQuestions(questions).build();

		return p;
	}

	static Product car() {

		List<Cover> covers = Arrays.asList(new Cover.Builder().withCode("C1").withName("Assistance").withDescription("")
				.withOptional(true).withSumInsured(null).build());
		List<Question> questions = Arrays.asList(new NumericQuestion.Builder().withCode("NUM_OF_CLAIM").withIndex(3)
				.withText("Number of claims in last 5 years").build());

		Product p = new Product.Builder().withCode("CAR").withName("Happy Driver").withImage("/static/car.jpg")
				.withDescription("Car insurance").withMaxNumberOfInsured(1).withIcon("car").withCovers(covers)
				.withQuestions(questions).build();

		return p;
	}
}
