package es.urjc.code.products.application.domain;

import java.util.Arrays;
import java.util.List;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;


public class ChoiceQuestion extends Question {
	
    private List<Choice> choices;

    public ChoiceQuestion() {
	}

	private ChoiceQuestion(final Builder builder) {
    	setCode(builder.code);
        setIndex(builder.index);
        setText(builder.text);
        this.choices = builder.choices;
    }
    
    public static List<Choice> yesNoChoice() {
        return Arrays.asList(
                new Choice.Builder().withCode("YES").withLabel("Yes").build(),
                new Choice.Builder().withCode("NO").withLabel("No").build()
        );
    }

    public List<Choice> getChoices() {
        return choices;
    }
    
    public static Builder builder() {
        return new Builder();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (!(o instanceof ChoiceQuestion)) return false;

        ChoiceQuestion that = (ChoiceQuestion) o;

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
        private List<Choice> choices;

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

        public Builder withChoices(List<Choice> value) {
        	this.choices = value;
            return this;
        }
        
        public ChoiceQuestion build() {
            return new ChoiceQuestion(this);
        }
    }
    
}
