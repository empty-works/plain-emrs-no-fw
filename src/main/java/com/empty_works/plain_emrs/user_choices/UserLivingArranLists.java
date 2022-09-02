package com.empty_works.plain_emrs.user_choices;

import java.util.ArrayList;
import java.util.List;

public class UserLivingArranLists {

	final public static List<UserLivingArranUnit> livingList = new ArrayList<>() {
		
		/**
		 * 
		 */
		private static final long serialVersionUID = 1593118704632849613L;

		{
			add(new UserLivingArranUnit("alone", "Alone"));
			add(new UserLivingArranUnit("spousePartner", "Spouse/Partner(s)"));
			add(new UserLivingArranUnit("children", "Child(ren)"));
			add(new UserLivingArranUnit("sibling", "Sibling"));
			add(new UserLivingArranUnit("parentGuard", "Parent(s)/Guardian(s)"));
			add(new UserLivingArranUnit("group", "Group setting"));
			add(new UserLivingArranUnit("personalCare", "Personal care attendant"));
			add(new UserLivingArranUnit("other", "Other"));
		}
	};
}
