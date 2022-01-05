package com.empty_works.plain_emrs.controllers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.empty_works.plain_emrs.beans.FacilityWardBean;
import com.empty_works.plain_emrs.dao.FacilityWardDao;
import com.empty_works.plain_emrs.util.FacilityWardIdUtil;

/**
 * Servlet implementation class WardServlet
 */
@WebServlet("/AddFacilityWardServlet")
public class AddFacilityWardServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddFacilityWardServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.getRequestDispatcher("/FacilityWardServlet").forward(request, response);
	}
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		FacilityWardBean fwb = new FacilityWardBean();
		String facilityId = request.getParameter("facId");
		fwb.setFacilityId(facilityId);
		fwb.setName(request.getParameter("facilityWardName"));
		fwb.setLocation(request.getParameter("facilityWardLocation"));
		fwb.setWardId(FacilityWardIdUtil.get(fwb));
		
		String facWardResult = FacilityWardDao.add(fwb);
		System.out.println("FacilityWardServlet facWardResult = " + facWardResult);
		if(facWardResult.equals(FacilityWardDao.ADDFACWARDDAO_SUCCESS)) {
			
			request.setAttribute("facId", facilityId);
			doGet(request, response);
		}
	}
}
