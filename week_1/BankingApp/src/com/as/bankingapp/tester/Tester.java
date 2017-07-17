package com.as.bankingapp.tester;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import com.as.bankingapp.accounttester.AccountTester;
import com.as.bankingapp.employeetester.EmployeeTester;
import com.as.bankingapp.filemanagertester.FileManagerTester;
import com.as.bankingapp.inputcheckertester.InputCheckerTester;
import com.as.bankingapp.logintester.LoginTester;

@RunWith(Suite.class)
@SuiteClasses({AccountTester.class, EmployeeTester.class, FileManagerTester.class, InputCheckerTester.class, LoginTester.class})
public class Tester {

}
