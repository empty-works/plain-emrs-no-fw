package com.empty_works.plain_emrs.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.empty_works.plain_emrs.beans.RoleBean;
import com.empty_works.plain_emrs.util.ConnectionUtil;
import com.empty_works.plain_emrs.util.FacilityRoleIdUtil;
import com.empty_works.plain_emrs.util.RoleIdUtil;

public class RoleDao {

	public static String ROLEDAO_SUCCESS = "Success";
	
	public static String add(RoleBean rb, String facilityId) {
		
		String roleName = rb.getName();
		String roleGroup = rb.getGroup();
		String roleDescription = rb.getDescription();
		String roleId = RoleIdUtil.get(rb);
		String facilityRoleId = FacilityRoleIdUtil.get(facilityId, roleId);
		
		Connection con = ConnectionUtil.getConnection();
		PreparedStatement roleStatement = null;
		PreparedStatement facilityRoleStatement = null;
		
		System.out.println("Facility ID in RoleDao: " + facilityId);
		
		String roleQuery = "INSERT INTO roles(role_id, role_name, role_group, role_description) values(?,?,?,?)";
		String facilityRoleQuery = "INSERT INTO facilities_roles(facilities_roles_id, role_id, facility_id) values(?,?,?)";
		try {
			roleStatement = con.prepareStatement(roleQuery);
			roleStatement.setString(1, roleId);
			roleStatement.setString(2, roleName);
			roleStatement.setString(3, roleGroup);
			roleStatement.setString(4, roleDescription);

			int roleSuccess = roleStatement.executeUpdate();
			
			facilityRoleStatement = con.prepareStatement(facilityRoleQuery);
			facilityRoleStatement.setString(1, facilityRoleId);
			facilityRoleStatement.setString(2, roleId);
			facilityRoleStatement.setString(3, facilityId);
			
			int facilityRoleSuccess = facilityRoleStatement.executeUpdate(); 
			
			if(roleSuccess != 0 && facilityRoleSuccess != 0) {
				
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
