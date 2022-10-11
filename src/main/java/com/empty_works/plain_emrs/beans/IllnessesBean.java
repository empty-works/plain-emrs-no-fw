package com.empty_works.plain_emrs.beans;

import java.util.List;

import com.empty_works.plain_emrs.patient_choices.MedicalRecordFamilyIllnessUnit;
import com.empty_works.plain_emrs.patient_choices.PatientIllnessUnit;

/*
 * Difference between disease and illness:
 * A disease has a specific result on a body part or function. Illness can be a perceived notion of unwellness or derive from self-diagnosis.
 */
public class IllnessesBean implements PatientIdInterface {

	private String userId;
	private String medicalRecordId;
	private List<MedicalRecordFamilyIllnessUnit> illness;
	private PatientIllnessUnit[] illnesses;
	private boolean illnessSelf;
	private boolean illnessFather;
	private boolean illnessMother;
	private boolean illnessBrothers;
	private boolean illnessSisters;
	private boolean illnessSons;
	private boolean illnessDaughters;
	private boolean illnessGrandparents;

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getMedicalRecordId() {
		return medicalRecordId;
	}

	public void setMedicalRecordId(String medicalRecordId) {
		this.medicalRecordId = medicalRecordId;
	}

	public List<MedicalRecordFamilyIllnessUnit> getIllness() {
		return illness;
	}

	public void setIllness(List<MedicalRecordFamilyIllnessUnit> illness) {
		this.illness = illness;
	}

	public PatientIllnessUnit[] getIllnesses() {
		return illnesses;
	}

	public void setIllnesses(PatientIllnessUnit[] illnesses) {
		this.illnesses = illnesses;
	}

	public boolean isIllnessSelf() {
		return illnessSelf;
	}

	public void setIllnessSelf(boolean illnessSelf) {
		this.illnessSelf = illnessSelf;
	}

	public boolean isIllnessFather() {
		return illnessFather;
	}

	public void setIllnessFather(boolean illnessFather) {
		this.illnessFather = illnessFather;
	}

	public boolean isIllnessMother() {
		return illnessMother;
	}

	public void setIllnessMother(boolean illnessMother) {
		this.illnessMother = illnessMother;
	}

	public boolean isIllnessBrothers() {
		return illnessBrothers;
	}

	public void setIllnessBrothers(boolean illnessBrothers) {
		this.illnessBrothers = illnessBrothers;
	}

	public boolean isIllnessSisters() {
		return illnessSisters;
	}

	public void setIllnessSisters(boolean illnessSisters) {
		this.illnessSisters = illnessSisters;
	}

	public boolean isIllnessSons() {
		return illnessSons;
	}

	public void setIllnessSons(boolean illnessSons) {
		this.illnessSons = illnessSons;
	}

	public boolean isIllnessDaughters() {
		return illnessDaughters;
	}

	public void setIllnessDaughters(boolean illnessDaughters) {
		this.illnessDaughters = illnessDaughters;
	}

	public boolean isIllnessGrandparents() {
		return illnessGrandparents;
	}

	public void setIllnessGrandparents(boolean illnessGrandparents) {
		this.illnessGrandparents = illnessGrandparents;
	}
}
