package com.wh.banking_appTests;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ AdminTest.class, ApplicationTest.class, CheckingAccountTest.class, CustomerTest.class,
	EmployeeTest.class, ListManagerTest.class, UserFactoryTest.class, UserTest.class })
public class AllTests {

}
