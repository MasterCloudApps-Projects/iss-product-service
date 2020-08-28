package es.urjc.code.products.application.dto;

import java.util.Arrays;
import java.util.List;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;


public class ChoiceQuestionDto extends QuestionDto {
	
    private List<ChoiceDto> choices;
    
    public ChoiceQuestionDto() {
    	
    }
    
    private ChoiceQuestionDto(final Builder builder) {
    	setCode(builder.code);
        setIndex(builder.index);
        setText(builder.text);
        this.choices = builder.choices;
    }
    
    public static List<ChoiceDto> yesNoChoice() {
        return Arrays.asList(
                new ChoiceDto.Builder().withCode("YES").withLabel("Yes").build(),
                new ChoiceDto.Builder().withCode("NO").withLabel("No").build()
        );
    }

    public List<ChoiceDto> getChoices() {
        return choices;
    }
    
    public static Builder builder() {
        return new Builder();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (!(o instanceof ChoiceQuestionDto)) return false;

        ChoiceQuestionDto that = (ChoiceQuestionDto) o;

        return new EqualsBuilder()
                .append(getCode(), that.getCode())
                .append(getIndex(), that.getIndex())
                .append(getText(), that.getText())
                .append(getChoices(), that.getChoices())
                .isEquals();
    }


    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .append(getCode())
                .append(getIndex())
                .append(getText())
                .append(getChoices())
                .toHashCode();
    }
            
    public static final class Builder {

        private String code;
        private int index;
        private String text;        
        private List<ChoiceDto> choices;

        public Builder withCode(String value) {
            this.code = value;
            return this;
        }

        public Builder withIndex(int value) {
            this.index = value;
            return this;
        }

        public Builder withText(String value) {
            this.text = value;
            return this;
        }

        public Builder withChoices(List<ChoiceDto> value) {
        	this.choices = value;
            return this;
        }
        
        public ChoiceQuestionDto build() {
            return new ChoiceQuestionDto(this);
        }
    }
    
}
