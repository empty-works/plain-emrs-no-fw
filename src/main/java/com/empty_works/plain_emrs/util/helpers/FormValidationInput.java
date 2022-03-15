package com.empty_works.plain_emrs.util.helpers;

public class FormValidationInput {

	private String input;
	private FormValidationType type;
	
	public FormValidationInput(String input, FormValidationType type) {
		
		this.input = input;
		this.type = type;
	}

	public String getInput() {
		return input;
	}

	public FormValidationType getType() {
		return type;
	}
}
