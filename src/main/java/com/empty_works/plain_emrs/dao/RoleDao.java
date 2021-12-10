package com.empty_works.plain_emrs.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.empty_works.plain_emrs.beans.RoleBean;
import com.empty_works.plain_emrs.util.ConnectionUtil;

public class RoleDao {

	public static String ROLEDAO_SUCCESS = "Success";
	
	public static String add(RoleBean rb) {
		
		String roleName = rb.getName();
		String roleGroup = rb.getGroup();
		String roleDescription = rb.getDescription();
		String roleId =  
		
		Connection con = ConnectionUtil.getConnection();
		PreparedStatement preparedStatement = null;
		
		String query = "INSERT INTO roles(role_id, name, group, description) values(?,?,?,?)";
		try {
			preparedStatement = con.prepareStatement(query);
			preparedStatement.setString(1, roleId);
			preparedStatement.setString(2, roleName);
			preparedStatement.setString(3, roleGroup);
			preparedStatement.setString(4, roleDescription);
			
			int i = preparedStatement.executeUpdate();
			if(i != 0) return ROLEDAO_SUCCESS;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return "There was a problem writing the role to the database.";
	}
	
	public static List<RoleBean> getList() {
		
		List<RoleBean> roles = new ArrayList<>();
		Connection con = ConnectionUtil.getConnection();
		PreparedStatement preparedStatement = null;
		preparedStatement = con.prepareStatement("SELECT ");
	}
}
