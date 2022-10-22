package com.empty_works.plain_emrs.beans;

public class UserAuthorityBean extends GeneralBean {

	String userId;
	String name;

	public String getId() {
		return userId;
	}
	public void setId(String id) {
		this.userId = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}
