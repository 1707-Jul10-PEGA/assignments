package com.EC.hw1.Model;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.text.DecimalFormat;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Scanner;

import org.apache.log4j.Logger;

import com.EC.hw1.Interfaces.CustomerInterface;
import com.EC.hw1.Utilities.BankUtilities;

public class Customer extends User implements CustomerInterface, Cloneable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6016377397393863930L;
	private static Logger log = Logger.getRootLogger();
	private static Scanner scan = new Scanner(System.in);
	private BankAccount bankAccount;
	private boolean active;

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

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
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
		while (valid) {
			ATM();
			if (scan.hasNextInt()) {
				int tmp2 = scan.nextInt();
				if (tmp2 >= 1 && tmp2 <= 4) {
					switch (tmp2) {
					case 1:
						this.bankAccount.setCashAccount(this.bankAccount.getCashAccount() + money);
						updateBankersData(this);
						valid = false;
						log.trace(this.getUserName() + " deposited " + money + " into checking account");
						break;
					case 2:
						this.bankAccount.setSavingAccount(this.bankAccount.getSavingAccount() + money);
						updateBankersData(this);
						valid = false;
						log.trace(this.getUserName() + " deposited " + money + " saving into account");
						break;
					case 3:
						this.bankAccount.setCreditAccount(this.bankAccount.getCreditAccount() - money);
						updateBankersData(this);
						valid = false;
						log.trace(this.getUserName() + " deposited " + money + " credit account");
						break;
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
						
						this.bankAccount.setCashAccount(this.bankAccount.getCashAccount() - money);
						updateBankersData(this);
						log.trace(this.getUserName() + " withdrew " + money + " from checking account");
						valid = false;
						break;
					case 2:
						if (money > this.bankAccount.getSavingAccount()) {
							System.out.println("Not enough money in your account");
							valid = false;
							return;
						}
						this.bankAccount.setSavingAccount(this.bankAccount.getSavingAccount() - money);
						log.trace(this.getUserName() + " withdrew " + money + " from saving account");
						updateBankersData(this);
						valid = false;
						break;
					case 3:
						log.trace(this.getUserName() + " withdrew " + money + " from credit account");
						this.bankAccount.setCreditAccount(this.bankAccount.getCreditAccount() + money);
						updateBankersData(this);
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
		result = prime * result + (active ? 1231 : 1237);
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
		if (active != other.active)
			return false;
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

	/*
	 * This was way to complicated. Simplier solution was to add a attribute to
	 * the Customer class and define which he/she was assigned to
	 */
	private void updateBankersData(Customer newCustomerData) {
		File folder = new File("Employees/");
		File[] listOfFiles = folder.listFiles();
		List<Employee> empList = new LinkedList<Employee>();
		for (File emp : listOfFiles) {
			try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(emp.getPath()))) {
				Employee e = (Employee) ois.readObject();
				empList.add(e);
			} catch (FileNotFoundException e) {
				log.error("Could not load employees for updateBankersData", e);
			} catch (IOException e) {
				log.error("Could not load employees for updateBankersData", e);
			} catch (ClassNotFoundException e) {
				log.error("Could not load employees for updateBankersData", e);
			}
		}
		if (empList.size() == 0) {
			log.error("Cannot update client's information because there are no employees");
		} else {
			try {
				ListIterator<Employee> empIter = empList.listIterator();
				while (empIter.hasNext()) {
					Employee emp = empIter.next();
					Iterator<Customer> custIter = emp.getCustList().iterator();
					while (custIter.hasNext()) {
						Customer tmp = custIter.next();//gives up a exception, but we ignore it
						if (tmp.getUserName().equals(newCustomerData.getUserName())) {
							custIter.remove(); //remove old data
							emp.getCustList().add(newCustomerData);// add new customer data
							BankUtilities.updateFiles(emp);//update file
						}
					}
				} 
			} catch (ConcurrentModificationException e) {
				//ignoring exception because it happens after file is updated
			}
			
		}
	}
}
