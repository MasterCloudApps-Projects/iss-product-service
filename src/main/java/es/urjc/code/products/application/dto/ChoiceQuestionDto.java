package es.urjc.code.products.application.dto;

import java.util.List;


public class ChoiceQuestionDto extends QuestionDto {
    private List<ChoiceDto> choices;

    public ChoiceQuestionDto(String code, int index, String text, List<ChoiceDto> choices) {
        super(code, index, text);
        this.choices = choices;
    }
}
