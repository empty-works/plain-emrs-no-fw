package user_choices;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class UserRelationGender {
	
	final public static HashSet<String> relationshipStatusHash = new HashSet<>()
	{ 
		/**
		 * 
		 */
		private static final long serialVersionUID = 4759298612889878166L;

		{
			add("Single");
			add("Married");
			add("Partnered");
			add("Separated");
			add("Divorced");
			add("Widowed");
		}
	};
	
	final public static List<UserLivingArranUnit> livingList = new ArrayList<>() {
		
		/**
		 * 
		 */
		private static final long serialVersionUID = 1593118704632849613L;

		{
			add(new UserLivingArranUnit("alone", "Alone"));
			add(new UserLivingArranUnit("spousePartner", "Spouse/Partner(s)"));
			add(new UserLivingArranUnit("children", "Child(ren)"));
			add(new UserLivingArranUnit("sibling", "Sibling"));
			add(new UserLivingArranUnit("parentGuard", "Parent(s)/Guardian(s)"));
			add(new UserLivingArranUnit("group", "Group setting"));
			add(new UserLivingArranUnit("personalCare", "Personal care attendant"));
			add(new UserLivingArranUnit("other", "Other"));
		}
	};
	
	final public static List<UserCurrentGenderUnit> currentGenderList = new ArrayList<>() {
		/**
		 * 
		 */
		private static final long serialVersionUID = -1816798785282417562L;

		{
			add(new UserCurrentGenderUnit("male", "Male"));
			add(new UserCurrentGenderUnit("female", "Female"));
			add(new UserCurrentGenderUnit("transFtm", "Transgender Male/Transgender Man/Female-to-Male (FtM)"));
			add(new UserCurrentGenderUnit("transMtf", "Transgender Female/Transgender Woman/Male-to-Female (MtF)"));
			add(new UserCurrentGenderUnit("genQueer", "Genderqueer - neither exclusively male nor female"));
			add(new UserCurrentGenderUnit("curGenOther", "Other"));
			add(new UserCurrentGenderUnit("curGenNoAnswer", "Choose not to disclose"));
		}
	};

	final public static List<UserSexAssignedBirthUnit> sexAssignedBirthList = new ArrayList<>() {
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		{
			add(new UserSexAssignedBirthUnit("sexAssignedMale", "Male"));
			add(new UserSexAssignedBirthUnit("sexAssignedFemale", "Female"));
			add(new UserSexAssignedBirthUnit("sexAssignedNoAnswer", "Choose not to disclose"));
		}
	};
	
	final public static List<UserSexualOrientationUnit> sexualOrientationList = new ArrayList<>() {
		/**
		 * 
		 */
		private static final long serialVersionUID = 1637247765396865477L;

		{
			add(new UserSexualOrientationUnit("straHetero", "Straight or heterosexual"));
			add(new UserSexualOrientationUnit("lesGaHomo", "Lesbian, gay, or homosexual"));
			add(new UserSexualOrientationUnit("bisex", "Bisexual"));
			add(new UserSexualOrientationUnit("someElse", "Something else"));
			add(new UserSexualOrientationUnit("donKno", "Don't know"));
		}
	};
}
