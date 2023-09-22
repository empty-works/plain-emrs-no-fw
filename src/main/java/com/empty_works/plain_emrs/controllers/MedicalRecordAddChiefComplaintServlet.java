package com.empty_works.plain_emrs.controllers;

import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.empty_works.plain_emrs.beans.MedicalRecordChiefComplaintsBean;
import com.empty_works.plain_emrs.beans.MedicalRecordHistoriesPresentIllnessBean;
import com.empty_works.plain_emrs.beans.MedicalRecordROSBean;
import com.empty_works.plain_emrs.beans.MedicalRecordVitalsBean;
import com.empty_works.plain_emrs.dao.MedicalRecordChiefComplaintsDao;
import com.empty_works.plain_emrs.dao.MedicalRecordROSDao;
import com.empty_works.plain_emrs.dao.MedicalRecordVitalsDao;
import com.empty_works.plain_emrs.util.ChiefComplaintIdUtil;

/**
 * Servlet implementation class MedicalRecordAddChiefComplaintServlet
 */
@WebServlet("/MedicalRecordAddChiefComplaintServlet")
public class MedicalRecordAddChiefComplaintServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		System.out.println("Forwarding to MedicalRecordAddChiefComplaint.jsp...");
		request.getRequestDispatcher("/WEB-INF/MedicalRecordAddChiefComplaint.jsp").forward(request, response);
	} 

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/plain");
		
		// Get the form data as a map
		//Map<String, String[]> formData = request.getParameterMap();
		
		// Access individual form fields by their names
		
		System.out.println("Adding chief complaint...");
		MedicalRecordChiefComplaintsBean chiefComplaintsBean = new MedicalRecordChiefComplaintsBean();
		MedicalRecordHistoriesPresentIllnessBean hpiBean = new MedicalRecordHistoriesPresentIllnessBean();
		//MedicalRecordVitalsBean vitals = new MedicalRecordVitalsBean();
		//MedicalRecordROSBean ros = new MedicalRecordROSBean();
		LocalDateTime currentDate = LocalDateTime.now();
		
		HttpSession session = request.getSession();
		String medRecordId = (String)session.getAttribute("medRecordId");
		System.out.println("MedicalRecordAddChiefComplaintServlet med ID: " + medRecordId);
		String chiefComplaintId = ChiefComplaintIdUtil.get(medRecordId);
		chiefComplaintsBean.setMedicalRecordId(medRecordId);
		chiefComplaintsBean.setChiefComplaintId(chiefComplaintId);
		chiefComplaintsBean.setDate(currentDate);
		chiefComplaintsBean.setAdmissionsId(Integer.parseInt(request.getParameter("admissionsIdInput")));
		chiefComplaintsBean.setStatement(request.getParameter("chiefComplaintInput"));
		
		hpiBean.setMedicalRecordId(medRecordId);
		hpiBean.setChiefComplaintId(chiefComplaintId);
		hpiBean.setLocation(request.getParameter("locationInput"));
		hpiBean.setCharacter(request.getParameter("characterInput"));
		hpiBean.setDuration(request.getParameter("durationInput"));
		hpiBean.setOnset(request.getParameter("onsetInput"));
		hpiBean.setModifyingFactors(request.getParameter("modifyingFactorsInput"));
		hpiBean.setRadiation(request.getParameter("radiationInput"));
		hpiBean.setTemporalPattern(request.getParameter("temporalPatternInput"));
		hpiBean.setSeverity(request.getParameter("severityInput"));
		hpiBean.setDescription(request.getParameter("descriptionInput"));
		
		System.out.println("Adding chief complaint...");
		
		/*
		vitals.setMedicalRecordId(medRecordId);
		vitals.setDateTaken(currentDate);
		vitals.setHeight(Double.parseDouble(request.getParameter("vitalsHeightCm")));
		vitals.setWeight(Double.parseDouble(request.getParameter("vitalsWeightKg")));
		vitals.setCalculatedBmi(Double.parseDouble(request.getParameter("vitalsBmi")));
		vitals.setTemperature(Double.parseDouble(request.getParameter("vitalsTemperature")));
		vitals.setPulse(Double.parseDouble(request.getParameter("vitalsPulse")));
		vitals.setRespiratoryRate(Double.parseDouble(request.getParameter("vitalsRespiratoryRate")));
		vitals.setBloodPressureSystolic(Double.parseDouble(request.getParameter("vitalsBPSystolic")));
		vitals.setBloodPressureDiastolic(Double.parseDouble(request.getParameter("vitalsBPDiastolic")));
		vitals.setArterialBloodOxygenSaturation(Double.parseDouble(request.getParameter("vitalsBloodO2Saturation")));
		
		ros.setMedicalRecordId(medRecordId);
		ros.setChiefComplaintId(chiefComplaintId);
		ros.setDate(currentDate);
		ros.setConstitutionalSymptoms(request.getParameter("rosConstitutionalSymptoms"));
		ros.setEyes(request.getParameter("rosEyes"));
		ros.setEarsNoseThroat(request.getParameter("rosEarsNoseThroat"));
		ros.setCardiovascular(request.getParameter("rosCardiovascular"));
		ros.setRespiratory(request.getParameter("rosRespiratory"));
		ros.setGastrointestinal(request.getParameter("rosGastrointestinal"));
		ros.setGenitournary(request.getParameter("rosGenitournary"));
		ros.setMusculoskeletal(request.getParameter("rosMusculoskeletal"));
		ros.setIntegumentary(request.getParameter("rosIntegumentary"));
		ros.setNeurological(request.getParameter("rosNeurological"));
		ros.setPsychiatric(request.getParameter("rosPsychiatric"));
		ros.setEndocrine(request.getParameter("rosEndocrine"));
		ros.setHematologicLymphatic(request.getParameter("rosHematologicLymphatic"));
		ros.setAllergicImmunologic(request.getParameter("rosAllergicImmunologic"));
		*/
		
		// DAOs
		try {
			MedicalRecordChiefComplaintsDao.add(chiefComplaintsBean, hpiBean);
			//MedicalRecordVitalsDao.add(vitals);
			//MedicalRecordROSDao.add(ros);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		//System.out.println("Forwarding to MedicalRecordLatestChiefComplaint.jsp from MedicalRecordAddChiefComplaintServlet...");
		//request.getRequestDispatcher("/WEB-INF/MedicalRecordLatestChiefComplaint.jsp").forward(request, response);
		
	}
}
