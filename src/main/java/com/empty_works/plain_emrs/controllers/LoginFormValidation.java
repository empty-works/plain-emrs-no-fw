package com.empty_works.plain_emrs.controllers;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.empty_works.plain_emrs.util.FormValidationUtil;
import com.empty_works.plain_emrs.util.helpers.FormValidationType;

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
		response.getWriter().append("Served at: ").append(request.getContextPath());
		request.getRequestDispatcher("/AdminServlet").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		FormValidationUtil formVal = new FormValidationUtil();
		Map<String, String> errorMessages;

		formVal.validate(request.getParameter(request.getParameter("loginname")), FormValidationType.ONLYEMPTY);
		formVal.validate(request.getParameter(request.getParameter("loginPassword")), FormValidationType.ONLYEMPTY);
		errorMessages = formVal.getErrorMessages(); 
		if(errorMessages.isEmpty()) {
			
			doGet(request, response);
		}
		else {
			
			request.setAttribute("errorMessages", errorMessages);
			request.getRequestDispatcher("/LoginServlet").forward(request, response);
		}
	}
}
