package com.empty_works.plain_emrs.patient_choices;

import java.util.ArrayList;
import java.util.List;

public class MedicalRecordFamilyIllnessLists {

	public static List<PatientFormUnit> familyConditionList = new ArrayList<>() {

		/**
		 * 
		 */
		private static final long serialVersionUID = 8723585501887545137L;
		
		{
			add(new PatientFormUnit("famCondLungCancer", "Lung cancer"));
			add(new PatientFormUnit("famCondColonCancer", "Colon cancer/rectal cancer"));
			add(new PatientFormUnit("famCondColonPolyp", "Colon polyp"));
			add(new PatientFormUnit("famCondBreastCancer", "Breast cancer"));
			add(new PatientFormUnit("famCondProstateCancer", "Prostate cancer"));
			add(new PatientFormUnit("famCondOvarianCancer", "Ovarian cancer"));
			add(new PatientFormUnit("famCondPancreaticCancer", "Pancreatic cancer"));
			add(new PatientFormUnit("famCondOtherCancer", "Other cancer"));
			add(new PatientFormUnit("famCondHeartDisease", "Heart disease"));
			add(new PatientFormUnit("famCondDiabetes", "Diabetes"));
			add(new PatientFormUnit("famCondAsthma", "Asthma"));
			add(new PatientFormUnit("famCondEczema", "Eczema/psoriasis"));
			add(new PatientFormUnit("famCondMigraine", "Migraine headache"));
			add(new PatientFormUnit("famCondSeizure", "Seizure disorder"));
			add(new PatientFormUnit("famCondStroke", "Stroke/TIA"));
			add(new PatientFormUnit("famCondHighChol", "High cholesterol"));
			add(new PatientFormUnit("famCondAbBleeding", "Abnormal bleeding (bleeding disorder)"));
			add(new PatientFormUnit("famCondWhiteCount", "High or low white count"));
			add(new PatientFormUnit("famCondHighBlood", "High blood pressure"));
			add(new PatientFormUnit("famCondAnemia", "Anemia"));
			add(new PatientFormUnit("famCondLiverDisease", "Liver disease"));
			add(new PatientFormUnit("famCondHepatitis", "Hepatitis"));
			add(new PatientFormUnit("famCondArthritis", "Arthritis"));
			add(new PatientFormUnit("famCondOsteopor", "Osteoporosis"));
			add(new PatientFormUnit("famCondAlcAbuse", "Alcohol abuse"));
			add(new PatientFormUnit("famCondRecDrugs", "Recreational/street drug use"));
			add(new PatientFormUnit("famCondSexTranDiseases", "Sexually transmitted disease(s)"));
			add(new PatientFormUnit("famCondDepression", "Depression"));
			add(new PatientFormUnit("famCondOtherMental", "Other psychiatric/mental illness"));
			add(new PatientFormUnit("famCondSuicide", "Suicide or attempted suicide"));
			add(new PatientFormUnit("famCondTb", "Tuberculosis (TB)"));
			add(new PatientFormUnit("famCondAnesthesiaComp", "Anesthesia complications"));
			add(new PatientFormUnit("famCondGenDisorder", "Genetic disorder"));
			add(new PatientFormUnit("famCondEmphysema", "COPD/Emphysema"));
			add(new PatientFormUnit("famCondAllergies", "Allergies/allergic reactions"));
			add(new PatientFormUnit("famCondOther", "Other (discussed with provider)"));
		}
	};
}
