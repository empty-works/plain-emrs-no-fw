package com.empty_works.plain_emrs.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.empty_works.plain_emrs.beans.LoginBean;
import com.empty_works.plain_emrs.roles.PlainEmrsRoles;
import com.empty_works.plain_emrs.roles.RolePair;
import com.empty_works.plain_emrs.util.ConnectionUtil;

public class LoginDao {

	public RolePair authenticateUser(LoginBean login) {

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
				System.out.println("Resultset user: " + usernameDb);
				System.out.println("Resultset pass: " + passwordDb);
				System.out.println("Resultset role: " + roleDb);
				
				if(usernameDb.equals(username) && passwordDb.equals(password)) {
					
					for(RolePair rolePair : PlainEmrsRoles.roleList) {
						
						System.out.println("From user: " + username);
						System.out.println("From user: " + password);
						System.out.println("From user: " + rolePair.getRoleDb());
						if(rolePair.getRoleDb().equals(roleDb)) {
							
							return rolePair;
						}
					}
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return PlainEmrsRoles.invalidUser; 
	}
}
