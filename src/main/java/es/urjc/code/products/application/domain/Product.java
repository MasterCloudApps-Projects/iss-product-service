package es.urjc.code.products.application.domain;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Document(collection = "product")
public class Product {
	
    @Id
	public String id;
    private String code;
    private String name;
    private String image;
    private String description;
    private List<Cover> covers= new ArrayList<>();
    private List<Question> questions= new ArrayList<>();
    private int maxNumberOfInsured;
    private String icon;
    
	public Product() {
		
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

	public List<Cover> getCovers() {
		return covers;
	}

	public List<Question> getQuestions() {
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

        if (!(o instanceof Product)) return false;

        Product that = (Product) o;

        return new EqualsBuilder()
        		.append(id, that.id) 
                .append(code, that.code)
                .append(name, that.name)
                .append(image, that.image)
                .append(description, that.description)
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
                .append(image)
                .append(description)
                .append(covers)
                .append(questions)
                .append(maxNumberOfInsured)
                .append(icon)
                .toHashCode();
    }
    
    public static final class Builder {

        private final Product object;

        public Builder() {
            object = new Product();
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

        public Builder withCovers(List<Cover> value) {
            object.covers = value;
            return this;
        }

        public Builder withQuestions(List<Question> value) {
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

        public Product build() {
            return object;
        }

    }
}
