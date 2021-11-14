package com.empty_works.plain_emrs.controllers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.empty_works.plain_emrs.beans.FacilityWardBean;
import com.empty_works.plain_emrs.dao.AddFacilityWardDao;
import com.empty_works.plain_emrs.util.FacilityWardIdUtil;

/**
 * Servlet implementation class AddFacilityWardServlet
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
		request.getRequestDispatcher("/FacilityServlet").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		FacilityWardBean wb = new FacilityWardBean();
		String facilityId = request.getParameter("setFacId");
		wb.setFacilityId(facilityId);
		System.out.println("Testing facility ID: " + wb.getFacilityId());
		wb.setName(request.getParameter("facilityWardName"));
		wb.setLocation(request.getParameter("facilityWardLocation"));
		String wbId = FacilityWardIdUtil.get(wb);
		System.out.println("Facility Ward Bean ID result= " + wbId);
		wb.setWardId(wbId);
		
		String addFacWardResult = AddFacilityWardDao.add(wb);
		System.out.println("AddFacilityWardServlet addFacWardResult = " + addFacWardResult);
		if(addFacWardResult.equals(AddFacilityWardDao.ADDFACWARDDAO_SUCCESS)) {
			
			request.setAttribute("facId", facilityId);
			doGet(request, response);
		}
	}
}
