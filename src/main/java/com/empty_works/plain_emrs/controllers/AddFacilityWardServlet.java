package com.empty_works.plain_emrs.controllers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.empty_works.plain_emrs.beans.FacilityWardBean;

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
		wb.setName(request.getParameter("facName"));
		System.out.println("Testing facility ID: " + wb.getFacilityId());
	}
}
