package com.empty_works.plain_emrs.user_choices;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class UserRelationGenderLists {
	
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
