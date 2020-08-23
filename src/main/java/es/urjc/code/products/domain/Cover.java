package es.urjc.code.products.domain;

import java.math.BigDecimal;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.bson.codecs.pojo.annotations.BsonCreator;
import org.bson.codecs.pojo.annotations.BsonProperty;

public class Cover {
	
    private String code;
    private String name;
    private String description;
    private boolean optional;
    private BigDecimal sumInsured;

    public Cover() {
    	
    }
    
    @BsonCreator
    public Cover(
            @BsonProperty("code") String code,
            @BsonProperty("name") String name,
            @BsonProperty("description") String description,
            @BsonProperty("optional") boolean optional,
            @BsonProperty("sumInsured") BigDecimal sumInsured) {
        this.code = code;
        this.name = name;
        this.description = description;
        this.optional = optional;
        this.sumInsured = sumInsured;
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

        if (!(o instanceof Cover)) return false;

        Cover that = (Cover) o;

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

        private final Cover object;

        public Builder() {
            object = new Cover();
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

        public Cover build() {
            return object;
        }

    }
    
}
