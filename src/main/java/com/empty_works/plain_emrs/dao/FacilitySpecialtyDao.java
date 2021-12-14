package com.empty_works.plain_emrs.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import com.empty_works.plain_emrs.beans.FacilityStaffSpecialtyBean;
import com.empty_works.plain_emrs.util.ConnectionUtil;

public class FacilitySpecialtyDao {

	public static String SPECIALTYDAO_SUCCESS = "Success";
	
	public static String add(FacilityStaffSpecialtyBean fssb) {
		
		// Extract attributes
		String facilityId = fssb.getFacilityId();
		String specialtyId = fssb.getId();
		String specialtyName = fssb.getName();
		String specialtyDescription = fssb.getDescription();
		
		Connection con = ConnectionUtil.getConnection();
		PreparedStatement preparedStatement = null;
		
		String query = "INSERT INTO staff_specialties(specialty_id, facility_id, specialty_name, "
				+ "specialty_description) values (?,?,?,?)";
		try {
			preparedStatement = con.prepareStatement(query);
			preparedStatement.setString(1, specialtyId);
			preparedStatement.setString(2, facilityId);
			preparedStatement.setString(3, specialtyName);
			preparedStatement.setString(4, specialtyDescription);
			int i = preparedStatement.executeUpdate();
			if(i != 0) return SPECIALTYDAO_SUCCESS;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			
			ConnectionUtil.closeConnection(con, preparedStatement, null);
		}
		
		return "Something went wrong writing staff specialty to the database.";
	}
	
	public static List<FacilityStaffSpecialtyBean> getList(String facilityId) {
		
		List<FacilityStaffSpecialtyBean> theList = new ArrayList<>();
		// Make connection and prepared statement
		Connection con = ConnectionUtil.getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			ps = con.prepareStatement("select specialty_id, facility_id, specialty_name, "
					+ "specialty_description "
					+ "from staff_specialties where facility_id=?");
			ps.setString(1, facilityId);
			rs = ps.executeQuery();
			while(rs.next()) {
				
				FacilityStaffSpecialtyBean fssb = new FacilityStaffSpecialtyBean();
				fssb.setId(rs.getString("specialty_id"));
				fssb.setName(rs.getString("specialty_name"));
				java.sql.Blob sd = rs.getBlob("specialty_description");
				fssb.setDescription(new String(sd.getBytes(1L, (int) sd.length())));
				theList.add(fssb);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			
			ConnectionUtil.closeConnection(con, ps, rs);
		}
		return theList;
	}
}
