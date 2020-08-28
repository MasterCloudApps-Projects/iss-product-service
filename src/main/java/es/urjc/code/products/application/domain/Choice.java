package es.urjc.code.products.application.domain;


import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

public class Choice {
	
    private String code;
    private String label;

    public Choice() {
	}

	public String getCode() {
        return code;
    }

    public String getLabel() {
        return label;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (!(o instanceof Choice)) return false;

        Choice that = (Choice) o;

        return new EqualsBuilder()
                .append(code, that.code)
                .append(label, that.label)
                .isEquals();
    }


    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .append(code)
                .append(label)
                .toHashCode();
    }
            
    
    public static final class Builder {

        private final Choice object;

        public Builder() {
            object = new Choice();
        }

        public Builder withCode(String value) {
            object.code = value;
            return this;
        }

        public Builder withLabel(String value) {
            object.label = value;
            return this;
        }

        public Choice build() {
            return object;
        }

    }

}
