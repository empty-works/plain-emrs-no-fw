package com.empty_works.plain_emrs.beans;

public class MedicalRecordHistoriesPresentIllnessBean implements MedicalRecordInterface {

	private int historyPresentIllnessId;
	private String medicalRecordId;
	private int chiefComplaintId;
	private String location;
	private String character;
	private String duration;
	private String onset;
	private String modifyingFactors;
	private String radiation;
	private String temporalPattern;
	private String severity;
	
	public int getHistoryPresentIllnessId() {
		return historyPresentIllnessId;
	}

	public void setHistoryPresentIllnessId(int historyPresentIllnessId) {
		this.historyPresentIllnessId = historyPresentIllnessId;
	}

	public int getChiefComplaintId() {
		return chiefComplaintId;
	}

	public void setChiefComplaintId(int chiefComplaintId) {
		this.chiefComplaintId = chiefComplaintId;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getCharacter() {
		return character;
	}

	public void setCharacter(String character) {
		this.character = character;
	}

	public String getDuration() {
		return duration;
	}

	public void setDuration(String duration) {
		this.duration = duration;
	}

	public String getOnset() {
		return onset;
	}

	public void setOnset(String onset) {
		this.onset = onset;
	}

	public String getModifyingFactors() {
		return modifyingFactors;
	}

	public void setModifyingFactors(String modifyingFactors) {
		this.modifyingFactors = modifyingFactors;
	}

	public String getRadiation() {
		return radiation;
	}

	public void setRadiation(String radiation) {
		this.radiation = radiation;
	}

	public String getTemporalPattern() {
		return temporalPattern;
	}

	public void setTemporalPattern(String temporalPattern) {
		this.temporalPattern = temporalPattern;
	}

	public String getSeverity() {
		return severity;
	}

	public void setSeverity(String severity) {
		this.severity = severity;
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
