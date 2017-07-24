package com.TS.banking.resources;

import org.junit.Assert;
import org.junit.Test;

/*
 * All JUnit Tests (All user input)
 */
public class UserInputTester {
	
	@Test
	public void intTest(){
		Assert.assertFalse("Check non integer returns false", UserInputTest.testIsInt("1Test"));
	}
	
	@Test
	public void whitespaceTest(){
		Assert.assertFalse("Check that any whitespace returns false", UserInputTest.testNoWhitespace("sdfsdf121 asdfadf"));
	}
}
