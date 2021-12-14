package com.empty_works.plain_emrs.controllers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.empty_works.plain_emrs.beans.FacilityBean;
import com.empty_works.plain_emrs.dao.FacilityDao;
import com.empty_works.plain_emrs.util.FacilityIdUtil;

/**
 * Servlet implementation class FacilityServlet
 */
@WebServlet("/AddFacilityServlet")
public class AddFacilityServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.getRequestDispatcher("/WEB-INF/AddFacility.jsp").forward(request, response);
	}
	
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
		fb.setNumberOfBeds(Integer.parseInt(request.getParameter("facilityNumBeds")));
		fb.setDescription(request.getParameter("facilityDescription"));
		fb.setId(FacilityIdUtil.get(fb));
		
		System.out.println("Adding facility to database...");
		String facilityRegistrationResult = FacilityDao.register(fb);
		if(facilityRegistrationResult.equals(FacilityDao.FACILITYDAO_SUCCESS)) {
			
			System.out.println("Success! Facility now registered in the database.");
			request.setAttribute("fbean", fb);
			request.getRequestDispatcher("/WEB-INF/Facility.jsp").forward(request, response);
		}
		else {
			
			System.out.println("Facility setup failed! Returning to facility setup form...");
			request.setAttribute("errMessage", facilityRegistrationResult);
			request.getRequestDispatcher("/WEB-INF/FacilitySetup.jsp").forward(request, response);
		}
	}
}
