package com.empty_works.plain_emrs.beans;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import com.empty_works.plain_emrs.patient_choices.MedicalRecordDiseaseUnit;

public class MedicalRecordDiseasesBean implements MedicalRecordInterface, BeanDaoInterface {

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
	@Override
	public String getWriteQuery() {
		return "INSERT INTO diseases(medical_record_id, disease, contracted_disease, received_immunization) "
				+ "values (?,?,?,?)";
	}
	@Override
	public String getWriteErrorMessage() {
		return "Could not add disease data into the database!";
	}
	@Override
	public int prepareWriteStatement(PreparedStatement preparedStatement) throws SQLException {

		if(diseases != null && diseases.size() > 0) {
			for(int i = 0; i < diseases.size(); i++) {
				
				preparedStatement.setString(1, medicalRecordId);
				preparedStatement.setString(2, diseases.get(i).getDiseaseName());
				preparedStatement.setBoolean(3, diseases.get(i).isContractedDisease());
				preparedStatement.setBoolean(4, diseases.get(i).isImmunized());
				preparedStatement.addBatch();
			}
			return preparedStatement.executeBatch()[0];
		}
		return 0;
	}
}