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
		System.out.println("userPatientId: " + userPatientId);
		request.setAttribute("userPatientId", userPatientId);
		PatientBean patient = UserPatientDao.getPatient(userPatientId);
		
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