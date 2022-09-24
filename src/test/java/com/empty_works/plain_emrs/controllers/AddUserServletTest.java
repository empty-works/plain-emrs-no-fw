package com.empty_works.plain_emrs.controllers;

import static org.junit.jupiter.api.Assertions.assertIterableEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.junit.jupiter.api.Test;

import com.empty_works.plain_emrs.patient_choices.MedicalRecordDiseaseUnit;
import com.empty_works.plain_emrs.patient_choices.MedicalRecordRelationsUnit;
import com.empty_works.plain_emrs.patient_choices.MedicalRecordSurgeryUnit;

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
		List<MedicalRecordDiseaseUnit> diseases = AddUserServlet.parseDiseasesImmun(request);
		for(MedicalRecordDiseaseUnit disease : diseases) {
		
			result.add(disease.getDiseaseName());
		}
		System.out.println(result);
		assertIterableEquals(expected, result);
	}
	
	@Test
	void testParseSurgeries_threeProbAreas_threeSurgRelatedProb_threeSurgProcedure_threeSurgYears() {
		
		HttpServletRequest request = mock(HttpServletRequest.class);
		String[] problemAreas = {"Bladder", "Brain", "Heart valves"}; 
		String[] surgeryRelatedProblems = {"Overactive bladder", "Brain tumor", "Stenosis"};
		String[] surgicalProcedures = {"Urinary diversion", "Awake craniotomy", "Valvuloplasty"};
		String[] surgicalProceduresYears = {"1994", "2011", "1991"};
		when(request.getParameterValues("medProbArea")).thenReturn(problemAreas);
		when(request.getParameterValues("medProbText")).thenReturn(surgeryRelatedProblems);
		when(request.getParameterValues("medProbSurgeryText")).thenReturn(surgicalProcedures);
		when(request.getParameterValues("medProbSurgeryDate")).thenReturn(surgicalProceduresYears);
		
		List<String> probAreaExpected = new ArrayList<>();
		probAreaExpected.add("Bladder");
		probAreaExpected.add("Brain");
		probAreaExpected.add("Heart valves");
		List<String> surgRelatedProbsExpected = new ArrayList<>();
		surgRelatedProbsExpected.add("Overactive bladder");
		surgRelatedProbsExpected.add("Brain tumor");
		surgRelatedProbsExpected.add("Stenosis");
		List<String> surgProceduresExpected = new ArrayList<>();
		surgProceduresExpected.add("Urinary diversion");
		surgProceduresExpected.add("Awake craniotomy");
		surgProceduresExpected.add("Valvuloplasty");
		List<String> surgProceduresYearsExpected = new ArrayList<>();
		surgProceduresYearsExpected.add("1994");
		surgProceduresYearsExpected.add("2011");
		surgProceduresYearsExpected.add("1991");
		List<String> probAreaResult = new ArrayList<>();
		List<String> surgRelatedResult = new ArrayList<>();
		List<String> surgProceduresResult = new ArrayList<>();
		List<String> surgProceduresYearsResult = new ArrayList<>();
		List<MedicalRecordSurgeryUnit> parsedMedProblems = AddUserServlet.parseSurgeries(request);
		for(MedicalRecordSurgeryUnit parsedMedProblem : parsedMedProblems) {
			
			probAreaResult.add(parsedMedProblem.getProblemArea());
			surgRelatedResult.add(parsedMedProblem.getSurgicalRelatedProblem());
			surgProceduresResult.add(parsedMedProblem.getSurgicalProcedure());
			surgProceduresYearsResult.add(parsedMedProblem.getSurgicalProcedureYear());
		}
		System.out.println(probAreaResult);
		System.out.println(surgRelatedResult);
		System.out.println(surgProceduresResult);
		System.out.println(surgProceduresYearsResult);
		assertIterableEquals(probAreaExpected, probAreaResult);
		assertIterableEquals(surgRelatedProbsExpected, surgRelatedResult);
		assertIterableEquals(surgProceduresExpected, surgProceduresResult);
		assertIterableEquals(surgProceduresYearsExpected, surgProceduresYearsResult);
	}
	
	@Test
	void testParseRelations() {
		
		HttpServletRequest request = mock(HttpServletRequest.class);
		List<MedicalRecordRelationsUnit> relations = new ArrayList<>();
		String[] relationList = {"Brothers", "Sisters", "Sons", "Daughters"};
		String[] relationNumList = {"2", "3", "1", "3"};
		
	}
}