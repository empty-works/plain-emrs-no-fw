package com.empty_works.plain_emrs.patient_choices;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Set;

public class PatientFormLists {

	public static List<PatientMedicalProblemUnit> medicalProblemGeneralList = new ArrayList<>() {
		/**
		 * 
		 */
		private static final long serialVersionUID = 4002195277166548304L;

		{
			add(new PatientMedicalProblemUnit("medProbAppend", "Appendix"));
			add(new PatientMedicalProblemUnit("medProbBack", "Back"));
			add(new PatientMedicalProblemUnit("medProbBladder", "Bladder"));
			add(new PatientMedicalProblemUnit("medProbBones", "Bones"));
			add(new PatientMedicalProblemUnit("medProbBowel", "Bowel"));
			add(new PatientMedicalProblemUnit("medProbBrain", "Brain"));
			add(new PatientMedicalProblemUnit("medProbEars", "Ears"));
			add(new PatientMedicalProblemUnit("medProbEsoph", "Esophagus"));
			add(new PatientMedicalProblemUnit("medProbEyes", "Eyes"));
			add(new PatientMedicalProblemUnit("medProbGallBl", "Gallbladder"));
			add(new PatientMedicalProblemUnit("medProbHernia", "Hernia"));
			add(new PatientMedicalProblemUnit("medProbJoints", "Joints"));
			add(new PatientMedicalProblemUnit("medProbKidneys", "Kidneys"));
			add(new PatientMedicalProblemUnit("medProbLiver", "Liver"));
			add(new PatientMedicalProblemUnit("medProbLungs", "Lungs"));
			add(new PatientMedicalProblemUnit("medProbLymph", "Lymph nodes"));
			add(new PatientMedicalProblemUnit("medProbMuscles", "Muscles"));
			add(new PatientMedicalProblemUnit("medProbNeck", "Neck"));
			add(new PatientMedicalProblemUnit("medProbNose", "Nose"));
			add(new PatientMedicalProblemUnit("medProbPancre", "Pancreas"));
			add(new PatientMedicalProblemUnit("medProbSinuses", "Sinuses"));
			add(new PatientMedicalProblemUnit("medProbSkin", "Skin"));
			add(new PatientMedicalProblemUnit("medProbSpine", "Spine"));
			add(new PatientMedicalProblemUnit("medProbSpleen", "Spleen"));
			add(new PatientMedicalProblemUnit("medProbStoma", "Stomach"));
			add(new PatientMedicalProblemUnit("medProbTonsils", "Tonsils"));
			add(new PatientMedicalProblemUnit("medProbThyParaThyGland", "Thyroid or parathyroid gland"));
		}
	};
	
	public static LinkedHashMap<String, String> medicalProblemsGeneralMap = new LinkedHashMap<>() {
		
		/**
		 * 
		 */
		private static final long serialVersionUID = 1508226257245976911L;

		{
			put("medProbAppend", "Appendix");
			put("medProbBack", "Back");
			put("medProbBladder", "Bladder");
			put("medProbBones", "Bones");
			put("medProbBowel", "Bowel");
			put("medProbBrain", "Brain");
			put("medProbEars", "Ears");
			put("medProbEsoph", "Esophagus");
			put("medProbEyes", "Eyes");
			put("medProbGallBl", "Gallbladder");
			put("medProbHernia", "Hernia");
			put("medProbJoints", "Joints");
			put("medProbKidneys", "Kidneys");
			put("medProbLiver", "Liver");
			put("medProbLungs", "Lungs");
			put("medProbLymph", "Lymph nodes");
			put("medProbMuscles", "Muscles");
			put("medProbNeck", "Neck");
			put("medProbNose", "Nose");
			put("medProbPancre", "Pancreas");
			put("medProbSinuses", "Sinuses");
			put("medProbSkin", "Skin");
			put("medProbSpine", "Spine");
			put("medProbSpleen", "Spleen");
			put("medProbStoma", "Stomach");
			put("medProbTonsils", "Tonsils");
			put("medProbThyParaThyGland", "Thyroid or parathyroid gland");
		}
	};
	
	public static Set<String> genMedProbMapKeyset = medicalProblemsGeneralMap.keySet();
	
	public static List<PatientMedicalProblemUnit> medicalProblemHeartList = new ArrayList<>() {
		/**
		 * 
		 */
		private static final long serialVersionUID = 1508226257245976911L;

		{
			add(new PatientMedicalProblemUnit("medProbAbnHeRhy", "Abnormal heart rhythm"));
			add(new PatientMedicalProblemUnit("medProbArteries", "Arteries (head, arms, legs, aorta, etc.)"));
			add(new PatientMedicalProblemUnit("medProbHeAtt", "Heart attack"));
			add(new PatientMedicalProblemUnit("medProbHeartOther", "Heart other"));
			add(new PatientMedicalProblemUnit("medProbHeVal", "Heart valves"));
			add(new PatientMedicalProblemUnit("medProbNarrCoroArt", "Narrowed coronary arteries"));
			add(new PatientMedicalProblemUnit("medProbBlooClots", "Veins or blood clots in the veins"));
		}
	};
	
