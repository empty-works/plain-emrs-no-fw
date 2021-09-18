package com.empty_works.plain_emrs.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.empty_works.plain_emrs.beans.LoginBean;
import com.empty_works.plain_emrs.roles.PlainEmrsRoles;
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
					return PlainEmrsRoles.getRole(roleDb);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return "Invalid user";
	}
}
