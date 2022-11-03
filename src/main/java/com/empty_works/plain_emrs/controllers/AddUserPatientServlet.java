package com.empty_works.plain_emrs.controllers;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;

import com.empty_works.plain_emrs.beans.BloodRelationsBean;
import com.empty_works.plain_emrs.beans.DiseasesBean;
import com.empty_works.plain_emrs.beans.IllnessesBean;
import com.empty_works.plain_emrs.beans.MedicalRecordBean;
import com.empty_works.plain_emrs.beans.NonPatientBean;
import com.empty_works.plain_emrs.beans.PatientBean;
import com.empty_works.plain_emrs.beans.SurgicalProblemsBean;
import com.empty_works.plain_emrs.beans.UserAccessLogBean;
import com.empty_works.plain_emrs.beans.UserActivityLogBean;
import com.empty_works.plain_emrs.beans.UserAuthorityBean;
import com.empty_works.plain_emrs.beans.UserBean;
import com.empty_works.plain_emrs.beans.UserLoginLogBean;
import com.empty_works.plain_emrs.dao.AddUserDao;
import com.empty_works.plain_emrs.dao.AuthoritiesDao;
import com.empty_works.plain_emrs.dao.BloodRelationsDao;
import com.empty_works.plain_emrs.dao.DiseasesDao;
import com.empty_works.plain_emrs.dao.IllnessesDao;
import com.empty_works.plain_emrs.dao.MedicalRecordDao;
import com.empty_works.plain_emrs.dao.PatientDao;
import com.empty_works.plain_emrs.dao.SurgicalProblemsDao;
import com.empty_works.plain_emrs.patient_choices.MedicalRecordFamilyIllnessLists;
import com.empty_works.plain_emrs.patient_choices.MedicalProblemGeneralLists;
import com.empty_works.plain_emrs.patient_choices.MedicalRecordDiseaseLists;
import com.empty_works.plain_emrs.patient_choices.MedicalRecordDiseaseUnit;
import com.empty_works.plain_emrs.patient_choices.SurgicalProblemUnit;
import com.empty_works.plain_emrs.patient_choices.MedicalRecordFamilyIllnessUnit;
import com.empty_works.plain_emrs.patient_choices.PatientFormUnit;
import com.empty_works.plain_emrs.roles.PlainEmrsRoles;
import com.empty_works.plain_emrs.user_choices.UserLivingArranLists;
import com.empty_works.plain_emrs.user_choices.UserRaceLists;
import com.empty_works.plain_emrs.user_choices.UserRelationGenderLists;
import com.empty_works.plain_emrs.util.MedicalRecordIdUtil;
import com.empty_works.plain_emrs.util.PasswordUtil;
import com.empty_works.plain_emrs.util.UserIdUtil;
import com.empty_works.plain_emrs.user_choices.UserMaritalStatusLists;

/**
 * Servlet implementation class AddUserServlet
 */
