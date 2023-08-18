package com.empty_works.plain_emrs.patient_choices;

import java.util.ArrayList;
import java.util.List;

import com.empty_works.plain_emrs.beans.MedicalRecordImmunizationsBean;
import com.empty_works.plain_emrs.dao.MedicalRecordDiseasesBean;

public class MedicalRecordDiseaseLists {

	public static List<MedicalRecordDiseasesBean> diseaseList = new ArrayList<>() {
		/**
		 * 
		 */
		private static final long serialVersionUID = -2920815267628068522L;

		{
			add(new MedicalRecordDiseasesBean("diseasePneumo", "Pneumococcal"));
			add(new MedicalRecordDiseasesBean("diseaseHepB", "Hepatitis B"));
			add(new MedicalRecordDiseasesBean("diseaseHepA", "Hepatitis A"));
			add(new MedicalRecordDiseasesBean("diseaseMeas", "Measles"));
			add(new MedicalRecordDiseasesBean("diseaseMumps", "Mumps"));
			add(new MedicalRecordDiseasesBean("diseaseRubel", "Rubella"));
			add(new MedicalRecordDiseasesBean("diseasePolio", "Polio"));
			add(new MedicalRecordDiseasesBean("diseaseVaric", "Varicella"));
		}
	};
}
