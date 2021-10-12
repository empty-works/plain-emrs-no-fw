package com.empty_works.plain_emrs.dao;

import java.time.LocalDate;

import com.empty_works.plain_emrs.beans.NonPatientBean;

public class RegisterNonPatientUserDao {

	//TODO: write to database. FIRST, update database
	public String register(NonPatientBean npb) {
		
		String id = npb.getId();
		String givenName = npb.getGivenName();
		String middleName = npb.getMiddleName();
		String lastName = npb.getLastName();
		String organization = npb.getOrganization();
		LocalDate dateOfBirth = npb.getDateOfBirth();
		String description = npb.getDescription();
		String wardId = npb.getWardId();
		String staffPositionId = npb.getStaffPositionId();
		String specialtyId = npb.getSpecialtyId();
		
		
		
		return "";
	}
}
