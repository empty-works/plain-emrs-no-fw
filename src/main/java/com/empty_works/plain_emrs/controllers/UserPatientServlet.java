package com.empty_works.plain_emrs.controllers;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.empty_works.plain_emrs.beans.EmergencyContactsBean;
import com.empty_works.plain_emrs.beans.MedicalRecordAllergiesBean;
import com.empty_works.plain_emrs.beans.MedicalRecordBean;
import com.empty_works.plain_emrs.beans.MedicalRecordBloodRelativesBean;
import com.empty_works.plain_emrs.beans.MedicalRecordChiefComplaintsBean;
import com.empty_works.plain_emrs.beans.MedicalRecordDiseasesBean;
import com.empty_works.plain_emrs.beans.MedicalRecordIllnessesBean;
import com.empty_works.plain_emrs.beans.MedicalRecordMedicationBean;
import com.empty_works.plain_emrs.beans.MedicalRecordROSBean;
import com.empty_works.plain_emrs.beans.MedicalRecordSurgicalProblemsBean;
import com.empty_works.plain_emrs.beans.MedicalRecordVitalsBean;
import com.empty_works.plain_emrs.beans.UserPatientBean;
import com.empty_works.plain_emrs.beans.PatientRaceBean;
import com.empty_works.plain_emrs.dao.EmergencyContactsDao;
import com.empty_works.plain_emrs.dao.MedicalRecordAllergiesDao;
import com.empty_works.plain_emrs.dao.MedicalRecordDao;
import com.empty_works.plain_emrs.dao.UserPatientDao;
import com.empty_works.plain_emrs.dao.UserPatientRaceDao;

/**
 * Servlet implementation class PatientsServlet
 * 
 * NOTE: when selecting a patient this will only run once. So if the user clicks on the chart overview link again, 
 * storing everything in session doesn't need to happen again. This is the reason for this intermediary servlet before 
 * UserPatientChartOverviewServlet.
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
		PatientRaceBean patientRace = UserPatientRaceDao.get(userPatientId);
		EmergencyContactsBean emergencyContacts = EmergencyContactsDao.get(userPatientId);
		MedicalRecordBean medRecord = MedicalRecordDao.get(userPatientId);
		String medRecordId = medRecord.getMedicalRecordId();
		List<MedicalRecordAllergiesBean> medRecordAllergiesList = MedicalRecordAllergiesDao.get(medRecordId);
		MedicalRecordBloodRelativesBean medRecordBloodRelations;
		MedicalRecordChiefComplaintsBean medRecordChiefComplaints;
		MedicalRecordDiseasesBean medRecordDiseases;
		MedicalRecordIllnessesBean medRecordIllnesses;
		MedicalRecordMedicationBean medRecordMedication;
		MedicalRecordROSBean medRecordRos;
		MedicalRecordSurgicalProblemsBean medRecordSurgicalProblems;
		MedicalRecordVitalsBean medRecordVitals;

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
		
		/* Retrieve patient races as a list in the JSP. */
		session.setAttribute("patientRaceList", patientRace.getRaces());

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
		
		response.sendRedirect(request.getContextPath() + "/UserPatientChartOverviewServlet");
		//request.getRequestDispatcher("/WEB-INF/UserPatient.jsp").forward(request, response);
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
}