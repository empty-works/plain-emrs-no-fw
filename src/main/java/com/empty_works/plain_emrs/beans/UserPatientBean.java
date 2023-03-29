package com.empty_works.plain_emrs.beans;

public class UserPatientBean extends UserBean {

	// User ID in UserBean
	private String provider;
	private String providerId;
	private String roomNumber;
	private String currentGender;
	private String type;
	private String languagePreference;
	private String streetAddress;
	private String city;
	private String state;
	private String country;
	private String phoneNumber;
	private String facilityId;
	private String genderAtBirth;
	private String sexualOrientation;
	private String maritalStatus;
	private String livingArrangement;
	private boolean isAdopted;
	
	// HIPAA identifiers
	private String licenseNumber;
	private String vehicleSerialNumber;
	private String vehiclePlateNumber;
	private String url;
	private String deviceSerialNumber;
	private String ipAddress;

	public String getProvider() {
		return provider;
	}
	public void setProvider(String provider) {
		this.provider = provider;
	}
	public String getProviderId() {
		return providerId;
	}
	public void setProviderId(String providerId) {
		this.providerId = providerId;
	}
	public String getRoomNumber() {
		return roomNumber;
	}
	public void setRoomNumber(String roomNumber) {
		this.roomNumber = roomNumber;
	}
	public String getCurrentGender() {
		return currentGender;
	}
	public void setCurrentGender(String currentGender) {
		this.currentGender = currentGender;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getLanguagePreference() {
		return languagePreference;
	}
	public void setLanguagePreference(String languagePreference) {
		this.languagePreference = languagePreference;
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
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getFacilityId() {
		return facilityId;
	}
	public void setFacilityId(String facilityId) {
		this.facilityId = facilityId;
	}
	public String getGenderAtBirth() {
		return genderAtBirth;
	}
	public void setGenderAtBirth(String genderAtBirth) {
		this.genderAtBirth = genderAtBirth;
	}
	public String getSexualOrientation() {
		return sexualOrientation;
	}
	public void setSexualOrientation(String sexualOrientation) {
		this.sexualOrientation = sexualOrientation;
	}
	public String getMaritalStatus() {
		return maritalStatus;
	}
	public void setMaritalStatus(String maritalStatus) {
		this.maritalStatus = maritalStatus;
	}
	public String getLivingArrangement() {
		return livingArrangement;
	}
	public void setLivingArrangement(String livingArrangement) {
		this.livingArrangement = livingArrangement;
	}
	public boolean isAdopted() {
		return isAdopted;
	}
	public void setAdopted(boolean isAdopted) {
		this.isAdopted = isAdopted;
	}
	
	public String getLicenseNumber() {
		return licenseNumber;
	}
	public void setLicenseNumber(String licenseNumber) {
		this.licenseNumber = licenseNumber;
	}
	public String getVehicleSerialNumber() {
		return vehicleSerialNumber;
	}
	public void setVehicleSerialNumber(String vehicleSerialNumber) {
		this.vehicleSerialNumber = vehicleSerialNumber;
	}
	public String getVehiclePlateNumber() {
		return vehiclePlateNumber;
	}
	public void setVehiclePlateNumber(String vehiclePlateNumber) {
		this.vehiclePlateNumber = vehiclePlateNumber;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getDeviceSerialNumber() {
		return deviceSerialNumber;
	}
	public void setDeviceSerialNumber(String deviceSerialNumber) {
		this.deviceSerialNumber = deviceSerialNumber;
	}
	public String getIpAddress() {
		return ipAddress;
	}
	public void setIpAddress(String ipAddress) {
		this.ipAddress = ipAddress;
	}
}
