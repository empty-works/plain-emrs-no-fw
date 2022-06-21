package com.empty_works.plain_emrs.beans;

public class FacilityStaffSpecialtyBean extends GeneralBean {

	String facilityId;
	String specialtyId;
	String name;
	String description;

	public String getFacilityId() {
		return facilityId;
	}
	public void setFacilityId(String facilityId) {
		this.facilityId = facilityId;
	}
	public String getStaffSpecialtyId() {
		return specialtyId;
	}
	public void setStaffSpecialtyId(String specialtyId) {
		this.specialtyId = specialtyId;
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
