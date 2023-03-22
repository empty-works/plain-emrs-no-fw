package com.empty_works.plain_emrs.beans;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDateTime;

public class MedicalRecordVitalsBean implements MedicalRecordInterface, BeanDaoInterface{

	private String medicalRecordId;
	private int vitalsId;
	private LocalDateTime dateTaken;
	private int height;
	private int weight;
	private int calculatedBmi;
	private double temperature;
	private int pulse;
	private int respiratoryRate;
	private int bloodPressureSystolic;
	private int bloodPressureDiastolic;
	private int arterialBloodOxygenSaturation;
	
	public int getVitalsId() {
		return vitalsId;
	}

	public void setVitalsId(int vitalsId) {
		this.vitalsId = vitalsId;
	}

	public LocalDateTime getDateTaken() {
		return dateTaken;
	}

	public void setDateTaken(LocalDateTime dateTaken) {
		this.dateTaken = dateTaken;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}

	public int getCalculatedBmi() {
		return calculatedBmi;
	}

	public void setCalculatedBmi(int calculatedBmi) {
		this.calculatedBmi = calculatedBmi;
	}

	public double getTemperature() {
		return temperature;
	}

	public void setTemperature(double temperature) {
		this.temperature = temperature;
	}

	public int getPulse() {
		return pulse;
	}

	public void setPulse(int pulse) {
		this.pulse = pulse;
	}

	public int getRespiratoryRate() {
		return respiratoryRate;
	}

	public void setRespiratoryRate(int respiratoryRate) {
		this.respiratoryRate = respiratoryRate;
	}

	public int getBloodPressureSystolic() {
		return bloodPressureSystolic;
	}

	public void setBloodPressureSystolic(int bloodPressureSystolic) {
		this.bloodPressureSystolic = bloodPressureSystolic;
	}

	public int getBloodPressureDiastolic() {
		return bloodPressureDiastolic;
	}

	public void setBloodPressureDiastolic(int bloodPressureDiastolic) {
		this.bloodPressureDiastolic = bloodPressureDiastolic;
	}

	public int getArterialBloodOxygenSaturation() {
		return arterialBloodOxygenSaturation;
	}

	public void setArterialBloodOxygenSaturation(int arterialBloodOxygenSaturation) {
		this.arterialBloodOxygenSaturation = arterialBloodOxygenSaturation;
	}

	@Override
	public String getWriteQuery() {
		return "INSERT INTO vitals(vitals_id, medical_record_id, vitals_date_taken, vitals_height, vitals_weight, vitals_calculated_bmi, "
				+ "vitals_temperature, vitals_pulse, vitals_respiratory_rate, vitals_blood_pressure_systolic, vitals_blood_pressure_diastolic, "
				+ "vitals_arterial_blood_oxygen_saturation) "
				+ "values (?,?,?,?,?,?,?,?,?,?,?,?)";
	}

	@Override
	public String getWriteErrorMessage() {
		return "Could not add to the vitals table!";
	}

	@Override
	public int prepareWriteStatement(PreparedStatement preparedStatement) throws SQLException {
		System.out.println("Adding to the vitals table...");
		preparedStatement.setInt(1, getVitalsId());
		preparedStatement.setString(2, getMedicalRecordId());
		preparedStatement.setTimestamp(3, java.sql.Timestamp.valueOf(getDateTaken()));
		preparedStatement.setInt(4, getHeight());
		preparedStatement.setInt(5, getWeight());
		preparedStatement.setInt(6, getCalculatedBmi());
		preparedStatement.setDouble(7, getTemperature());
		preparedStatement.setInt(8, getPulse());
		preparedStatement.setInt(9, getRespiratoryRate());
		preparedStatement.setInt(10, getBloodPressureSystolic());
		preparedStatement.setInt(11, getBloodPressureDiastolic());
		preparedStatement.setInt(12, getArterialBloodOxygenSaturation());
		return preparedStatement.executeUpdate();
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
