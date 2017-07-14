package com.EC.hw1.Model;
import java.util.LinkedList;
import java.util.List;
public class Employee extends User{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 6075316305104448561L;

	private Account account;
	private List<Customer> custList = new LinkedList<Customer>();
	
	public Employee(){
		super();
	}
	
	public Employee(String firstName, String lastName, String userName ,Account account,List<Customer> custList){
		super(firstName,lastName, userName);
		this.account = account;
		this.custList = custList;
	}
	
	public void addCustomer(Customer c){
		this.getCustList().add(c);
	}

	public List<Customer> getCustList() {
		return custList;
	}

	public void setCustList(List<Customer> custList) {
		this.custList = custList;
	}

	public Account getAccount() {
		return account;
	}
	
	
	
	
	
}
