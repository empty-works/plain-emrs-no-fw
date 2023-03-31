package com.empty_works.plain_emrs.beans;

import java.time.LocalDateTime;

public class MedicalRecordVisitsBean implements MedicalRecordInterface {

	private int visitId;
	private String medicalRecordId;
	private String visitsTitle;
	private LocalDateTime visitsDate;
	private String description;
	
	public int getVisitId() {
		return visitId;
	}

	public void setVisitId(int visitId) {
		this.visitId = visitId;
	}

	public String getVisitsTitle() {
		return visitsTitle;
	}

	public void setVisitsTitle(String visitsTitle) {
		this.visitsTitle = visitsTitle;
	}

	public LocalDateTime getVisitsDate() {
		return visitsDate;
	}

	public void setVisitsDate(LocalDateTime visitsDate) {
		this.visitsDate = visitsDate;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
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
