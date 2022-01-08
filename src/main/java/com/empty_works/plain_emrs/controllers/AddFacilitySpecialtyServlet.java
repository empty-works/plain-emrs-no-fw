package com.empty_works.plain_emrs.controllers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.empty_works.plain_emrs.beans.FacilityStaffSpecialtyBean;
import com.empty_works.plain_emrs.dao.FacilitySpecialtyDao;
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

		request.getRequestDispatcher("/FacilityServlet").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// Retrieve user input from form
		FacilityStaffSpecialtyBean fssb = new FacilityStaffSpecialtyBean();
		String facilityId = request.getParameter("facId");
		fssb.setFacilityId(facilityId);
		fssb.setName(request.getParameter("facilitySpecialtyName"));
		fssb.setDescription(request.getParameter("facilitySpecialtyDescription"));
		fssb.setStaffSpecialtyId(FacilitySpecialtyIdUtil.get(fssb));
		
		String result = FacilitySpecialtyDao.add(fssb);
		if(result.equals(FacilitySpecialtyDao.SPECIALTYDAO_SUCCESS)) {
			
			request.setAttribute("facId", facilityId);
			doGet(request, response);
		}
	}
}
