package com.empty_works.plain_emrs.controllers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.empty_works.plain_emrs.beans.FacilityBean;
import com.empty_works.plain_emrs.beans.FacilityStaffPositionBean;
import com.empty_works.plain_emrs.dao.FacilityDao;
import com.empty_works.plain_emrs.util.ParamAttribHandler;

/**
 * Servlet implementation class FacilityPositionServlet
 */
@WebServlet("/FacilityPositionServlet")
public class FacilityPositionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		FacilityStaffPositionBean fspb = new FacilityStaffPositionBean();
		String facilityId = ParamAttribHandler.get(request, "facId");
		FacilityBean facility = FacilityDao.getFacility(facilityId);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
