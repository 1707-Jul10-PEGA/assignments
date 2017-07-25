package com.jntm.banking.users;

import java.io.Serializable;
import java.util.Scanner;

import org.apache.log4j.Logger;

import com.jntm.banking.driver.Driver;
import com.jntm.banking.tools.Account;
import com.jntm.banking.tools.Application;

public class Admin extends User implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private static Logger log = Logger.getRootLogger();

	public Admin(String firstName, String lastName, String username, String password) {
		super(firstName, lastName, username, password, 100 + User.getUserCount() + "", "Admin");
		log.trace("New admin created." + firstName + " " + lastName + " " + User.getUserCount());
		User.setUserCount(User.getUserCount() + 1);
	}

	public void setBalance(String accID, double sum) {
		log.trace("Method: Admin.setBalance " + accID + " " + sum);
		for (Account acc : Account.accList) {
			if (acc.getUniqueID().equals(accID)) {
				log.trace("Account" + accID + " Altered");
				System.out.println("The account was altered.");
				acc.setBalance(sum);
			}
		}
	}

	public void reviewApplications() {
		log.trace("Method: Admin.reviewApplications ");
		Scanner scan = new Scanner(System.in);

		for (Application app : Application.appList) {

			String ans = "";

			while (!ans.equalsIgnoreCase("Y") && !ans.equalsIgnoreCase("N")) {
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
				log.trace("Application " + app.getAppID() + " approved.");
				System.out.println("Account Denied!");

			} else {
				System.out.println("It needs to be Y or N");
			}

		}

		Application.appList.clear();

	}

	public void viewAccounts(Customer c) {
		log.trace("Method: Admin.viewAccounts " + c.toString());
		System.out.println("Customer " + c.toString() + " has the following accounts: ");
		for (Account acc : Account.accList) {
			if (c.getUserID().equals(acc.getOwnerID())) {
				System.out.println(acc.toString());
			}
		}

	}

	public String toString() {
		return this.getfName() + " " + this.getlName() + " " + this.getUserID();
	}

}
