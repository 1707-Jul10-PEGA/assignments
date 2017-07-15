package com.EC.hw1.Model;
import java.util.LinkedList;
import java.util.List;

import com.EC.hw1.Interfaces.EmployeeInterface;
public class Employee extends User implements EmployeeInterface{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 6075316305104448561L;

	private Account account;
	private List<Customer> custList = new LinkedList<Customer>();
	
	public Employee(){
		super();
	}
	
	public Employee(String firstName, String lastName, String userName ,String password,Account account,LinkedList<Customer> custList){
		super(firstName,lastName, userName, password);
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

	@Override
	public void approveOrDenyApp() {
		for(Customer c : this.custList){
			if(!c.isActive()){
				
			}
		}
		
	}

	@Override
	public void viewCustomerAsset() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void viewCustomerList() {
		// TODO Auto-generated method stub
		
	}
	
	
	
	
	
}
