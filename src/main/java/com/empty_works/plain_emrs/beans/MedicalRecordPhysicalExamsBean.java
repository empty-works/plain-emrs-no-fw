package com.empty_works.plain_emrs.beans;

public class MedicalRecordPhysicalExamsBean implements MedicalRecordInterface {

	private int physicalExamId;
	private int chiefComplaintId;
	private String medicalRecordId;
	private String heent;
	private String respiratory;
	private String cardiovascular;
	private String abdominal;
	private String limbs;
	private String neurological;
	
	public int getPhysicalExamId() {
		return physicalExamId;
	}

	public void setPhysicalExamId(int physicalExamId) {
		this.physicalExamId = physicalExamId;
	}

	public int getChiefComplaintId() {
		return chiefComplaintId;
	}

	public void setChiefComplaintId(int chiefComplaintId) {
		this.chiefComplaintId = chiefComplaintId;
	}

	public String getHeent() {
		return heent;
	}

	public void setHeent(String heent) {
		this.heent = heent;
	}

	public String getRespiratory() {
		return respiratory;
	}

	public void setRespiratory(String respiratory) {
		this.respiratory = respiratory;
	}

	public String getCardiovascular() {
		return cardiovascular;
	}

	public void setCardiovascular(String cardiovascular) {
		this.cardiovascular = cardiovascular;
	}

	public String getAbdominal() {
		return abdominal;
	}

	public void setAbdominal(String abdominal) {
		this.abdominal = abdominal;
	}

	public String getLimbs() {
		return limbs;
	}

	public void setLimbs(String limbs) {
		this.limbs = limbs;
	}

	public String getNeurological() {
		return neurological;
	}

	public void setNeurological(String neurological) {
		this.neurological = neurological;
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
