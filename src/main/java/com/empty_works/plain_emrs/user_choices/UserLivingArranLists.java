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
			add(new UserLivingArranUnit("userLivingAlone", "Alone"));
			add(new UserLivingArranUnit("userLivingSpousePartner", "Spouse/Partner(s)"));
			add(new UserLivingArranUnit("userLivingChildren", "Child(ren)"));
			add(new UserLivingArranUnit("userLivingSibling", "Sibling"));
			add(new UserLivingArranUnit("userLivingParentGuard", "Parent(s)/Guardian(s)"));
			add(new UserLivingArranUnit("userLivingGroup", "Group setting"));
			add(new UserLivingArranUnit("userLivingPersonalCare", "Personal care attendant"));
			add(new UserLivingArranUnit("userLivingOther", "Other"));
			add(new UserLivingArranUnit("userLivingNotDisclosed", "Not disclosed"));
		}
	};
}
