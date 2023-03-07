package com.empty_works.plain_emrs.beans;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class PatientBean extends UserBean implements BeanDaoInterface {

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

	// Storage string of binary file for patient image
	private String base64PatientImage;
	
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
	
	public String getBase64PatientImage() {
		return base64PatientImage;
	}
	public void setBase64PatientImage(String base64PatientImage) {
		this.base64PatientImage = base64PatientImage;
	}
	
	@Override
	public String getWriteQuery() {
		return "INSERT INTO patients(user_id, patient_provider, patient_provider_id, patient_room, patient_current_gender, patient_type, "
				+ "patient_language_preference, patient_street_address, patient_city, patient_state, patient_country, patient_phone_number, "
				+ "patient_gender_at_birth, patient_sexual_orientation, patient_marital_status, patient_living_arrangement, patient_is_adopted, "
				+ "patient_license_number, patient_vehicle_serial_number, patient_vehicle_plate_number, patient_url, patient_device_serial_number, "
				+ "patient_ip_address) "
				+ "values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
	}
	@Override
	public String getErrorMessage() {
		return "Could not add patient to patients table!";
	}
	@Override
	public int prepareStatments(PreparedStatement preparedStatement) throws SQLException {
		
		System.out.println("Adding patient...");
		preparedStatement.setString(1, getUserId());
		preparedStatement.setString(2, getProvider());
		preparedStatement.setString(3, getProviderId());
		preparedStatement.setString(4, getRoomNumber());
		preparedStatement.setString(5, getCurrentGender());
		preparedStatement.setString(6, getType());
		preparedStatement.setString(7, getLanguagePreference());
		preparedStatement.setString(8, getStreetAddress());
		preparedStatement.setString(9, getCity());
		preparedStatement.setString(10, getState());
		preparedStatement.setString(11, getCountry());
		preparedStatement.setString(12, getPhoneNumber());
		preparedStatement.setString(13, getGenderAtBirth());
		preparedStatement.setString(14, getSexualOrientation());
		preparedStatement.setString(15, getMaritalStatus());
		preparedStatement.setString(16, getLivingArrangement());
		preparedStatement.setBoolean(17, isAdopted());
		preparedStatement.setString(18, getLicenseNumber());
		preparedStatement.setString(19, getVehicleSerialNumber());
		preparedStatement.setString(20, getVehiclePlateNumber());
		preparedStatement.setString(21, getUrl());
		preparedStatement.setString(22, getDeviceSerialNumber());
		preparedStatement.setString(23, getIpAddress());
		return preparedStatement.executeUpdate();
	}
}
