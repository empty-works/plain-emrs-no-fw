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

import com.empty_works.plain_emrs.beans.MedicalRecordBean;
import com.empty_works.plain_emrs.beans.NonPatientBean;
import com.empty_works.plain_emrs.beans.PatientBean;
import com.empty_works.plain_emrs.beans.UserBean;
import com.empty_works.plain_emrs.patient_choices.FamilyConditionLists;
import com.empty_works.plain_emrs.patient_choices.MedicalProblemGeneralLists;
import com.empty_works.plain_emrs.patient_choices.MedicalRecordDiseaseLists;
import com.empty_works.plain_emrs.patient_choices.MedicalRecordDiseaseUnit;
import com.empty_works.plain_emrs.patient_choices.MedicalRecordRelationsUnit;
import com.empty_works.plain_emrs.patient_choices.MedicalRecordSurgeryUnit;
import com.empty_works.plain_emrs.patient_choices.PatientFormUnit;
import com.empty_works.plain_emrs.roles.PlainEmrsRoles;
import com.empty_works.plain_emrs.user_choices.UserLivingArranLists;
import com.empty_works.plain_emrs.user_choices.UserRaceLists;
import com.empty_works.plain_emrs.user_choices.UserRelationGenderLists;
import com.empty_works.plain_emrs.user_choices.UserMaritalStatusLists;

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
		request.setAttribute("maritalStatusList", UserMaritalStatusLists.maritalStatusList);
		request.setAttribute("livingArrangementList", UserLivingArranLists.livingList);
		request.setAttribute("currentGenderList", UserRelationGenderLists.currentGenderList);
		request.setAttribute("sexAssignedBirthList", UserRelationGenderLists.sexAssignedBirthList);
		request.setAttribute("sexualOrientationList", UserRelationGenderLists.sexualOrientationList);
		request.setAttribute("diseaseList", MedicalRecordDiseaseLists.diseaseList);
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
		MedicalRecordBean medRecord;
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
			patient.setMaritalStatus(request.getParameter("maritalOptionRadio"));
			patient.setLivingArrangement(request.getParameter("livingOptionRadio"));
			patient.setCurrentGender(request.getParameter("currentGenderRadio"));
			patient.setGenderAtBirth(request.getParameter("sexAssignedBirthRadio"));
			patient.setSexualOrientation(request.getParameter("sexualOrientationRadio"));
			// Medical history
			medRecord = new MedicalRecordBean();
			medRecord.setPatientCondition(request.getParameter("patientConditionDropdown"));
			medRecord.setBloodTransfusionStatus(request.getParameter("bloodTransfusionRadio"));
			medRecord.setActive(true); // Not in add user jsp, so automatically set to true.
			medRecord.setDateCreated(LocalDateTime.now());
			medRecord.setImmunDiseases(parseDiseasesImmun(request));
			medRecord.setAdopted(Boolean.parseBoolean(request.getParameter("patientAdopted")));
			medRecord.setFatherStatus(request.getParameter("patientFather"));
			medRecord.setMotherStatus(request.getParameter("patientMother"));
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
	protected static List<String> parseRaces(HttpServletRequest request) {
		
		List<String> races = new ArrayList<>(); 
		String[] reqRaces = request.getParameterValues("raceCheck");
		for(String raceName : reqRaces) {
			
			String parsedRace = raceName;
			if(raceName.equals(UserRaceLists.asianName)) {
				
				parsedRace += "-" + request.getParameter("asianEthnDropdown");
			}
			else if(raceName.equals(UserRaceLists.hiLaName)) {
				
				parsedRace += "-" + request.getParameter("hisLatinEthnDropdown");
			}
			else if(raceName.equals(UserRaceLists.naHaPaIsName)) {
				
				parsedRace += "-" + request.getParameter("pacIslEthnDropdown");
			}
			races.add(parsedRace);
		}
		return races;
	}
	
	/**
	 * 
	 * @param request
	 * @return
	 */
	protected static List<MedicalRecordDiseaseUnit> parseDiseasesImmun(HttpServletRequest request) {
		
		List<MedicalRecordDiseaseUnit> diseases = new ArrayList<>();
		for(MedicalRecordDiseaseUnit disease : MedicalRecordDiseaseLists.diseaseList) {
			
			String result = request.getParameter(disease.getDiseaseId() + "immuDiseaseRadio");
			if(result.contains("HadNoImmun") || result.contains("HadImmun")) {
				
				MedicalRecordDiseaseUnit patientDisease = new MedicalRecordDiseaseUnit(disease.getDiseaseId(), disease.getDiseaseName());
				patientDisease.setContractedDisease(true);
				if(result.contains("HadImmun")) {
					patientDisease.setImmunized(true);
				}
				// Only added if the patient had the disease regardless of immunization.
				diseases.add(patientDisease);
			}
		}
		return diseases;
	}

	/**
	 * 
	 * @param request
	 * @return
	 */
	protected static List<MedicalRecordSurgeryUnit> parseSurgeries(HttpServletRequest request) {
		
		List<MedicalRecordSurgeryUnit> surgeries = new ArrayList<>();
		String[] problemAreas = request.getParameterValues("medProbArea");
		String[] medProbTexts = request.getParameterValues("medProbText");
		String[] medProbSurgeryTexts = request.getParameterValues("medProbSurgeryText");
		String[] medProbSurgeryDates = request.getParameterValues("medProbSurgeryDate");
		for(int i = 0; i < problemAreas.length; i++) {
			
			MedicalRecordSurgeryUnit surgeryUnit = new MedicalRecordSurgeryUnit();
			surgeryUnit.setProblemArea(problemAreas[i]);
			surgeryUnit.setSurgicalRelatedProblem(medProbTexts[i]);
			surgeryUnit.setSurgicalProcedure(medProbSurgeryTexts[i]);
			surgeryUnit.setSurgicalProcedureYear(medProbSurgeryDates[i]);
			surgeries.add(surgeryUnit);
		}
		return surgeries;
	}
	
	/**
	 * 
	 * @param request
	 * @return
	 */
	protected static List<MedicalRecordRelationsUnit> parseRelations(HttpServletRequest request) {
		
		List<MedicalRecordRelationsUnit> relations = new ArrayList<>();
		relations.add(new MedicalRecordRelationsUnit("Brothers", Integer.parseInt(request.getParameter("Brothers"))));
		relations.add(new MedicalRecordRelationsUnit("Sisters", Integer.parseInt(request.getParameter("Sisters"))));
		relations.add(new MedicalRecordRelationsUnit("Sons", Integer.parseInt(request.getParameter("Sons"))));
		relations.add(new MedicalRecordRelationsUnit("Daughters", Integer.parseInt(request.getParameter("Daughters"))));

		return relations;
	}
}