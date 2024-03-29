package com.empty_works.plain_emrs.controllers;

import java.io.IOException;
import java.sql.SQLException;
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

import com.empty_works.plain_emrs.beans.AuthorityBean;
import com.empty_works.plain_emrs.beans.MedicalRecordBloodRelativesBean;
import com.empty_works.plain_emrs.beans.MedicalRecordImmunizationsBean;
import com.empty_works.plain_emrs.beans.EmergencyContactsBean;
import com.empty_works.plain_emrs.beans.MedicalRecordAllergiesBean;
import com.empty_works.plain_emrs.beans.MedicalRecordFamilyIllnessesBean;
import com.empty_works.plain_emrs.beans.MedicalRecordBean;
import com.empty_works.plain_emrs.beans.UserPatientBean;
import com.empty_works.plain_emrs.beans.UserPatientRaceBean;
import com.empty_works.plain_emrs.beans.MedicalRecordSurgicalProblemsBean;
import com.empty_works.plain_emrs.beans.UserActivityLogBean;
import com.empty_works.plain_emrs.beans.UserAuthorityBean;
import com.empty_works.plain_emrs.beans.UserBean;
import com.empty_works.plain_emrs.beans.UserLoginLogBean;
import com.empty_works.plain_emrs.dao.AuthoritiesDao;
import com.empty_works.plain_emrs.dao.EmergencyContactsDao;
import com.empty_works.plain_emrs.dao.MedicalRecordAllergiesDao;
import com.empty_works.plain_emrs.dao.MedicalRecordBloodRelativesDao;
import com.empty_works.plain_emrs.dao.MedicalRecordDao;
import com.empty_works.plain_emrs.dao.MedicalRecordDiseasesBean;
import com.empty_works.plain_emrs.dao.MedicalRecordImmunizationsDao;
import com.empty_works.plain_emrs.dao.MedicalRecordFamilyIllnessesDao;
import com.empty_works.plain_emrs.dao.MedicalRecordSurgicalProblemsDao;
import com.empty_works.plain_emrs.dao.UserActivityLogDao;
import com.empty_works.plain_emrs.dao.UserDao;
import com.empty_works.plain_emrs.dao.UserLoginLogDao;
import com.empty_works.plain_emrs.dao.UserPatientDao;
import com.empty_works.plain_emrs.dao.UserPatientRaceDao;
import com.empty_works.plain_emrs.patient_choices.MedicalRecordFamilyIllnessLists;
import com.empty_works.plain_emrs.patient_choices.MedicalProblemGeneralLists;
import com.empty_works.plain_emrs.patient_choices.MedicalRecordAllergyUnit;
import com.empty_works.plain_emrs.patient_choices.MedicalRecordDiseaseLists;
import com.empty_works.plain_emrs.patient_choices.MedicalRecordDiseaseUnit;
import com.empty_works.plain_emrs.patient_choices.MedicalRecordSurgicalProblemUnit;
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
		request.setAttribute("patientRole", PlainEmrsRoles.ROLE_PATIENT.getRoleDb());
		request.getRequestDispatcher("/WEB-INF/AddUserPatient.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		UserBean user = new UserBean();
		AuthorityBean authority;
		UserPatientBean patient; // Instantiated if user is a new patient.
		EmergencyContactsBean contacts;
		UserPatientRaceBean patientRace;
		UserAuthorityBean userAuthority;
		UserLoginLogBean userLogin;
		UserActivityLogBean userActivity;
		List<MedicalRecordAllergiesBean> allergies;
		List<MedicalRecordImmunizationsBean> immunizations;
		List<MedicalRecordFamilyIllnessesBean> illnesses;
		MedicalRecordBloodRelativesBean relations;
		MedicalRecordSurgicalProblemsBean surgicalProblems;
		MedicalRecordBean medRecord;	
		
		user.setEmailAddress(request.getParameter("userEmailAddress"));
		user.setUserEnabled(true); // User enabled right away when created.
		user.setDateCreated(LocalDateTime.now());
		user.setFirstName(request.getParameter("userFirstName"));
		user.setMiddleInitial(request.getParameter("userMiddleInitial"));
		user.setLastName(request.getParameter("userLastName"));
		user.setCurrentFacilityId(request.getParameter("userCurrentFacilityId"));
		user.setRole(request.getParameter("rolePatient"));
		user.setDateOfBirth(LocalDate.parse(request.getParameter("patientDateOfBirth")));
		request.setAttribute("userBean", user);
		
		patient = new UserPatientBean();
		patient.setStreetAddress(request.getParameter("patientStreetAddress"));
		patient.setCity(request.getParameter("patientCity"));
		patient.setState(request.getParameter("patientState"));
		patient.setCountry(request.getParameter("patientCountry"));
		String phoneArea = request.getParameter("patientPhoneArea");
		String patientNumber = request.getParameter("patientPhoneNumber");
		patient.setPhoneNumber(phoneArea + " " + patientNumber);
		patient.setProvider(request.getParameter("patientProvider"));
		patient.setProviderId(request.getParameter("patientProviderId"));
		patient.setType(request.getParameter("patientTypeDropdown"));
		patient.setMaritalStatus(request.getParameter("maritalOptionRadio"));
		patient.setLivingArrangement(request.getParameter("livingOptionRadio"));
		patient.setCurrentGender(request.getParameter("currentGenderRadio"));
		patient.setGenderAtBirth(request.getParameter("sexAssignedBirthRadio"));
		patient.setSexualOrientation(request.getParameter("sexualOrientationRadio"));
		patient.setAdopted(Boolean.parseBoolean(request.getParameter("patientAdopted")));
		patient.setLanguagePreference(request.getParameter("langPrefSelect"));
		patient.setLicenseNumber(request.getParameter("licenseNumber"));
		patient.setVehicleSerialNumber(request.getParameter("vehicleSerialNumber"));
		patient.setVehiclePlateNumber(request.getParameter("vehiclePlateNumber"));
		patient.setUrl(request.getParameter("patientUrl"));
		patient.setDeviceSerialNumber(request.getParameter("deviceSerialNumber"));
		patient.setIpAddress(request.getParameter("ipAddress"));
		// Patient user ID generated based on info
		String userId = UserIdUtil.get(UserIdUtil.PATIENT, user.getFirstName(), user.getLastName());
		// Generate medical record ID based on the newly generated user ID.
		String medicalRecordId = MedicalRecordIdUtil.get(userId);
		String userPassword = PasswordUtil.generate(PASSWORD_LENGTH);
		
		// Add patient role/authority
		authority = new AuthorityBean();
		authority.setUserId(userId);
		authority.setAuthority(request.getParameter("rolePatient"));

		// Add user(patient) to database and display result.
		user.setUserId(userId);
		user.setUserPassword(userPassword);
		patient.setUserId(userId);

		// Patient emergency contact
		contacts = new EmergencyContactsBean(userId);
		contacts.setFirstName(request.getParameter("contactFirstName"));
		contacts.setMiddleInitial(request.getParameter("contactMiddleInitial"));
		contacts.setLastName(request.getParameter("contactLastName"));
		String contactPhoneArea = request.getParameter("contactPhoneArea");
		String contactPhoneNumber = request.getParameter("contactPhoneNumber");
		contacts.setPhoneNumber(contactPhoneArea + " " + contactPhoneNumber);
		contacts.setEmail(request.getParameter("contactEmailAddress"));
		
		// Patient race
		patientRace = new UserPatientRaceBean();
		patientRace.setUserId(userId);
		patientRace.addRaces(parseRaces(request));

		// User authority
		userAuthority = new UserAuthorityBean();
		userAuthority.setId(userId);
		userAuthority.setName(request.getParameter("rolePatient"));

		// User login log
		userLogin = new UserLoginLogBean();
		userLogin.setUserId(userId);
		userLogin.setUserDateTimeOfVisit(LocalDateTime.now());
		
		// User activity log
		userActivity = new UserActivityLogBean();
		userActivity.setUserId(userId);
		userActivity.setUserDateTimeOfActivity(LocalDateTime.now());
		userActivity.setActivityDescription("Medical record created.");

		medRecord = new MedicalRecordBean();
		medRecord.setUserId(userId);
		medRecord.setMedicalRecordId(medicalRecordId);
		medRecord.setPatientCondition(request.getParameter("patientConditionDropdown"));
		medRecord.setMedicalRecordCreatedOn(LocalDateTime.now());
		medRecord.setActive(true); // Not in add user jsp, so automatically set to true.
		medRecord.setBloodTransfusionStatus(request.getParameter("bloodTransfusionRadio"));

		allergies = parseAllergies(request, medicalRecordId);
		/*
		allergies = new MedicalRecordAllergiesBean();
		allergies.setMedicalRecordId(medicalRecordId);
		allergies.setAllergyUnits(parseAllergies(request));
		*/

		surgicalProblems = new MedicalRecordSurgicalProblemsBean();
		surgicalProblems.setMedicalRecordId(medicalRecordId);
		surgicalProblems.setSurgicalRelatedProblems(parseSurgeries(request));
		
		immunizations = parseImmuns(request, medicalRecordId);
		/*
		diseases = new MedicalRecordImmunizationsBean();
		diseases.setMedicalRecordId(medicalRecordId);
		diseases.setDiseases(parseDiseasesImmun(request));
		*/

		// blood_relatives
		relations = new MedicalRecordBloodRelativesBean();
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

		// illnesses
		//illnesses = new MedicalRecordFamilyIllnessesBean();
		//illnesses.setMedicalRecordId(medicalRecordId);
		illnesses = parseIllnesses(request, medicalRecordId);

		// Now execute all collected queries.

		try {
			UserDao.add(user);
			AuthoritiesDao.add(authority);
			UserLoginLogDao.add(userLogin);
			UserActivityLogDao.add(userActivity);
			UserPatientDao.add(patient);
			UserPatientRaceDao.add(patientRace);
			MedicalRecordDao.add(medRecord);
			MedicalRecordAllergiesDao.add(allergies);
			MedicalRecordSurgicalProblemsDao.add(surgicalProblems);
			MedicalRecordImmunizationsDao.add(immunizations);
			MedicalRecordBloodRelativesDao.add(relations);
			MedicalRecordFamilyIllnessesDao.add(illnesses, medicalRecordId);
			EmergencyContactsDao.add(contacts);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		response.sendRedirect(request.getContextPath() + "/UserPatientServlet?userPatientId=" + user.getUserId());
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
	
	protected static List<String> parseRaces(HttpServletRequest request) {
		
		List<String> patientRaces = new ArrayList<>();
		String[] races = request.getParameterValues("raceCheck");
		for(String race : races) {
			if(race.equals(UserRaceLists.asianName)) {
				race += " - " + request.getParameter("asianEthnDropdown");
			}
			else if(race.equals(UserRaceLists.hiLaName)) {
				race += " - " + request.getParameter("hisLatinEthnDropdown");
			}
			else if(race.equals(UserRaceLists.naHaPaIsName)) {
				race += " - " + request.getParameter("pacIslEthnDropdown");
			}
			System.out.println("Checked race: " + race);
			patientRaces.add(race);
		}
		return patientRaces;
	}
	
	protected static List<MedicalRecordAllergiesBean> parseAllergies(HttpServletRequest request, String medicalRecordId) {
		
		List<MedicalRecordAllergiesBean> allergiesList = new ArrayList<>();
		
		String[] allergyNames = request.getParameterValues("allergyText");
		String[] allergySeverities = request.getParameterValues("allergySeverity");
		String[] additionalInformation = request.getParameterValues("allergyAddInfo");
		if(allergyNames != null) {
			for(int i = 0; i < allergyNames.length; i++) {
				MedicalRecordAllergiesBean allergyUnit = new MedicalRecordAllergiesBean();
				allergyUnit.setMedicalRecordId(medicalRecordId);
				allergyUnit.setAllergyName(allergyNames[i]);
				allergyUnit.setAllergySeverity(allergySeverities[i]);
				allergyUnit.setAdditionalInformation(additionalInformation[i]);
				allergiesList.add(allergyUnit);
			}
		}
		return allergiesList;
	}
	
	protected static List<MedicalRecordImmunizationsBean> parseImmuns(HttpServletRequest request, String medicalRecordId) {
		
		List<MedicalRecordImmunizationsBean> immunizationsList = new ArrayList<>();
		for(MedicalRecordDiseasesBean disease : MedicalRecordDiseaseLists.diseaseList) {
			String result = request.getParameter(disease.getDiseaseId());
			System.out.println("Retrieved disease: " + result + " Disease ID: " + disease.getDiseaseId());
			if(result != null && result.contains("Immun")) {
				MedicalRecordImmunizationsBean patientImmunization = new MedicalRecordImmunizationsBean();
				patientImmunization.setImmunization(disease.getDiseaseName());
				patientImmunization.setMedicalRecordId(medicalRecordId);
				System.out.println("Added patient immunization: " + patientImmunization);
				immunizationsList.add(patientImmunization);
			}
		}
		return immunizationsList;
	}

	/**
	 * 
	 * @param request
	 * @return
	 */
	protected static List<MedicalRecordSurgicalProblemUnit> parseSurgeries(HttpServletRequest request) {
		
		List<MedicalRecordSurgicalProblemUnit> surgeries = new ArrayList<>();
		String[] problemAreas = request.getParameterValues("medProbArea");
		String[] medProbTexts = request.getParameterValues("medProbText");
		String[] medProbSurgeryTexts = request.getParameterValues("medProbSurgeryText");
		String[] medProbSurgeryDates = request.getParameterValues("medProbSurgeryDate");
		if(problemAreas != null) {
			for(int i = 0; i < problemAreas.length; i++) {
				
				MedicalRecordSurgicalProblemUnit surgeryUnit = new MedicalRecordSurgicalProblemUnit();
				surgeryUnit.setProblemArea(problemAreas[i]);
				surgeryUnit.setSurgicalRelatedProblem(medProbTexts[i]);
				surgeryUnit.setSurgicalProcedure(medProbSurgeryTexts[i]);
				surgeryUnit.setSurgicalProcedureYear(medProbSurgeryDates[i]);
				surgeries.add(surgeryUnit);
			}
		}
		return surgeries;
	}
	
	/**
	 * 
	 * @param request
	 * @return
	 */
	protected static List<MedicalRecordFamilyIllnessesBean> parseIllnesses(HttpServletRequest request, String medicalRecordId) {
		
		List<MedicalRecordFamilyIllnessesBean> illnesses = new ArrayList<>();
		for(PatientFormUnit illness : MedicalRecordFamilyIllnessLists.familyConditionList) {
		
			MedicalRecordFamilyIllnessesBean unit = new MedicalRecordFamilyIllnessesBean(illness.getId(), illness.getValue());
			unit.setMedicalRecordId(medicalRecordId);
			unit.setIllnessFather(getFamilyRelation(request, illness, MedicalRecordFamilyIllnessUnit.FATHER));
			unit.setIllnessMother(getFamilyRelation(request, illness, MedicalRecordFamilyIllnessUnit.MOTHER));
			unit.setIllnessBrothers(getFamilyRelation(request, illness, MedicalRecordFamilyIllnessUnit.BROTHERS));
			unit.setIllnessSisters(getFamilyRelation(request, illness, MedicalRecordFamilyIllnessUnit.SISTERS));
			unit.setIllnessSons(getFamilyRelation(request, illness, MedicalRecordFamilyIllnessUnit.SONS));
			unit.setIllnessDaughters(getFamilyRelation(request, illness, MedicalRecordFamilyIllnessUnit.DAUGHTERS));
			unit.setIllnessGrandparents(getFamilyRelation(request, illness, MedicalRecordFamilyIllnessUnit.GRANDPARENTS));
			
			if(checkUnit(unit) == true) {
				System.out.println("Adding illnesses: " + unit);
				illnesses.add(unit);
			}
		}
		System.out.println("Illnesses: " + illnesses);
		return illnesses;
	}
	
	/**
	 * 
	 * @param unit
	 * @return
	 */
	private static Boolean checkUnit(MedicalRecordFamilyIllnessesBean unit) {
		if(unit.isIllnessFather()) return true;
		if(unit.isIllnessMother()) return true;
		if(unit.isIllnessBrothers()) return true;
		if(unit.isIllnessSisters()) return true;
		if(unit.isIllnessSons()) return true;
		if(unit.isIllnessDaughters()) return true;
		if(unit.isIllnessGrandparents()) return true;
		return false;
	}
	
	/**
	 * 
	 * @param request
	 * @param illness
	 * @param relation
	 */
	private static Boolean getFamilyRelation(HttpServletRequest request, PatientFormUnit illness, String relation) {
		
		Boolean hasIllness = request.getParameter(illness.getId() + "familyIllness" + relation) != null && 
				request.getParameter(illness.getId() + "familyIllness" + relation).equals("true") ? true : false;
		return hasIllness;
	}
}