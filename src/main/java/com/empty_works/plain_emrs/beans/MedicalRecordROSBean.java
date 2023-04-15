package com.empty_works.plain_emrs.beans;

import java.time.LocalDateTime;

public class MedicalRecordROSBean implements MedicalRecordInterface {
	
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
	private LocalDateTime date;
	
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
	public void setMedicalRecordId(String medicalRecordId) {
		this.medicalRecordId = medicalRecordId;
	}
	@Override
	public String getMedicalRecordId() {
		return medicalRecordId;
	}
	public LocalDateTime getDate() {
		return date;
	}
	public void setDate(LocalDateTime date) {
		this.date = date;
	}
}
