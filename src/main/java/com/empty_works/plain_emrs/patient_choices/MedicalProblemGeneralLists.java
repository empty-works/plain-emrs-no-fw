package com.empty_works.plain_emrs.patient_choices;

import java.util.ArrayList;
import java.util.List;

public class MedicalProblemGeneralLists {

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
}
