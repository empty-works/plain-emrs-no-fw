package com.empty_works.plain_emrs.beans;

public class FacilityBean extends GeneralBean {

	String facilityId;
	String name;
	String streetAddress;
	String city;
	String state;
	String country;
	String zipCode;
	int numberOfBeds = 3;
	String description = "No description given.";

	public String getId() {
		return facilityId;
	}
	public void setId(String facilityId) {
		this.facilityId = facilityId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getStreetAddress() {
		return streetAddress;
	}
	public void setStreetAddress(String streetAddress) {
		this.streetAddress = streetAddress;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getZipCode() {
		return zipCode;
	}
	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}
	public int getNumberOfBeds() {
		return numberOfBeds;
	}
	public void setNumberOfBeds(int numberOfBeds) {
		this.numberOfBeds = numberOfBeds;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
}
