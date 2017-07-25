//Can customer do everything it needs to yet?
/*
 * Apply for accounts
 * view account balance
 * withdraw and deposit
 * 
 * */
package com.jntm.banking.users;

import java.io.Serializable;

import org.apache.log4j.Logger;

import com.jntm.banking.tools.Account;
import com.jntm.banking.tools.Application;

public class Customer extends User implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String assignedEmployeeID;
	private static Logger log = Logger.getRootLogger();

	public Customer(String firstName, String lastName, String username, String password, String empID) {
		super(firstName, lastName, username, password, User.getUserCount() + 100 + "", "Customer");
		this.assignedEmployeeID = empID;
		log.trace("Customer created." + firstName + " " + lastName + " " + (100 + User.getUserCount()));
		User.setUserCount(User.getUserCount() + 1);
	}

	public void applyForAccount() {

		Application app = new Application(this.getUserID(), this.getAssignedEmployeeID());
		Application.addtoAppList(app);
		log.trace("Application " + app.getAppID() + " created.");
	}

	public String getAssignedEmployeeID() {
		log.trace("Method: Customer.getAssignedEmployeeID");
		return assignedEmployeeID;
	}

	public void setAssignedEmployeeID(String assignedEmployeeID) {
		log.trace("Method: Customer.setAssignedEmployeeID: " + assignedEmployeeID);
		this.assignedEmployeeID = assignedEmployeeID;
	}

	public String toString() {
		return this.getfName() + " " + this.getlName() + " uID: " + this.getUserID() + " eID: "
				+ this.getAssignedEmployeeID();
	}

	public void CheckAccount() {
		log.trace("Method: Customer.checkAccount");
		// Returns string summaries of all accounts associated with a customer.
		System.out.println("ownerid:" + this.getUserID());
		for (Account acc : Account.accList) {
			if (acc.getOwnerID().equals(this.getUserID())) {
				System.out.println(acc.toString());
			}
		}

	}

	public void withdrawAccount(String accID, double sum) {
		// This method allows a customer to withdraw from an account given
		// they have the account ID and a given sum
		// You can't overdraw though.
		for (Account acc : Account.accList) {

			if (acc.getUniqueID().equals(accID)) {
				System.out.println("id's match");
				if (Double.parseDouble(acc.getBalance()) >= sum && sum >= 0.0
						&& Double.parseDouble(acc.getBalance()) > 0.0) {
					acc.withdrawMoney(sum);
					log.trace("Successful Withdrawal. " + this.getUserID());
					log.trace("Method: Customer.withdrawAccount: " + accID + " " + sum);
					System.out.println("You have withdrawn $" + sum + " from Account #" + accID + ".");
					System.out.println("You have $" + acc.getBalance() + " remaining");
				} else {
					System.out.println("Your balance is $" + acc.getBalance() + ". You can't withdraw $" + sum + ".");
				}
			}
		}

	}

	public void depositAccount(String accID, double sum) {
		// allows customer to deposit sum into an account given an id and sum.
		for (Account acc : Account.accList) {
			if (acc.getUniqueID().equals(accID)) {
				if (sum >= 0.0) {
					acc.depositMoney(sum);
					log.trace("Successful Deposit. " + this.getUserID());
					log.trace("Method: Customer.depositAccount" + accID + " " + sum);
					System.out.println("You have deposited $" + sum + " into Account #" + accID);
					System.out.println("You now have $" + acc.getBalance() + ".");
				} else {
					System.out.println("Your balance is $" + acc.getBalance() + ". You can't deposit $" + sum + ".");
				}
			}
		}

	}

}
