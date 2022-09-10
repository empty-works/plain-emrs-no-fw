package com.empty_works.plain_emrs.beans;

import com.empty_works.plain_emrs.patient_choices.PatientIllnessUnit;

/*
 * Difference between disease and illness:
 * A disease has a specific result on a body part or function. Illness can be a perceived notion of unwellness or derive from self-diagnosis.
 */
public class MedicalRecordIllnessesBean extends UserBean {

	private PatientIllnessUnit[] illnesses;

	public PatientIllnessUnit[] getIllnesses() {
		return illnesses;
	}

	public void setIllnesses(PatientIllnessUnit[] illnesses) {
		this.illnesses = illnesses;
	}
}
