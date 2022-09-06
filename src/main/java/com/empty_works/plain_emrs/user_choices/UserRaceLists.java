package com.empty_works.plain_emrs.user_choices;

import java.util.ArrayList;
import java.util.List;

/*
 * Descriptions of races taken from the Office of Diversity, Inclusion and Civil Rights of 
 * U.S. Department of the Interior
 * */

public class UserRaceLists {
	
	public static String amInAlNa = "ameriIndAlasNat";
	public static String asian = "asian";
	public static String blAfAm = "blackAfroAmeri";
	public static String hiLa = "hispanLat";
	public static String naHaPaIs = "natiHawPacIsl";
	public static String white = "white";

	final public static List<UserRaceUnit> raceList = new ArrayList<>() {
		/**
		 * 
		 */
		private static final long serialVersionUID = -6214395715920744505L;

		{
			add(new UserRaceUnit(amInAlNa, "American Indian or Alaska Native", "A person having origins in any of the original "
					+ "peoples of North and South America (including Central America), and who maintains tribal affiliation or community attachment."));
			add(new UserRaceUnit(asian, "Asian", "A person having origins in any of the original peoples of the Far East, Southeast "
					+ "Asia, or the Indian subcontinent including, for example, Cambodia, China, India, Japan, "
					+ "Korea, Malaysia, Pakistan, the Philippine Islands, Thailand, and Vietnam."));
			add(new UserRaceUnit(blAfAm, "Black or African American", "A person having origins in any of the black racial groups of Africa."));
			add(new UserRaceUnit(hiLa, "Hispanic or Latino", "A person of Cuban, Mexican, Puerto Rican, South or Central American, or other Spanish "
					+ "culture or origin, regardless of race."));
			add(new UserRaceUnit(naHaPaIs, "Native Hawaiian or Other Pacific Islander", "A person having origins in any of the original peoples "
					+ "of Hawaii, Guam, Samoa, or other Pacific Islands."));
			add(new UserRaceUnit(white, "White", "A person having origins in any of the original peoples of Europe, the Middle East, or North Africa."));
		}
	};
	
	final public static List<UserRaceUnit> hispanicLatinList = new ArrayList<>() {
		
		/**
		 * 
		 */
		private static final long serialVersionUID = -2226743304012359142L;

		{
			add(new UserRaceUnit("latinMex", "Mexican"));
			add(new UserRaceUnit("latinMexAmeri", "Mexican American"));
			add(new UserRaceUnit("latinChican", "Chicano/a"));
			add(new UserRaceUnit("latinPuerRic", "Puerto Rican"));
			add(new UserRaceUnit("latinCuba", "Cuban"));
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
	
	final public static List<UserRaceUnit> asianEthnicityList = new ArrayList<>() {
		/**
		 * 
		 */
		private static final long serialVersionUID = -300245558993893663L;

		{
			add(new UserRaceUnit("asianBangla", "Bangladeshi"));
			add(new UserRaceUnit("asianBhuta", "Bhutanese"));
			add(new UserRaceUnit("asianBurm", "Burmese"));
			add(new UserRaceUnit("asianCambo", "Cambodian"));
			add(new UserRaceUnit("asianTaiw", "Taiwanese"));
			add(new UserRaceUnit("asianHmong", "Hmong"));
			add(new UserRaceUnit("asianIndon", "Indonesian"));
			add(new UserRaceUnit("asianLoat", "Loation"));
			add(new UserRaceUnit("asianMalay", "Malaysian"));
			add(new UserRaceUnit("asianOkina", "Okinawan"));
			add(new UserRaceUnit("asianPakist", "Pakistani"));
			add(new UserRaceUnit("asianSriLan", "Sri Lankan"));
			add(new UserRaceUnit("asianThai", "Thai"));
			add(new UserRaceUnit("asianIwoJim", "Iwo Jiman"));
			add(new UserRaceUnit("asianMaldiv", "Maldivian"));
			add(new UserRaceUnit("asianNepal", "Nepalese"));
			add(new UserRaceUnit("asianSingap", "Singaporean"));
			add(new UserRaceUnit("asianMadag", "Madagascar"));
		}
	};
	
	final public static List<UserRaceUnit> pacificIslanderEthnicityList = new ArrayList<>() {
		/**
		 * 
		 */
		private static final long serialVersionUID = -1908913311631911647L;

		{
			add(new UserRaceUnit("pacIslPolyn", "Polynesian"));
			add(new UserRaceUnit("pacIslTahit", "Tahitian"));
			add(new UserRaceUnit("pacIslTongan", "Tongan"));
			add(new UserRaceUnit("pacIslTokel", "Tokelauan"));
			add(new UserRaceUnit("pacIslGuama", "Guamanian"));
			add(new UserRaceUnit("pacIslMicron", "Micronesian"));
			add(new UserRaceUnit("pacIslMarIsl", "Mariana Islander"));
			add(new UserRaceUnit("pacIslSaipan", "Saipanese"));
			add(new UserRaceUnit("pacIslPalau", "Palauan"));
			add(new UserRaceUnit("pacIslKosra", "Kosraean"));
			add(new UserRaceUnit("pacIslKirib", "Kiribati"));
			add(new UserRaceUnit("pacIslPohnpe", "Pohnpeian"));
			add(new UserRaceUnit("pacIslChuuk", "Chuukese"));
			add(new UserRaceUnit("pacIslYape", "Yapese"));
			add(new UserRaceUnit("pacIslMarchal", "Marchallese"));
			add(new UserRaceUnit("pacIslKriba", "KribatI"));
			add(new UserRaceUnit("pacIslOtherMicro", "Other Micronesian"));
			add(new UserRaceUnit("pacIslMelan", "Melanesian"));
			add(new UserRaceUnit("pacIslFiji", "Fijian"));
			add(new UserRaceUnit("pacIslPapNewGui", "Papua New Guinean"));
			add(new UserRaceUnit("pacIslSoloIsl", "Solomon Islander"));
			add(new UserRaceUnit("pacIslNewHebri", "New Hebrides"));
			add(new UserRaceUnit("pacIslOtherPacIsl", "Other Pacific Islander"));
		}
	};
}
