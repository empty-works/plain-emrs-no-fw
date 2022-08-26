package com.empty_works.plain_emrs.patient_choices;

public class PatientFormUnit {

	private String id;
	private String value;
	
	public PatientFormUnit(String id, String value) {
		
		this.id = id;
		this.value = value;
	}
	
	public String getId() {
		
		return id;
	}
	
	public String getValue() {
		
		return value;
	}
}
