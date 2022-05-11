package com.empty_works.plain_emrs.dao;

import java.time.LocalDate;

import com.empty_works.plain_emrs.beans.PatientBean;

public class AddPatientDao {

	//TODO: write to database. First, update database
	public String register(PatientBean pb) {
		
		String id = pb.getId();
		String givenName = pb.getGivenName();
		String middleInitial = pb.getMiddleInitial();
		String lastName = pb.getLastName();
		LocalDate dateOfBirth = pb.getDateOfBirth(); 
		
		
		return "";
	}
}
