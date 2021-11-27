package com.empty_works.plain_emrs.controllers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.empty_works.plain_emrs.beans.FacilityStaffSpecialtyBean;
import com.empty_works.plain_emrs.util.FacilitySpecialtyIdUtil;

/**
 * Servlet implementation class AddFacilitySpecialtyServlet
 */
@WebServlet("/AddFacilitySpecialtyServlet")
public class AddFacilitySpecialtyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddFacilitySpecialtyServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// Retrieve user input from form
		FacilityStaffSpecialtyBean fssb = new FacilityStaffSpecialtyBean();
		fssb.setFacilityId(request.getParameter("facilityId"));
		fssb.setName(request.getParameter("facilityId"));
		fssb.setDescription(request.getParameter("specialtyDescription"));
		fssb.setId(FacilitySpecialtyIdUtil.get(fssb));
		
		
		
		doGet(request, response);
	}
}
