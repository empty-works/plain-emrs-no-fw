package com.empty_works.plain_emrs.controllers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.empty_works.plain_emrs.beans.FacilityBean;
import com.empty_works.plain_emrs.dao.FacilityDao;

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
		
		System.out.println("Updating facility...");
		String editFacilityResult = FacilityDao.update(fb);
		if(editFacilityResult.equals(FacilityDao.FACILITYDAO_SUCCESS)) {
			
			System.out.println("Facility updated successfully!");
			request.setAttribute(FacilityServlet.facilityDbAttribute, fb);
		}
		else {
			
			System.out.println("Facility update failed! Returning to facility...");
			request.setAttribute("errMessage", editFacilityResult);
		}
		request.getRequestDispatcher("/WEB-INF/Facility.jsp").forward(request, response);
	}
}
