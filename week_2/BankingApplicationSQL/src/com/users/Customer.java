package com.users;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.apache.log4j.Logger;

import com.interfaces.BankingApplicationCustomerDao;
import com.interfaces.Menu;
import com.util.dao.BankingApplicationCustomerDaoImplementation;

public class Customer extends User implements Menu, Serializable {
	/**
	 * 
	 */
	private static Logger log = Logger.getRootLogger();
	private static final long serialVersionUID = 8927339110720449292L;
	private int BANKER_ID;
	public class Account implements Serializable {
		/**
		 * 
		 */
		private static final long serialVersionUID = 349109202023360198L;
		private String accountName;
		private double balance;

		public Account(String accountName, double balance) {
			super();
			this.accountName = accountName;
			this.balance = balance;
		}

		public Account() {
			super();
			// TODO Auto-generated constructor stub
			balance = 0;
		}

		public String getAccountName() {
			return accountName;
		}

		public void setAccountName(String accountName) {
			this.accountName = accountName;
		}

		public double getBalance() {
			return balance;
		}

		public void addBalance(double arg) {
			if (arg < 0) {
				log.warn("Attempted to add negative balance: " + arg + "  , Account info: " + this);
			} else {
				this.balance += arg;
				log.info("Added balance, amount: " + arg + ", balance: " + this.balance + ", customer:"
						+ this.getOuterType().getUserName());
			}
		}

		public void subtractBalance(double arg) {
			if (arg < 0) {
				log.warn("Attempted to subtract negative balance: " + arg + "  , Account info: " + this);
			} else {
				if (this.balance - arg < 25) {
					log.warn("Account balance is low! " + this);
				}
				if (this.balance - arg < 0) {
					log.warn("Excess withdrawl, amount attempted: " + arg + " , for account: " + this + " , Customer: "
							+ this.getOuterType().getUserName());
				} else {
					this.balance -= arg;
					log.info("withdrawn amount: " + arg + ", balance: " + this.balance + ", customer:"
							+ this.getOuterType().getUserName());
				}
			}
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Account other = (Account) obj;
			if (accountName == null) {
				if (other.accountName != null)
					return false;
			} else if (!accountName.equals(other.accountName))
				return false;
			if (Double.doubleToLongBits(balance) != Double.doubleToLongBits(other.balance))
				return false;
			return true;
		}

		@Override
		public String toString() {
			return "Account [accountName=" + accountName + ", balance=" + balance + "]";
		}

		private Customer getOuterType() {
			return Customer.this;
		}
	}

	ArrayList<Account> accountBalances;
	ArrayList<Account> pendingAccounts;
	public Customer() {
		accountBalances = new ArrayList<Account>();
		Account temp = new Account();
		temp.setAccountName("Checking");
		accountBalances.add(temp);
		temp = new Account();
		temp.setAccountName("Savings");
		accountBalances.add(temp);
		this.setAge(23);
		this.setFirstName("John");
		this.setLastName("Powell");
		this.setUserName("JPowell");
		this.setPassword("abc123");
		this.menuIndex = 0;
		pendingAccounts = new ArrayList<Account>();
	}

	public Customer(ArrayList<Account> accountBalances) {
		super();
		this.accountBalances = accountBalances;
	}

	private static String[] menuStrings = {
			"\n=====\nMENU\n=====\n1 )View balances\n2 )Deposit\n3 )Withdrawal \n4 )Apply for an account\n5 )End transactions\n=====\n",
			"Enter deposit amount: ", "Enter withdrawal amount: ", "** BYE **" };
	private static String[] optionString = { "Enter an option (1, 2, 3, ..): " };
	private int menuIndex;

	@Override
	public void displayMenu() {
		System.out.print(menuStrings[menuIndex]);
	}

	@Override
	public boolean optionInput() {
		BankingApplicationCustomerDao cd = new BankingApplicationCustomerDaoImplementation();
		System.out.print(optionString[0]);
		Scanner cScan = new Scanner(System.in);
		String input = cScan.nextLine();
		switch(input){
		case "1":
			try {
				List<Customer.Account> ca = cd.viewBalances(this.getUser_id());
				System.out.println();
				for(Customer.Account ac: ca){
					System.out.println("Account: " + ac.getAccountName() + ", balance: " + ac.getBalance());
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return true;
		case "2":
			try {
				cd.deposit(this.getUser_id());
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return true;
		case "3":
			try {
				cd.withdraw(this.getUser_id());
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return true;
		case "4":
			try {
				cd.apply(this.getUser_id());
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return true;
		case "5":
			return false;
		default:
			System.out.println("Invalid option");
			return true;
		}

	}

	public void displayAccounts() {
		int i = 1;
		for (Account x : accountBalances) {
			System.out.println("\t" + i++ + " )" + x.accountName + ": " + x.getBalance());
		}
	}

	public ArrayList<Account> getAccountBalances() {
		return accountBalances;
	}

	public void applyForAccount(String accountName) {

	}


	@Override
	public String toString() {
		return "Customer [accountBalances=" + accountBalances + ", pendingAccounts=" + pendingAccounts + ", menuIndex="
				+ menuIndex + ", getFirstName()=" + getFirstName() + ", getLastName()=" + getLastName()
				+ ", getUserName()=" + getUserName() + ", getPassword()=" + getPassword() + ", getAge()=" + getAge()
				+ ", toString()=" + super.toString() + ", hashCode()=" + hashCode() + ", getClass()=" + getClass()
				+ "]";
	}

	public int getBANKER_ID() {
		return BANKER_ID;
	}

	public void setBANKER_ID(int bANKER_ID) {
		BANKER_ID = bANKER_ID;
	}

}
