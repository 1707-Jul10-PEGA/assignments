package com.users;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;

import org.apache.log4j.Logger;

import com.interfaces.Menu;

public class Customer extends User implements Menu, Serializable {
	/**
	 * 
	 */
	private static Logger log = Logger.getRootLogger();
	private static final long serialVersionUID = 8927339110720449292L;

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

		public void addBalance(double arg){
			if(arg < 0){
				log.warn("Attempted to add negative balance: " + arg + "  , Account info: " + this);
			}else{
				this.balance += arg;
				log.info("Added balance, amount: " + arg + ", balance: " + this.balance + ", customer:" + this.getOuterType().getUserName() );
			}
		}
		
		public void subtractBalance(double arg){
			if(arg < 0){
				log.warn("Attempted to subtract negative balance: " + arg + "  , Account info: " + this);
			}else{
				if(this.balance - arg < 25){
					log.warn("Account balance is low! " + this);
				}
				if(this.balance - arg < 0){
					log.warn("Excess withdrawl, amount attempted: " + arg + " , for account: " + this
							+ " , Customer: " + this.getOuterType().getUserName());
				}else{
					this.balance -= arg;
					log.info("withdrawn amount: " + arg + ", balance: " + this.balance + ", customer:" + this.getOuterType().getUserName() );
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

	public Customer(){
		Account temp = new Account();
		temp.setAccountName("Checking");
		accountBalances.add(temp);
		temp = new Account();
		temp.setAccountName("Savings");
		accountBalances.add(temp);
	}
	public Customer(ArrayList<Account> accountBalances) {
		super();
		this.accountBalances = accountBalances;
	}

	private String[] menuStrings = {"","","",""};
	
	@Override
	public void displayMenu() {
	}

	@Override
	public boolean optionInput() {
		return false;

	}

	public ArrayList<Account> getAccountBalances() {
		return accountBalances;
	}

	public void applyForAccount(String accountName){
		
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Customer other = (Customer) obj;
		if (accountBalances == null) {
			if (other.accountBalances != null)
				return false;
		} else if (!accountBalances.equals(other.accountBalances))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Customer [accountBalances=" + accountBalances + ", getFirstName()=" + getFirstName()
				+ ", getLastName()=" + getLastName() + ", getUserName()=" + getUserName() + ", getPassword()="
				+ getPassword() + ", getAge()=" + getAge() + ", toString()="
				+ super.toString() + ", hashCode()=" + hashCode() + ", getClass()=" + getClass() + "]";
	}

}
