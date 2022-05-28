package com.empty_works.plain_emrs.controllers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.empty_works.plain_emrs.roles.RolePair;

/**
 * Servlet implementation class FacilitySelectionServlet
 */
@WebServlet("/FacilitySelectionServlet")
public class FacilitySelectionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		
		request.getRequestDispatcher("/WEB-INF/FacilitySelection.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}
	
	/**
	 * 
	 * @param userRole
	 * @param username
	 */
	private void setSessionUserAndRole(RolePair userRole, HttpServletRequest request, HttpServletResponse response) {
		
		System.out.println(userRole.getRole() + "'s " + "Home");
		try {

			request.getRequestDispatcher("/WEB-INF/" + userRole.getRole() + ".jsp").forward(request, response);
		} catch (ServletException | IOException e) {

			e.printStackTrace();
		}
	}
}
