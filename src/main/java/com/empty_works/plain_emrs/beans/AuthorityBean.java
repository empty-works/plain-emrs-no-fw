package com.empty_works.plain_emrs.beans;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class AuthorityBean implements BeanDaoInterface {

	private String userId;
	private String authority;
	
	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getAuthority() {
		return authority;
	}

	public void setAuthority(String authority) {
		this.authority = authority;
	}

	@Override
	public String getQuery() {
		return "INSERT INTO authorities(user_id, authority) values (?, ?)";
	}

	@Override
	public String getErrorMessage() {
		return "Could not add authority to authorities table!";
	}

	@Override
	public int prepareStatments(PreparedStatement preparedStatement) throws SQLException {
		preparedStatement.setString(1, getUserId());
		preparedStatement.setString(2, getAuthority());
		return preparedStatement.executeUpdate();
	}
}
