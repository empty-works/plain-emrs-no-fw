package com.empty_works.plain_emrs.beans;

import java.util.List;

import com.empty_works.plain_emrs.patient_choices.MedicalRecordRelationsUnit;

public class BloodRelationsBean {

	private List<MedicalRecordRelationsUnit> relations;
	private String fatherStatus, motherStatus;
	private int fathDecAge, mothDecAge;
	private String fathCauseDea, mothCauseDea;

	public List<MedicalRecordRelationsUnit> getRelations() {
		return relations;
	}

	public void setRelations(List<MedicalRecordRelationsUnit> relations) {
		this.relations = relations;
	}

	public String getFatherStatus() {
		return fatherStatus;
	}

	public void setFatherStatus(String fatherStatus) {
		this.fatherStatus = fatherStatus;
	}

	public String getMotherStatus() {
		return motherStatus;
	}

	public void setMotherStatus(String motherStatus) {
		this.motherStatus = motherStatus;
	}

	public int getFathDecAge() {
		return fathDecAge;
	}

	public void setFathDecAge(int fathDecAge) {
		this.fathDecAge = fathDecAge;
	}

	public int getMothDecAge() {
		return mothDecAge;
	}

	public void setMothDecAge(int mothDecAge) {
		this.mothDecAge = mothDecAge;
	}

	public String getFathCauseDea() {
		return fathCauseDea;
	}

	public void setFathCauseDea(String fathCauseDea) {
		this.fathCauseDea = fathCauseDea;
	}

	public String getMothCauseDea() {
		return mothCauseDea;
	}

	public void setMothCauseDea(String mothCauseDea) {
		this.mothCauseDea = mothCauseDea;
	}
}
