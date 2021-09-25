package com.empty_works.plain_emrs.controllers;

import java.io.IOException;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.empty_works.plain_emrs.beans.GeneratedUserBean;
import com.empty_works.plain_emrs.beans.NonPatientBean;
import com.empty_works.plain_emrs.util.PasswordUtil;

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
		// TODO: MAKE SURE TO ONLY ALLOW USER TO SELECT FROM DROP-DOWN BOXES
		np.setDateOfBirth(Date.valueOf(request.getParameter("dateOfBirth")));
		np.setOrganization(request.getParameter("organization"));
		np.setDescription(request.getParameter("description"));
		
		System.out.println("Forwarding to GeneratedUser JSP...");
		request.setAttribute("npbean", np);
		request.setAttribute("gubean", autoGenerate(np)); // Set generated user bean
		request.getRequestDispatcher("/GeneratedUser.jsp").forward(request, response);
	}
	
	private GeneratedUserBean autoGenerate(NonPatientBean npb) {
		
		GeneratedUserBean gub = new GeneratedUserBean();
		gub.setUsername(npb.getGivenName() + npb.getMiddleName() + npb.getLastName() + npb.hashCode());
		gub.setPassword(PasswordUtil.generate(5));
		gub.setPassword(npb.getEmailAddress());
		gub.setEnabled(true);
		gub.setCreatedOn(new java.sql.Date(System.currentTimeMillis())); // Set current date
		return gub;
	}
}
