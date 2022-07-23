package com.empty_works.plain_emrs.controllers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.empty_works.plain_emrs.beans.UserBean;
import com.empty_works.plain_emrs.patient_choices.PatientDiseaseLists;
import com.empty_works.plain_emrs.patient_choices.PatientMedicalProblemLists;
import com.empty_works.plain_emrs.roles.PlainEmrsRoles;
import com.empty_works.plain_emrs.user_choices.UserRaceLists;
import com.empty_works.plain_emrs.user_choices.UserRelationGenderLists;

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

		request.setAttribute("raceList", UserRaceLists.raceList);
		request.setAttribute("latinOptionsList", UserRaceLists.latinOptionsList);
		request.setAttribute("latinOthersList", UserRaceLists.latinOtherList);
		request.setAttribute("relationshipStatusList", UserRelationGenderLists.relationshipStatusList);
		request.setAttribute("livingArrangementList", UserRelationGenderLists.livingList);
		request.setAttribute("currentGenderList", UserRelationGenderLists.currentGenderList);
		request.setAttribute("sexAssignedBirthList", UserRelationGenderLists.sexAssignedBirthList);
		request.setAttribute("sexualOrientationList", UserRelationGenderLists.sexualOrientationList);
		request.setAttribute("diseaseList", PatientDiseaseLists.diseaseList);
		request.setAttribute("generalMedicalProblemList", PatientMedicalProblemLists.medicalProblemGeneralList);
		request.setAttribute("medicalProblemHeartList", PatientMedicalProblemLists.medicalProblemHeartList);
		request.setAttribute("medicalProblemReproductList", PatientMedicalProblemLists.medicalProblemReproductList);
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
		//user.setPatientId(request.getParameter("userPatientId"));
		//user.setNonPatientId(request.getParameter("userNonPatientId"));
		user.setCurrentFacilityId(request.getParameter("userCurrentFacilityId"));
		user.setRole(request.getParameter("roleDropdown"));
		request.setAttribute("userBean", user);
		
		request.getRequestDispatcher("/WEB-INF/AddUserSummary.jsp").forward(request, response);
	}
}
