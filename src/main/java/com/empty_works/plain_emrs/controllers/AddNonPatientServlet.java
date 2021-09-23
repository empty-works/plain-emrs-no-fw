package com.empty_works.plain_emrs.controllers;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.empty_works.plain_emrs.beans.NonPatientBean;

/**
 * Servlet implementation class AddNonPatientServlet
 */
@WebServlet("/AddNonPatientServlet")
public class AddNonPatientServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("Setting parameters to NonPatientBean...");
		NonPatientBean np = new NonPatientBean();
		np.setGivenName(request.getParameter("givenName"));
		np.setMiddleName(request.getParameter("middleName"));
		np.setLastName(request.getParameter("lastName"));
		np.setEmailAddress(request.getParameter("emailAddress"));
		try {
			np.setDateOfBirth(new SimpleDateFormat("dd/MM/yyyy")
					.parse(request.getParameter("dateOfBirth")));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		np.setOrganization(request.getParameter("organization"));
		np.setDescription(request.getParameter("description"));
		
		System.out.println("Forwarding to GeneratedUser JSP...");
		request.setAttribute("npbean", np);
		request.getRequestDispatcher("/jsp/GeneratedUser.jsp").forward(request, response);
	}
}
