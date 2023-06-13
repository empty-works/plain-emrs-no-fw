package com.empty_works.plain_emrs.controllers;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.empty_works.plain_emrs.beans.MedicalRecordChiefComplaintsBean;
import com.empty_works.plain_emrs.dao.MedicalRecordChiefComplaintsDao;

/**
 * Servlet implementation class MedicalRecordEditChiefComplaintServlet
 */
@WebServlet("/MedicalRecordEditChiefComplaintServlet")
public class MedicalRecordEditChiefComplaintServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		System.out.println("Forwarding to MedicalRecordEditChiefComplaint.jsp...");
		request.getRequestDispatcher("/WEB-INF/MedicalRecordEditChiefComplaint.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("MedicalRecordLatestChiefComplaint doPut() method...");
		HttpSession session = request.getSession();
		String medRecordId = (String) session.getAttribute("medRecordId");
		MedicalRecordChiefComplaintsBean latestComplaint = (MedicalRecordChiefComplaintsBean) session.getAttribute("medRecordChiefComplaintsLatest");
		String statement = request.getParameter("chiefComplaintStatementInput");
		try {
			int success = MedicalRecordChiefComplaintsDao.updateStatement(statement, latestComplaint.getChiefComplaintId(), medRecordId);
			if(success != 0) {
				latestComplaint.setStatement(statement);
				session.setAttribute("medRecordChiefComplaintsLatest", latestComplaint);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
