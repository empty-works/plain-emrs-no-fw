package com.empty_works.plain_emrs.beans;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public interface BeanDaoInterface {

	String getWriteQuery();
	String getWriteErrorMessage();
	int prepareWriteStatement(PreparedStatement preparedStatement) throws SQLException;
}