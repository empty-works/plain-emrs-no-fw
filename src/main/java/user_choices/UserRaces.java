package user_choices;

import java.util.HashMap;

/*
 * Descriptions of races taken from the Office of Diversity, Inclusion and Civil Rights of 
 * U.S. Department of the Interior
 * */

public class UserRaces {
	
	final public static HashMap<String, String> raceHash = new HashMap<>()
		{/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

		{
			put("American Indian or Alaska Native","A person having origins in any of the original "
					+ "peoples of North and South America (including Central America), and who maintains "
					+ "tribal affiliation or community attachment.");
			put("Asian","A person having origins in any of the original peoples of the Far East, Southeast "
					+ "Asia, or the Indian subcontinent including, for example, Cambodia, China, India, Japan, "
					+ "Korea, Malaysia, Pakistan, the Philippine Islands, Thailand, and Vietnam.");
			put("Black or African American","A person having origins in any of the black racial groups of Africa. "
					+ "Terms such as \"Haitian\" or \"Negro\" can be used in addition to \"Black or African American.\"");
			put("Hispanic or Latino","A person of Cuban, Mexican, Puerto Rican, South or Central American, or other Spanish "
					+ "culture or origin, regardless of race. The term, \"Spanish origin,\" can be used in addition to \"Hispanic or Latino.\"");
			put("Native Hawaiian or Other Pacific Islander","A person having origins in any of the original peoples "
					+ "of Hawaii, Guam, Samoa, or other Pacific Islands.");
			put("White","A person having origins in any of the original peoples of Europe, the Middle East, or North Africa.");
		}
	};
}
