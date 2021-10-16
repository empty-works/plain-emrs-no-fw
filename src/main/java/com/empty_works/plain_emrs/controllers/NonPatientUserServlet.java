package com.empty_works.plain_emrs.controllers;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.empty_works.plain_emrs.beans.GeneratedUserBean;
import com.empty_works.plain_emrs.beans.NonPatientBean;
import com.empty_works.plain_emrs.dao.RegisterNonPatientUserDao;
import com.empty_works.plain_emrs.util.NonPatientIdUtil;
import com.empty_works.plain_emrs.util.NonPatientUsernameUtil;
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
		NonPatientBean npb = new NonPatientBean();
		npb.setGivenName(request.getParameter("givenName"));
		npb.setMiddleName(request.getParameter("middleName"));
		npb.setLastName(request.getParameter("lastName"));
		npb.setEmailAddress(request.getParameter("emailAddress"));
		// MAKE SURE TO ONLY ALLOW USER TO SELECT FROM DROP-DOWN BOXES
		npb.setDateOfBirth(LocalDate.parse((request.getParameter("dateOfBirth"))));
		npb.setOrganization(request.getParameter("organization"));
		npb.setDescription(request.getParameter("description"));
		npb.setId(NonPatientIdUtil.get(npb.getGivenName(), npb.getLastName(), 
				npb.getDateOfBirth().toString()));
		
		RegisterNonPatientUserDao rnpud = new RegisterNonPatientUserDao();
		// Write to database
		System.out.println("Registering non-patient user...");
		String registrationResult = rnpud.register(npb);
		if(registrationResult.equals(RegisterNonPatientUserDao.NONPATIENTDAO_SUCCESS)) {
			
			System.out.println("User registration successful! Forwarding to GeneratedUser JSP...");
			request.setAttribute("npbean", npb);
			request.setAttribute("gubean", autoGenerateUser(npb)); // Set generated user bean
			request.getRequestDispatcher("/GeneratedNonPatientUser.jsp").forward(request, response);
		}
		else {
			
			System.out.println("User registration failed! Going back to registration page...");
			request.setAttribute("errMessage", registrationResult);
			request.getRequestDispatcher("/AddNonPatient.jsp").forward(request, response);
		}
	}
	
	private GeneratedUserBean autoGenerateUser(NonPatientBean npb) {
		
		GeneratedUserBean gub = new GeneratedUserBean();
		gub.setUsername(NonPatientUsernameUtil.get(npb));
		gub.setPassword(PasswordUtil.generate(5));
		gub.setEmailAddress(npb.getEmailAddress());
		gub.setEnabled(true);
		gub.setCreatedOn(LocalDateTime.now()); // Set current date and time

		return gub;
	}
}