	public static List<PatientMedicalProblemUnit> medicalProblemReproductList = new ArrayList<>() {
		/**
		 * 
		 */
		private static final long serialVersionUID = -6131874158098753909L;

		{
			add(new PatientMedicalProblemUnit("medProbBreasts", "Breasts"));
			add(new PatientMedicalProblemUnit("medProbFallTubes", "Fallopian tubes"));
			add(new PatientMedicalProblemUnit("medProbHysterec", "Hysterectomy"));
			add(new PatientMedicalProblemUnit("medProbOvaries", "Ovaries"));
			add(new PatientMedicalProblemUnit("medProbPenis", "Penis"));
			add(new PatientMedicalProblemUnit("medProbProstate", "Prostate"));
			add(new PatientMedicalProblemUnit("medProbReproductOther", "Reproductive other"));
			add(new PatientMedicalProblemUnit("medProbTesticles", "Testicles"));
			add(new PatientMedicalProblemUnit("medProbUterus", "Uterus"));
			add(new PatientMedicalProblemUnit("medProbVasect", "Vasectomy"));
		}
	};
	
	public static List<PatientFamilyConditionUnit> familyConditionList = new ArrayList<>() {

		/**
		 * 
		 */
		private static final long serialVersionUID = 8723585501887545137L;
		
		{
			add(new PatientFamilyConditionUnit("famCondLungCancer", "Lung cancer"));
			add(new PatientFamilyConditionUnit("famCondColonCancer", "Colon cancer/rectal cancer"));
			add(new PatientFamilyConditionUnit("famCondColonPolyp", "Colon polyp"));
			add(new PatientFamilyConditionUnit("famCondBreastCancer", "Breast cancer"));
			add(new PatientFamilyConditionUnit("famCondProstateCancer", "Prostate cancer"));
			add(new PatientFamilyConditionUnit("famCondOvarianCancer", "Ovarian cancer"));
			add(new PatientFamilyConditionUnit("famCondPancreaticCancer", "Pancreatic cancer"));
			add(new PatientFamilyConditionUnit("famCondOtherCancer", "Other cancer"));
			add(new PatientFamilyConditionUnit("famCondHeartDisease", "Heart disease"));
			add(new PatientFamilyConditionUnit("famCondDiabetes", "Diabetes"));
			add(new PatientFamilyConditionUnit("famCondAsthma", "Asthma"));
			add(new PatientFamilyConditionUnit("famCondEczema", "Eczema/psoriasis"));
			add(new PatientFamilyConditionUnit("famCondMigraine", "Migraine headache"));
			add(new PatientFamilyConditionUnit("famCondSeizure", "Seizure disorder"));
			add(new PatientFamilyConditionUnit("famCondStroke", "Stroke/TIA"));
			add(new PatientFamilyConditionUnit("famCondHighChol", "High cholesterol"));
			add(new PatientFamilyConditionUnit("famCondAbBleeding", "Abnormal bleeding (bleeding disorder)"));
			add(new PatientFamilyConditionUnit("famCondWhiteCount", "High or low white count"));
			add(new PatientFamilyConditionUnit("famCondHighBlood", "High blood pressure"));
			add(new PatientFamilyConditionUnit("famCondAnemia", "Anemia"));
			add(new PatientFamilyConditionUnit("famCondLiverDisease", "Liver disease"));
			add(new PatientFamilyConditionUnit("famCondHepatitis", "Hepatitis"));
			add(new PatientFamilyConditionUnit("famCondArthritis", "Arthritis"));
			add(new PatientFamilyConditionUnit("famCondOsteopor", "Osteoporosis"));
			add(new PatientFamilyConditionUnit("famCondAlcAbuse", "Alcohol abuse"));
			add(new PatientFamilyConditionUnit("famCondRecDrugs", "Recreational/street drug use"));
			add(new PatientFamilyConditionUnit("famCondSexTranDiseases", "Sexually transmitted disease(s)"));
			add(new PatientFamilyConditionUnit("famCondDepression", "Depression"));
			add(new PatientFamilyConditionUnit("famCondOtherMental", "Other psychiatric/mental illness"));
			add(new PatientFamilyConditionUnit("famCondSuicide", "Suicide or attempted suicide"));
			add(new PatientFamilyConditionUnit("famCondTb", "Tuberculosis (TB)"));
			add(new PatientFamilyConditionUnit("famCondAnesthesiaComp", "Anesthesia complications"));
			add(new PatientFamilyConditionUnit("famCondGenDisorder", "Genetic disorder"));
			add(new PatientFamilyConditionUnit("famCondEmphysema", "COPD/Emphysema"));
			add(new PatientFamilyConditionUnit("famCondAllergies", "Allergies/allergic reactions"));
			add(new PatientFamilyConditionUnit("famCondOther", "Other (discussed with provider)"));
		}
	};
}
