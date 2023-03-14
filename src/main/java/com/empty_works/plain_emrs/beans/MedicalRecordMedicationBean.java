package com.empty_works.plain_emrs.beans;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class MedicalRecordMedicationBean implements MedicalRecordInterface, BeanDaoInterface {

	private String medicalRecordId;
	@Override
	public String getWriteQuery() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getErrorMessage() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int prepareStatments(PreparedStatement preparedStatement) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
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
