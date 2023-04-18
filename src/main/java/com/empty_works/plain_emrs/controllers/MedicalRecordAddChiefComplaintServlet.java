package com.empty_works.plain_emrs.controllers;

import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDateTime;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.empty_works.plain_emrs.beans.MedicalRecordChiefComplaintsBean;
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

		MedicalRecordChiefComplaintsBean chiefComplaints = new MedicalRecordChiefComplaintsBean();
		MedicalRecordVitalsBean vitals = new MedicalRecordVitalsBean();
		MedicalRecordROSBean ros = new MedicalRecordROSBean();
		LocalDateTime currentDate = LocalDateTime.now();
		
		String chiefComplaintId = ChiefComplaintIdUtil.get((String)request.getAttribute("medRecord"));
		chiefComplaints.setChiefComplaintId(chiefComplaintId);
		chiefComplaints.setDate(currentDate);
		chiefComplaints.setStatement((String)request.getAttribute("chiefComplaintInput"));
		
		vitals.setMedicalRecordId((String)request.getAttribute("medRecord"));
		vitals.setDateTaken(currentDate);
		vitals.setHeight((double)request.getAttribute("vitalsHeightCm"));
		vitals.setWeight((double)request.getAttribute("vitalsWeightKg"));
		vitals.setCalculatedBmi((double)request.getAttribute("vitalsBmi"));
		vitals.setTemperature((double)request.getAttribute("vitalsTemperature"));
		vitals.setPulse((double)request.getAttribute("vitalsPulse"));
		vitals.setRespiratoryRate((double)request.getAttribute("vitalsRespiratoryRate"));
		vitals.setBloodPressureSystolic((double)request.getAttribute("vitalsBPSystolic"));
		vitals.setBloodPressureDiastolic((double)request.getAttribute("vitalsBPDiastolic"));
		vitals.setArterialBloodOxygenSaturation((double)request.getAttribute("vitalsBloodO2Saturation"));
		
		ros.setMedicalRecordId((String)request.getAttribute("medRecord"));
		ros.setChiefComplaintId(chiefComplaintId);
		ros.setDate(currentDate);
		ros.setConstitutionalSymptoms((String)request.getAttribute("rosConstitutionalSymptoms"));
		ros.setEyes((String)request.getAttribute("rosEyes"));
		ros.setEarsNoseThroat((String)request.getAttribute("rosEarsNoseThroat"));
		ros.setCardiovascular((String)request.getAttribute("rosCardiovascular"));
		ros.setRespiratory((String)request.getAttribute("rosRespiratory"));
		ros.setGastrointestinal((String)request.getAttribute("rosGastrointestinal"));
		ros.setGenitournary((String)request.getAttribute("rosGenitournary"));
		ros.setMusculoskeletal((String)request.getAttribute("rosMusculoskeletal"));
		ros.setIntegumentary((String)request.getAttribute("rosIntegumentary"));
		ros.setNeurological((String)request.getAttribute("rosNeurological"));
		ros.setPsychiatric((String)request.getAttribute("rosPsychiatric"));
		ros.setEndocrine((String)request.getAttribute("rosEndocrine"));
		ros.setHematologicLymphatic((String)request.getAttribute("rosHematologicLymphatic"));
		ros.setAllergicImmunologic((String)request.getAttribute("rosAllergicImmunologic"));
		
		// DAOs
		try {
			MedicalRecordChiefComplaintsDao.add(chiefComplaints);
			MedicalRecordVitalsDao.add(vitals);
			MedicalRecordROSDao.add(ros);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
