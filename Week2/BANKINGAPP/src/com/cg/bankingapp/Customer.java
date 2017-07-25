package com.cg.bankingapp;

import java.io.Serializable;
import java.util.ArrayList;

public class Customer extends User implements Serializable {

	// Variables
	private static final long serialVersionUID = 2118251608993389226L;
	private CheckingsAccount checkings;
	private SavingsAccount savings;
	private String managedby;
	private int customerLevel;

	// Constructor for existing user
	public Customer(int userid, String firstname, String lastname, String username, String password,
			ArrayList<Account> accounts, int status) {
		super(userid, firstname, lastname, username, password, "customer", status);
		
		for (Account i : accounts) {
			if ("checkings".equals(i.getAccountType())) {
				checkings = (CheckingsAccount) i;
				customerLevel++;
			} else if ("savings".equals(i.getAccountType())) {
				savings = (SavingsAccount) i;
				customerLevel++;
			}
		}
		if (accounts.size() == 2) {
			customerLevel++;
		}
	}

	// Constructor for new customer
	public Customer(String firstname, String lastname, String username, String password, ArrayList<Account> accounts,
			int status) {
		super(firstname, lastname, username, password, "customer", status);
		for (Account i : accounts) {
			if ("checkings".equals(i.getAccountType())) {
				checkings = (CheckingsAccount) i;
				customerLevel++;
			} else if ("savings".equals(i.getAccountType())) {
				savings = (SavingsAccount) i;
				customerLevel++;
			}
		}
		if (accounts.size() == 2) {
			customerLevel++;
		}
	}

	// Change password
	public void changePassword(String newPass) {
		this.setPassword(newPass);
	}

	// Transfer money between accounts
	public String transferMoney(Double money, String in, String out) {
		int flag;
		if (money > 0) {
			if ("checkings".equalsIgnoreCase(in) && "savings".equalsIgnoreCase(out)) {
				flag = checkings.withdraw(money);
				if (flag == 1) {
					flag = savings.deposit(money);
					return "Checkings New Balance: " + checkings.getBalance() + " Savings New Balance: "
							+ savings.getBalance();
				} else {
					return "The amount to transfer is higher than the available balance. Savings: "
							+ savings.getBalance();
				}

			} else if ("checkings".equalsIgnoreCase(out) && "savings".equalsIgnoreCase(in)) {
				flag = savings.withdraw(money);
				if (flag == 1) {
					flag = savings.deposit(money);
					return "Checkings New Balance: " + checkings.getBalance() + " Savings New Balance: "
							+ savings.getBalance();
				} else {
					return "The amount to transfer is higher than the available balance. Checkings: "
							+ checkings.getBalance();
				}
			} else {
				return "Check that the correct account names we entered. Transfer from " + in + " to " + out + ".";
			}
		} else {
			return "Amount to transfer must be greater than 0";
		}
	}

	public String getBalance() {
		if (checkings != null && savings != null) {
			return "Checkings: " + checkings.getBalance() + " Savings: " + savings.getBalance();
		} else if (checkings != null) {
			return "Checkings: " + checkings.getBalance();
		} else if (savings != null){
			return "Savings: " + savings.getBalance();
		}else {
			return null;
		}
	}

	public double getBalance(int i) {
		if (i == 1) {
			return checkings.getBalance();
		} else {
			return savings.getBalance();
		}
	}

	public int withdraw(double money, int response) {
		if (response == 1) {
			checkings.withdraw(money);
			return checkings.getAccountNumber();
		} else {
			savings.withdraw(money);
			return savings.getAccountNumber();
		}
	}

	public int deposit(double money, int response) {
		if (response == 1) {
			checkings.deposit(money);
			return checkings.getAccountNumber();
		} else {
			savings.deposit(money);
			return savings.getAccountNumber();
		}
	}

	/**
	 * @return the approved
	 */
	public int getApproved() {
		return this.getStatus();
	}

	/**
	 * @param approved
	 *            the approved to set
	 */
	public void setApproved(int approved) {
		this.setStatus(approved);
	}

	/**
	 * @return the managedby
	 */
	public String getManagedby() {
		return managedby;
	}

	/**
	 * @param managedby
	 *            the managedby to set
	 */
	public void setManagedby(String managedby) {
		this.managedby = managedby;
	}

	/**
	 * @return the customerLevel
	 */
	public int getCustomerLevel() {
		return customerLevel;
	}

	/**
	 * @param the
	 *            customerLevel
	 */
	public void setCustomerLevel(int customerLevel) {
		this.customerLevel = customerLevel;
	}

	@Override
	public String toString() {
		return "Name: " + this.getFirstname() + " " + this.getLastname() + " Username: " + this.getUsername()
				+ " Password: " + this.getPassword() + " Balance: " + this.getBalance() + " Approved: "
				+ this.getStatus();
	}

}
