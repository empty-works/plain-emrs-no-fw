package com.empty_works.plain_emrs.controllers;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;

import com.empty_works.plain_emrs.beans.NonPatientBean;
import com.empty_works.plain_emrs.beans.PatientBean;
import com.empty_works.plain_emrs.beans.UserBean;
import com.empty_works.plain_emrs.patient_choices.FamilyConditionLists;
import com.empty_works.plain_emrs.patient_choices.MedicalProblemGeneralLists;
import com.empty_works.plain_emrs.patient_choices.PatientDiseaseLists;
import com.empty_works.plain_emrs.patient_choices.PatientFormUnit;
import com.empty_works.plain_emrs.roles.PlainEmrsRoles;
import com.empty_works.plain_emrs.user_choices.UserLivingArranLists;
import com.empty_works.plain_emrs.user_choices.UserRaceLists;
import com.empty_works.plain_emrs.user_choices.UserRelationGenderLists;
import com.empty_works.plain_emrs.user_choices.UserRelationshipStatusLists;

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

		request.setAttribute("amInAlNa", UserRaceLists.amInAlNa);
		request.setAttribute("asian", UserRaceLists.asian);
		request.setAttribute("blAfAm", UserRaceLists.blAfAm);
		request.setAttribute("hiLa", UserRaceLists.hiLa);
		request.setAttribute("naHaPaIs", UserRaceLists.naHaPaIs);
		request.setAttribute("white", UserRaceLists.white);
		request.setAttribute("raceList", UserRaceLists.raceList);
		request.setAttribute("asianEthnList", UserRaceLists.asianEthnicityList);
		request.setAttribute("pacifIslEthnList", UserRaceLists.pacificIslanderEthnicityList);
		request.setAttribute("hisLatEthnList", UserRaceLists.hispanicLatinList);
		request.setAttribute("relationshipStatusList", UserRelationshipStatusLists.relationshipStatusList);
		request.setAttribute("livingArrangementList", UserLivingArranLists.livingList);
		request.setAttribute("currentGenderList", UserRelationGenderLists.currentGenderList);
		request.setAttribute("sexAssignedBirthList", UserRelationGenderLists.sexAssignedBirthList);
		request.setAttribute("sexualOrientationList", UserRelationGenderLists.sexualOrientationList);
		request.setAttribute("diseaseList", PatientDiseaseLists.diseaseList);
		request.setAttribute("generalMedicalProblemListJson", makeJson(MedicalProblemGeneralLists.medicalProblemGeneralList));
		request.setAttribute("heartMedicalProblemListJson", makeJson(MedicalProblemGeneralLists.medicalProblemHeartList));
		request.setAttribute("reproductMedicalProblemListJson", makeJson(MedicalProblemGeneralLists.medicalProblemReproductList));
		request.setAttribute("familyConditionsList", makeJson(FamilyConditionLists.familyConditionList));
		request.setAttribute("roleList", PlainEmrsRoles.roleList);
		request.getRequestDispatcher("/WEB-INF/AddUser.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		UserBean user = new UserBean();
		PatientBean patient; // Instantiated if user is a new patient.
		NonPatientBean nonPatient;
		
		user.setEmailAddress(request.getParameter("userEmailAddress"));
		user.setUserEnabled(Boolean.parseBoolean(request.getParameter("userEnabled")));
		//user.setPatientId(request.getParameter("userPatientId"));
		//user.setNonPatientId(request.getParameter("userNonPatientId"));
		user.setUserEnabled(true);
		user.setDateCreated(LocalDateTime.now());
		user.setFirstName(request.getParameter("userFirstName"));
		user.setMiddleInitial(request.getParameter("userMiddleInitial"));
		user.setLastName(request.getParameter("userLastName"));
		user.setCurrentFacilityId(request.getParameter("userCurrentFacilityId"));
		user.setRole(request.getParameter("roleDropdown"));
		request.setAttribute("userBean", user);
		
		if(request.getAttribute("patientFormSubmitButton") == "isPatient") {
			
			patient = new PatientBean();
			patient.setStreetAddress(request.getParameter("patientStreetAddress"));
			patient.setCity(request.getParameter("patientCity"));
			patient.setState(request.getParameter("patientState"));
			patient.setCountry(request.getParameter("patientCountry"));
			patient.setPhoneNumber(request.getParameter("patientPhoneNumber"));
			patient.setProvider(request.getParameter("patientProvider"));
			patient.setProviderId(request.getParameter("patientProviderId"));
			patient.setRaces(parseRaces(request));
		}
		
		request.getRequestDispatcher("/WEB-INF/AddUserSummary.jsp").forward(request, response);
	}
	
	/**
	 * 
	 * @param list
	 * @return
	 */
	private String makeJson(List<PatientFormUnit> list) {

		JSONObject jobj = new JSONObject();
		for(PatientFormUnit unit : list) {
			jobj.put(unit.getId(), unit.getValue());
		}
		System.out.println(jobj);
		return jobj.toString();
	}
	
	/**
	 * 
	 * @param request
	 * @return
	 */
	public static List<String> parseRaces(HttpServletRequest request) {
		
		List<String> races = new ArrayList<>(); 
		String[] reqRaces = request.getParameterValues("raceCheck");
		for(String raceName : reqRaces) {
			
			String parsedRace = raceName;
			if(raceName.equals(UserRaceLists.asian)) {
				
				parsedRace += "-" + request.getParameter("asianEthnDropdown");
			}
			else if(raceName.equals(UserRaceLists.hiLa)) {
				
				parsedRace += "-" + request.getParameter("hisLatinEthnDropdown");
			}
			else if(raceName.equals(UserRaceLists.naHaPaIs)) {
				
				parsedRace += "-" + request.getParameter("pacIslEthnDropdown");
			}
			races.add(parsedRace);
		}
		return races;
	}
}