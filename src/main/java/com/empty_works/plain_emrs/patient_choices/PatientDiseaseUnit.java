package com.empty_works.plain_emrs.patient_choices;

public class PatientDiseaseUnit {

	private String diseaseId;
	private String diseaseName;
	private String diseaseImmunizedId;
	private String diseaseImmunizedName;
	
	public PatientDiseaseUnit(String diseaseId, String diseaseName) {
		
		this.diseaseId = diseaseId;
		this.diseaseName = diseaseName;
		this.diseaseImmunizedId = diseaseId + "Immunized";
		this.diseaseImmunizedName = diseaseName + "Immunized";
	}

	public String getDiseaseId() {
		return diseaseId;
	}
	public String getDiseaseName() {
		return diseaseName;
	}

	public String getDiseaseImmunizedId() {
		return diseaseImmunizedId;
	}

	public String getDiseaseImmunizedName() {
		return diseaseImmunizedName;
	}
}
