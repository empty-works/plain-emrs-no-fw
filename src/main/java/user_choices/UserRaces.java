package user_choices;

import java.util.ArrayList;
import java.util.List;

/*
 * Descriptions of races taken from the Office of Diversity, Inclusion and Civil Rights of 
 * U.S. Department of the Interior
 * */

public class UserRaces {
	
	final public static List<UserRaceUnit> raceList = new ArrayList<>() {
		/**
		 * 
		 */
		private static final long serialVersionUID = -6214395715920744505L;

		{
			add(new UserRaceUnit("ameriIndAlasNat", "American Indian or Alaska Native", "A person having origins in any of the original "
					+ "peoples of North and South America (including Central America), and who maintains tribal affiliation or community attachment."));
			add(new UserRaceUnit("asian", "Asian", "A person having origins in any of the original peoples of the Far East, Southeast "
					+ "Asia, or the Indian subcontinent including, for example, Cambodia, China, India, Japan, "
					+ "Korea, Malaysia, Pakistan, the Philippine Islands, Thailand, and Vietnam."));
			add(new UserRaceUnit("blackAfroAmeri", "Black or African American", "A person having origins in any of the black racial groups of Africa."));
			add(new UserRaceUnit("hispanLat", "Hispanic or Latino", "A person of Cuban, Mexican, Puerto Rican, South or Central American, or other Spanish "
					+ "culture or origin, regardless of race."));
			add(new UserRaceUnit("natiHawPacIsl", "Native Hawaiian or Other Pacific Islander", "A person having origins in any of the original peoples "
					+ "of Hawaii, Guam, Samoa, or other Pacific Islands."));
			add(new UserRaceUnit("white", "White", "A person having origins in any of the original peoples of Europe, the Middle East, or North Africa."));
		}
	};
}
