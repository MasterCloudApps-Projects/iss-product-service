package es.urjc.code.products.application.dto;

public class QuestionDto {
	
    private String code;
    private int index;
    private String text;

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
