package user_choices;

public class SexualOrientationUnit {

	private String sexualOrientationId;
	private String sexualOrientation;
	
	public SexualOrientationUnit(String sexualOrientationId, String sexualOrientation) {
		
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
