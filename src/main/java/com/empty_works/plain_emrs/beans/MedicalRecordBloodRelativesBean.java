package com.empty_works.plain_emrs.beans;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class MedicalRecordBloodRelativesBean implements MedicalRecordInterface, BeanDaoInterface {

	private int bloodRelativesId;
	private String medicalRecordId;
	private String fatherStatus, motherStatus;
	private int fathDecAge, mothDecAge;
	private String fathCauseDea, mothCauseDea;
	private int numSisters, numBrothers, numDaughters, numSons;

	public int getBloodRelativesId() {
		return bloodRelativesId;
	}

	public void setBloodRelativesId(int bloodRelativesId) {
		this.bloodRelativesId = bloodRelativesId;
	}

	@Override
	public String getMedicalRecordId() {
		return medicalRecordId;
	}

	@Override
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

	@Override
	public String getWriteQuery() {
		return "INSERT INTO blood_relatives(medical_record_id, mother_status, father_status, mother_deceased_age, father_deceased_age,"
				+ "num_sisters_alive, num_brothers_alive, num_daughters_alive, num_sons_alive, mother_cause_of_death, father_cause_of_death) "
				+ "values (?,?,?,?,?,?,?,?,?,?,?)";
	}

	@Override
	public String getErrorMessage() {
		return "Could not add blood relatives data to the database!";
	}

	@Override
	public int prepareStatments(PreparedStatement preparedStatement) throws SQLException {
		
		System.out.println("Mother status: " + getMotherStatus());
		System.out.println("Father status: " + getFatherStatus());
		System.out.println("Mother age: " + getMothDecAge());
		System.out.println("Father age: " + getFathDecAge());
		System.out.println("Num sisters: " + getNumSisters());
		System.out.println("Num brothers: " + getNumBrothers());
		System.out.println("Num daughters: " + getNumDaughters());
		System.out.println("Num sons: " + getNumSons());
		preparedStatement.setString(1, getMedicalRecordId());
		preparedStatement.setString(2, getMotherStatus());
		preparedStatement.setString(3, getFatherStatus());
		preparedStatement.setInt(4, getMothDecAge());
		preparedStatement.setInt(5, getFathDecAge());
		preparedStatement.setInt(6, getNumSisters());
		preparedStatement.setInt(7, getNumBrothers());
		preparedStatement.setInt(8, getNumDaughters());
		preparedStatement.setInt(9, getNumSons());
		preparedStatement.setString(10, getMothCauseDea());
		preparedStatement.setString(11, getFathCauseDea());
		return preparedStatement.executeUpdate();
	}
}
