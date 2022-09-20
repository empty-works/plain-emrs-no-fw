package com.empty_works.plain_emrs.patient_choices;

public class MedicalRecordDiseaseUnit {

	private String diseaseId;
	private String diseaseName;
	private boolean contractedDisease;
	private boolean isImmunized;
	
	public MedicalRecordDiseaseUnit(String diseaseId, String diseaseName) {
		
		this.diseaseId = diseaseId;
		this.diseaseName = diseaseName;
	}

	public String getDiseaseId() {
		return diseaseId;
	}
	public String getDiseaseName() {
		return diseaseName;
	}

	public boolean isContractedDisease() {
		return contractedDisease;
	}

	public void setContractedDisease(boolean contractedDisease) {
		this.contractedDisease = contractedDisease;
	}

	public boolean isImmunized() {
		return isImmunized;
	}

	public void setImmunized(boolean isImmunized) {
		this.isImmunized = isImmunized;
	}
}
