package com.empty_works.plain_emrs.controllers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.empty_works.plain_emrs.beans.MedicalRecordBean;
import com.empty_works.plain_emrs.dao.MedicalRecordDao;

/**
 * Servlet implementation class UserPatientMedicalHistoryServlet
 */
@WebServlet("/UserPatientMedicalHistoryServlet")
public class UserPatientMedicalHistoryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userPatientId = (String)request.getParameter("userPatientId");
		MedicalRecordBean medBean = MedicalRecordDao.get(userPatientId);
		request.setAttribute("userPatientId", userPatientId);
		request.setAttribute("medicalRecordId", medBean.getMedicalRecordId());
		request.setAttribute("medRecordPatientCondition", medBean.getPatientCondition());
		request.setAttribute("medRecordCreated", medBean.getMedicalRecordCreatedOn());
		request.setAttribute("medRecordIsActive", medBean.isActive());
		request.setAttribute("medRecordBloodTransfusionStatus", medBean.getBloodTransfusionStatus());
		request.getRequestDispatcher("/WEB-INF/UserPatientMedicalHistory.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
