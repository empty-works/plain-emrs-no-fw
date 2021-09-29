package com.empty_works.plain_emrs.util;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Assertions;

public class PasswordUtilTest {

	@Test
	void testGetNameId_gnOver2lnOver2() {
		
		String nameId = NonPatientIdUtil.getNameId("Fatima", "Garcia");
		Assertions.assertEquals("05", "");
	}
	
}
