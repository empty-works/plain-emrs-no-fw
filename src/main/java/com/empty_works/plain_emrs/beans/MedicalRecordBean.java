package com.empty_works.plain_emrs.beans;

import java.time.LocalDateTime;
import java.util.List;

import com.empty_works.plain_emrs.patient_choices.MedicalRecordDiseaseUnit;
import com.empty_works.plain_emrs.patient_choices.MedicalRecordRelationsUnit;
import com.empty_works.plain_emrs.patient_choices.MedicalRecordSurgeryUnit;
import com.empty_works.plain_emrs.patient_choices.MedicalRecordFamilyConditionUnit;
import com.empty_works.plain_emrs.patient_choices.PatientIllnessUnit;

public class MedicalRecordBean extends UserBean {

	// User ID in parent class
	private String medicalRecordId;
	private String patientCondition;
	private LocalDateTime medicalRecordCreatedOn;
	private boolean isActive;
	private String bloodTransfusionStatus;
	private List<MedicalRecordDiseaseUnit> immunDiseases;
	private List<MedicalRecordSurgeryUnit> surgeryMedProblems;
	private String fatherStatus, motherStatus;
	private int fathDecAge, mothDecAge;
	private String fathCauseDea, mothCauseDea;
	private List<MedicalRecordRelationsUnit> relations;
	private List<MedicalRecordFamilyConditionUnit> conditions;

	public String getMedicalRecordId() {
		return medicalRecordId;
	}
	public void setMedicalRecordId(String medicalRecordId) {
		this.medicalRecordId = medicalRecordId;
	}
	public String getPatientCondition() {
		return patientCondition;
	}
	public void setPatientCondition(String patientCondition) {
		this.patientCondition = patientCondition;
	}
	public LocalDateTime getMedicalRecordCreatedOn() {
		return medicalRecordCreatedOn;
	}
	public void setMedicalRecordCreatedOn(LocalDateTime medicalRecordCreatedOn) {
		this.medicalRecordCreatedOn = medicalRecordCreatedOn;
	}
	public boolean isActive() {
		return isActive;
	}
	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}
	public String getBloodTransfusionStatus() {
		return bloodTransfusionStatus;
	}
	public void setBloodTransfusionStatus(String bloodTransfusionStatus) {
		this.bloodTransfusionStatus = bloodTransfusionStatus;
	}
	public List<MedicalRecordDiseaseUnit> getImmunDiseases() {
		return immunDiseases;
	}
	public void setImmunDiseases(List<MedicalRecordDiseaseUnit> immunDiseases) {
		this.immunDiseases = immunDiseases;
	}
	public List<MedicalRecordSurgeryUnit> getSurgeryMedProblems() {
		return surgeryMedProblems;
	}
	public void setSurgeryMedProblems(List<MedicalRecordSurgeryUnit> surgeryMedProblems) {
		this.surgeryMedProblems = surgeryMedProblems;
	}
	public String getFatherStatus() {
		return fatherStatus;
	}
	public void setFatherStatus(String fatherStatus) {
		this.fatherStatus = fatherStatus;
	}
	public String getMotherStatus() {
		return motherStatus;
	}
	public void setMotherStatus(String motherStatus) {
		this.motherStatus = motherStatus;
	}
	public List<MedicalRecordRelationsUnit> getRelations() {
		return relations;
	}
	public void setRelations(List<MedicalRecordRelationsUnit> relations) {
		this.relations = relations;
	}
	public List<MedicalRecordFamilyConditionUnit> getConditions() {
		return conditions;
	}
	public void setConditions(List<MedicalRecordFamilyConditionUnit> conditions) {
		this.conditions = conditions;
	}
	public int getFathDecAge() {
		return fathDecAge;
	}
	public void setFathDecAge(int fathDecAge) {
		this.fathDecAge = fathDecAge;
	}
	public int getMothDecAge() {
		return mothDecAge;
	}
	public void setMothDecAge(int mothDecAge) {
		this.mothDecAge = mothDecAge;
	}
	public String getFathCauseDea() {
		return fathCauseDea;
	}
	public void setFathCauseDea(String fathCauseDea) {
		this.fathCauseDea = fathCauseDea;
	}
	public String getMothCauseDea() {
		return mothCauseDea;
	}
	public void setMothCauseDea(String mothCauseDea) {
		this.mothCauseDea = mothCauseDea;
	}
}
