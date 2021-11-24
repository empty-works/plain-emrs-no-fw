package com.empty_works.plain_emrs.controllers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.empty_works.plain_emrs.beans.FacilityStaffPositionBean;
import com.empty_works.plain_emrs.dao.FacilityPositionDao;
import com.empty_works.plain_emrs.util.FacilityPositionIdUtil;

/**
 * Servlet implementation class AddFacilityPositionServlet
 */
@WebServlet("/AddFacilityPositionServlet")
public class AddFacilityPositionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddFacilityPositionServlet() {
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
		
		FacilityStaffPositionBean fspb = new FacilityStaffPositionBean();
		String facilityId = request.getParameter("setFacId");
		fspb.setFacilityId(facilityId);
		fspb.setName(request.getParameter("facilityPositionName"));
		fspb.setDescription(request.getParameter("facilityPositionDescription"));
		fspb.setId(FacilityPositionIdUtil.get(fspb));
		
		String facPositionResult = FacilityPositionDao.add(fspb);
		System.out.println("AddFacilityPositionServlet facPositionResult = " + facPositionResult);
		if(facPositionResult.equals(FacilityPositionDao.ADDFACPOSITIONDAO_SUCCESS)) {
			
			request.setAttribute("facId", facilityId);
			doGet(request, response);
		}
	}
}
