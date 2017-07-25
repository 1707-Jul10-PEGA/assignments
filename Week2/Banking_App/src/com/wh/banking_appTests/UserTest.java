package com.wh.banking_appTests;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;

import com.wh.banking_app.User;

public class UserTest {
    	static User user0,user1;

    @BeforeClass
    public static void setup() {
	user0 = new User();
	user1 = new User("Name", 1234);
    }

    @Test
    public void nameTest() {
	user0.setName("Billy");
	assertEquals(user0.getName(), "Billy");
	assertEquals(user1.getName(), "Name");
    }
    
    @Test
    public void IDTest() {
	user0.setPassword(3241);
	assertEquals(user0.getPassword(), 3241);
	assertEquals(user1.getPassword(), 1234);
    }

}
