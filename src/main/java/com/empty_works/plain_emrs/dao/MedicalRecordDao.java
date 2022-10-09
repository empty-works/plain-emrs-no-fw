package com.empty_works.plain_emrs.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.time.LocalDateTime;
import java.util.List;

import com.empty_works.plain_emrs.beans.MedicalRecordBean;
import com.empty_works.plain_emrs.patient_choices.MedicalRecordDiseaseUnit;
import com.empty_works.plain_emrs.patient_choices.MedicalRecordFamilyConditionUnit;
import com.empty_works.plain_emrs.patient_choices.MedicalRecordRelationsUnit;
import com.empty_works.plain_emrs.util.ConnectionUtil;

public class MedicalRecordDao {

	final public static String MEDICALRECORDDAO_SUCCESS = "Medical record successfully added!";
	
	public static String add(MedicalRecordBean medRecord) {
		
		String userId = medRecord.getUserId();
		String medicalRecordId = medRecord.getMedicalRecordId();
		String patientCondition = medRecord.getPatientCondition();
		String bloodTransfusionStatus = medRecord.getBloodTransfusionStatus();
		boolean isActive = medRecord.isActive();
		LocalDateTime recordCreated = medRecord.getDateCreated();
		List<MedicalRecordFamilyConditionUnit> conditions = medRecord.getConditions();
		
		Connection con = ConnectionUtil.getConnection();
		PreparedStatement preparedStatement = null;
		
		String query = "insert into ";
	}
}
