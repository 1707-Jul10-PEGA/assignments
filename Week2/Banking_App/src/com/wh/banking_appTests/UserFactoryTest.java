package com.wh.banking_appTests;

import static org.junit.Assert.*;

import java.sql.SQLException;

import org.junit.BeforeClass;
import org.junit.Test;

import com.wh.banking_app.Admin;
import com.wh.banking_app.Customer;
import com.wh.banking_app.Employee;
import com.wh.banking_app.UserFactory;

public class UserFactoryTest {

    static UserFactory factory;

    @BeforeClass
    public static void setup() {
	factory = new UserFactory();
    }

    @Test
    public void createEmployeeTest() {
	Employee e1;
	try {
	    e1 = UserFactory.createEmployee("Edward", 123412);

	    assertEquals(e1.getName(), "Edward");
	    assertEquals(e1.getPassword(), 123412, 0);
	    assertTrue(e1.getClass() == Employee.class);
	} catch (SQLException e) {
	    // TODO Auto-generated catch block
	    e.printStackTrace();
	}
    }

    @Test
    public void createAdminTest() throws SQLException {
	Admin a1 = UserFactory.createAdmin("Foobar", 321942);
	assertEquals(a1.getName(), "Foobar");
	assertEquals(a1.getPassword(), 321942, 0);
	assertTrue(a1.getClass() == Admin.class);
    }

    @Test
    public void createCustomerTest() throws SQLException {
	Customer c1 = UserFactory.createCustomer("Billy", 23141);
	assertEquals(c1.getName(), "Billy");
	assertEquals(c1.getPassword(), 23141, 0);
	assertTrue(c1.getClass() == Customer.class);

    }

}
