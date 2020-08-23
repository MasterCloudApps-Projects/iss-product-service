package es.urjc.code.products.application.dto;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

public class ChoiceDto {
	
    private String code;
    private String label;
    
    public String getCode() {
        return code;
    }

    public String getLabel() {
        return label;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (!(o instanceof ChoiceDto)) return false;

        ChoiceDto that = (ChoiceDto) o;

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

        private final ChoiceDto object;

        public Builder() {
            object = new ChoiceDto();
        }

        public Builder withCode(String value) {
            object.code = value;
            return this;
        }

        public Builder withLabel(String value) {
            object.label = value;
            return this;
        }

        public ChoiceDto build() {
            return object;
        }

    }
}
