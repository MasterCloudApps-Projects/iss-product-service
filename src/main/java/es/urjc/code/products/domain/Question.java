package es.urjc.code.products.domain;

import org.bson.codecs.pojo.annotations.BsonDiscriminator;


@BsonDiscriminator
public class Question {
    private String code;
    private int index;
    private String text;

    public Question() {
    	
    }
    
    public Question(String code, int index, String text) {
        this.code = code;
        this.index = index;
        this.text = text;
    }

    public String getCode() {
        return code;
    }

    public int getIndex() {
        return index;
    }

    public String getText() {
        return text;
    }

	public void setCode(String code) {
		this.code = code;
	}

	public void setIndex(int index) {
		this.index = index;
	}

	public void setText(String text) {
		this.text = text;
	}
    
}
