package es.urjc.code.products.domain;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.bson.codecs.pojo.annotations.BsonCreator;
import org.bson.codecs.pojo.annotations.BsonProperty;


public class NumericQuestion extends Question {
	
    private NumericQuestion(final Builder builder) {
    	setCode(builder.code);
        setIndex(builder.index);
        setText(builder.text);
    }

	public NumericQuestion() {
		super();
	}
	
    @BsonCreator
    public NumericQuestion(@BsonProperty("code") String code,
                           @BsonProperty("index") int index,
                           @BsonProperty("text") String text) {
        super(code, index, text);
    }
    
    public static Builder builder() {
        return new Builder();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (!(o instanceof NumericQuestion)) return false;

        NumericQuestion that = (NumericQuestion) o;

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

    }    
}
