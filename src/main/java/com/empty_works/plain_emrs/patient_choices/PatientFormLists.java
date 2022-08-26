package com.empty_works.plain_emrs.patient_choices;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Set;

public class PatientFormLists {

	public static List<PatientFormUnit> medicalProblemGeneralList = new ArrayList<>() {
		/**
		 * 
		 */
		private static final long serialVersionUID = 4002195277166548304L;

		{
			add(new PatientFormUnit("medProbAppend", "Appendix"));
			add(new PatientFormUnit("medProbBack", "Back"));
			add(new PatientFormUnit("medProbBladder", "Bladder"));
			add(new PatientFormUnit("medProbBones", "Bones"));
			add(new PatientFormUnit("medProbBowel", "Bowel"));
			add(new PatientFormUnit("medProbBrain", "Brain"));
			add(new PatientFormUnit("medProbEars", "Ears"));
			add(new PatientFormUnit("medProbEsoph", "Esophagus"));
			add(new PatientFormUnit("medProbEyes", "Eyes"));
			add(new PatientFormUnit("medProbGallBl", "Gallbladder"));
			add(new PatientFormUnit("medProbHernia", "Hernia"));
			add(new PatientFormUnit("medProbJoints", "Joints"));
			add(new PatientFormUnit("medProbKidneys", "Kidneys"));
			add(new PatientFormUnit("medProbLiver", "Liver"));
			add(new PatientFormUnit("medProbLungs", "Lungs"));
			add(new PatientFormUnit("medProbLymph", "Lymph nodes"));
			add(new PatientFormUnit("medProbMuscles", "Muscles"));
			add(new PatientFormUnit("medProbNeck", "Neck"));
			add(new PatientFormUnit("medProbNose", "Nose"));
			add(new PatientFormUnit("medProbPancre", "Pancreas"));
			add(new PatientFormUnit("medProbSinuses", "Sinuses"));
			add(new PatientFormUnit("medProbSkin", "Skin"));
			add(new PatientFormUnit("medProbSpine", "Spine"));
			add(new PatientFormUnit("medProbSpleen", "Spleen"));
			add(new PatientFormUnit("medProbStoma", "Stomach"));
			add(new PatientFormUnit("medProbTonsils", "Tonsils"));
			add(new PatientFormUnit("medProbThyParaThyGland", "Thyroid or parathyroid gland"));
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
	
	public static List<PatientFormUnit> medicalProblemHeartList = new ArrayList<>() {
		/**
		 * 
		 */
		private static final long serialVersionUID = 1508226257245976911L;

		{
			add(new PatientFormUnit("medProbAbnHeRhy", "Abnormal heart rhythm"));
			add(new PatientFormUnit("medProbArteries", "Arteries (head, arms, legs, aorta, etc.)"));
			add(new PatientFormUnit("medProbHeAtt", "Heart attack"));
			add(new PatientFormUnit("medProbHeartOther", "Heart other"));
			add(new PatientFormUnit("medProbHeVal", "Heart valves"));
			add(new PatientFormUnit("medProbNarrCoroArt", "Narrowed coronary arteries"));
			add(new PatientFormUnit("medProbBlooClots", "Veins or blood clots in the veins"));
		}
	};
	
	public static List<PatientFormUnit> medicalProblemReproductList = new ArrayList<>() {
		/**
		 * 
		 */
		private static final long serialVersionUID = -6131874158098753909L;

		{
			add(new PatientFormUnit("medProbBreasts", "Breasts"));
			add(new PatientFormUnit("medProbFallTubes", "Fallopian tubes"));
			add(new PatientFormUnit("medProbHysterec", "Hysterectomy"));
			add(new PatientFormUnit("medProbOvaries", "Ovaries"));
			add(new PatientFormUnit("medProbPenis", "Penis"));
			add(new PatientFormUnit("medProbProstate", "Prostate"));
			add(new PatientFormUnit("medProbReproductOther", "Reproductive other"));
			add(new PatientFormUnit("medProbTesticles", "Testicles"));
			add(new PatientFormUnit("medProbUterus", "Uterus"));
			add(new PatientFormUnit("medProbVasect", "Vasectomy"));
		}
	};
	
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
