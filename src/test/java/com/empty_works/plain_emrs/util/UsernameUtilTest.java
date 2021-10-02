package com.empty_works.plain_emrs.util;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

public class UsernameUtilTest {

	@Test
	public void testGetNameId_fourOrMoreChars() {
		
		String nameId = UsernameUtil.getNameId("Martha", "Rodriguez");
		Assertions.assertEquals("martrodr", nameId);
	}
}

