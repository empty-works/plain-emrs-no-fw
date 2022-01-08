package com.empty_works.plain_emrs.controllers;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.empty_works.plain_emrs.beans.FacilityStaffSpecialtyBean;
import com.empty_works.plain_emrs.dao.FacilitySpecialtyDao;
import com.empty_works.plain_emrs.util.ParamAttribHandler;

/**
 * Servlet implementation class FacilitySpecialtyServlet
 */
@WebServlet("/FacilitySpecialtyServlet")
public class FacilitySpecialtyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String facilityId = ParamAttribHandler.get(request, "facId");
		List<FacilityStaffSpecialtyBean> fssbList = FacilitySpecialtyDao.getList(facilityId);
		request.setAttribute("facId", facilityId);
		request.setAttribute("facilitySpecialtyList", fssbList);
		request.getRequestDispatcher("/WEB-INF/FacilityStaffSpecialty.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
