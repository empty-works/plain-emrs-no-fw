package com.empty_works.plain_emrs.beans;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import com.empty_works.plain_emrs.patient_choices.MedicalRecordDiseaseUnit;

public class DiseasesBean implements BeanDaoInterface {

	private String medicalRecordId;
	private List<MedicalRecordDiseaseUnit> diseases;

	public String getMedicalRecordId() {
		return medicalRecordId;
	}
	public void setMedicalRecordId(String medicalRecordId) {
		this.medicalRecordId = medicalRecordId;
	}
	public List<MedicalRecordDiseaseUnit> getDiseases() {
		return diseases;
	}
	public void setDiseases(List<MedicalRecordDiseaseUnit> diseases) {
		this.diseases = diseases;
	}
	@Override
	public String getQuery() {
		return "insert into diseases(medical_record_id, disease, contracted_disease, received_immunization) "
				+ "values (?,?,?,?)";
	}
	@Override
	public String getErrorMessage() {
		return "Could not add disease data into the database!";
	}
	@Override
	public int prepareStatments(PreparedStatement preparedStatement) throws SQLException {

		for(int i = 0; i < diseases.size(); i++) {
			
			preparedStatement.setString(1, medicalRecordId);
			preparedStatement.setString(2, diseases.get(i).getDiseaseName());
			preparedStatement.setBoolean(3, diseases.get(i).isContractedDisease());
			preparedStatement.setBoolean(4, diseases.get(i).isImmunized());
			preparedStatement.addBatch();
		}
		return preparedStatement.executeBatch()[0];
	}
}