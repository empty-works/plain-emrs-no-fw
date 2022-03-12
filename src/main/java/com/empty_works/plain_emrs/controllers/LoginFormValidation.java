package com.empty_works.plain_emrs.controllers;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class FormValidation
 */
@WebServlet("/FormValidation")
public class LoginFormValidation extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Map<String, String> errorMessages = new HashMap<String, String>();
		request.setAttribute("errorMessages", errorMessages);
		
		String alphanumError = request.getParameter("alphanumError");
		if(alphanumError == null || alphanumError.trim().isEmpty()) {
			errorMessages.put("alphanumError", "Cannot leave empty.");
		}
		else if(!alphanumError.matches("\\p{Alnum}+")) {
			errorMessages.put("alphanumError", "Please only enter characters or numbers.");
		}
		doGet(request, response);
	}
}
