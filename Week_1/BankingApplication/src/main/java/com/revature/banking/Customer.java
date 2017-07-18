package com.revature.banking;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author hy150
 *
 */
public class Customer extends User{
	
	private ArrayList<Integer> acctIndex;
	private int customerIndex;

	public Customer(String firstName, String lastName, int age, String phone, String address, String username,
			String password, ArrayList<Integer> acctIndex, int customerIndex) {
		super(firstName, lastName, age, phone, address, username, password, "customer");
		this.acctIndex = acctIndex;
		this.customerIndex = customerIndex;
	}
	
	public void deposit(int accountId, double amount) {
		Main.bankAcc.get(accountId).deposit(amount);
	}
	
	public void withdraw(int accountId, double amount) {
		Main.bankAcc.get(accountId).withdraw(amount);
	}
	
	public void applyForAccount() {
		
		try {
			System.out.println("What type of account do you want? Please input saving or checking");
			Scanner sc = new Scanner(System.in);
			String type = sc.nextLine();
			System.out.println("How much do you want to put in?");
			Double amount = Double.parseDouble(sc.nextLine());
			Main.application.add(new Application(this,type,amount));
			System.out.println("Application created. Please wait up to 7 to 14 days to processed");
		}
		catch(Exception e) {
			System.out.println("Error: Application not created!");
		}
		
	}
	
	public void displayAccounts() {
		ArrayList<BankAccount> bList = Main.getBankAcc();
		for(Integer i: getAcctIndex()) {
			System.out.println("[" + i + "]" + bList.get(i));
		}
	}
	
	/**
	 * Checks to see if the user holds a particular account.
	 * @param index
	 * @return
	 */
	public boolean hasAccount(int index) {
		for(Integer i: getAcctIndex()) {
			if(index == i) {
				return true;
			}
		}
		return false;
	}

	public ArrayList<Integer> getAcctIndex() {
		return acctIndex;
	}

	public void setAcctIndex(ArrayList<Integer> acctIndex) {
		this.acctIndex = acctIndex;
	}

	public int getCustomerIndex() {
		return customerIndex;
	}

	public void setCustomerIndex(int customerIndex) {
		this.customerIndex = customerIndex;
	}

	@Override
	public String toString() {
		return "\n" + super.toString() + "acctIndex=" + acctIndex + ", customerIndex=" + customerIndex ;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((acctIndex == null) ? 0 : acctIndex.hashCode());
		result = prime * result + customerIndex;
		return result;
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
		if (acctIndex == null) {
			if (other.acctIndex != null)
				return false;
		} else if (!acctIndex.equals(other.acctIndex))
			return false;
		if (customerIndex != other.customerIndex)
			return false;
		return true;
	}
	
	
	
	
	
}
