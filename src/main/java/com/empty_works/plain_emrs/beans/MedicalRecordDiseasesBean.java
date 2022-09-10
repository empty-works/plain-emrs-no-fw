package com.empty_works.plain_emrs.beans;

import com.empty_works.plain_emrs.patient_choices.PatientDiseaseUnit;

/*
 * Difference between disease and illness:
 * A disease has a specific result on a body part or function. Illness can be a perceived notion of unwellness or derive from self-diagnosis.
 */
public class MedicalRecordDiseasesBean extends UserBean {

	// User ID in parent class
	private PatientDiseaseUnit[] immunDiseases;

	public PatientDiseaseUnit[] getImmunDiseases() {
		return immunDiseases;
	}

	public void setImmunDiseases(PatientDiseaseUnit[] immunDiseases) {
		this.immunDiseases = immunDiseases;
	}
}
