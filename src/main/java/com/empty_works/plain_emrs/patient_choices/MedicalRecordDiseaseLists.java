package com.empty_works.plain_emrs.patient_choices;

import java.util.ArrayList;
import java.util.List;

public class MedicalRecordDiseaseLists {

	public static List<MedicalRecordDiseaseUnit> diseaseList = new ArrayList<>() {
		/**
		 * 
		 */
		private static final long serialVersionUID = -2920815267628068522L;

		{
			add(new MedicalRecordDiseaseUnit("diseasePneumo", "Pneumococcal"));
			add(new MedicalRecordDiseaseUnit("diseaseHepB", "Hepatitis B"));
			add(new MedicalRecordDiseaseUnit("diseaseHepA", "Hepatitis A"));
			add(new MedicalRecordDiseaseUnit("diseaseMeas", "Measles"));
			add(new MedicalRecordDiseaseUnit("diseaseMumps", "Mumps"));
			add(new MedicalRecordDiseaseUnit("diseaseRubel", "Rubella"));
			add(new MedicalRecordDiseaseUnit("diseasePolio", "Polio"));
			add(new MedicalRecordDiseaseUnit("diseaseVaric", "Varicella"));
		}
	};
}
