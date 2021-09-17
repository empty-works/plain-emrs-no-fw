package com.empty_works.plain_emrs.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.empty_works.plain_emrs.beans.LoginBean;
import com.empty_works.plain_emrs.contants.PlainEmrsRole;
import com.empty_works.plain_emrs.util.ConnectionUtil;

public class LoginDao {

	public String authenticateUser(LoginBean login) {

		String username = login.getUsername();
		String password = login.getPassword();

		Connection connection = ConnectionUtil.getConnection();
		try {
			PreparedStatement statement = connection.prepareStatement(
					"SELECT users.username, users.password, authorities.authority FROM users "
					+ "INNER JOIN authorities ON users.username=authorities.username");
			
			ResultSet rs = statement.executeQuery();
			
			while(rs.next()) {
				
				String usernameDb = rs.getString("username");
				String passwordDb = rs.getString("password");
				String roleDb = rs.getString("authority");
				
				if(usernameDb.equals(username) && passwordDb.equals(password)) 
					return getRole(roleDb);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return "Invalid user";
	}
	
	private String getRole(String roleDb) {
		
		if(roleDb.equals(PlainEmrsRole.admin)) return PlainEmrsRole.admin;
		else if(roleDb.equals(PlainEmrsRole.doctor)) return PlainEmrsRole.doctor;
		else if(roleDb.equals(PlainEmrsRole.nurse)) return PlainEmrsRole.nurse;
		else if(roleDb.equals(PlainEmrsRole.alliedMedStaff)) return PlainEmrsRole.alliedMedStaff;
		else if(roleDb.equals(PlainEmrsRole.provider)) return PlainEmrsRole.provider;
		else if(roleDb.equals(PlainEmrsRole.government)) return PlainEmrsRole.government;
		else return PlainEmrsRole.unknown;
	}
}
