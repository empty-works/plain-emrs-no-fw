package com.empty_works.plain_emrs.user_choices;

public class UserRelationshipStatusUnit {

	private String relationshipStatusId;
	private String relationshipStatus;
	
	public UserRelationshipStatusUnit(String relationshipStatusId, String relationshipStatus) {
		
		this.relationshipStatusId = relationshipStatusId;
		this.relationshipStatus = relationshipStatus;
	}
	
	public String getRelationshipStatusId() {
		return relationshipStatusId;
	}
	public String getRelationshipStatus() {
		return relationshipStatus;
	}
}
