package com.empty_works.plain_emrs.beans;

import java.util.List;

public class PatientWrapper {

	private String userPatientId;
	private UserPatientBean userPatient;
	private UserPatientRaceBean userPatientRace;
	private EmergencyContactsBean emergencyContacts;
	private MedicalRecordBean medicalRecord;
	private List<MedicalRecordAllergiesBean> allergiesList;
	private MedicalRecordBloodRelativesBean bloodRelatives;
	private List<MedicalRecordChiefComplaintsBean> chiefComplaintsList;
	private List<MedicalRecordDiseasesBean> diseasesList;
	private List<MedicalRecordIllnessesBean> illnessesList;
	private List<MedicalRecordMedicationBean> medicationList;
	private List<MedicalRecordSurgicalProblemsBean> surgicalProblemsList;
	private List<MedicalRecordNurseNotesBean> nurseNotesList;
	private List<MedicalRecordVitalsBean> vitalsList;
	private List<MedicalRecordAdmissionsBean> admissionsList;
	private List<MedicalRecordROSBean> rosList;

	public String getUserPatientId() {
		return userPatientId;
	}
	public void setUserPatientId(String userPatientId) {
		this.userPatientId = userPatientId;
	}
	public UserPatientBean getUserPatient() {
		return userPatient;
	}
	public void setUserPatient(UserPatientBean userPatient) {
		this.userPatient = userPatient;
	}
	public UserPatientRaceBean getUserPatientRace() {
		return userPatientRace;
	}
	public void setUserPatientRace(UserPatientRaceBean userPatientRace) {
		this.userPatientRace = userPatientRace;
	}
	public EmergencyContactsBean getEmergencyContacts() {
		return emergencyContacts;
	}
	public void setEmergencyContacts(EmergencyContactsBean emergencyContacts) {
		this.emergencyContacts = emergencyContacts;
	}
	public MedicalRecordBean getMedicalRecord() {
		return medicalRecord;
	}
	public void setMedicalRecord(MedicalRecordBean medicalRecord) {
		this.medicalRecord = medicalRecord;
	}
	public List<MedicalRecordAllergiesBean> getAllergiesList() {
		return allergiesList;
	}
	public void setAllergiesList(List<MedicalRecordAllergiesBean> allergiesList) {
		this.allergiesList = allergiesList;
	}
	public MedicalRecordBloodRelativesBean getBloodRelatives() {
		return bloodRelatives;
	}
	public void setBloodRelatives(MedicalRecordBloodRelativesBean bloodRelatives) {
		this.bloodRelatives = bloodRelatives;
	}
	public List<MedicalRecordChiefComplaintsBean> getChiefComplaintsList() {
		return chiefComplaintsList;
	}
	public void setChiefComplaintsList(List<MedicalRecordChiefComplaintsBean> chiefComplaintsList) {
		this.chiefComplaintsList = chiefComplaintsList;
	}
	public List<MedicalRecordDiseasesBean> getDiseasesList() {
		return diseasesList;
	}
	public void setDiseasesList(List<MedicalRecordDiseasesBean> diseasesList) {
		this.diseasesList = diseasesList;
	}
	public List<MedicalRecordIllnessesBean> getIllnessesList() {
		return illnessesList;
	}
	public void setIllnessesList(List<MedicalRecordIllnessesBean> illnessesList) {
		this.illnessesList = illnessesList;
	}
	public List<MedicalRecordMedicationBean> getMedicationList() {
		return medicationList;
	}
	public void setMedicationList(List<MedicalRecordMedicationBean> medicationList) {
		this.medicationList = medicationList;
	}
	public List<MedicalRecordSurgicalProblemsBean> getSurgicalProblemsList() {
		return surgicalProblemsList;
	}
	public void setSurgicalProblemsList(List<MedicalRecordSurgicalProblemsBean> surgicalProblemsList) {
		this.surgicalProblemsList = surgicalProblemsList;
	}
	public List<MedicalRecordNurseNotesBean> getNurseNotesList() {
		return nurseNotesList;
	}
	public void setNurseNotesList(List<MedicalRecordNurseNotesBean> nurseNotesList) {
		this.nurseNotesList = nurseNotesList;
	}
	public List<MedicalRecordVitalsBean> getVitalsList() {
		return vitalsList;
	}
	public void setVitalsList(List<MedicalRecordVitalsBean> vitalsList) {
		this.vitalsList = vitalsList;
	}
	public List<MedicalRecordAdmissionsBean> getAdmissionsList() {
		return admissionsList;
	}
	public void setAdmissionsList(List<MedicalRecordAdmissionsBean> admissionsList) {
		this.admissionsList = admissionsList;
	}
	public List<MedicalRecordROSBean> getRosList() {
		return rosList;
	}
	public void setRosList(List<MedicalRecordROSBean> rosList) {
		this.rosList = rosList;
	}
}
