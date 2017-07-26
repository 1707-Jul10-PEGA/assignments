package com.revature.bankingapp.entities.account;

import java.io.Serializable;
import java.time.LocalTime;
import java.util.UUID;

import com.revature.bankingapp.entities.user.Customer;
import com.revature.bankingapp.interfaces.BankAccountInterface;

public class BankAccount implements BankAccountInterface {

	private UUID accountId;
	private UUID primaryOwner;
	private int status;
	private int accountType;
	private double balance;
	private String dateOpened;

	public BankAccount() {

	}

	@Override
	public String toString() {
		return "Account Id= " + accountId + "  Type: " + getAccountTypeString() + "\nPrimary Owner: " + primaryOwner
				+ "\nBalance= " + balance + "\nDate Opened= " + dateOpened + "\nOwner Id= " + primaryOwner
				+ "\nStatus= " + getStatusString();
	}

	public BankAccount(UUID accountId, UUID primaryOwner, int status, int accountType, double balance,
			String dateOpened) {
		super();
		this.accountId = accountId;
		this.primaryOwner = primaryOwner;
		this.status = status;
		this.accountType = accountType;
		this.balance = balance;
		this.dateOpened = dateOpened;

	}

	public boolean activateAccount() {
		this.status = 1;
		return true;
	}

	public String getStatusString() {

		if (this.status == 1) {
			return "Active";
		}

		if (this.status == 2) {
			return "Application under review by bank associate";
		}

		if (this.status == 3) {
			return "Account has been frozed. Please call your banker for more details";
		}

		if (this.status == 4) {
			return "This account has been deactivated. Please call your banker for more details";
		}

		return "";
	}

	public void setStatus(int status) {
		this.status = status;
	}

	@Override
	public boolean withdraw(double ammount) {
		// TODO Auto-generated method stub

		if (this.getStatus() == 2) {
			System.out.println("We are sorry, you cannot withdraw at this time."
					+ " This account is under application review. Thank you for your patience");
			return false;
		}

		if (this.getBalance() < ammount) {
			System.out.println("Not enough funds in this account");
			return false;
		} else
			this.balance -= ammount;

		System.out.println("WithdraW succesfull. New Balance is: " + this.getBalance());
		return true;

	}

	@Override
	public boolean deposit(double ammount) {

		if (this.getStatus() != 1) {
			System.out.println("We are sorry, you cannot deposit at this time."
					+ " This account is under application review. Thank you for your patience");
			return false;
		} else if (this.getStatus() == 1) {
			// TODO Auto-generated method stub
			this.balance += ammount;
			System.out.println("Deposit successful. New Balance is: " + this.getBalance());
			return true;
		}
		return false;
	}

	@Override
	public boolean viewBalance() {
		// TODO Auto-generated method stub
		this.toString();
		return true;
	}

	public UUID getAccountId() {
		return accountId;
	}

	public void setAccountId(UUID accountId) {
		this.accountId = accountId;
	}

	public UUID getPrimaryOwner() {
		return primaryOwner;
	}

	public void setPrimaryOwner(UUID primaryOwner) {
		this.primaryOwner = primaryOwner;
	}

	public int getAccountType() {
		return accountType;
	}

	public String getAccountTypeString() {
		if (getAccountType() == 1) {
			return "SAVINGS";
		}
		if (getAccountType() == 2) {
			return "CHECKING";
		}
		if (getAccountType() == 3) {
			return "MONEY MARKET";
		}
		if (getAccountType() == 4) {
			return "INVESTMENT";
		}
		return "UNDEFINED";
	}

	public void setAccountType(int accountType) {
		this.accountType = accountType;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public String getDateOpened() {
		return dateOpened;
	}

	public void setDateOpened(String dateOpened) {
		this.dateOpened = dateOpened;
	}

	public int getStatus() {
		return status;
	}

}
