package com.empty_works.plain_emrs.beans;

import java.util.List;

import com.empty_works.plain_emrs.patient_choices.MedicalRecordDiseaseUnit;

public class DiseasesBean {

	private List<MedicalRecordDiseaseUnit> diseases;

	public List<MedicalRecordDiseaseUnit> getDiseases() {
		return diseases;
	}
	public void setDiseases(List<MedicalRecordDiseaseUnit> diseases) {
		this.diseases = diseases;
	}
}