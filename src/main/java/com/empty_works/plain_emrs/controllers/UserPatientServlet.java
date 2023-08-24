package com.empty_works.plain_emrs.controllers;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;

import com.empty_works.plain_emrs.beans.EmergencyContactsBean;
import com.empty_works.plain_emrs.beans.MedicalRecordAdmissionsBean;
import com.empty_works.plain_emrs.beans.MedicalRecordAllergiesBean;
import com.empty_works.plain_emrs.beans.MedicalRecordBean;
import com.empty_works.plain_emrs.beans.MedicalRecordBloodRelativesBean;
import com.empty_works.plain_emrs.beans.MedicalRecordChiefComplaintsBean;
import com.empty_works.plain_emrs.beans.MedicalRecordImmunizationsBean;
import com.empty_works.plain_emrs.beans.MedicalRecordFamilyIllnessesBean;
import com.empty_works.plain_emrs.beans.MedicalRecordMedicationBean;
import com.empty_works.plain_emrs.beans.MedicalRecordNurseNotesBean;
import com.empty_works.plain_emrs.beans.MedicalRecordROSBean;
import com.empty_works.plain_emrs.beans.MedicalRecordSurgicalProblemsBean;
import com.empty_works.plain_emrs.beans.MedicalRecordVitalsBean;
import com.empty_works.plain_emrs.beans.PatientWrapper;
import com.empty_works.plain_emrs.beans.UserPatientBean;
import com.empty_works.plain_emrs.beans.UserPatientRaceBean;
import com.empty_works.plain_emrs.dao.EmergencyContactsDao;
import com.empty_works.plain_emrs.dao.MedicalRecordAdmissionsDao;
import com.empty_works.plain_emrs.dao.MedicalRecordAllergiesDao;
import com.empty_works.plain_emrs.dao.MedicalRecordBloodRelativesDao;
import com.empty_works.plain_emrs.dao.MedicalRecordChiefComplaintsDao;
import com.empty_works.plain_emrs.dao.MedicalRecordDao;
import com.empty_works.plain_emrs.dao.MedicalRecordImmunizationsDao;
import com.empty_works.plain_emrs.dao.MedicalRecordIllnessesDao;
import com.empty_works.plain_emrs.dao.MedicalRecordMedicationDao;
import com.empty_works.plain_emrs.dao.MedicalRecordNurseNotesDao;
import com.empty_works.plain_emrs.dao.MedicalRecordROSDao;
import com.empty_works.plain_emrs.dao.MedicalRecordSurgicalProblemsDao;
import com.empty_works.plain_emrs.dao.MedicalRecordVitalsDao;
import com.empty_works.plain_emrs.dao.UserPatientDao;
import com.empty_works.plain_emrs.dao.UserPatientRaceDao;

/**
 * Servlet implementation class PatientsServlet
 * 
 * NOTE: when selecting a patient this will only run once. So if the user clicks on the chart overview link again, 
 * storing everything in session doesn't need to happen again. This is the reason for this intermediary servlet before 
 * MedicalRecordLatestChiefComplaintServlet.
 */
