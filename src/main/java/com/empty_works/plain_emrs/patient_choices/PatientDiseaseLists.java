package com.empty_works.plain_emrs.patient_choices;

import java.util.ArrayList;
import java.util.List;

public class PatientDiseaseLists {

	public static List<PatientDiseaseUnit> diseaseList = new ArrayList<>() {
		/**
		 * 
		 */
		private static final long serialVersionUID = -2920815267628068522L;

		{
			add(new PatientDiseaseUnit("diseasePneumo", "Pneumococcal"));
			add(new PatientDiseaseUnit("diseaseHepB", "Hepatitis B"));
			add(new PatientDiseaseUnit("diseaseHepA", "Hepatitis A"));
			add(new PatientDiseaseUnit("diseaseMeas", "Measles"));
			add(new PatientDiseaseUnit("diseaseMumps", "Mumps"));
			add(new PatientDiseaseUnit("diseaseRubel", "Rubella"));
			add(new PatientDiseaseUnit("diseasePolio", "Polio"));
			add(new PatientDiseaseUnit("diseaseVaric", "Varicella"));
		}
	};
}
