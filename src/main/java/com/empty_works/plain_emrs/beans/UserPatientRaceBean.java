package com.empty_works.plain_emrs.beans;

import java.util.ArrayList;
import java.util.List;

public class UserPatientRaceBean {

	private String userId;
	private List<String> races = new ArrayList<>();

	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public List<String> getRaces() {
		return races;
	}
	public void addRaces(List<String> races) {
		this.races = races;
	}
	public void addRace(String race) {
		races.add(race);
	}
}
