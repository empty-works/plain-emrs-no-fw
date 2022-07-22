package com.empty_works.plain_emrs.patient_choices;

import java.util.ArrayList;
import java.util.List;

public class PatientMedicalProblemLists {

	public static List<PatientMedicalProblemUnit> medicalProblemGeneralList = new ArrayList<>() {
		/**
		 * 
		 */
		private static final long serialVersionUID = 4002195277166548304L;

		{
			add(new PatientMedicalProblemUnit("medProbEyes", "Eyes"));
			add(new PatientMedicalProblemUnit("medProbEars", "Ears"));
			add(new PatientMedicalProblemUnit("medProbNose", "Nose"));
			add(new PatientMedicalProblemUnit("medProbSinuses", "Sinuses"));
			add(new PatientMedicalProblemUnit("medProbTonsils", "Tonsils"));
			add(new PatientMedicalProblemUnit("medProbThyParaThyGland", "Thyroid or parathyroid gland"));
			add(new PatientMedicalProblemUnit("medProbLungs", "Lungs"));
			add(new PatientMedicalProblemUnit("medProbEsoph", "Esophagus"));
			add(new PatientMedicalProblemUnit("medProbStoma", "Stomach"));
			add(new PatientMedicalProblemUnit("medProbBowel", "Bowel"));
			add(new PatientMedicalProblemUnit("medProbAppend", "Appendix"));
			add(new PatientMedicalProblemUnit("medProbLymph", "Lymph nodes"));
			add(new PatientMedicalProblemUnit("medProbSpleen", "Spleen"));
			add(new PatientMedicalProblemUnit("medProbLiver", "Liver"));
			add(new PatientMedicalProblemUnit("medProbGallBl", "Gallbladder"));
			add(new PatientMedicalProblemUnit("medProbPancre", "Pancreas"));
			add(new PatientMedicalProblemUnit("medProbHernia", "Hernia"));
			add(new PatientMedicalProblemUnit("medProbKidneys", "Kidneys"));
			add(new PatientMedicalProblemUnit("medProbBladder", "Bladder"));
			add(new PatientMedicalProblemUnit("medProbBones", "Bones"));
			add(new PatientMedicalProblemUnit("medProbJoints", "Joints"));
			add(new PatientMedicalProblemUnit("medProbMuscles", "Muscles"));
			add(new PatientMedicalProblemUnit("medProbBack", "Back"));
			add(new PatientMedicalProblemUnit("medProbNeck", "Neck"));
			add(new PatientMedicalProblemUnit("medProbSpine", "Spine"));
			add(new PatientMedicalProblemUnit("medProbBrain", "Brain"));
			add(new PatientMedicalProblemUnit("medProbSkin", "Skin"));
		}
	};
	
	public static List<PatientMedicalProblemUnit> medicalProblemHeartList = new ArrayList<>() {
		/**
		 * 
		 */
		private static final long serialVersionUID = 1508226257245976911L;

		{
			add(new PatientMedicalProblemUnit("medProbHeAtt", "Heart attack"));
			add(new PatientMedicalProblemUnit("medProbHeVal", "Heart valves"));
			add(new PatientMedicalProblemUnit("medProbAbnHeRhy", "Abnormal heart rhythm"));
			add(new PatientMedicalProblemUnit("medProbNarrCoroArt", "Narrowed coronary arteries"));
			add(new PatientMedicalProblemUnit("medProbArteries", "Arteries (head, arms, legs, aorta, etc.)"));
			add(new PatientMedicalProblemUnit("medProbBlooClots", "Veins or blood clots in the veins"));
			add(new PatientMedicalProblemUnit("medProbHeartOther", "Heart other"));
		}
	};
	
	public static List<PatientMedicalProblemUnit> medicalProblemReproductList = new ArrayList<>() {
		/**
		 * 
		 */
		private static final long serialVersionUID = -6131874158098753909L;

		{
			add(new PatientMedicalProblemUnit("medProbBreasts", "Breasts"));
			add(new PatientMedicalProblemUnit("medProbUterus", "Uterus"));
			add(new PatientMedicalProblemUnit("medProbOvaries", "Ovaries"));
			add(new PatientMedicalProblemUnit("medProbFallTubes", "Fallopian tubes"));
			add(new PatientMedicalProblemUnit("medProbHysterec", "Hysterectomy"));
			add(new PatientMedicalProblemUnit("medProbReproductOther", "Reproductive other"));
			add(new PatientMedicalProblemUnit("medProbProstate", "Prostate"));
			add(new PatientMedicalProblemUnit("medProbPenis", "Penis"));
			add(new PatientMedicalProblemUnit("medProbTesticles", "Testicles"));
			add(new PatientMedicalProblemUnit("medProbVasect", "Vasectomy"));
		}
	};
}
