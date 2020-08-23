package es.urjc.code.products.domain;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.bson.codecs.pojo.annotations.BsonCreator;
import org.bson.codecs.pojo.annotations.BsonDiscriminator;
import org.bson.codecs.pojo.annotations.BsonProperty;


@BsonDiscriminator
public class Product {
	
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

	@BsonCreator
    public Product(
            @BsonProperty("code") String code,
            @BsonProperty("name") String name,
            @BsonProperty("image") String image,
            @BsonProperty("description") String description,
            @BsonProperty("covers") List<Cover> covers,
            @BsonProperty("questions") List<Question> questions,
            @BsonProperty("maxNumberOfInsured") int maxNumberOfInsured,
            @BsonProperty("icon") String icon) {
        this.code = code;
        this.name = name;
        this.image = image;
        this.description = description;
        this.covers = covers;
        this.questions = questions;
        this.maxNumberOfInsured = maxNumberOfInsured;
        this.icon = icon;
    }

    public void addCover(String code, String name, String description, boolean isOptional, BigDecimal sumInsured) {
        covers.add(new Cover(code, name, description, isOptional, sumInsured));
    }

    public void addQuestions(List<Question> questions) {
        if (this.questions == null) {
            this.questions = new ArrayList<>();
        }
        this.questions.addAll(questions);
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
