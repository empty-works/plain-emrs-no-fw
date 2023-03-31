package com.empty_works.plain_emrs.beans;

public class MedicalRecordPlansBean implements MedicalRecordInterface {

	private int planId;
	private int chiefComplaintId;
	private String medicalRecordId;
	private String summation;
	
	public int getPlanId() {
		return planId;
	}

	public void setPlanId(int planId) {
		this.planId = planId;
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
