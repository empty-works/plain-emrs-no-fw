package com.empty_works.plain_emrs.beans;

public class BloodRelationsBean implements PatientIdInterface {

	private String userId;
	private String medicalRecordId;
	private String fatherStatus, motherStatus;
	private int fathDecAge, mothDecAge;
	private String fathCauseDea, mothCauseDea;
	private int numSisters, numBrothers, numDaughters, numSons;

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getMedicalRecordId() {
		return medicalRecordId;
	}

	public void setMedicalRecordId(String medicalRecordId) {
		this.medicalRecordId = medicalRecordId;
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

	public int getNumSisters() {
		return numSisters;
	}

	public void setNumSisters(int numSisters) {
		this.numSisters = numSisters;
	}

	public int getNumBrothers() {
		return numBrothers;
	}

	public void setNumBrothers(int numBrothers) {
		this.numBrothers = numBrothers;
	}

	public int getNumDaughters() {
		return numDaughters;
	}

	public void setNumDaughters(int numDaughters) {
		this.numDaughters = numDaughters;
	}

	public int getNumSons() {
		return numSons;
	}

	public void setNumSons(int numSons) {
		this.numSons = numSons;
	}
}
