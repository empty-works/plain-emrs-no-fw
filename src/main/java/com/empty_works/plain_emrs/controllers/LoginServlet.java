package com.empty_works.plain_emrs.controllers;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.empty_works.plain_emrs.beans.LoginBean;
import com.empty_works.plain_emrs.dao.LoginDao;
import com.empty_works.plain_emrs.roles.RolePair;
import com.empty_works.plain_emrs.util.FormValidationUtil;
import com.empty_works.plain_emrs.util.helpers.FormValidationType;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		RolePair userRole = (RolePair)session.getAttribute("rolePair");
		setSessionUserAndRole(userRole, request, response);
	}
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		FormValidationUtil formVal = new FormValidationUtil();
		Map<String, String> errorMessages;

		formVal.validate(request.getParameter("username"), "username", FormValidationType.ONLYEMPTY);
		formVal.validate(request.getParameter("password"), "password", FormValidationType.ONLYEMPTY);
		errorMessages = formVal.getErrorMessages(); 
		if(formVal.hasErrorMessages()) {
			
			System.out.println("ERROR USERNAME: " + errorMessages.get("username"));
			
			request.setAttribute("errorMessages", errorMessages);
			request.getRequestDispatcher("/default.jsp").forward(request, response);
		}
		else {
			
			String username = request.getParameter("username");
			String password = request.getParameter("password");
			
			LoginBean loginBean = new LoginBean();
			loginBean.setUsername(username);
			loginBean.setPassword(password);
			
			LoginDao loginDao = new LoginDao();
			
			RolePair userRole = loginDao.authenticateUser(loginBean);
			HttpSession session = request.getSession();
			session.setAttribute(userRole.getRole(), username);
			session.setAttribute("rolePair", userRole);
			session.setAttribute("username", username);
			
			System.out.println("Username: " + username);
			System.out.println("Password: " + password);

			setSessionUserAndRole(userRole, request, response);
		}
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
