package com.empty_works.plain_emrs.controllers;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.empty_works.plain_emrs.beans.PatientBean;
import com.empty_works.plain_emrs.dao.UserPatientDao;

/**
 * Servlet implementation class PatientsServlet
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
		PatientBean patient = UserPatientDao.getPatient(userPatientId);
		request.setAttribute("patientProvider", patient.getProvider());
		request.setAttribute("patientProviderId", patient.getProviderId());
		request.setAttribute("patientRoom", patient.getRoomNumber());
		request.setAttribute("patientType", patient.getType());
		request.setAttribute("patientLanguagePreference", patient.getLanguagePreference());
		request.setAttribute("patientStreetAddress", patient.getStreetAddress());
		request.setAttribute("patientCity", patient.getCity());
		request.setAttribute("patientState", patient.getState());
		request.setAttribute("patientCountry", patient.getCountry());
		request.setAttribute("patientPhoneNumber", patient.getPhoneNumber());
		request.setAttribute("patientBirthGender", patient.getGenderAtBirth());
		request.setAttribute("userEmailAddress", patient.getEmailAddress());
		request.setAttribute("userEnabled", patient.isUserEnabled());
		request.setAttribute("userCreatedOn", patient.getDateCreated());
		request.setAttribute("userCurrentFacilityId", patient.getCurrentFacilityId());
		request.setAttribute("userPatientFirstName", patient.getFirstName());
		request.setAttribute("userPatientMiddleInitial", patient.getMiddleInitial());
		request.setAttribute("userPatientLastName", patient.getLastName());
		request.setAttribute("userDateOfBirth", patient.getDateOfBirth());
		request.setAttribute("emergencyContactGivenName", patient.getEmergencyContactGivenName());
		request.setAttribute("emergencyContactLastName", patient.getEmergencyContactLastName());
		request.setAttribute("emergencyContactPhoneNumber", patient.getEmergencyContactPhoneNumber());
		request.setAttribute("emergencyContactEmail", patient.getEmergencyContactEmail());
		request.getRequestDispatcher("/WEB-INF/UserPatient.jsp").forward(request, response);
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