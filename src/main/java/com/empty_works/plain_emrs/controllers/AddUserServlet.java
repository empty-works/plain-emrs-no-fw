package com.empty_works.plain_emrs.controllers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.empty_works.plain_emrs.beans.UserBean;
import com.empty_works.plain_emrs.roles.PlainEmrsRoles;

/**
 * Servlet implementation class AddUserServlet
 */
@WebServlet("/AddUserServlet")
public class AddUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setAttribute("roleList", PlainEmrsRoles.roleList);
		request.getRequestDispatcher("/WEB-INF/AddUser.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		UserBean user = new UserBean();
		user.setEmailAddress(request.getParameter("userEmailAddress"));
		user.setUserEnabled(Boolean.parseBoolean(request.getParameter("userEnabled")));
		user.setPatientId(request.getParameter("userPatientId"));
		user.setNonPatientId(request.getParameter("userNonPatientId"));
		user.setCurrentFacilityId(request.getParameter("userCurrentFacilityId"));
		user
	}

}
