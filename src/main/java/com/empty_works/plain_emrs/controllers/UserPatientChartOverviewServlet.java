package com.empty_works.plain_emrs.controllers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class UserPatientChartOverviewServlet
 */
@WebServlet("/UserPatientChartOverviewServlet")
public class UserPatientChartOverviewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		/*
		HttpSession session = request.getSession();
		request.setAttribute("patientProvider", session.getAttribute("patientProvider"));
		request.setAttribute("patientProviderId", session.getAttribute("patientProviderId"));
		request.setAttribute("patientRoom", session.getAttribute("patientRoom"));
		request.setAttribute("patientType", session.getAttribute("patientType"));
		request.setAttribute("patientLanguagePreference", session.getAttribute("patientLanguagePreference"));
		request.setAttribute("patientBirthGender", session.getAttribute("patientBirthGender"));
		request.setAttribute("patientCurrentGender", session.getAttribute("patientCurrentGender"));
		*/
		
		System.out.println("Forwarding to UserPatientChartOverview.jsp...");
		request.getRequestDispatcher("/WEB-INF/UserPatientChartOverview.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
