package com.empty_works.plain_emrs.controllers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.empty_works.plain_emrs.beans.FacilityBean;
import com.empty_works.plain_emrs.dao.FacilitySetupDao;
import com.empty_works.plain_emrs.util.FacilityIdUtil;

/**
 * Servlet implementation class FacilityServlet
 */
@WebServlet("/FacilitySetupServlet")
public class FacilitySetupServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		System.out.println("Setting parameters to FacilityBean...");
		FacilityBean fb = new FacilityBean();
		fb.setName(request.getParameter("facilityName"));
		fb.setStreetAddress(request.getParameter("facilityStreetAddress"));
		fb.setCity(request.getParameter("facilityCity"));
		fb.setState(request.getParameter("facilityState"));
		fb.setCountry(request.getParameter("facilityCountry"));
		fb.setZipCode(request.getParameter("facilityZipCode"));
		fb.setFacilityId(FacilityIdUtil.get(fb));
		
		System.out.println("Registering facility to database...");
		String facilityRegistrationResult = FacilitySetupDao.register(fb);
		if(facilityRegistrationResult.equals(FacilitySetupDao.FACILITYDAO_SUCCESS)) {
			
			System.out.println("Success! Facility now registered in the database.");
			request.setAttribute("fbean", fb);
			request.getRequestDispatcher("/Facility.jsp").forward(request, response);
		}
		else {
			
			System.out.println("Facility setup failed! Returning to facility setup form...");
			request.setAttribute("errMessage", facilityRegistrationResult);
			request.getRequestDispatcher("/FacilitySetup.jsp").forward(request, response);
		}
	}
}
