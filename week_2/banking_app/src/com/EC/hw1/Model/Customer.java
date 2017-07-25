package com.EC.hw1.Model;

import java.text.DecimalFormat;
import java.util.Scanner;

import org.apache.log4j.Logger;

import com.EC.hw1.Interfaces.CustomerInterface;
import com.EC.hw1.Utilities.DAOUtilities;
import com.EC.hw2.DAO.BankAccountDAO;

public class Customer extends User implements CustomerInterface, Cloneable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6016377397393863930L;
	private static Logger log = Logger.getRootLogger();
	private static Scanner scan = new Scanner(System.in);
	private BankAccount bankAccount;

	public Customer() {
		super();
	}

	public Customer(String firstName, String lastName, String userName, String password, BankAccount bankAccount) {
		super(firstName, lastName, userName, password);
		this.bankAccount = bankAccount;
	}

	public BankAccount getBankAccount() {
		return bankAccount;
	}
		
	public void setBankAccount(BankAccount bankAccount) {
		this.bankAccount = bankAccount;
	}

	@Override
	public void viewBalance() {
		DecimalFormat df2 = new DecimalFormat(".##");
		System.out.println(("CASH ACCOUNT: $"
				+ df2.format(this.bankAccount.getCashAccount() + this.bankAccount.getSavingAccount())));
		System.out.println("CHECKING: $" + df2.format(this.bankAccount.getCashAccount()));
		System.out.println("SAVING: $" + df2.format(this.bankAccount.getSavingAccount()));
		System.out.println("CREDIT: $" + df2.format(this.bankAccount.getCreditAccount()) + "\n");

	}

	@Override
	public void deposit(double money) {
		if (money < 0) {
			System.out.println("Cannot deposit a negative amount of money");
			return;
		}
		boolean valid = true;
		BankAccountDAO dao = DAOUtilities.getBankAccountDAO();
		while (valid) {
			ATM();
			if (scan.hasNextInt()) {
				int tmp2 = scan.nextInt();
				if (tmp2 >= 1 && tmp2 <= 4) {
					switch (tmp2) {
					case 1:
						if(dao.updateChecking(this.getUser_id(), this.getBankAccount().getCashAccount()+money)){
							this.bankAccount.setCashAccount(this.bankAccount.getCashAccount() + money);
							valid = false;
							log.trace(this.getUserName() + " deposit " + money + " into checking account");
							break;
						}else{
							valid = false;
							System.out.println("Failed to deposit money");
							log.trace("Failed to depoist money for: " + this.getUserName() + " into checking account");
							break;
						}	
					case 2:
						if(dao.updateSaving(this.getUser_id(), this.getBankAccount().getSavingAccount()+money)){
							this.bankAccount.setSavingAccount(this.bankAccount.getSavingAccount() + money);
							valid = false;
							log.trace(this.getUserName() + " deposit " + money + " into saving account");
							break;
						}else{
							valid = false;
							System.out.println("Failed to deposit money");
							log.trace("Failed to depoist money for: " + this.getUserName());
							break;
						}	
					case 3:
						if(dao.updateCredit(this.getUser_id(), this.getBankAccount().getCreditAccount()-money)){
							this.bankAccount.setCreditAccount(this.bankAccount.getCreditAccount() - money);
							valid = false;
							log.trace(this.getUserName() + " deposited " + money + " into credit account");
							break;
						}else{
							valid = false;
							System.out.println("Failed to deposit money");
							log.trace("Failed to depoist money for: " + this.getUserName() + " into credit account");
							break;
						}	
					case 4:
						valid = false;
						break;
					}

				} else {
					ATM();
				}
			} else {
				ATM();
				// clear invalid input
				scan.next();
			}

		}

	}

	@Override
	public void withdraw(double money) {
		BankAccountDAO dao = DAOUtilities.getBankAccountDAO();
		if (money < 0) {
			System.out.println("Cannot withdraw a negative amount of money");
			return;
		}

		boolean valid = true;
		while (valid) {
			ATM();
			if (scan.hasNextInt()) {
				int tmp = scan.nextInt();
				if (tmp >= 1 && tmp <= 3) {
					switch (tmp) {
					case 1:
						if (money > this.bankAccount.getCashAccount()) {
							System.out.println("Not enough money in your account");
							return;
						}
						dao.updateChecking(this.getUser_id(), this.getBankAccount().getCashAccount()-money);
						this.bankAccount.setCashAccount(this.bankAccount.getCashAccount() - money);
						log.trace(this.getUserName() + " withdrew " + money + " from checking account");
						valid = false;
						break;
					case 2:
						if (money > this.bankAccount.getSavingAccount()) {
							System.out.println("Not enough money in your account");
							valid = false;
							return;
						}
						dao.updateSaving(this.getUser_id(), this.getBankAccount().getSavingAccount()-money);
						this.bankAccount.setSavingAccount(this.bankAccount.getSavingAccount() - money);
						log.trace(this.getUserName() + " withdrew " + money + " from saving account");
						valid = false;
						break;
					case 3:
						log.trace(this.getUserName() + " withdrew " + money + " from credit account");
						dao.updateCredit(this.getUser_id(), this.getBankAccount().getCreditAccount()-money);
						this.bankAccount.setCreditAccount(this.bankAccount.getCreditAccount() + money);
						valid = false;
						break;
					}

				} else {
					ATM();
				}
			} else {
				ATM();
				// clear invalid input
				scan.next();
			}

		}

	}

	private static void ATM() {
		System.out.println("Please enter a number between 1-4");
		System.out.println("(1)CHECKING ACCOUNT");
		System.out.println("(2)SAVING ACCOUNT");
		System.out.println("(3)CREDIT ACCOUNT");
		System.out.println("(4)BACK");
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((bankAccount == null) ? 0 : bankAccount.hashCode());
		return result;
	}

	
	@Override	
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Customer other = (Customer) obj;
		if (bankAccount == null) {
			if (other.bankAccount != null)
				return false;
		} else if (!bankAccount.equals(other.bankAccount))
			return false;
		return true;
	}

	
	@Override
	public Customer clone() {
		Customer clone = new Customer();
		clone.setFirstName(this.getFirstName());
		clone.setLastName(this.getLastName());
		clone.setPassword(this.getPassword());
		clone.setUserName(this.getUserName());
		clone.setBankAccount(this.getBankAccount());
		return clone;
	}

	
}
