package com.bank.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import com.bank.util.UserInput;


public class UserInputTest {
	
	static UserInput ui;
	
	@BeforeClass
	public static void setUpBeforeClass(){
		ui = new UserInput();
	}
	@Test
	public void testInputAge(){
		
		assertFalse("Check negative age returns false", ui.inputAge(-1));
	}
	@Test
	public void testInputName(){
		assertFalse("Check empty string returns false", ui.inputName(""));
	}
	@Test
	public void testShoe(){
		assertEquals(true, ui.inputShoes("Nike"));
		assertFalse("Testing knock-off shoes are flse", ui.inputShoes("Under Armour"));
		assertTrue("Testing adidas return true", ui.inputShoes("adidas"));
	}
	@AfterClass
	public static void cleanUpAFterClass(){
		ui = null;
	}
}
