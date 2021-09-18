package com.empty_works.plain_emrs.roles;

public class RolePair {

	private String roleDb;
	private String role;
	
	public RolePair(String roleDb, String role) {
		
		this.roleDb = roleDb;
		this.role = role;
	}

	public String getRoleDb() {
		return roleDb;
	}
	public void setRoleDb(String roleDb) {
		this.roleDb = roleDb;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
}