@WebServlet("/UserPatientServlet")
public class UserPatientServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userPatientId = (String)request.getParameter("userPatientId");
		request.setAttribute("userPatientId", userPatientId);
		UserPatientBean patient = UserPatientDao.get(userPatientId);
		UserPatientRaceBean patientRace = UserPatientRaceDao.get(userPatientId);
		EmergencyContactsBean emergencyContacts = EmergencyContactsDao.get(userPatientId);
		MedicalRecordBean medRecord = MedicalRecordDao.get(userPatientId);
		String medRecordId = medRecord.getMedicalRecordId();
		System.out.println("Medical record ID: " + medRecordId);
		List<MedicalRecordAllergiesBean> medRecordAllergiesList = null;
		MedicalRecordBloodRelativesBean medRecordBloodRelations = null;
		List<MedicalRecordChiefComplaintsBean> medRecordChiefComplaintsList = null;
		List<MedicalRecordImmunizationsBean> medRecordImmunizationsList = null;
		List<MedicalRecordFamilyIllnessesBean> medRecordFamilyIllnessesList = null;
		List<MedicalRecordMedicationBean> medRecordMedicationList = null;
		List<MedicalRecordSurgicalProblemsBean> medRecordSurgicalProblemsList = null;
		List<MedicalRecordNurseNotesBean> medRecordNurseNotesList = null;
		List<MedicalRecordVitalsBean> medRecordVitalsList = null;
		List<MedicalRecordAdmissionsBean> medRecordAdmissionsList = null; 
		List<MedicalRecordROSBean> medRecordRosBeanList = null;
		try {
			medRecordAllergiesList = MedicalRecordAllergiesDao.get(medRecordId);
			medRecordBloodRelations = MedicalRecordBloodRelativesDao.get(medRecordId);
			medRecordChiefComplaintsList = MedicalRecordChiefComplaintsDao.get(medRecordId);
			medRecordImmunizationsList = MedicalRecordImmunizationsDao.get(medRecordId);
			medRecordFamilyIllnessesList = MedicalRecordIllnessesDao.get(medRecordId);
			medRecordMedicationList = MedicalRecordMedicationDao.get(medRecordId);
			medRecordSurgicalProblemsList = MedicalRecordSurgicalProblemsDao.get(medRecordId);
			medRecordNurseNotesList = MedicalRecordNurseNotesDao.get(medRecordId);
			medRecordVitalsList = MedicalRecordVitalsDao.get(medRecordId);
			medRecordAdmissionsList = MedicalRecordAdmissionsDao.get(medRecordId);
			medRecordRosBeanList = MedicalRecordROSDao.get(medRecordId);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		PatientWrapper patientWrapper = new PatientWrapper();
		patientWrapper.setUserPatientId(userPatientId);
		patientWrapper.setUserPatient(patient);
		patientWrapper.setUserPatientRace(patientRace);
		patientWrapper.setEmergencyContacts(emergencyContacts);
		patientWrapper.setMedicalRecord(medRecord);
		patientWrapper.setAllergiesList(medRecordAllergiesList);
		patientWrapper.setBloodRelatives(medRecordBloodRelations);
		patientWrapper.setChiefComplaintsList(medRecordChiefComplaintsList);
		patientWrapper.setImmunizationsList(medRecordImmunizationsList);
		patientWrapper.setFamilyIllnessesList(medRecordFamilyIllnessesList);
		patientWrapper.setMedicationList(medRecordMedicationList);
		patientWrapper.setSurgicalProblemsList(medRecordSurgicalProblemsList);
		patientWrapper.setNurseNotesList(medRecordNurseNotesList);
		patientWrapper.setVitalsList(medRecordVitalsList);
		patientWrapper.setAdmissionsList(medRecordAdmissionsList);
		patientWrapper.setRosList(medRecordRosBeanList);
		
		Gson gson = new Gson();
		String gsonPatientString = gson.toJson(patientWrapper);
		
		System.out.println("Gson patient string: " + gsonPatientString);

		// Set the response content type to JSON
        response.setContentType("application/json");
        
        // Write the JSON string to the response body
        response.getWriter().write(gsonPatientString);
        
		/*
		// Store retrieved variables from the database into JSON.
		JSONObject jsonPatient = new JSONObject();
		jsonPatient.put("patientProvider", patient.getProvider());
		System.out.println("JSON patientProvider: " + jsonPatient.getString("patientProvider"));
		jsonPatient.put("patientProviderId", patient.getProviderId());
		jsonPatient.put("patientRoom", patient.getRoomNumber());
		jsonPatient.put("patientType", patient.getType());
		jsonPatient.put("patientLanguagePreference", patient.getLanguagePreference());
		jsonPatient.put("patientStreetAddress", patient.getStreetAddress());
		jsonPatient.put("patientCity", patient.getCity());
		jsonPatient.put("patientState", patient.getState());
		jsonPatient.put("patientCountry", patient.getCountry());
		jsonPatient.put("patientPhoneNumber", patient.getPhoneNumber());
		jsonPatient.put("patientBirthGender", patient.getGenderAtBirth());
		jsonPatient.put("patientCurrentGender", patient.getCurrentGender());
		jsonPatient.put("patientSexualOrientation", patient.getSexualOrientation());
		jsonPatient.put("patientMaritalStatus", patient.getMaritalStatus());
		jsonPatient.put("patientLivingArrangement", patient.getLivingArrangement());
		jsonPatient.put("patientAdopted", patient.isAdopted());
		
		jsonPatient.put("patientRaceList", patientRace.getRaces());
		jsonPatient.put("userPatientId", userPatientId);
		jsonPatient.put("userEmailAddress", patient.getEmailAddress());
		jsonPatient.put("userEnabled", patient.isUserEnabled());
		jsonPatient.put("userCreatedOn", patient.getDateCreated());
		jsonPatient.put("userCurrentFacilityId", patient.getCurrentFacilityId());
		jsonPatient.put("userPatientFirstName", patient.getFirstName());
		jsonPatient.put("userPatientMiddleInitial", patient.getMiddleInitial());
		jsonPatient.put("userPatientLastName", patient.getLastName());
		jsonPatient.put("userDateOfBirth", patient.getDateOfBirth());
		jsonPatient.put("licenseNumber", patient.getLicenseNumber());
		jsonPatient.put("vehicleSerialNumber", patient.getVehicleSerialNumber());
		jsonPatient.put("vehiclePlateNumber", patient.getVehiclePlateNumber());
		jsonPatient.put("url", patient.getUrl());
		jsonPatient.put("deviceSerialNumber", patient.getDeviceSerialNumber());
		jsonPatient.put("ipAddress", patient.getIpAddress());
		jsonPatient.put("emergencyContactFirstName", emergencyContacts.getFirstName());
		jsonPatient.put("emergencyContactLastName", emergencyContacts.getLastName());
		jsonPatient.put("emergencyContactPhoneNumber", emergencyContacts.getPhoneNumber());
		jsonPatient.put("emergencyContactEmail", emergencyContacts.getEmail());
		jsonPatient.put("medRecord", medRecord);
		jsonPatient.put("medRecordId", medRecordId);
		jsonPatient.put("medRecordAllergiesList", medRecordAllergiesList);
		jsonPatient.put("medRecordBloodRelatives", medRecordBloodRelations);
		jsonPatient.put("medRecordChiefComplaintsList", medRecordChiefComplaintsList);
		jsonPatient.put("medRecordChiefComplaintsLatest", getLatest(medRecordChiefComplaintsList));
		jsonPatient.put("medRecordDiseasesList", medRecordDiseasesList);
		jsonPatient.put("medRecordIllnessesList", medRecordIllnessesList);
		jsonPatient.put("medRecordMedicationList", medRecordMedicationList);
		jsonPatient.put("medRecordSurgicalProblemsList", medRecordSurgicalProblemsList);
		jsonPatient.put("medRecordNurseNotesList", medRecordNurseNotesList);
		jsonPatient.put("medRecordVitals", getLatestVitalsDate(medRecordVitalsList));
		jsonPatient.put("medRecordAdmissionsList", medRecordAdmissionsList);
		jsonPatient.put("medRecordRosList", medRecordRosBeanList);
		jsonPatient.put("medRecordRosLatest", getLatestRosDate(medRecordRosBeanList));
		
		// Set the response content type to JSON
	    response.setContentType("application/json");
	    
	    // Write the JSON data to the response
	    PrintWriter out = response.getWriter();
	    out.print(jsonPatient);
	    
		*/

        /*
		// Store retrieved variables from the database into session variables. 
		HttpSession session = request.getSession();
		session.setAttribute("patientProvider", patient.getProvider());
		session.setAttribute("patientProviderId", patient.getProviderId());
		session.setAttribute("patientRoom", patient.getRoomNumber());
		session.setAttribute("patientType", patient.getType());
		session.setAttribute("patientLanguagePreference", patient.getLanguagePreference());
		session.setAttribute("patientStreetAddress", patient.getStreetAddress());
		session.setAttribute("patientCity", patient.getCity());
		session.setAttribute("patientState", patient.getState());
		session.setAttribute("patientCountry", patient.getCountry());
		session.setAttribute("patientPhoneNumber", patient.getPhoneNumber());
		session.setAttribute("patientBirthGender", patient.getGenderAtBirth());
		session.setAttribute("patientCurrentGender", patient.getCurrentGender());
		session.setAttribute("patientSexualOrientation", patient.getSexualOrientation());
		session.setAttribute("patientMaritalStatus", patient.getMaritalStatus());
		session.setAttribute("patientLivingArrangement", patient.getLivingArrangement());
		session.setAttribute("patientAdopted", patient.isAdopted());
		
		// Retrieve patient races as a list in the JSP. 
		session.setAttribute("patientRaceList", patientRace.getRaces());

		session.setAttribute("userPatientId", userPatientId);
		session.setAttribute("userEmailAddress", patient.getEmailAddress());
		session.setAttribute("userEnabled", patient.isUserEnabled());
		session.setAttribute("userCreatedOn", patient.getDateCreated());
		session.setAttribute("userCurrentFacilityId", patient.getCurrentFacilityId());
		session.setAttribute("userPatientFirstName", patient.getFirstName());
		session.setAttribute("userPatientMiddleInitial", patient.getMiddleInitial());
		session.setAttribute("userPatientLastName", patient.getLastName());
		session.setAttribute("userDateOfBirth", patient.getDateOfBirth());
		session.setAttribute("licenseNumber", patient.getLicenseNumber());
		session.setAttribute("vehicleSerialNumber", patient.getVehicleSerialNumber());
		session.setAttribute("vehiclePlateNumber", patient.getVehiclePlateNumber());
		session.setAttribute("url", patient.getUrl());
		session.setAttribute("deviceSerialNumber", patient.getDeviceSerialNumber());
		session.setAttribute("ipAddress", patient.getIpAddress());
		session.setAttribute("emergencyContactFirstName", emergencyContacts.getFirstName());
		session.setAttribute("emergencyContactLastName", emergencyContacts.getLastName());
		session.setAttribute("emergencyContactPhoneNumber", emergencyContacts.getPhoneNumber());
		session.setAttribute("emergencyContactEmail", emergencyContacts.getEmail());

		session.setAttribute("medRecord", medRecord);
		session.setAttribute("medRecordId", medRecordId);
		session.setAttribute("medRecordAllergiesList", medRecordAllergiesList);
		session.setAttribute("medRecordBloodRelatives", medRecordBloodRelations);
		session.setAttribute("medRecordChiefComplaintsList", medRecordChiefComplaintsList);
		session.setAttribute("medRecordChiefComplaintsLatest", getLatest(medRecordChiefComplaintsList));
		session.setAttribute("medRecordDiseasesList", medRecordDiseasesList);
		session.setAttribute("medRecordIllnessesList", medRecordIllnessesList);
		session.setAttribute("medRecordMedicationList", medRecordMedicationList);
		session.setAttribute("medRecordSurgicalProblemsList", medRecordSurgicalProblemsList);
		session.setAttribute("medRecordNurseNotesList", medRecordNurseNotesList);
		session.setAttribute("medRecordVitals", getLatestVitalsDate(medRecordVitalsList));
		session.setAttribute("medRecordAdmissionsList", medRecordAdmissionsList);
		
		session.setAttribute("medRecordRosList", medRecordRosBeanList);
		System.out.println("Latest ROS: " + getLatestRosDate(medRecordRosBeanList));
		session.setAttribute("medRecordRosLatest", getLatestRosDate(medRecordRosBeanList));
		
		System.out.println("Forwarding to MedicalRecordLatestChiefComplaintServlet from UserPatientServlet...");
		//response.sendRedirect(request.getContextPath() + "/MedicalRecordLatestChiefComplaintServlet");
		request.getRequestDispatcher("/WEB-INF/MedicalRecordLatestChiefComplaint.jsp").forward(request, response);
		*/
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// Get start row and row count from the JSP.
		
		// Update start row and row count variables after incrementing depending on if the previous or next button was clicked.
		// Update session start row and row count.
		HttpSession session = request.getSession();
	}
	
	/**
	 * 
	 * @param vitalsList
	 * @return
	 */
	private MedicalRecordVitalsBean getLatestVitalsDate(List<MedicalRecordVitalsBean> vitalsList) {
		
		if(vitalsList == null || vitalsList.isEmpty()) {
			return null;
		}
		return Collections.max(vitalsList, Comparator.comparing(MedicalRecordVitalsBean::getDateTaken));
	}
	
	private MedicalRecordROSBean getLatestRosDate(List<MedicalRecordROSBean> rosList) {
		
		if(rosList == null || rosList.isEmpty()) {
			return null;
		}
		return Collections.max(rosList, Comparator.comparing(MedicalRecordROSBean::getDate));
	}
	
	private MedicalRecordChiefComplaintsBean getLatest(List<MedicalRecordChiefComplaintsBean> chiefComplaintsList) {
		
		if(chiefComplaintsList == null || chiefComplaintsList.isEmpty()) {
			return null;
		}
		return Collections.max(chiefComplaintsList, Comparator.comparing(MedicalRecordChiefComplaintsBean::getChiefComplaintId));
	}
}