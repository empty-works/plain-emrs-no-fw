package user_choices;

public class UserSexualOrientationUnit {

	private String sexualOrientationId;
	private String sexualOrientation;
	
	public UserSexualOrientationUnit(String sexualOrientationId, String sexualOrientation) {
		
		this.sexualOrientationId = sexualOrientationId;
		this.sexualOrientation = sexualOrientation;
	}
	
	public String getSexualOrientationId() {
		return sexualOrientationId;
	}
	public String getSexualOrientation() {
		return sexualOrientation;
	}
}
