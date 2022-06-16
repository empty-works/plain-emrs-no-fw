package com.empty_works.plain_emrs.util.helpers;

import java.util.ArrayList;
import java.util.List;

public class SelectQueryResult {

	private List<QueryField> fieldList = new ArrayList<>();
	private String fullQueryString;

	public List<QueryField> getFieldList() {
		return fieldList;
	}
	public void setFieldList(List<QueryField> fieldList) {
		this.fieldList = fieldList;
	}
	public String getFullQueryString() {
		return fullQueryString;
	}
	public void setFullQueryString(String fullQueryString) {
		this.fullQueryString = fullQueryString;
	}
}
