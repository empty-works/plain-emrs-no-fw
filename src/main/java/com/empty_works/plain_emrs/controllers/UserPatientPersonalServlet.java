package com.empty_works.plain_emrs.controllers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.empty_works.plain_emrs.beans.MedicalRecordBean;
import com.empty_works.plain_emrs.dao.MedicalRecordDao;

/**
 * Servlet implementation class UserPatientPersonalServlet
 */
@WebServlet("/UserPatientPersonalServlet")
public class UserPatientPersonalServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userPatientId = (String)request.getParameter("userPatientId");
		MedicalRecordBean medBean = MedicalRecordDao.get(userPatientId);
		
		HttpSession session = request.getSession();
		request.setAttribute("patientStreetAddress", session.getAttribute("patientStreetAddress"));
		request.setAttribute("patientCity", session.getAttribute("patientCity"));
		request.setAttribute("patientState", session.getAttribute("patientState"));
		request.setAttribute("patientCountry", session.getAttribute("patientCountry"));
		request.setAttribute("patientPhoneNumber", session.getAttribute("patientPhoneNumber"));
		request.setAttribute("patientSexualOrientation", session.getAttribute("patientSexualOrientation"));
		request.setAttribute("patientMaritalStatus", session.getAttribute("patientMaritalStatus"));
		request.setAttribute("patientLivingArrangement", session.getAttribute("patientLivingArrangement"));
		request.setAttribute("patientAdopted", session.getAttribute("patientAdopted"));

		/* Retrieve patient races as a list in the JSP. */
		request.setAttribute("patientRaceList", session.getAttribute("patientRaceList"));

		request.setAttribute("userEmailAddress", session.getAttribute("userEmailAddress"));
		request.setAttribute("userEnabled", session.getAttribute("userEnabled"));
		request.setAttribute("userCreatedOn", session.getAttribute("userCreatedOn"));
		request.setAttribute("userCurrentFacilityId", session.getAttribute("userCurrentFacilityId"));
		request.setAttribute("userPatientFirstName", session.getAttribute("userPatientFirstName"));
		request.setAttribute("userPatientMiddleInitial", session.getAttribute("userPatientMiddleInitial"));
		request.setAttribute("userPatientLastName", session.getAttribute("userPatientLastName"));
		request.setAttribute("userDateOfBirth", session.getAttribute("userDateOfBirth"));
		request.setAttribute("licenseNumber", session.getAttribute("licenseNumber"));
		request.setAttribute("vehicleSerialNumber", session.getAttribute("vehicleSerialNumber"));
		request.setAttribute("vehiclePlateNumber", session.getAttribute("vehiclePlateNumber"));
		request.setAttribute("url", session.getAttribute("url"));
		request.setAttribute("deviceSerialNumber", session.getAttribute("deviceSerialNumber"));
		request.setAttribute("ipAddress", session.getAttribute("ipAddress"));
		request.setAttribute("emergencyContactFirstName", session.getAttribute("emergencyContactFirstName"));
		request.setAttribute("emergencyContactLastName", session.getAttribute("emergencyContactLastName"));
		request.setAttribute("emergencyContactPhoneNumber", session.getAttribute("emergencyContactPhoneNumber"));
		request.setAttribute("emergencyContactEmail", session.getAttribute("emergencyContactEmail"));
		
		request.getRequestDispatcher("/WEB-INF/UserPatientPersonal.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
