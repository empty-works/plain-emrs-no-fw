package com.empty_works.plain_emrs.beans;

import java.util.List;

import com.empty_works.plain_emrs.patient_choices.PatientDiseaseUnit;

/*
 * Difference between disease and illness:
 * A disease has a specific result on a body part or function. Illness can be a perceived notion of unwellness or derive from self-diagnosis.
 */
public class MedicalRecordDiseasesBean extends UserBean {

	// User ID in parent class
	private List<PatientDiseaseUnit> immunDiseases;
	private boolean contractedDisease;
	private boolean receivedImmunization;

	public List<PatientDiseaseUnit> getImmunDiseases() {
		return immunDiseases;
	}

	public void setImmunDiseases(List<PatientDiseaseUnit> immunDiseases) {
		this.immunDiseases = immunDiseases;
	}

	public boolean isContractedDisease() {
		return contractedDisease;
	}

	public void setContractedDisease(boolean contractedDisease) {
		this.contractedDisease = contractedDisease;
	}

	public boolean isReceivedImmunization() {
		return receivedImmunization;
	}

	public void setReceivedImmunization(boolean receivedImmunization) {
		this.receivedImmunization = receivedImmunization;
	}
}
