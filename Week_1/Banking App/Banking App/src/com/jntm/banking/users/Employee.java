package com.jntm.banking.users;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Scanner;

import org.apache.log4j.Logger;

import com.jntm.banking.tools.Account;
import com.jntm.banking.tools.Application;

public class Employee extends User implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static Logger log = Logger.getRootLogger();

	public Employee(String firstName, String lastName, String username, String password) {
		super(firstName, lastName, username, password, 100 + User.getUserCount() + "", "Employee");
		User.setUserCount(User.getUserCount() + 1);
		log.trace("Employee created" + firstName + " " + lastName + " " + User.getUserCount());
	}

	public void reviewApplications() {
		log.trace("Applications being reviewed.");
		Scanner scan = new Scanner(System.in);
		boolean flag = false;
		for (Application app : Application.appList) {
			if (app.getEmpID().equals(this.getUserID())) {
				String ans = "";

				while (!ans.equalsIgnoreCase("Y") && !ans.equalsIgnoreCase("N")) {
					flag = true;
					System.out.println("Will you approve this application? (Y/N)");
					System.out.println(app.toString());
					ans = scan.nextLine();

				}

				if (ans.equalsIgnoreCase("Y")) {
					log.trace("Application " + app.getAppID() + " approved.");
					System.out.println("Application Approved!");
					Account acc = new Account(app.getUserID());
					Account.accList.add(acc);

				} else if (ans.equalsIgnoreCase("N")) {
					log.trace("Application " + app.getAppID() + " denied.");
					System.out.println("Account Denied!");

				} else {
					System.out.println("It needs to be Y or N");
				}

			}
		}

		if (flag) {
			Application.appList.clear();
		}
	}

	public void viewAccounts(Customer c) {
		log.trace("Method: Employee.viewAccounts " + c.toString());
		if (c.getAssignedEmployeeID().equals(this.getUserID())) {
			System.out.println(
					c.getfName() + " " + c.getlName() + "(" + c.getUserID() + ") has the following accounts: ");
			for (Account acc : Account.accList) {
				if (c.getUserID().equals(acc.getOwnerID())) {
					System.out.println(acc.toString());
				}
			}
		}
	}

	public String toString() {
		return this.getfName() + " " + this.getlName() + " " + this.getUserID();
	}

}
