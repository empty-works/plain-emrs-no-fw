package com.empty_works.plain_emrs.beans;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import com.empty_works.plain_emrs.patient_choices.MedicalRecordDiseaseUnit;

public class MedicalRecordDiseasesBean implements MedicalRecordInterface {

	private int diseaseId;
	private String medicalRecordId;
	private String disease;
	private boolean contractedDisease;
	private boolean receivedImmunization;
	private List<MedicalRecordDiseaseUnit> diseases;

	public int getDiseaseId() {
		return diseaseId;
	}
	public void setDiseaseId(int diseaseId) {
		this.diseaseId = diseaseId;
	}
	public String getMedicalRecordId() {
		return medicalRecordId;
	}
	public void setMedicalRecordId(String medicalRecordId) {
		this.medicalRecordId = medicalRecordId;
	}
	public String getDisease() {
		return disease;
	}
	public void setDisease(String disease) {
		this.disease = disease;
	}
	public boolean isContractedDisease() {
		return contractedDisease;
	}
	public void setContractedDisease(boolean contractedDisease) {
		this.contractedDisease = contractedDisease;
	}
	public boolean isReceivedImmunization() {
		return receivedImmunization;
	}
	public void setReceivedImmunization(boolean receivedImmunization) {
		this.receivedImmunization = receivedImmunization;
	}
	public void setDiseases(List<MedicalRecordDiseaseUnit> diseases) {
		this.diseases = diseases;
	}
	public List<MedicalRecordDiseaseUnit> getDiseases() {
		return diseases;
	}
}