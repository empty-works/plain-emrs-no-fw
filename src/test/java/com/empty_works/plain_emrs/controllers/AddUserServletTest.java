package com.empty_works.plain_emrs.controllers;

import static org.junit.jupiter.api.Assertions.assertIterableEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.junit.jupiter.api.Test;

import com.empty_works.plain_emrs.patient_choices.PatientDiseaseUnit;

public class AddUserServletTest {

	@Test
	void testParseRaces_asianlatino() {
		
		HttpServletRequest request = mock(HttpServletRequest.class);
		
		String[] raceArray = {"Asian", "Hispanic or Latino"};
		when(request.getParameterValues("raceCheck")).thenReturn(raceArray);
		when(request.getParameter("asianEthnDropdown")).thenReturn("Okinawan");
		when(request.getParameter("hisLatinEthnDropdown")).thenReturn("Nicaraguan");
		
		List<String> expected = new ArrayList<>() {
			
			{
				add("Asian-Okinawan");
				add("Hispanic or Latino-Nicaraguan");
			}
		};
		
		List<String> result = AddUserServlet.parseRaces(request);
		System.out.println(result);
		assertIterableEquals(expected, result);
	}
	
	@Test
	void testParseDiseasesImmun_hepAImmun_rubelNoImmun() {
		
		HttpServletRequest request = mock(HttpServletRequest.class);
		when(request.getParameter("diseasePneumoimmuDiseaseRadio")).thenReturn("diseasePneumoNeverHad");
		when(request.getParameter("diseaseHepBimmuDiseaseRadio")).thenReturn("diseaseHepBNeverHad");
		when(request.getParameter("diseaseHepAimmuDiseaseRadio")).thenReturn("diseaseHepAHadImmun");
		when(request.getParameter("diseaseMeasimmuDiseaseRadio")).thenReturn("diseaseMeasHadNeverHad");
		when(request.getParameter("diseaseMumpsimmuDiseaseRadio")).thenReturn("diseaseMumpsNeverHad");
		when(request.getParameter("diseaseRubelimmuDiseaseRadio")).thenReturn("diseaseRubelHadNoImmun");
		when(request.getParameter("diseasePolioimmuDiseaseRadio")).thenReturn("diseasePolioNeverHad");
		when(request.getParameter("diseaseVaricimmuDiseaseRadio")).thenReturn("diseaseVaricNeverHad");
		
		List<String> expected = new ArrayList<>() {
			
			{
				add("Hepatitis A");
				add("Rubella");
			}
		};
		
		List<String> result = new ArrayList<>();
		List<PatientDiseaseUnit> diseases = AddUserServlet.parseDiseasesImmun(request);
		for(PatientDiseaseUnit disease : diseases) {
		
			result.add(disease.getDiseaseName());
		}
		System.out.println(result);
		assertIterableEquals(expected, result);
	}
}
