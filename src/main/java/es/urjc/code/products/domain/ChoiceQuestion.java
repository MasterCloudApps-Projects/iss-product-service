package es.urjc.code.products.domain;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.bson.codecs.pojo.annotations.BsonCreator;
import org.bson.codecs.pojo.annotations.BsonProperty;

import java.util.Arrays;
import java.util.List;


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
    
    @BsonCreator
    public ChoiceQuestion(
            @BsonProperty("code") String code,
            @BsonProperty("index") int index,
            @BsonProperty("text") String text,
            @BsonProperty("choices") List<Choice> choices) {
        super(code, index, text);
        this.choices = choices;
    }

    public static List<Choice> yesNoChoice() {
        return Arrays.asList(
                new Choice("YES", "Yes"),
                new Choice("NO", "No")
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
    }
    
}
