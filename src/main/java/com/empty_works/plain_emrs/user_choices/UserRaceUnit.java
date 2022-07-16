package com.empty_works.plain_emrs.user_choices;

public class UserRaceUnit {

	private String raceId;
	private String raceName;
	private String raceDescription;
	
	/**
	 * 
	 * @param raceId
	 * @param raceName
	 * @param raceDescription
	 */
	public UserRaceUnit(String raceId, String raceName, String raceDescription) {
		
		this.raceId = raceId;
		this.raceName = raceName;
		this.raceDescription = raceDescription;
	}
	
	/**
	 * 
	 * @param raceId
	 * @param raceName
	 */
	public UserRaceUnit(String raceId, String raceName) {
		
		this.raceId = raceId;
		this.raceName = raceName;
	}

	public String getRaceId() {
		return raceId;
	}
	public String getRaceName() {
		return raceName;
	}
	public String getRaceDescription() {
		return raceDescription;
	}
}
