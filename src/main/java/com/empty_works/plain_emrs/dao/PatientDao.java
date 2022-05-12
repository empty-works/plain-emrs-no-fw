package com.empty_works.plain_emrs.dao;

import java.sql.Connection;
import java.time.LocalDate;

import com.empty_works.plain_emrs.beans.PatientBean;
import com.empty_works.plain_emrs.util.ConnectionUtil;

public class PatientDao {

	//TODO: write to database. First, update database
	public String register(PatientBean pb) {
		
		String id = pb.getId();
		String givenName = pb.getGivenName();
		String middleInitial = pb.getMiddleInitial();
		String lastName = pb.getLastName();
		LocalDate dateOfBirth = pb.getDateOfBirth(); 
		String gender = pb.getGender();
		String type = pb.getType();
		String race = pb.getRace();
		String ethnicity = pb.getEthnicity();
		String streetAddress = pb.getStreetAddress();
		String city = pb.getCity();
		String country = pb.getCountry();
		String phoneNumber = pb.getPhoneNumber();
		String provider = pb.getProvider();
		String providerId = pb.getProviderId();
		int roomNumber = pb.getRoomNumber();
		
		Connection con = ConnectionUtil.getConnection();
		
		
		return "";
	}
}
