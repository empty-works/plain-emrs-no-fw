package com.empty_works.plain_emrs.controllers;

import java.io.IOException;
import java.time.LocalDate;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.empty_works.plain_emrs.beans.PatientBean;
import com.empty_works.plain_emrs.dao.UserPatientDao;
import com.empty_works.plain_emrs.util.UserIdUtil;

/**
 * Servlet implementation class AddPatientServlet
 */
@WebServlet("/AddPatientServlet")
public class AddPatientServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.getRequestDispatcher("/WEB-INF/AddPatient.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("Settings parameters to patient bean...");
		PatientBean pb = new PatientBean();
		String givenName = request.getParameter("patientGivenName");
		String middleInitial = request.getParameter("patientMiddleInitial");
		String lastName = request.getParameter("patientLastName");
		//pb.setGivenName(givenName);
		pb.setMiddleInitial(middleInitial);
		pb.setLastName(lastName);
		//pb.setDateOfBirth(LocalDate.parse(request.getParameter("patientDateOfBirth")));
		pb.setCurrentGender(request.getParameter("patientGender"));
		pb.setType(request.getParameter("patientType"));
		//pb.setRace(request.getParameter("patientRace"));
		//pb.setEthnicity(request.getParameter("patientEthnicity"));
		pb.setStreetAddress(request.getParameter("patientStreetAddress"));
		pb.setCity(request.getParameter("patientCity"));
		pb.setState(request.getParameter("patientState"));
		pb.setCountry(request.getParameter("patientCountry"));
		pb.setPhoneNumber(request.getParameter("patientPhoneNumber"));
		pb.setProvider(request.getParameter("patientProvider"));
		pb.setProviderId(request.getParameter("patientProviderId"));
		pb.setRoomNumber(request.getParameter("patientRoom"));
		pb.setFacilityId(request.getParameter("patientFacilityId"));
		//pb.setPatientId(PatientIdUtil.get(givenName, lastName));
		
		System.out.println("Adding patient to the database...");
		String patientAddResult = UserPatientDao.add(pb);
		if(patientAddResult.equals(UserPatientDao.PATIENTDAO_SUCCESS)) {
			
			System.out.println("Patient successfully added to the database!");
			//request.setAttribute(UserPatientServlet.patientDbAttribute, pb);
			request.getRequestDispatcher("/WEB-INF/Patient.jsp").forward(request, response);
		}
		else {
			
			System.out.println("Patient setup failed!");
			request.setAttribute("errMessage", patientAddResult);
			request.getRequestDispatcher("/WEB-INF/AddPatient.jsp").forward(request, response);
		}
		
		doGet(request, response);
	}
}
