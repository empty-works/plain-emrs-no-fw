package com.empty_works.plain_emrs.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.empty_works.plain_emrs.beans.MedicalRecordAppointmentsBean;
import com.empty_works.plain_emrs.util.ConnectionUtil;

public class MedicalRecordAppointmentsDao {

	public static List<MedicalRecordAppointmentsBean> get(String medicalRecordId) throws SQLException {
		
		List<MedicalRecordAppointmentsBean> appointments = new ArrayList<>();
		String query = "SELECT appointment_id, appointment_title, appointment_date, "
				+ "appointment_description "
				+ "FROM appointments "
				+ "WHERE medical_record_id=?";
		
		try(Connection con = ConnectionUtil.getConnection()) {
			
			try(PreparedStatement preparedStatement = con.prepareStatement(query)) {
				
				preparedStatement.setString(1, medicalRecordId);
				ResultSet rs = preparedStatement.executeQuery();
				while(rs.next()) {
					MedicalRecordAppointmentsBean appointment = new MedicalRecordAppointmentsBean();
					appointment.setAppointmentId(rs.getInt("appointment_id"));
					appointment.setTitle(rs.getString("appointment_title"));
					appointment.setDate(rs.getObject("appointment_date", LocalDateTime.class));
					appointment.setDescription(rs.getString("appointment_description"));
					appointments.add(appointment);
				}
			}
		}
		return appointments;
	}
	
	public static String add(MedicalRecordAppointmentsBean appointment) throws SQLException {
		
		String query = "INSERT INTO appointments(medical_record_id, appointment_title, "
				+ "appointment_date, appointment_description) "
				+ "VALUES (?,?,?,?)";
		
		int success = 0;
		try(Connection con = ConnectionUtil.getConnection()) {
			
			try(PreparedStatement preparedStatement = con.prepareStatement(query)) {
				
				preparedStatement.setString(1, appointment.getMedicalRecordId());
				preparedStatement.setString(2, appointment.getTitle());
				preparedStatement.setTimestamp(3, java.sql.Timestamp.valueOf(appointment.getDate()));
				preparedStatement.setString(4, appointment.getDescription());
				success = preparedStatement.executeUpdate();
			}
		}
		if(success == 0) {
			return "Could not add to the appointments table!";
		}
		return "Successfully added to the appointments table!";
	}
}
