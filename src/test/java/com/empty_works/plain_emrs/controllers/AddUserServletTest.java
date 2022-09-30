package com.empty_works.plain_emrs.controllers;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertIterableEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.junit.jupiter.api.Test;

import com.empty_works.plain_emrs.patient_choices.MedicalRecordDiseaseUnit;
import com.empty_works.plain_emrs.patient_choices.MedicalRecordFamilyConditionUnit;
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
	void testParseRelations_allRelations_multipleRelationsEach() {
		
		int NUM_ARGS = 4;
		HttpServletRequest request = mock(HttpServletRequest.class);
		List<MedicalRecordRelationsUnit> relations;
		when(request.getParameter("Brothers")).thenReturn("2");
		when(request.getParameter("Sisters")).thenReturn("3");
		when(request.getParameter("Sons")).thenReturn("1");
		when(request.getParameter("Daughters")).thenReturn("3");
		relations = AddUserServlet.parseRelations(request);

		List<String> expectedRelationList = new ArrayList<>();
		expectedRelationList.add("Brothers");
		expectedRelationList.add("Sisters");
		expectedRelationList.add("Sons");
		expectedRelationList.add("Daughters");

		int[] expectedRelationNumArray = {2, 3, 1, 3};

		List<String> resultRelationList = new ArrayList<>();
		int[] resultRelationNumArray = new int[NUM_ARGS];
		for(int i = 0; i < NUM_ARGS; i++) {
			
			resultRelationList.add(relations.get(i).getRelation());
			resultRelationNumArray[i] = relations.get(i).getNumRelations();
		}
		System.out.println(resultRelationList);
		assertIterableEquals(expectedRelationList, resultRelationList);
		assertArrayEquals(expectedRelationNumArray, resultRelationNumArray);
	}
	
	@Test
	void testParseConditions_asthmaBrothersGrandparentsOnly_otherConditionsNotAdded() {
		
		HttpServletRequest request = mock(HttpServletRequest.class);
		List<MedicalRecordFamilyConditionUnit> conditions = new ArrayList<>();
		when(request.getParameter("AsthmafamilyConditionSelf")).thenReturn("false");
		when(request.getParameter("AsthmafamilyConditionFather")).thenReturn("false");
		when(request.getParameter("AsthmafamilyConditionMother")).thenReturn("false");
		when(request.getParameter("AsthmafamilyConditionBrothers")).thenReturn("true");
		when(request.getParameter("AsthmafamilyConditionSisters")).thenReturn("false");
		when(request.getParameter("AsthmafamilyConditionSons")).thenReturn("false");
		when(request.getParameter("AsthmafamilyConditionDaughters")).thenReturn("false");
		when(request.getParameter("AsthmafamilyConditionGrandparents")).thenReturn("true");
		conditions = AddUserServlet.parseConditions(request);
		
		List<String> expectedRelativesNumList = new ArrayList<>();
		expectedRelativesNumList.add(MedicalRecordFamilyConditionUnit.BROTHERS);
		expectedRelativesNumList.add(MedicalRecordFamilyConditionUnit.GRANDPARENTS);
		
		List<String> resultRelativesList = new ArrayList<>();
		
		for(MedicalRecordFamilyConditionUnit condition: conditions) {
			
			for(String relative : condition.getFamilyRelations()) {
				
				resultRelativesList.add(relative);
			}
		}
		
		assertEquals(expectedRelativesNumList.size(), resultRelativesList.size());
		assertIterableEquals(expectedRelativesNumList, resultRelativesList);
	}
}