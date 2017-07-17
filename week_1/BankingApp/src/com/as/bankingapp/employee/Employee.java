package com.as.bankingapp.employee;

import java.util.ArrayList;
import java.util.List;

import com.as.bankingapp.user.User;

public class Employee extends User{
	
	private static final long serialVersionUID = -6614705024406425070L;
	
	private List<Integer> accountIds;

	public Employee() {
		//this.setId("");
		this.setUserName("");
		this.setPassword("");
		accountIds = new ArrayList<Integer>();
	}
	
	
	public Employee(String userName, String password) {
		super(userName, password);
		accountIds = new ArrayList<Integer>();
	}



	public List<Integer> getAccountIds() {
		return accountIds;
	}

	public void setaccountIds(List<Integer> accountIds) {
		this.accountIds = accountIds;
	}
	
	/*
	 * Add the account corrisponding to the given id to the managed accounts
	 */
	public boolean addAccount(Integer id) {
		if (this.getAccountIds().contains(id)) {
			System.out.println("This is already your customer.");
			return false;
		} else {
			this.getAccountIds().add(id);
			return true;
		}
	}


	@Override
	public String toString() {
		return super.toString();
	}
	
	
}
