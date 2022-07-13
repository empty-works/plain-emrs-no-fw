package user_choices;

public class UserRaceUnit {

	private String raceId;
	private String raceName;
	private String raceDescription;
	
	public UserRaceUnit(String raceId, String raceName, String raceDescription) {
		
		this.raceId = raceId;
		this.raceName = raceName;
		this.raceDescription = raceDescription;
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
