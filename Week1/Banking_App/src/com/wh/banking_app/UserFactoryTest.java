package com.wh.banking_app;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;

public class UserFactoryTest {

    static UserFactory factory;
    
    @BeforeClass
    public static void setup() {
	factory = new UserFactory();
    }
    
    @Test
    public void createEmployeeTest() {
	Employee e1 = UserFactory.createEmployee("Edward", 123412);
	assertEquals(e1.getName(), "Edward");
	assertEquals(e1.getID(), 123412, 0);
	assertTrue(e1.getClass() == Employee.class);
    }
    
    @Test
    public void createAdminTest() {
	Admin a1 = UserFactory.createAdmin("Foobar", 321942);
	assertEquals(a1.getName(), "Foobar");
	assertEquals(a1.getID(), 321942, 0);
	assertTrue(a1.getClass() == Admin.class);
    }
    
    @Test
    public void createCustomerTest() {
	Customer c1 = UserFactory.createCustomer("Billy", 23141);
	assertEquals(c1.getName(), "Billy");
	assertEquals(c1.getID(), 23141, 0);
	assertTrue(c1.getClass() == Customer.class);
	
    }

}
