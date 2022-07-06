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
import com.empty_works.plain_emrs.roles.PlainEmrsRoles;
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

		formVal.validate(request.getParameter("userId"), "userId", FormValidationType.ONLYEMPTY);
		formVal.validate(request.getParameter("password"), "password", FormValidationType.ONLYEMPTY);
		errorMessages = formVal.getErrorMessages(); 
		if(formVal.hasErrorMessages()) {
			
			System.out.println("ERROR USER ID: " + errorMessages.get("userId"));
			handleError(errorMessages, request, response);
		}
		else {
			
			String userId = request.getParameter("userId");
			String password = request.getParameter("password");
			
			LoginBean loginBean = new LoginBean();
			loginBean.setUserId(userId);
			loginBean.setPassword(password);
			
			LoginDao loginDao = new LoginDao();
			
			RolePair userRole = loginDao.authenticateUser(loginBean);
			// TODO:Implement this after implementing add user functionality
			//List<String> facilitiesList = 
			
			if(userRole.equals(PlainEmrsRoles.invalidUser)) {
				
				System.out.println("Wrong user ID/password!");
				handleError("Incorrect user ID or password.", request, response);
			}
			else {
				
				HttpSession session = request.getSession();
				session.setAttribute(userRole.getRole(), userId);
				session.setAttribute("rolePair", userRole);
				session.setAttribute("userId", userId);
				
				System.out.println("User ID: " + userId);
				System.out.println("Password: " + password);

				setSessionUserAndRole(userRole, request, response);
			}
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
	
	private void handleError(String errorMessage, HttpServletRequest request, HttpServletResponse response) {
		
		System.out.println("Error: " + errorMessage);
		request.setAttribute("errorMessage", errorMessage);
		try {

			request.getRequestDispatcher("/default.jsp").forward(request, response);
		} catch(ServletException | IOException e) {
			
			e.printStackTrace();
		}
	}

	private void handleError(Map<String, String> errorMessages, HttpServletRequest request, HttpServletResponse response) {
		
		request.setAttribute("errorMessages", errorMessages);
		try {

			request.getRequestDispatcher("/default.jsp").forward(request, response);
		} catch(ServletException | IOException e) {
			
			e.printStackTrace();
		}
	}
}
