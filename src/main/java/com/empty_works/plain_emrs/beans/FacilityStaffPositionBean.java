package com.empty_works.plain_emrs.beans;

public class FacilityStaffPositionBean {

	private String facilityId;
	private String staffPositionId;
	private String name;
	private String description;

	public String getFacilityId() {
		return facilityId;
	}
	public void setFacilityId(String facilityId) {
		this.facilityId = facilityId;
	}
	public String getId() {
		return staffPositionId;
	}
	public void setId(String staffPositionId) {
		this.staffPositionId = staffPositionId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
}
