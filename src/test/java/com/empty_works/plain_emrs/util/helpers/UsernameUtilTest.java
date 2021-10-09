package com.empty_works.plain_emrs.util.helpers;

import org.junit.jupiter.api.Test;

import com.empty_works.plain_emrs.util.helpers.UsernameUtil;

import org.junit.jupiter.api.Assertions;

public class UsernameUtilTest {

	@Test
	public void testGetNameId_fourOrMoreChars() {
		
		String nameId = UsernameUtil.getName("Martha", "Rodriguez");
		Assertions.assertEquals("martrodr", nameId);
	}
	
	@Test
	public void testGetNameId_givenNameThreeChars() {
		
		String nameId = UsernameUtil.getName("Les", "Siddhartha");
		Assertions.assertEquals(8, nameId.length());
	}
	
	@Test
	public void testGetNameId_givenNameTwoChars() {
		
		String nameId = UsernameUtil.getName("Pi", "Lomelia");
		Assertions.assertEquals(8, nameId.length());
	}
	
	@Test
	public void testGetNameId_givenNameOneChar() {
		
		String nameId = UsernameUtil.getName("Q", "Shoemaker");
		Assertions.assertEquals(8, nameId.length());
	}
	
	//TODO Create tests for last name and random sequence
}
