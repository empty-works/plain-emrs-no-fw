package com.empty_works.plain_emrs.controllers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.empty_works.plain_emrs.beans.PatientBean;
import com.empty_works.plain_emrs.dao.PatientDao;

/**
 * Servlet implementation class PatientSearchServlet
 */
@WebServlet("/PatientSearchServlet")
public class PatientSearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.getRequestDispatcher("/WEB-INF/PatientSearch.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		/*
		String patientId = "";
		String testId = request.getParameter("patientId");
		System.out.println("Test Patient ID: " + testId);
		if(!request.getParameter("patientId").isEmpty()) {
			
			patientId = request.getParameter("patientId");
			System.out.println("Retrieving request patient data...");
			PatientBean patient = PatientDao.getPatient(patientId);
			request.setAttribute("patientDb", patient);
		}
		request.setAttribute("patientIdCheck", patientId);
		doGet(request, response);
		*/
	}
}
