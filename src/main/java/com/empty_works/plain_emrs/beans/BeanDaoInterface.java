package com.empty_works.plain_emrs.beans;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public interface BeanDaoInterface {

	String getQuery();
	String getErrorMessage();
	int prepareStatments(PreparedStatement preparedStatement) throws SQLException;
}