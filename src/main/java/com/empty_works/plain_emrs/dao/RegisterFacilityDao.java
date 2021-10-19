package com.empty_works.plain_emrs.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.empty_works.plain_emrs.beans.FacilityBean;
import com.empty_works.plain_emrs.util.ConnectionUtil;

public class RegisterFacilityDao {

	public static String register(FacilityBean fb) {
		
		String id = fb.getFacilityId();
		String name = fb.getName();
		String streetAddress = fb.getStreetAddress();
		String city = fb.getCity();
		String country = fb.getCountry();
		String zipCode = fb.getZipCode();
		
		Connection con = null;
		PreparedStatement preparedStatement = null;
		
		con = ConnectionUtil.getConnection();
		String query = "";
		
		return "";
	}
}
