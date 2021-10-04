package com.empty_works.plain_emrs.util;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

public class UsernameUtilTest {

	@Test
	public void testGetNameId_fourOrMoreChars() {
		
		String nameId = UsernameUtil.getNameId("Martha", "Rodriguez");
		Assertions.assertEquals("martrodr", nameId);
	}
	
	@Test
	public void testGetNameId_givenNameThreeChars() {
		
		String nameId = UsernameUtil.getNameId("Les", "Siddhartha");
		Assertions.assertEquals(8, nameId.length());
	}
	
	@Test
	public void testGetNameId_givenNameTwoChars() {
		
		String nameId = UsernameUtil.getNameId("Pi", "Lomelia");
		Assertions.assertEquals(8, nameId.length());
	}
	
	@Test
	public void testGetNameId_givenNameOneChar() {
		
		String nameId = UsernameUtil.getNameId("Q", "Shoemaker");
		Assertions.assertEquals(8, nameId.length());
	}
	
	//TODO Create tests for last name and random sequence
}
