package com.empty_works.plain_emrs.beans;

import java.time.LocalDateTime;

public class UserLoginLogBean {

	private String userId;
	private LocalDateTime userDateTimeOfVisit;

	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public LocalDateTime getUserDateTimeOfVisit() {
		return userDateTimeOfVisit;
	}
	public void setUserDateTimeOfVisit(LocalDateTime userDateTimeOfVisit) {
		this.userDateTimeOfVisit = userDateTimeOfVisit;
	}
}
