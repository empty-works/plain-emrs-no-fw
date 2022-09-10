package com.empty_works.plain_emrs.beans;

import java.time.LocalDateTime;

import com.empty_works.plain_emrs.patient_choices.PatientIllnessUnit;

public class MedicalRecordBean extends UserBean {

	// User ID in parent class
	private String patientCondition;
	private LocalDateTime medicalRecordCreatedOn;
	private boolean isActive;
	private String bloodTransfusionStatus;
	
}
