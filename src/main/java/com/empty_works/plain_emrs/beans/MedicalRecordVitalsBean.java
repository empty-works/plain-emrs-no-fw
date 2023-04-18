package com.empty_works.plain_emrs.beans;

import java.time.LocalDateTime;

public class MedicalRecordVitalsBean implements MedicalRecordInterface {

	private String medicalRecordId;
	private int vitalsId;
	private LocalDateTime dateTaken;
	private double height;
	private double weight;
	private double calculatedBmi;
	private double temperature;
	private double pulse;
	private double respiratoryRate;
	private double bloodPressureSystolic;
	private double bloodPressureDiastolic;
	private double arterialBloodOxygenSaturation;
	
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

	public double getHeight() {
		return height;
	}

	public void setHeight(double height) {
		this.height = height;
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

	public double getCalculatedBmi() {
		return calculatedBmi;
	}

	public void setCalculatedBmi(double calculatedBmi) {
		this.calculatedBmi = calculatedBmi;
	}

	public double getTemperature() {
		return temperature;
	}

	public void setTemperature(double temperature) {
		this.temperature = temperature;
	}

	public double getPulse() {
		return pulse;
	}

	public void setPulse(double pulse) {
		this.pulse = pulse;
	}

	public double getRespiratoryRate() {
		return respiratoryRate;
	}

	public void setRespiratoryRate(double respiratoryRate) {
		this.respiratoryRate = respiratoryRate;
	}

	public double getBloodPressureSystolic() {
		return bloodPressureSystolic;
	}

	public void setBloodPressureSystolic(double bloodPressureSystolic) {
		this.bloodPressureSystolic = bloodPressureSystolic;
	}

	public double getBloodPressureDiastolic() {
		return bloodPressureDiastolic;
	}

	public void setBloodPressureDiastolic(double bloodPressureDiastolic) {
		this.bloodPressureDiastolic = bloodPressureDiastolic;
	}

	public double getArterialBloodOxygenSaturation() {
		return arterialBloodOxygenSaturation;
	}

	public void setArterialBloodOxygenSaturation(double arterialBloodOxygenSaturation) {
		this.arterialBloodOxygenSaturation = arterialBloodOxygenSaturation;
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
