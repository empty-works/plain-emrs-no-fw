package com.empty_works.plain_emrs.patient_choices;

public class PatientDiseaseUnit {

	private String diseaseId;
	private String diseaseName;
	
	public PatientDiseaseUnit(String diseaseId, String diseaseName) {
		
		this.diseaseId = diseaseId;
		this.diseaseName = diseaseName;
	}

	public String getDiseaseId() {
		return diseaseId;
	}
	public String getDiseaseName() {
		return diseaseName;
	}
}
