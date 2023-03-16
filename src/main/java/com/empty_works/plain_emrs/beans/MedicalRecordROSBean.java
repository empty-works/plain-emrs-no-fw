package com.empty_works.plain_emrs.beans;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class MedicalRecordROSBean implements MedicalRecordInterface, BeanDaoInterface {
	
	private int reviewOfSystemsId;
	private String medicalRecordId;
	private int chiefComplaintId;
	private	String constitutionalSymptoms; 
	private String eyes;
	private String earsNoseThroat;
	private String cardiovascular;
	private String respiratory;
	private String gastrointestinal;
	private String genitournary;
	private String musculoskeletal;
	private String integumentary;
	private String neurological;
	private String psychiatric;
	private String endocrine;
	private String hematologicLymphatic;
	private String allergicImmunologic;
	
	public int getReviewOfSystemsId() {
		return reviewOfSystemsId;
	}
	public void setReviewOfSystemsId(int reviewOfSystemsId) {
		this.reviewOfSystemsId = reviewOfSystemsId;
	}
	public int getChiefComplaintId() {
		return chiefComplaintId;
	}
	public void setChiefComplaintId(int chiefComplaintId) {
		this.chiefComplaintId = chiefComplaintId;
	}
	public String getConstitutionalSymptoms() {
		return constitutionalSymptoms;
	}
	public void setConstitutionalSymptoms(String constitutionalSymptoms) {
		this.constitutionalSymptoms = constitutionalSymptoms;
	}
	public String getEyes() {
		return eyes;
	}
	public void setEyes(String eyes) {
		this.eyes = eyes;
	}
	public String getEarsNoseThroat() {
		return earsNoseThroat;
	}
	public void setEarsNoseThroat(String earsNoseThroat) {
		this.earsNoseThroat = earsNoseThroat;
	}
	public String getCardiovascular() {
		return cardiovascular;
	}
	public void setCardiovascular(String cardiovascular) {
		this.cardiovascular = cardiovascular;
	}
	public String getRespiratory() {
		return respiratory;
	}
	public void setRespiratory(String respiratory) {
		this.respiratory = respiratory;
	}
	public String getGastrointestinal() {
		return gastrointestinal;
	}
	public void setGastrointestinal(String gastrointestinal) {
		this.gastrointestinal = gastrointestinal;
	}
	public String getGenitournary() {
		return genitournary;
	}
	public void setGenitournary(String genitournary) {
		this.genitournary = genitournary;
	}
	public String getMusculoskeletal() {
		return musculoskeletal;
	}
	public void setMusculoskeletal(String musculoskeletal) {
		this.musculoskeletal = musculoskeletal;
	}
	public String getIntegumentary() {
		return integumentary;
	}
	public void setIntegumentary(String integumentary) {
		this.integumentary = integumentary;
	}
	public String getNeurological() {
		return neurological;
	}
	public void setNeurological(String neurological) {
		this.neurological = neurological;
	}
	public String getPsychiatric() {
		return psychiatric;
	}
	public void setPsychiatric(String psychiatric) {
		this.psychiatric = psychiatric;
	}
	public String getEndocrine() {
		return endocrine;
	}
	public void setEndocrine(String endocrine) {
		this.endocrine = endocrine;
	}
	public String getHematologicLymphatic() {
		return hematologicLymphatic;
	}
	public void setHematologicLymphatic(String hematologicLymphatic) {
		this.hematologicLymphatic = hematologicLymphatic;
	}
	public String getAllergicImmunologic() {
		return allergicImmunologic;
	}
	public void setAllergicImmunologic(String allergicImmunologic) {
		this.allergicImmunologic = allergicImmunologic;
	}
	@Override
	public String getWriteQuery() {
		return "INSERT INTO reviews_of_systems(review_of_systems_id, chief_complaint_id, medical_record_id, constitutional_symptoms, "
				+ "eyes, ears_nose_throat, cardiovascular, respiratory, gastrointestinal, genitournary, musculoskeletal, integumentary, "
				+ "neurological, psychiatric, endocrine, hematologic_lymphatic, allergic_immunologic) "
				+ "values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
	}
	@Override
	public String getErrorMessage() {
		return "Could not add to the reviews_of_systems table!";
	}
	@Override
	public int prepareStatments(PreparedStatement preparedStatement) throws SQLException {
		System.out.println("Adding to the reviews_of_systems table...");
		preparedStatement.setInt(1, getReviewOfSystemsId());
		preparedStatement.setInt(2, getChiefComplaintId());
		preparedStatement.setString(3, getMedicalRecordId());
		preparedStatement.setString(4, getConstitutionalSymptoms());
		preparedStatement.setString(5, getEyes());
		preparedStatement.setString(6, getEarsNoseThroat());
		preparedStatement.setString(7, getCardiovascular());
		preparedStatement.setString(8, getRespiratory());
		preparedStatement.setString(9, getGastrointestinal());
		preparedStatement.setString(10, getGenitournary());
		preparedStatement.setString(11, getMusculoskeletal());
		preparedStatement.setString(12, getIntegumentary());
		preparedStatement.setString(13, getNeurological());
		preparedStatement.setString(14, getPsychiatric());
		preparedStatement.setString(15, getEndocrine());
		preparedStatement.setString(16, getHematologicLymphatic());
		preparedStatement.setString(17, getAllergicImmunologic());
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
