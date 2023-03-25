package com.empty_works.plain_emrs.beans;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserPatientRaceBean implements BeanDaoInterface {

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
	public void addRace(String race) {
		races.add(race);
	}
	@Override
	public String getWriteQuery() {
		return "INSERT INTO patient_races(user_id, patient_race) values(?,?)";
	}
	@Override
	public String getWriteErrorMessage() {
		return "Could not add races to patient race table!";
	}
	@Override
	public int prepareWriteStatement(PreparedStatement preparedStatement) throws SQLException {

		System.out.println("Adding patient race..." + getRaces());
		for(int i = 0; i < getRaces().size(); i++) {
			
			preparedStatement.setString(1, getUserId());
			preparedStatement.setString(2, getRaces().get(i));
			preparedStatement.addBatch();
		}
		return preparedStatement.executeBatch()[0];
	}
}
