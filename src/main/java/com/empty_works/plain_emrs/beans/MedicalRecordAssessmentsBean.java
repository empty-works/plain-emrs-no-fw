package com.empty_works.plain_emrs.beans;

public class MedicalRecordAssessmentsBean implements MedicalRecordInterface {

	private String medicalRecordId;
	private int assessmentId;
	private int chiefComplaintId;
	private String summation;
	
	public int getAssessmentId() {
		return assessmentId;
	}

	public void setAssessmentId(int assessmentId) {
		this.assessmentId = assessmentId;
	}

	public int getChiefComplaintId() {
		return chiefComplaintId;
	}

	public void setChiefComplaintId(int chiefComplaintId) {
		this.chiefComplaintId = chiefComplaintId;
	}

	public String getSummation() {
		return summation;
	}

	public void setSummation(String summation) {
		this.summation = summation;
	}

	@Override
	public void setMedicalRecordId(String medicalRecordId) {
		this.medicalRecordId = medicalRecordId;
	}

	@Override
	public String getMedicalRecordId() {
		return medicalRecordId;
	}
}
