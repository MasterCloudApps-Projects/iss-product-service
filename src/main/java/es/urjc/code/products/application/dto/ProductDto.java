package es.urjc.code.products.application.dto;

import java.util.List;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

public class ProductDto {
	
	public String id;
    private String code;
    private String name;
    private String image;
    private String description;
    private List<CoverDto> covers;
    private List<QuestionDto> questions;
    private int maxNumberOfInsured;
    private String icon;

	public ProductDto() {
		
	}

	public String getId() {
		return id;
	}

	public String getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    public String getImage() {
        return image;
    }

    public String getDescription() {
        return description;
    }

    public List<CoverDto> getCovers() {
        return covers;
    }

    public List<QuestionDto> getQuestions() {
        return questions;
    }

    public int getMaxNumberOfInsured() {
        return maxNumberOfInsured;
    }

    public String getIcon() {
        return icon;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (!(o instanceof ProductDto)) return false;

        ProductDto that = (ProductDto) o;

        return new EqualsBuilder()
        		.append(id, that.id)
                .append(code, that.code)
                .append(name, that.name)
                .append(description, that.description)
                .append(image, that.image)
                .append(covers, that.covers)
                .append(questions, that.questions)
                .append(maxNumberOfInsured, that.maxNumberOfInsured)
                .append(icon, that.icon)
                .isEquals();
    }


    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
        		.append(id)
                .append(code)
                .append(name)
                .append(description)
                .append(image)
                .append(covers)
                .append(questions)
                .append(maxNumberOfInsured)
                .append(icon)
                .toHashCode();
    }
    
    public static final class Builder {

        private final ProductDto object;

        public Builder() {
            object = new ProductDto();
        }

        public Builder withId(String value) {
            object.id = value;
            return this;
        }

        
        public Builder withCode(String value) {
            object.code = value;
            return this;
        }

        public Builder withName(String value) {
            object.name = value;
            return this;
        }

        public Builder withImage(String value) {
            object.image = value;
            return this;
        }

        public Builder withDescription(String value) {
            object.description = value;
            return this;
        }

        public Builder withCovers(List<CoverDto> value) {
            object.covers = value;
            return this;
        }

        public Builder withQuestions(List<QuestionDto> value) {
            object.questions = value;
            return this;
        }

        public Builder withMaxNumberOfInsured(int value) {
            object.maxNumberOfInsured = value;
            return this;
        }

        public Builder withIcon(String value) {
            object.icon = value;
            return this;
        }

        public ProductDto build() {
            return object;
        }

    }
    
}
