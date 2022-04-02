package com.empty_works.plain_emrs.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.empty_works.plain_emrs.beans.RoleBean;
import com.empty_works.plain_emrs.util.ConnectionUtil;
import com.empty_works.plain_emrs.util.RoleIdUtil;

public class RoleDao {

	public static String ROLEDAO_SUCCESS = "Success";
	
	public static String add(RoleBean rb, String facilityId) {
		
		String roleName = rb.getName();
		String roleGroup = rb.getGroup();
		String roleDescription = rb.getDescription();
		String roleId = RoleIdUtil.get(rb);
		
		Connection con = ConnectionUtil.getConnection();
		PreparedStatement roleStatement = null;
		PreparedStatement roleFacilityStatement = null; 
		
		String roleQuery = "INSERT INTO roles(role_id, role_name, role_group, role_description) values(?,?,?,?)";
		String roleFacilityQuery = "INSERT INTO facilities_roles(role_id, facility_id) values(?,?)"; 
		try {
			con.setAutoCommit(false);
			roleStatement = con.prepareStatement(roleQuery);
			roleStatement.setString(1, roleId);
			roleStatement.setString(2, roleName);
			roleStatement.setString(3, roleGroup);
			roleStatement.setString(4, roleDescription);
			roleStatement.addBatch();
			
			roleFacilityStatement = con.prepareStatement(roleFacilityQuery); 
			roleFacilityStatement.setString(1, roleId);
			roleFacilityStatement.setString(2, facilityId);
			roleFacilityStatement.addBatch();
			roleFacilityStatement
			
			if(roleSuccess != 0 && roleFacilitySuccess != 0) {
				
				return ROLEDAO_SUCCESS;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return "There was a problem writing the role to the database.";
	}
	
	public static List<RoleBean> getList() {
		
		List<RoleBean> roles = new ArrayList<>();
		Connection con = ConnectionUtil.getConnection();
		PreparedStatement preparedStatement = null;
		try {
			String query = "select role_id, role_name, role_group, role_description from roles";
			preparedStatement = con.prepareStatement(query);
			ResultSet resultSet = preparedStatement.executeQuery();
			while(resultSet.next()) {
				
				RoleBean rb = new RoleBean();
				rb.setId(resultSet.getString("role_id"));
				rb.setName(resultSet.getString("role_name"));
				rb.setGroup(resultSet.getString("role_group"));
				rb.setDescription(resultSet.getString("role_description"));
				roles.add(rb);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return roles;
	}
}
