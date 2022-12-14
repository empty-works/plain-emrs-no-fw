package com.empty_works.plain_emrs.controllers;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.empty_works.plain_emrs.beans.PatientBean;
import com.empty_works.plain_emrs.dao.UserPatientDao;

/**
 * Servlet implementation class UserPatientListServlet
 */
@WebServlet("/UserPatientListServlet")
public class UserPatientListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static String patientDbAttribute = "patientDb";
	private int startRow = 0, rowCount = 25;
       
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("startRow", startRow);
		request.setAttribute("rowCount", rowCount);
		List<PatientBean> theList = UserPatientDao.getList(startRow, rowCount);
		System.out.println("Patient sublist: " + theList);
		request.setAttribute("patientSublist", theList);

		request.getRequestDispatcher("/WEB-INF/UserPatientList.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}
