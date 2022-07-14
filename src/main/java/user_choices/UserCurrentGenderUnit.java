package user_choices;

public class UserCurrentGenderUnit {

	private String currentGenderId;
	private String currentGender;
	
	public UserCurrentGenderUnit(String currentGenderId, String currentGender) {
		
		this.currentGenderId = currentGenderId;
		this.currentGender = currentGender;
	}

	public String getCurrentGenderId() {
		return currentGenderId;
	}
	public String getCurrentGender() {
		return currentGender;
	}
}
