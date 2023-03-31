package com.empty_works.plain_emrs.beans;

public class MedicalRecordSocialHistoriesBean implements MedicalRecordInterface {

	private int socialHistoryId;
	private String medicalRecordId;
	private String substances;
	private String occupation;
	private String sexualBehavior;
	private String prison;
	private String travel;
	private String exercise;
	private String diet;
	private String firearmsInHousehold;
	
	public int getSocialHistoryId() {
		return socialHistoryId;
	}

	public void setSocialHistoryId(int socialHistoryId) {
		this.socialHistoryId = socialHistoryId;
	}

	public String getSubstances() {
		return substances;
	}

	public void setSubstances(String substances) {
		this.substances = substances;
	}

	public String getOccupation() {
		return occupation;
	}

	public void setOccupation(String occupation) {
		this.occupation = occupation;
	}

	public String getSexualBehavior() {
		return sexualBehavior;
	}

	public void setSexualBehavior(String sexualBehavior) {
		this.sexualBehavior = sexualBehavior;
	}

	public String getPrison() {
		return prison;
	}

	public void setPrison(String prison) {
		this.prison = prison;
	}

	public String getTravel() {
		return travel;
	}

	public void setTravel(String travel) {
		this.travel = travel;
	}

	public String getExercise() {
		return exercise;
	}

	public void setExercise(String exercise) {
		this.exercise = exercise;
	}

	public String getDiet() {
		return diet;
	}

	public void setDiet(String diet) {
		this.diet = diet;
	}

	public String getFirearmsInHousehold() {
		return firearmsInHousehold;
	}

	public void setFirearmsInHousehold(String firearmsInHousehold) {
		this.firearmsInHousehold = firearmsInHousehold;
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
