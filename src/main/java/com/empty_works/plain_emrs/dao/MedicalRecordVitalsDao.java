package com.empty_works.plain_emrs.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.empty_works.plain_emrs.beans.MedicalRecordVitalsBean;
import com.empty_works.plain_emrs.util.ConnectionUtil;

public class MedicalRecordVitalsDao {

	public static List<MedicalRecordVitalsBean> get(String medicalRecordId) throws SQLException {
		
		List<MedicalRecordVitalsBean> vitalsBeans = new ArrayList<>();
		String query = "SELECT vitals_id, vitals_date_taken, vitals_height, vitals_weight, "
				+ "vitals_calculated_bmi, vitals_temperature, vitals_pulse, vitals_respiratory_rate, "
				+ "vitals_blood_pressure_systolic, vitals_blood_pressure_diastolic, "
				+ "vitals_arterial_blood_oxygen_saturation "
				+ "FROM vitals "
				+ "WHERE medical_record_id=?";
		
		try(Connection con = ConnectionUtil.getConnection()) {
			
			try(PreparedStatement preparedStatement = con.prepareStatement(query)) {
				
				preparedStatement.setString(1, medicalRecordId);
				System.out.println("Retrieving from the vitals table...");
				ResultSet rs = preparedStatement.executeQuery();
				while(rs.next()) {
					MedicalRecordVitalsBean vitalsBean = new MedicalRecordVitalsBean();
					vitalsBean.setVitalsId(rs.getInt("vitals_id"));
					vitalsBean.setDateTaken(rs.getObject("vitals_date_taken", LocalDateTime.class));
					vitalsBean.setHeight(rs.getInt("vitals_height"));
					vitalsBean.setWeight(rs.getInt("vitals_weight"));
					vitalsBean.setCalculatedBmi(rs.getInt("vitals_calculated_bmi"));
					vitalsBean.setTemperature(rs.getDouble("vitals_temperature"));
					vitalsBean.setPulse(rs.getInt("vitals_pulse"));
					vitalsBean.setRespiratoryRate(rs.getInt("vitals_respiratory_rate"));
					vitalsBean.setBloodPressureSystolic(rs.getInt("vitals_blood_pressure_systolic"));
					vitalsBean.setBloodPressureDiastolic(rs.getInt("vitals_blood_pressure_diastolic"));
					vitalsBean.setArterialBloodOxygenSaturation(rs.getInt("vitals_arterial_blood_oxygen_saturation"));
					vitalsBeans.add(vitalsBean);
				}
			}
		}
		return vitalsBeans;
	}
	
	public static String add(MedicalRecordVitalsBean vitalsBean) throws SQLException {
		
		String query = "INSERT INTO vitals(medical_record_id, vitals_date_taken, vitals_height, vitals_weight, "
				+ "vitals_calculated_bmi, vitals_temperature, vitals_pulse, vitals_respiratory_rate, "
				+ "vitals_blood_pressure_systolic, vitals_blood_pressure_diastolic, vitals_arterial_blood_oxygen_saturation) "
				+ "VALUES (?,?,?,?,?,?,?,?,?,?,?)";
		
		int success = 0;
		try(Connection con = ConnectionUtil.getConnection()) {
			
			try(PreparedStatement preparedStatement = con.prepareStatement(query)) {
				
				preparedStatement.setString(1, vitalsBean.getMedicalRecordId());
				preparedStatement.setTimestamp(2, java.sql.Timestamp.valueOf(vitalsBean.getDateTaken()));
				preparedStatement.setDouble(3, vitalsBean.getHeight());
				preparedStatement.setDouble(4, vitalsBean.getWeight());
				preparedStatement.setDouble(5, vitalsBean.getCalculatedBmi());
				preparedStatement.setDouble(6, vitalsBean.getTemperature());
				preparedStatement.setDouble(7, vitalsBean.getPulse());
				preparedStatement.setDouble(8, vitalsBean.getRespiratoryRate());
				preparedStatement.setDouble(9, vitalsBean.getBloodPressureSystolic());
				preparedStatement.setDouble(10, vitalsBean.getBloodPressureDiastolic());
				preparedStatement.setDouble(11, vitalsBean.getArterialBloodOxygenSaturation());
				success = preparedStatement.executeUpdate();
			}
		}
		if(success == 0) {
			return "Could not add to the vitals table!";
		}
		return "Successfully added to the vitals table!";
	}
}
