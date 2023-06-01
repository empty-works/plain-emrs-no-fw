package com.empty_works.plain_emrs.controllers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.empty_works.plain_emrs.beans.MedicalRecordAllergiesBean;
import com.empty_works.plain_emrs.patient_choices.MedicalRecordAllergyUnit;

/**
 * Servlet implementation class MedicalRecordEditPatientServlet
 */
@WebServlet("/MedicalRecordEditPatientServlet")
public class MedicalRecordEditPatientServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		
		request.getRequestDispatcher("/WEB-INF/MedicalRecordEditPatient.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String medicalRecordId = (String) session.getAttribute("userPatientId"); 
		
		

		MedicalRecordAllergiesBean allergies = new MedicalRecordAllergiesBean();
		allergies.setMedicalRecordId(medicalRecordId);
		allergies.setAllergyUnits(parseAllergiesEdit(request));
	}
	
	protected static List<MedicalRecordAllergyUnit> parseAllergiesEdit(HttpServletRequest request) {
		List<MedicalRecordAllergyUnit> allergiesList = new ArrayList<>();
		String[] allergiesToAddArray = request.getParameterValues("allergyTextToAdd");
		String[] allergiesArray = request.getParameterValues("allergyText");
		List<String> mergedAllergies = new ArrayList<>(allergiesToAddArray.length + allergiesArray.length);
		Collections.addAll(mergedAllergies, allergiesToAddArray);
		Collections.addAll(mergedAllergies, allergiesArray);
		if(mergedAllergies.size() > 0) {
			for(String allergy : mergedAllergies) {
				MedicalRecordAllergyUnit allergyUnit = new MedicalRecordAllergyUnit(allergy);
				allergiesList.add(allergyUnit);
			}
		}
		return allergiesList;
	}
}
