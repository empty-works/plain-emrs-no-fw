package user_choices;

import java.util.HashSet;

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
	
	final public static HashSet<String> livingArrangementHash = new HashSet<>()
	{
		/**
		 * 
		 */
		private static final long serialVersionUID = 1593118704632849613L;

		{
			add("Alone");
			add("Spouse/Partner(s)");
			add("Child(ren)");
			add("Sibling");
			add("Parent(s)/Guardian(s)");
			add("Group setting");
			add("Personal care attendant");
			add("Other");
		}
	};
	
	final public static HashSet<String> currentGenderHash = new HashSet<>()
	{
		/**
		 * 
		 */
		private static final long serialVersionUID = -1816798785282417562L;

		{
			add("Male");
			add("Female");
			add("Transgender Male/Transgender Man/Female-to-Male (FtM)");
			add("Transgender Female/Transgender Woman/Male-to-Female (MtF)");
			add("Genderqueer - neither exclusively male nor female");
			add("Other");
			add("Choose not to disclose");
		}
	};

	final public static HashSet<String> genderAtBirthHash = new HashSet<>()
	{
		/**
		 * 
		 */
		private static final long serialVersionUID = 6994264506059224095L;

		{
			add("Male");
			add("Female");
		}
	};
	
	final public static HashSet<String> sexualOrientationHash = new HashSet<>()
	{
		/**
		 * 
		 */
		private static final long serialVersionUID = 1637247765396865477L;

		{
			add("Straight or heterosexual");
			add("Lesbian, gay, or homosexual");
			add("Bisexual");
			add("Something else");
			add("Don't know");
		}
	};
}
