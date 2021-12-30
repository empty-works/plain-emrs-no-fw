package com.empty_works.plain_emrs.controllers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.empty_works.plain_emrs.beans.FacilityBean;

/**
 * Servlet implementation class EditFacilityServlet
 */
@WebServlet("/EditFacilityServlet")
public class EditFacilityServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditFacilityServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		FacilityBean fb = new FacilityBean();
		fb.setId(request.getParameter("facId"));
		fb.setName(request.getParameter("facilityName"));
		fb.setStreetAddress(request.getParameter("facilityStreetAddress"));
		fb.setCity(request.getParameter("facilityCity"));
		fb.setState(request.getParameter("facilityState"));
		fb.setCountry(request.getParameter("facilityCountry"));
		fb.setZipCode(request.getParameter("facilityZipCode"));
		fb.setNumberOfBeds(Integer.parseInt(request.getParameter("facilityNumBeds")));
		fb.setDescription(request.getParameter("facilityDescription"));
		
		//doGet(request, response);
	}
}
