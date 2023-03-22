package com.empty_works.plain_emrs.beans;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import com.empty_works.plain_emrs.patient_choices.MedicalRecordFamilyIllnessUnit;
import com.empty_works.plain_emrs.patient_choices.PatientIllnessUnit;

/*
 * Difference between disease and illness:
 * A disease has a specific result on a body part or function. Illness can be a perceived notion of unwellness or derive from self-diagnosis.
 */
public class MedicalRecordIllnessesBean implements MedicalRecordInterface, BeanDaoInterface {

	private int illnessId;
	private String medicalRecordId;
	private String illness;
	private List<MedicalRecordFamilyIllnessUnit> illnesses;
	private boolean illnessSelf;
	private boolean illnessFather;
	private boolean illnessMother;
	private boolean illnessBrothers;
	private boolean illnessSisters;
	private boolean illnessSons;
	private boolean illnessDaughters;
	private boolean illnessGrandparents;

	public int getIllnessId() {
		return illnessId;
	}

	public void setIllnessId(int illnessId) {
		this.illnessId = illnessId;
	}
	
	public void setIllness(String illness) {
		this.illness = illness;
	}
	
	public List<MedicalRecordFamilyIllnessUnit> getIllnesses() {
		return illnesses;
	}

	public void setIllnesses(List<MedicalRecordFamilyIllnessUnit> illnesses) {
		this.illnesses = illnesses;
	}

	@Override
	public String getMedicalRecordId() {
		return medicalRecordId;
	}

	@Override
	public void setMedicalRecordId(String medicalRecordId) {
		this.medicalRecordId = medicalRecordId;
	}

	public List<MedicalRecordFamilyIllnessUnit> getIllness() {
		return illnesses;
	}

	public void setIllness(List<MedicalRecordFamilyIllnessUnit> illnesses) {
		this.illnesses = illnesses;
	}

	public boolean isIllnessSelf() {
		return illnessSelf;
	}

	public void setIllnessSelf(boolean illnessSelf) {
		this.illnessSelf = illnessSelf;
	}

	public boolean isIllnessFather() {
		return illnessFather;
	}

	public void setIllnessFather(boolean illnessFather) {
		this.illnessFather = illnessFather;
	}

	public boolean isIllnessMother() {
		return illnessMother;
	}

	public void setIllnessMother(boolean illnessMother) {
		this.illnessMother = illnessMother;
	}

	public boolean isIllnessBrothers() {
		return illnessBrothers;
	}

	public void setIllnessBrothers(boolean illnessBrothers) {
		this.illnessBrothers = illnessBrothers;
	}

	public boolean isIllnessSisters() {
		return illnessSisters;
	}

	public void setIllnessSisters(boolean illnessSisters) {
		this.illnessSisters = illnessSisters;
	}

	public boolean isIllnessSons() {
		return illnessSons;
	}

	public void setIllnessSons(boolean illnessSons) {
		this.illnessSons = illnessSons;
	}

	public boolean isIllnessDaughters() {
		return illnessDaughters;
	}

	public void setIllnessDaughters(boolean illnessDaughters) {
		this.illnessDaughters = illnessDaughters;
	}

	public boolean isIllnessGrandparents() {
		return illnessGrandparents;
	}

	public void setIllnessGrandparents(boolean illnessGrandparents) {
		this.illnessGrandparents = illnessGrandparents;
	}

	@Override
	public String getWriteQuery() {
		return "INSERT INTO illnesses(medical_record_id, illness, self, father, mother, brothers, sisters, "
				+ "sons, daughters, grandparents) values (?,?,?,?,?,?,?,?,?,?)";
	}

	@Override
	public String getWriteErrorMessage() {
		return "Could not add illnesses data to the database!";
	}

	@Override
	public int prepareWriteStatement(PreparedStatement preparedStatement) throws SQLException {
		
		if(illnesses != null && illnesses.size() > 0) {
			for(int i = 0; i < illnesses.size(); i++) {
				preparedStatement.setString(1, medicalRecordId);
				preparedStatement.setString(2, illnesses.get(i).getFamilyIllness());
				addRelations(illnesses.get(i), preparedStatement);
				preparedStatement.addBatch();
			}
			return preparedStatement.executeBatch()[0];
		}
		return 0;
	}

	/**
	 * 
	 * @param illness
	 * @param preparedStatement
	 */
	private static void addRelations(MedicalRecordFamilyIllnessUnit illness, PreparedStatement preparedStatement) {
		
		int prepStatementNum = 3; // Prepared statement starts at 3.
		for(int i = 0; i < illness.getFamilyRelations().size(); i++) {
			try {
				preparedStatement.setBoolean(prepStatementNum, illness.getFamilyRelations().get(i));
				prepStatementNum++;
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
