package com.empty_works.plain_emrs.controllers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.empty_works.plain_emrs.beans.FacilityWardBean;
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
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		FacilityWardBean wb = new FacilityWardBean();
		wb.setFacilityId(request.getParameter("facId"));
		System.out.println("Testing facility ID: " + wb.getFacilityId());
		wb.setName(request.getParameter("facilityName"));
		wb.setLocation(request.getParameter("facilityLocation"));
		String wbId = FacilityWardIdUtil.get(wb);
		System.out.println("Facility Ward Bean ID result= " + wbId);
		wb.setWardId(wbId);
	}
}
