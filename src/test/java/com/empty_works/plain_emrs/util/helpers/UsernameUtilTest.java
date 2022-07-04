package com.empty_works.plain_emrs.util.helpers;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

public class UsernameUtilTest {

	@Test
	public void testGetNameId_fourOrMoreChars() {
		
		String nameId = PersonUtil.getName("Martha", "Rodriguez");
		Assertions.assertEquals("martrodr", nameId);
	}
	
	@Test
	public void testGetNameId_givenNameThreeChars() {
		
		String nameId = PersonUtil.getName("Les", "Siddhartha");
		Assertions.assertEquals(8, nameId.length());
	}
	
	@Test
	public void testGetNameId_givenNameTwoChars() {
		
		String nameId = PersonUtil.getName("Pi", "Lomelia");
		Assertions.assertEquals(8, nameId.length());
	}
	
	@Test
	public void testGetNameId_givenNameOneChar() {
		
		String nameId = PersonUtil.getName("Q", "Shoemaker");
		Assertions.assertEquals(8, nameId.length());
	}
	
	//TODO Create tests for last name and random sequence
}
