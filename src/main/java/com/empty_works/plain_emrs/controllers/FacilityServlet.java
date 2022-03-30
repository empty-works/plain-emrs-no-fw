package com.empty_works.plain_emrs.controllers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.empty_works.plain_emrs.beans.FacilityBean;
import com.empty_works.plain_emrs.beans.FacilityStaffPositionBean;
import com.empty_works.plain_emrs.beans.FacilityStaffSpecialtyBean;
import com.empty_works.plain_emrs.beans.FacilityWardBean;
import com.empty_works.plain_emrs.beans.RoleBean;
import com.empty_works.plain_emrs.dao.FacilityDao;
import com.empty_works.plain_emrs.dao.FacilityPositionDao;
import com.empty_works.plain_emrs.dao.FacilitySpecialtyDao;
import com.empty_works.plain_emrs.dao.FacilityWardDao;
import com.empty_works.plain_emrs.dao.RoleDao;
import com.empty_works.plain_emrs.util.ParamAttribHandler;

/**
 * Servlet implementation class FacilityServlet
 */
@WebServlet("/FacilityServlet")
public class FacilityServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static String facilityDbAttribute = "facilityDb";
       
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
		String facilityId = ParamAttribHandler.get(request, "facId");
		System.out.println("FacilityServlet doGet facility ID = " + facilityId);
		FacilityBean facility = FacilityDao.getFacility(facilityId);
		System.out.println("FacilityServlet doGet facility name= " + facility.getName());
		request.setAttribute(facilityDbAttribute, facility);
		// Get list of staff positions
		List<FacilityStaffPositionBean> fspbList = FacilityPositionDao.getList(facility.getId());
		request.setAttribute("facilityPositionList", fspbList);
		// Get list of staff specialties
		List<FacilityStaffSpecialtyBean> fssbList = FacilitySpecialtyDao.getList(facility.getId());
		request.setAttribute("facilitySpecialtyList", fssbList);
		
		// Facility-specific roles
		List<RoleBean> roles = new ArrayList<>();
		roles = RoleDao.getList();
		request.setAttribute("rolesList", roles);
		
		request.getRequestDispatcher("/WEB-INF/Facility.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
