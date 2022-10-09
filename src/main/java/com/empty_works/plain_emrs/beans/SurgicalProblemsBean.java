package com.empty_works.plain_emrs.beans;

import java.util.List;

import com.empty_works.plain_emrs.patient_choices.MedicalRecordSurgeryUnit;

public class SurgicalProblemsBean {

	private List<MedicalRecordSurgeryUnit> surgeryMedProblems;

	public List<MedicalRecordSurgeryUnit> getSurgeryMedProblems() {
		return surgeryMedProblems;
	}

	public void setSurgeryMedProblems(List<MedicalRecordSurgeryUnit> surgeryMedProblems) {
		this.surgeryMedProblems = surgeryMedProblems;
	}
}
