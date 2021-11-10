package com.empty_works.plain_emrs.controllers;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.empty_works.plain_emrs.beans.FacilityBean;
import com.empty_works.plain_emrs.beans.FacilityWardBean;
import com.empty_works.plain_emrs.dao.FacilityDao;
import com.empty_works.plain_emrs.dao.FacilityWardDao;

/**
 * Servlet implementation class FacilityServlet
 */
@WebServlet("/FacilityServlet")
public class FacilityServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FacilityServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// Get specified facility
		FacilityBean facility = FacilityDao.getFacility(request.getParameter("facId"));
		request.setAttribute("facility", facility);
		// Get list of wards
		List<FacilityWardBean> fwbList = FacilityWardDao.getList();
		request.setAttribute("facilityWardList", fwbList);
		// Get list of staff positions
		// Get list of staff specialties
		request.getRequestDispatcher("/WEB-INF/Facility.jsp").forward(request, response);
	}
}
