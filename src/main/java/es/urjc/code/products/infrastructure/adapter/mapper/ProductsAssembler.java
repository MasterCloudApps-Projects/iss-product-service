package es.urjc.code.products.infrastructure.adapter.mapper;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import es.urjc.code.products.application.domain.Choice;
import es.urjc.code.products.application.domain.ChoiceQuestion;
import es.urjc.code.products.application.domain.Cover;
import es.urjc.code.products.application.domain.DateQuestion;
import es.urjc.code.products.application.domain.NumericQuestion;
import es.urjc.code.products.application.domain.Product;
import es.urjc.code.products.application.domain.Question;
import es.urjc.code.products.application.dto.ChoiceDto;
import es.urjc.code.products.application.dto.ChoiceQuestionDto;
import es.urjc.code.products.application.dto.CoverDto;
import es.urjc.code.products.application.dto.DateQuestionDto;
import es.urjc.code.products.application.dto.NumericQuestionDto;
import es.urjc.code.products.application.dto.ProductDto;
import es.urjc.code.products.application.dto.QuestionDto;

public final class ProductsAssembler {

	private ProductsAssembler() {

	}

	public static List<ProductDto> map(List<Product> products) {
		return products.stream().map(ProductsAssembler::map).collect(Collectors.toList());
	}

	public static ProductDto map(Product product) {
		return new ProductDto.Builder().withCode(product.getCode()).withName(product.getName())
				.withImage(product.getImage()).withDescription(product.getDescription()).withCovers(mapCovers(product))
				.withQuestions(mapQuestions(product)).withMaxNumberOfInsured(product.getMaxNumberOfInsured())
				.withIcon(product.getIcon()).build();
	}

	private static List<QuestionDto> mapQuestions(Product product) {
		return product.getQuestions().stream().map(ProductsAssembler::mapQuestion).collect(Collectors.toList());
	}

	private static List<CoverDto> mapCovers(Product product) {
		return product.getCovers().stream().map(ProductsAssembler::mapCover).collect(Collectors.toList());
	}

	private static CoverDto mapCover(Cover cover) {
		return new CoverDto.Builder().withCode(cover.getCode()).withName(cover.getName())
				.withDescription(cover.getDescription()).withOptional(cover.getOptional())
				.withSumInsured(cover.getSumInsured()).build();

	}

	private static QuestionDto mapQuestion(Question question) {
		QuestionDto dto = mapToNumericIfFit(question);

		dto = dto == null ? mapToDateIfFit(question) : dto;
		dto = dto == null ? mapToChoiceIfFit(question) : dto;

		return dto;
	}

	private static QuestionDto mapToChoiceIfFit(Question question) {
		if (!(question instanceof ChoiceQuestion))
			return null;

		return new ChoiceQuestionDto.Builder().withCode(question.getCode()).withIndex(question.getIndex())
				.withText(question.getText()).withChoices(mapChoices(question)).build();
	}

	private static List<ChoiceDto> mapChoices(Question question) {
		List<Choice> choices = ((ChoiceQuestion) question).getChoices();

		if (choices == null)
			return new ArrayList<>();

		return choices.stream().map(x -> new ChoiceDto.Builder().withCode(x.getCode()).withLabel(x.getLabel()).build())
				.collect(Collectors.toList());
	}

	private static QuestionDto mapToDateIfFit(Question question) {
		if (!(question instanceof DateQuestion))
			return null;

		return new DateQuestionDto.Builder().withCode(question.getCode()).withIndex(question.getIndex())
				.withText(question.getText()).build();
	}

	private static QuestionDto mapToNumericIfFit(Question question) {
		if (!(question instanceof NumericQuestion))
			return null;

		return new NumericQuestionDto.Builder().withCode(question.getCode()).withIndex(question.getIndex())
				.withText(question.getText()).build();
	}

}
