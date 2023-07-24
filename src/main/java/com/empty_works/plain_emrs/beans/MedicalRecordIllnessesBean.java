package com.empty_works.plain_emrs.beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import com.empty_works.plain_emrs.patient_choices.MedicalRecordFamilyIllnessUnit;

/*
 * Difference between disease and illness:
 * A disease has a specific result on a body part or function. Illness can be a perceived notion of unwellness or derive from self-diagnosis.
 */
public class MedicalRecordIllnessesBean implements MedicalRecordInterface, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1144063173632007764L;
	public static String FATHER = "Father";
	public static String MOTHER = "Mother";
	public static String BROTHERS = "Brothers";
	public static String SISTERS = "Sisters";
	public static String SONS = "Sons";
	public static String DAUGHTERS = "Daughters";
	public static String GRANDPARENTS = "Grandparents";
	private int illnessId;
	private String listIllnessId;
	private String medicalRecordId;
	private String illness;
	private List<Boolean> familyRelations = new ArrayList<>();
	private boolean illnessFather;
	private boolean illnessMother;
	private boolean illnessBrothers;
	private boolean illnessSisters;
	private boolean illnessSons;
	private boolean illnessDaughters;
	private boolean illnessGrandparents;
	
	public MedicalRecordIllnessesBean() {}
	
	public MedicalRecordIllnessesBean(String listIllnessId, String illness) {
		this.listIllnessId = listIllnessId;
		this.illness = illness;
	}

	public int getIllnessId() {
		return illnessId;
	}

	public void setIllnessId(int illnessId) {
		this.illnessId = illnessId;
	}
	
	public String getListIllnessId() {
		return listIllnessId;
	}

	public void setListIllnessId(String listIllnessId) {
		this.listIllnessId = listIllnessId;
	}

	public void setIllness(String illness) {
		this.illness = illness;
	}
	
	public String getIllness() {
		return illness;
	}

	@Override
	public String getMedicalRecordId() {
		return medicalRecordId;
	}

	@Override
	public void setMedicalRecordId(String medicalRecordId) {
		this.medicalRecordId = medicalRecordId;
	}

	public List<Boolean> getFamilyRelations() {
		return familyRelations;
	}

	public void setFamilyRelation(Boolean relation) {
		this.familyRelations.add(relation);
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
