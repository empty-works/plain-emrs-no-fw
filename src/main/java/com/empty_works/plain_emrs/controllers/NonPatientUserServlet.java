package com.empty_works.plain_emrs.controllers;

import java.io.IOException;
import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.empty_works.plain_emrs.beans.GeneratedUserBean;
import com.empty_works.plain_emrs.beans.NonPatientBean;
import com.empty_works.plain_emrs.util.NonPatientIdUtil;
import com.empty_works.plain_emrs.util.PasswordUtil;

/**
 * Servlet implementation class AddNonPatientServlet
 */
@WebServlet("/GenerateNonPatientUser")
public class NonPatientUserServlet extends HttpServlet {
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
		// TODO: MAKE SURE TO ONLY ALLOW USER TO SELECT FROM DROP-DOWN BOXES
		np.setDateOfBirth(LocalDate.parse((request.getParameter("dateOfBirth"))));
		np.setOrganization(request.getParameter("organization"));
		np.setDescription(request.getParameter("description"));
		
		System.out.println("Forwarding to GeneratedUser JSP...");
		request.setAttribute("npbean", np);
		request.setAttribute("gubean", autoGenerateUser(np)); // Set generated user bean
		request.getRequestDispatcher("/GeneratedNonPatientUser.jsp").forward(request, response);
	}
	
	private GeneratedUserBean autoGenerateUser(NonPatientBean npb) {
		
		GeneratedUserBean gub = new GeneratedUserBean();
		gub.setUsername(NonPatientIdUtil.get(npb));
		gub.setPassword(PasswordUtil.generate(5));
		gub.setEmailAddress(npb.getEmailAddress());
		gub.setEnabled(true);
		gub.setCreatedOn(LocalDateTime.now()); // Set current date and time

		return gub;
	}
}
