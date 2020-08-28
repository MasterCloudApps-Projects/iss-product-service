package es.urjc.code.products.application.dto;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

public class DateQuestionDto extends QuestionDto {
	
	
    public DateQuestionDto() {
	
	}

	private DateQuestionDto(final Builder builder) {
    	setCode(builder.code);
        setIndex(builder.index);
        setText(builder.text);
    }

    public static Builder builder() {
        return new Builder();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (!(o instanceof DateQuestionDto)) return false;

        DateQuestionDto that = (DateQuestionDto) o;

        return new EqualsBuilder()
                .append(getCode(), that.getCode())
                .append(getIndex(), that.getIndex())
                .append(getText(), that.getText())
                .isEquals();
    }


    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .append(getCode())
                .append(getIndex())
                .append(getText())
                .toHashCode();
    }
            
    public static final class Builder {

        private String code;
        private int index;
        private String text;        

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

        public DateQuestionDto build() {
            return new DateQuestionDto(this);
        }
    }
    
}
