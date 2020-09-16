package es.urjc.code.products.application.dto;

import io.swagger.v3.oas.annotations.media.Schema;

public class QuestionDto {
	
	@Schema(description = "Question code.", example = "NUM_OF_CLAIM", required = true)
    private String code;
	@Schema(description = "Question index.", example = "1", required = true)
    private int index;
	@Schema(description = "Question text.", example = "Number of claims in last 5 years", required = true)
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
