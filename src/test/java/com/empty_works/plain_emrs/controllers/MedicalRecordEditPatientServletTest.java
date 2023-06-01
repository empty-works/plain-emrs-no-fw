package com.empty_works.plain_emrs.controllers;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.empty_works.plain_emrs.patient_choices.MedicalRecordAllergyUnit;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

class MedicalRecordEditPatientServletTest {

	@Test
	void testparseAllergiesEdit() {

		HttpServletRequest request = mock(HttpServletRequest.class);
		String[] allergiesToAddArray = {"Peanuts", "Crabs"};
		when(request.getParameterValues("allergyTextToAdd")).thenReturn(allergiesToAddArray);
		String[] allergiesArray = {"Penicillin", "Pollen"};
		when(request.getParameterValues("allergyText")).thenReturn(allergiesArray);
		
		List<String> expectedMergedList = new ArrayList<>() {
			{	
				add("Peanuts");
				add("Crabs");
				add("Penicillin");
				add("Pollen");
			}
		};
		List<MedicalRecordAllergyUnit> resultMergedList = MedicalRecordEditPatientServlet.parseAllergiesEdit(request);
		List<String> resultMergedListStr = new ArrayList<>();
		for(int i = 0; i < resultMergedList.size(); i++) {
			resultMergedListStr.add(resultMergedList.get(i).getAllergyName());
		}
		assertIterableEquals(expectedMergedList, resultMergedListStr);
	}
}