@WebServlet("/AddUserPatientServlet")
public class AddUserPatientServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	final private short PASSWORD_LENGTH = 14;
       
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
		request.setAttribute("familyConditionsList", makeJson(MedicalRecordFamilyIllnessLists.familyConditionList));
		request.setAttribute("roleList", PlainEmrsRoles.roleList);
		request.getRequestDispatcher("/WEB-INF/AddUserPatient.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		UserBean user = new UserBean();
		PatientBean patient; // Instantiated if user is a new patient.
		UserAuthorityBean userAuthority;
		UserAccessLogBean userAccess;
		UserLoginLogBean userLogin;
		UserActivityLogBean userActivity;
		MedicalRecordBean medRecord;
		DiseasesBean diseases;
		BloodRelationsBean relations;
		SurgicalProblemsBean surgicalProblems;
		IllnessesBean illnesses;
		
		user.setEmailAddress(request.getParameter("userEmailAddress"));
		user.setUserEnabled(Boolean.parseBoolean(request.getParameter("userEnabled")));
		user.setUserEnabled(true);
		user.setDateCreated(LocalDateTime.now());
		user.setFirstName(request.getParameter("userFirstName"));
		user.setMiddleInitial(request.getParameter("userMiddleInitial"));
		user.setLastName(request.getParameter("userLastName"));
		user.setCurrentFacilityId(request.getParameter("userCurrentFacilityId"));
		user.setRole(request.getParameter("rolePatient"));
		user.setDateOfBirth(LocalDate.parse(request.getParameter("patientDateOfBirth")));
		request.setAttribute("userBean", user);
		
		patient = new PatientBean();
		patient.setStreetAddress(request.getParameter("patientStreetAddress"));
		patient.setCity(request.getParameter("patientCity"));
		patient.setState(request.getParameter("patientState"));
		patient.setCountry(request.getParameter("patientCountry"));
		patient.setPhoneNumber(request.getParameter("patientPhoneNumber"));
		patient.setProvider(request.getParameter("patientProvider"));
		patient.setProviderId(request.getParameter("patientProviderId"));
		patient.setRaces(parseRaces(request));
		patient.setType(request.getParameter("patientTypeDropdown"));
		patient.setMaritalStatus(request.getParameter("maritalOptionRadio"));
		patient.setLivingArrangement(request.getParameter("livingOptionRadio"));
		patient.setCurrentGender(request.getParameter("currentGenderRadio"));
		patient.setGenderAtBirth(request.getParameter("sexAssignedBirthRadio"));
		patient.setSexualOrientation(request.getParameter("sexualOrientationRadio"));
		patient.setAdopted(Boolean.parseBoolean(request.getParameter("patientAdopted")));
		// Patient user ID generated based on info
		String userId = UserIdUtil.get(UserIdUtil.PATIENT, user.getFirstName(), user.getLastName());
		// Generate medical record ID based on the newly generated user ID.
		String medicalRecordId = MedicalRecordIdUtil.get(userId);
		String userPassword = PasswordUtil.generate(PASSWORD_LENGTH);

		// Add user(patient) to database and display result.
		user.setUserId(userId);
		user.setUserPassword(userPassword);

		// User authority
		userAuthority = new UserAuthorityBean();
		userAuthority.setId(userId);
		userAuthority.setName(request.getParameter("rolePatient"));

		// User access log
		userAccess = new UserAccessLogBean();
		userAccess.setUserId(userId);
		userAccess.setUserDateTimeOfAccess(LocalDateTime.now());
		userAccess.setMedicalRecordId(medicalRecordId);
		
		// User login log
		userLogin = new UserLoginLogBean();
		userLogin.setUserId(userId);
		userLogin.setUserDateTimeOfVisit(LocalDateTime.now());
		
		// User activity log
		userActivity = new UserActivityLogBean();
		userActivity.setUserId(userId);
		userActivity.setMedicalRecordId(medicalRecordId);
		userActivity.setUserDateTimeOfActivity(LocalDateTime.now());
		userActivity.setActivityDescription("Medical record created.");

		patient.setUserId(userId);
		
		medRecord = new MedicalRecordBean();
		medRecord.setUserId(userId);
		medRecord.setMedicalRecordId(medicalRecordId);
		medRecord.setPatientCondition(request.getParameter("patientConditionDropdown"));
		medRecord.setMedicalRecordCreatedOn(LocalDateTime.now());
		medRecord.setActive(true); // Not in add user jsp, so automatically set to true.
		medRecord.setBloodTransfusionStatus(request.getParameter("bloodTransfusionRadio"));
		surgicalProblems = new SurgicalProblemsBean();
		surgicalProblems.setUserId(userId);
		surgicalProblems.setMedicalRecordId(medicalRecordId);
		surgicalProblems.setSurgeryMedProblems(parseSurgeries(request));
		System.out.println(AddUserDao.add(user, userAccess, userLogin, userActivity, patient, medRecord, surgicalProblems));

		// Add patient here.
		//System.out.println("Adding patient...");
		//patient.setUserId(userId);
		//System.out.println(PatientDao.add(patient));
		
		// medical_records
		/*
		System.out.println("Adding medical record...");
		medRecord = new MedicalRecordBean();
		medRecord.setUserId(userId);
		medRecord.setMedicalRecordId(medicalRecordId);
		medRecord.setPatientCondition(request.getParameter("patientConditionDropdown"));
		medRecord.setMedicalRecordCreatedOn(LocalDateTime.now());
		medRecord.setActive(true); // Not in add user jsp, so automatically set to true.
		medRecord.setBloodTransfusionStatus(request.getParameter("bloodTransfusionRadio"));
		*/

		// Add medical record to database and display result.
		//System.out.println(MedicalRecordDao.add(medRecord));
		
		// diseases
		diseases = new DiseasesBean();
		diseases.setUserId(userId);
		diseases.setMedicalRecordId(medicalRecordId);
		diseases.setDiseases(parseDiseasesImmun(request));

		// Add diseases to database and display result.
		System.out.println(DiseasesDao.add(diseases));

		// blood_relatives
		relations = new BloodRelationsBean();
		relations.setUserId(userId);
		relations.setMedicalRecordId(medicalRecordId);
		relations.setFatherStatus(request.getParameter("patientFather"));
		relations.setMotherStatus(request.getParameter("patientMother"));
		relations.setFathDecAge(Integer.parseInt(request.getParameter("fatherDecAge")));
		relations.setFathCauseDea(request.getParameter("fatherCauseDeath"));
		relations.setMothDecAge(Integer.parseInt(request.getParameter("motherDecAge")));
		relations.setMothCauseDea(request.getParameter("motherCauseDeath"));
		relations.setNumSisters(Integer.parseInt(request.getParameter("SistersAlive")));
		relations.setNumBrothers(Integer.parseInt(request.getParameter("BrothersAlive")));
		relations.setNumDaughters(Integer.parseInt(request.getParameter("DaughtersAlive")));
		relations.setNumSons(Integer.parseInt(request.getParameter("SonsAlive")));

		// Add blood relations to the database and display result.
		System.out.println(BloodRelationsDao.add(relations));

		// surgical_related_problems
		/*
		surgicalProblems = new SurgicalProblemsBean();
		surgicalProblems.setUserId(userId);
		surgicalProblems.setMedicalRecordId(medicalRecordId);
		surgicalProblems.setSurgeryMedProblems(parseSurgeries(request));

		// Add surgical problems to the database and display result.
		System.out.println(SurgicalProblemsDao.add(surgicalProblems));
		*/
		
		// illnesses
		illnesses = new IllnessesBean();
		illnesses.setUserId(userId);
		illnesses.setMedicalRecordId(medicalRecordId);
		illnesses.setIllness(parseIllnesses(request));

		// Add illnesses to the database and display result.
		System.out.println(IllnessesDao.add(illnesses));
			
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
			
			System.out.println("Disease - " + disease);
			String result = request.getParameter(disease.getDiseaseId() + "immuDiseaseRadio");
			if(result != null) {
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
		}
		return diseases;
	}

	/**
	 * 
	 * @param request
	 * @return
	 */
	protected static List<SurgicalProblemUnit> parseSurgeries(HttpServletRequest request) {
		
		List<SurgicalProblemUnit> surgeries = new ArrayList<>();
		String[] problemAreas = request.getParameterValues("medProbArea");
		String[] medProbTexts = request.getParameterValues("medProbText");
		String[] medProbSurgeryTexts = request.getParameterValues("medProbSurgeryText");
		String[] medProbSurgeryDates = request.getParameterValues("medProbSurgeryDate");
		for(int i = 0; i < problemAreas.length; i++) {
			
			SurgicalProblemUnit surgeryUnit = new SurgicalProblemUnit();
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
	protected static List<MedicalRecordFamilyIllnessUnit> parseIllnesses(HttpServletRequest request) {
		
		List<MedicalRecordFamilyIllnessUnit> illnesses = new ArrayList<>();
		for(PatientFormUnit illness : MedicalRecordFamilyIllnessLists.familyConditionList) {
			
			MedicalRecordFamilyIllnessUnit unit = new MedicalRecordFamilyIllnessUnit(illness.getId(), illness.getValue());
			if(request.getParameter(illness.getValue() + "familyIllnessSelf") != null && 
					request.getParameter(illness.getValue() + "familyIllnessSelf").equals("true")) {
				unit.setFamilyRelation(MedicalRecordFamilyIllnessUnit.SELF);
			}
			if(request.getParameter(illness.getValue() + "familyIllnessFather") != null && 
					request.getParameter(illness.getValue() + "familyIllnessFather").equals("true")) {
				unit.setFamilyRelation(MedicalRecordFamilyIllnessUnit.FATHER);
			}
			if(request.getParameter(illness.getValue() + "familyIllnessMother") != null && 
					request.getParameter(illness.getValue() + "familyIllnessMother").equals("true")) {
				unit.setFamilyRelation(MedicalRecordFamilyIllnessUnit.MOTHER);
			}
			if(request.getParameter(illness.getValue() + "familyIllnessBrothers") != null && 
					request.getParameter(illness.getValue() + "familyIllnessBrothers").equals("true")) {
				unit.setFamilyRelation(MedicalRecordFamilyIllnessUnit.BROTHERS);
			}
			if(request.getParameter(illness.getValue() + "familyIllnessSisters") != null && 
					request.getParameter(illness.getValue() + "familyIllnessSisters").equals("true")) {
				unit.setFamilyRelation(MedicalRecordFamilyIllnessUnit.SISTERS);
			}
			if(request.getParameter(illness.getValue() + "familyIllnessSons") != null && 
					request.getParameter(illness.getValue() + "familyIllnessSons").equals("true")) {
				unit.setFamilyRelation(MedicalRecordFamilyIllnessUnit.SONS);
			}
			if(request.getParameter(illness.getValue() + "familyIllnessDaughters") != null && 
					request.getParameter(illness.getValue() + "familyIllnessDaughters").equals("true")) {
				unit.setFamilyRelation(MedicalRecordFamilyIllnessUnit.DAUGHTERS);
			}
			if(request.getParameter(illness.getValue() + "familyIllnessGrandparents") != null &&
					request.getParameter(illness.getValue() + "familyIllnessGrandparents").equals("true")) {
				unit.setFamilyRelation(MedicalRecordFamilyIllnessUnit.GRANDPARENTS);
			}
			// Only add unit if there are relatives/self added.
			if(unit.getFamilyRelations().isEmpty() == false) {
				illnesses.add(unit);
			}
		}
		return illnesses;
	}
}