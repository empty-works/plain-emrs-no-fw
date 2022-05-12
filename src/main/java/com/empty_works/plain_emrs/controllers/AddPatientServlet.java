package com.empty_works.plain_emrs.controllers;

import java.io.IOException;
import java.time.LocalDate;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.empty_works.plain_emrs.beans.PatientBean;

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
		pb.setGivenName(request.getParameter("patientGivenName"));
		pb.setMiddleInitial(request.getParameter("patientMiddleInitial"));
		pb.setLastName(request.getParameter("patientLastName"));
		pb.setDateOfBirth(LocalDate.parse(request.getParameter("patientDateOfBirth")));
		pb.setGender(request.getParameter("patientGender"));
		pb.setType(request.getParameter("patientType"));
		pb.setRace(request.getParameter("patientRace"));
		pb.setEthnicity(request.getParameter("patientEthnicity"));
		pb.setEmailAddress(request.getParameter("patientEmailAddress"));
		pb.setStreetAddress(request.getParameter("patientStreetAddress"));
		pb.setCity(request.getParameter("patientCity"));
		pb.setCountry(request.getParameter("patientCountry"));
		pb.setPhoneNumber(request.getParameter("patientPhoneNumber"));
		pb.setProvider(request.getParameter("patientProvider"));
		pb.setProviderId(request.getParameter("patientProviderId"));
		pb.setRoomNumber(Integer.parseInt(request.getParameter("patientRoom")));
		
		System.out.println("Adding patient to the database...");
		String addPatientResult = PatientDao 
		
		doGet(request, response);
	}
}
