package com.empty_works.plain_emrs.patient_choices;

import java.time.LocalDate;

public class PatientMedicalProblemUnit {

	private String problemArea;
	private String mediProblemId;
	private String mediProblemName;
	private String surgicalProcedure;
	private LocalDate surgeryDate;

	public String getProblemArea() {
		return problemArea;
	}
	public String getMediProblemId() {
		return mediProblemId;
	}
	public String getMediProblemName() {
		return mediProblemName;
	}
	public String getSurgicalProcedure() {
		return surgicalProcedure;
	}
	public LocalDate getSurgeryDate() {
		return surgeryDate;
	}
}
