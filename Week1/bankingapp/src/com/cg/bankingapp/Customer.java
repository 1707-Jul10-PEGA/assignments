package com.cg.bankingapp;

import java.io.Serializable;

public class Customer extends User implements Serializable {

	// Variables
	private static final long serialVersionUID = 2118251608993389226L;
	private CheckingsAccount checkings;
	private SavingsAccount savings;
	private int approved;
	private String managedby;
	private int customerLevel;


	// Constructor for one account(Checkings or Savings)
	public Customer(String name, String username, String password, int customerLevel,
			double balance) {
		super(name, username, password, "customer");
		this.customerLevel = customerLevel;
		if (customerLevel == 1) {
			checkings = new CheckingsAccount();
			checkings.deposit(balance);
		} else {
			savings = new SavingsAccount();
			savings.deposit(balance);
		}
	}

	// Constructor for two accounts(Checkings and Savings)
	public Customer(String name, String username, String password,
			double checkingsDeposit, double savingsDeposit) {
		super(name, username, password, "customer");
		this.customerLevel = 3;
		
		checkings = new CheckingsAccount();
		savings = new SavingsAccount();
		checkings.deposit(checkingsDeposit);
		savings.deposit(savingsDeposit);
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
		} else {
			return "Savings: " + savings.getBalance();
		}
	}

	public String withdraw(Double money, String account) {
		int flag;

		if (money > 0) {
			if ("checkings".equalsIgnoreCase(account)) {
				flag = checkings.withdraw(money);
				if (flag == 1) {
					return "New Balance: " + checkings.getBalance();
				} else {
					return "Withdraw amount is higher than the available balance. Current balance is "
							+ checkings.getBalance();
				}
			} else if ("savings".equalsIgnoreCase(account)) {
				flag = savings.withdraw(money);
				if (flag == 1) {
					return "New Balance: " + savings.getBalance();
				} else {
					return "Withdraw amount is higher than the available balance. Current balance is "
							+ savings.getBalance();
				}
			} else {
				return account + " doesn't exist. Try again.";
			}

		} else {
			return "Withdraw amount must be greater than 0.";
		}
	}

	public String deposit(Double money, String account) {
		int flag;
		if ("checkings".equalsIgnoreCase(account)) {
			flag = checkings.deposit(money);
			if (flag == 1) {
				return "New Balance: " + checkings.getBalance();
			} else {
				return "Deposit amount must be greater than 0.";
			}
		} else if ("savings".equalsIgnoreCase(account)) {
			flag = savings.withdraw(money);
			if (flag == 1) {
				return "New Balance: " + savings.getBalance();
			} else {
				return "Deposit amount must be greater than 0.";
			}
		} else {
			return account + " doesn't exist. Try again.";
		}
	}

	/**
	 * @return the approved
	 */
	public int getApproved() {
		return approved;
	}

	/**
	 * @param approved
	 *            the approved to set
	 */
	public void setApproved(int approved) {
		this.approved = approved;
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
	 * @param the customerLevel
	 */
	public void setCustomerLevel(int customerLevel) {
		this.customerLevel = customerLevel;
	}

	@Override
	public String toString() {
		return "Name: " + this.getName() + " Username: " + this.getUsername() + " Password: " + this.getPassword() + " Balance: " + this.getBalance() + " Approved: "  +this.approved ;
	}
}
