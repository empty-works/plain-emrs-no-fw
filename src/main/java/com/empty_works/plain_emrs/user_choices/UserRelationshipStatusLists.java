package com.empty_works.plain_emrs.user_choices;

import java.util.ArrayList;
import java.util.List;

public class UserRelationshipStatusLists {

	final public static List<UserRelationshipStatusUnit> relationshipStatusList = new ArrayList<>() {
		/**
		 * 
		 */
		private static final long serialVersionUID = -8020002724918366344L;

		{
			add(new UserRelationshipStatusUnit("relStatusSingle","Single"));
			add(new UserRelationshipStatusUnit("relStatusMarried","Married"));
			add(new UserRelationshipStatusUnit("relStatusPartner","Partnered"));
			add(new UserRelationshipStatusUnit("relStatusSeparate","Separated"));
			add(new UserRelationshipStatusUnit("relStatusDivor","Divorced"));
			add(new UserRelationshipStatusUnit("relStatusWido","Widowed"));
		}
	};
}
