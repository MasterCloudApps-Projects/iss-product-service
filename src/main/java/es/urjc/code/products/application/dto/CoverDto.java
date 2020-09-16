package es.urjc.code.products.application.dto;

import java.math.BigDecimal;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import io.swagger.v3.oas.annotations.media.Schema;

public class CoverDto {
	
	@Schema(description = "Cover code.", example = "C1", required = true)
    private String code;
	@Schema(description = "Cover name.", example = "Assistance", required = true)
    private String name;
	@Schema(description = "Cover description.", required = false)
    private String description;
	@Schema(description = "Cover optional flag.", example = "true", required = true)
    private boolean optional;
	@Schema(description = "Cover sum insured.", example = "1", required = false)
    private BigDecimal sumInsured;
    
    public CoverDto() {
	}

	public String getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public boolean getOptional() {
        return optional;
    }

    public BigDecimal getSumInsured() {
        return sumInsured;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (!(o instanceof CoverDto)) return false;

        CoverDto that = (CoverDto) o;

        return new EqualsBuilder()
                .append(code, that.code)
                .append(name, that.name)
                .append(description, that.description)
                .append(optional, that.optional)
                .append(sumInsured, that.sumInsured)
                .isEquals();
    }


    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .append(code)
                .append(name)
                .append(description)
                .append(optional)
                .append(sumInsured)
                .toHashCode();
    }    
    
    public static final class Builder {

        private final CoverDto object;

        public Builder() {
            object = new CoverDto();
        }

        public Builder withCode(String value) {
            object.code = value;
            return this;
        }

        public Builder withName(String value) {
            object.name = value;
            return this;
        }

        public Builder withDescription(String value) {
            object.description = value;
            return this;
        }

        public Builder withOptional(boolean value) {
            object.optional = value;
            return this;
        }

        public Builder withSumInsured(BigDecimal value) {
            object.sumInsured = value;
            return this;
        }

        public CoverDto build() {
            return object;
        }

    }
}
