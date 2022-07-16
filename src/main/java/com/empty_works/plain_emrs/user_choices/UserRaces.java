package com.empty_works.plain_emrs.user_choices;

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
	
	final public static List<UserRaceUnit> latinEthnicityList = new ArrayList<>() {
	
		{
			add(new UserRaceUnit("latinSpani", "Spaniard"));
			add(new UserRaceUnit("latinAndul", "Andalusian"));
			add(new UserRaceUnit("latinAstur", "Asturian"));
			add(new UserRaceUnit("latinCastil", "Castillian"));
			add(new UserRaceUnit("latinCatal", "Catalonian"));
			add(new UserRaceUnit("latinBelea", "Belearic Islander"));
			add(new UserRaceUnit("latinGalle", "Gallego"));
			add(new UserRaceUnit("latinValenc", "Valencian"));
			add(new UserRaceUnit("latinCanar", "Canarian"));
			add(new UserRaceUnit("latinSpanBas", "Spanish Basque"));
			add(new UserRaceUnit("latinLaRaz", "La Raza"));
			add(new UserRaceUnit("latinMexAmeInd", "Mexican American Indian"));
			add(new UserRaceUnit("latinCentAmer", "Central American"));
			add(new UserRaceUnit("latinCostRic", "Costa Rican"));
			add(new UserRaceUnit("latinGuate", "Guatemalan"));
			add(new UserRaceUnit("latinHondur", "Honduran"));
			add(new UserRaceUnit("latinNicarag", "Nicaraguan"));
			add(new UserRaceUnit("latinPanam", "Panamanian"));
			add(new UserRaceUnit("latinSalva", "Salvadoran"));
			add(new UserRaceUnit("latinCenAmeInd", "Central American Indian"));
			add(new UserRaceUnit("latinCanZon", "Canal Zone"));
			add(new UserRaceUnit("latinSouAme", "South American"));
			add(new UserRaceUnit("latinArgine", "Argentinean"));
			add(new UserRaceUnit("latinBoliv", "Bolivian"));
			add(new UserRaceUnit("latinChile", "Chilean"));
			add(new UserRaceUnit("latinColom", "Colombian"));
			add(new UserRaceUnit("latinEcuad", "Ecuadorian"));
			add(new UserRaceUnit("latinParagu", "Paraguayan"));
			add(new UserRaceUnit("latinPeruv", "Peruvian"));
			add(new UserRaceUnit("latinUrugu", "Uruguayan"));
			add(new UserRaceUnit("latinVenezu", "Venezuelan"));
			add(new UserRaceUnit("latinSouAmeInd", "South American Indian"));
			add(new UserRaceUnit("latinCrill", "Criollo"));
			add(new UserRaceUnit("latinLatAme", "Latin American"));
			add(new UserRaceUnit("latinDomini", "Dominican"));
		}
	};
}
