package com.empty_works.plain_emrs.util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class ConnectionUtil {

	public static Connection getConnection() {
		
		Connection connection = null;
		try {
			Context context = new InitialContext();
			DataSource ds = (DataSource) context.lookup("java:comp/env/emrsds");
			connection = ds.getConnection();
		} catch (NamingException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return connection;
	}
	
	public static void closeConnection(Connection con, PreparedStatement ps, ResultSet rs) {
		
		try {
			
			if(con != null) {
				
				con.close();
			}
			
			if(ps != null) {
				
				ps.close();
			}
			
			if(rs != null) {
				
				rs.close();
			}
		}
		catch(SQLException e) {
			
			e.printStackTrace();
		}
	}
}
