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
import com.empty_works.plain_emrs.util.ParamAttribHandler;

/**
 * Servlet implementation class FacilityWardServlet
 */
@WebServlet("/FacilityWardServlet")
public class FacilityWardServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FacilityWardServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Get list of wards
		String facilityId = ParamAttribHandler.get(request, "facId");
		FacilityBean facility = FacilityDao.getFacility(facilityId);
		List<FacilityWardBean> fwbList = FacilityWardDao.getList(facility.getId());
		request.setAttribute("facilityWardList", fwbList);
		request.getRequestDispatcher("/WEB-INF/FacilityWard.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
