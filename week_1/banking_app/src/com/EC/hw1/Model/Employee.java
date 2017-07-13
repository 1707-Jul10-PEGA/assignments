package com.EC.hw1.Model;
import java.util.HashMap;
import java.util.Map;
public class Employee extends User{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 6075316305104448561L;

	private Account account;
	private Map<Customer, Boolean> mapofCustomers = new HashMap<Customer,Boolean>();
	
	public Employee(String firstName, String lastName, Account account, Map <Customer,Boolean>mapOfCustomers ){
		this.account = account;
		this.mapofCustomers = mapOfCustomers;
	}

	public Map<Customer, Boolean> getMapofCustomers() {
		return mapofCustomers;
	}

	public void setMapofCustomers(Map<Customer, Boolean> mapofCustomers) {
		this.mapofCustomers = mapofCustomers;
	}

	public Account getAccount() {
		return account;
	}
	
	
	
	
	
}
