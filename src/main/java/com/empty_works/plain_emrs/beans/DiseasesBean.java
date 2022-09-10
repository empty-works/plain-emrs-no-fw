package com.empty_works.plain_emrs.beans;

import com.empty_works.plain_emrs.patient_choices.PatientDiseaseUnit;

public class DiseasesBean extends UserBean {

	// User ID in parent class
	private PatientDiseaseUnit[] immunDiseases;

	public PatientDiseaseUnit[] getImmunDiseases() {
		return immunDiseases;
	}

	public void setImmunDiseases(PatientDiseaseUnit[] immunDiseases) {
		this.immunDiseases = immunDiseases;
	}
}
