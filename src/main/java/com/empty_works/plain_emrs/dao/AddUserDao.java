package com.empty_works.plain_emrs.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.empty_works.plain_emrs.beans.BeanDaoInterface;
import com.empty_works.plain_emrs.beans.MedicalRecordBean;
import com.empty_works.plain_emrs.beans.UserPatientBean;
import com.empty_works.plain_emrs.beans.SurgicalProblemsBean;
import com.empty_works.plain_emrs.beans.UserActivityLogBean;
import com.empty_works.plain_emrs.beans.UserBean;
import com.empty_works.plain_emrs.beans.UserLoginLogBean;
import com.empty_works.plain_emrs.util.ConnectionUtil;

public class AddUserDao {

	final public static String USERDAO_SUCCESS = "User successfully added!";
	private List<BeanDaoInterface> beans = new ArrayList<>();
	
	/**
	 * 
	 * @param bean
	 */
	public void add(BeanDaoInterface bean) {
		beans.add(bean);
	}
	
	/**
	 * 
	 * @return
	 */
	public String executeQueries() {
		
		boolean exceptionThrown = false;
		String thrownResult = "";

		try (Connection con = ConnectionUtil.getConnection()) {

			for(BeanDaoInterface bean : beans) {
				
				try(PreparedStatement preparedStatement = con.prepareStatement(bean.getWriteQuery())) {
					
					bean.prepareStatments(preparedStatement);
				}
				catch (SQLException e) {
					
					exceptionThrown = true;
					thrownResult = bean.getErrorMessage() + " " + e;
				}
			}
		}
		catch (SQLException e) {
			
			exceptionThrown = true;
			thrownResult = "Connection failed in user DAO. " + e;
		}
		if(exceptionThrown) {
			
			return thrownResult;
		}
		return USERDAO_SUCCESS;
	}
}
