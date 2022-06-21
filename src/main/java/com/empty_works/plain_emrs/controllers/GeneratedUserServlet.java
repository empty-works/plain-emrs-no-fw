package com.empty_works.plain_emrs.controllers;

import java.io.IOException;
import java.time.LocalDateTime;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.empty_works.plain_emrs.beans.GeneratedUserBean;
import com.empty_works.plain_emrs.beans.NonPatientBean;
import com.empty_works.plain_emrs.util.NonPatientUsernameUtil;
import com.empty_works.plain_emrs.util.PasswordUtil;

/**
 * Servlet implementation class UserServlet
 */
@WebServlet("/UserServlet")
public class GeneratedUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

	private GeneratedUserBean autoGenerateUser(NonPatientBean npb) {
		
		GeneratedUserBean gub = new GeneratedUserBean();
		gub.setUsername(NonPatientUsernameUtil.get(npb));
		gub.setPassword(PasswordUtil.generate(5));
		gub.setEnabled(true);
		gub.setCreatedOn(LocalDateTime.now()); // Set current date and time

		return gub;
	}
}
