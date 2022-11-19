package com.empty_works.plain_emrs.user_choices;

import java.util.ArrayList;
import java.util.List;

public class UserMaritalStatusLists {

	final public static List<UserMaritalStatusUnit> maritalStatusList = new ArrayList<>() {
		/**
		 * 
		 */
		private static final long serialVersionUID = -8020002724918366344L;

		{
			add(new UserMaritalStatusUnit("relStatusSingle","Single"));
			add(new UserMaritalStatusUnit("relStatusMarried","Married"));
			add(new UserMaritalStatusUnit("relStatusPartner","Partnered"));
			add(new UserMaritalStatusUnit("relStatusSeparate","Separated"));
			add(new UserMaritalStatusUnit("relStatusDivor","Divorced"));
			add(new UserMaritalStatusUnit("relStatusWido","Widowed"));
			add(new UserMaritalStatusUnit("relStatusNotDisclosed","Not disclosed"));
		}
	};
}
