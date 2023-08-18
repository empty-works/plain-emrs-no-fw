package com.empty_works.plain_emrs.dao;

public class MedicalRecordDiseasesBean {

	private String diseaseId;
	private String diseaseName;
	
	public MedicalRecordDiseasesBean() {}
	
	public MedicalRecordDiseasesBean(String diseaseId, String diseaseName) {
		
		this.diseaseId = diseaseId;
		this.diseaseName = diseaseName;
	}

	public String getDiseaseId() {
		return diseaseId;
	}

	public void setDiseaseId(String diseaseId) {
		this.diseaseId = diseaseId;
	}

	public String getDiseaseName() {
		return diseaseName;
	}

	public void setDiseaseName(String diseaseName) {
		this.diseaseName = diseaseName;
	}
}
