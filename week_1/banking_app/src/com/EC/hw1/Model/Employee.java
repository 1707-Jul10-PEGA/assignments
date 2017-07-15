package com.EC.hw1.Model;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

import com.EC.hw1.Interfaces.EmployeeInterface;
import com.EC.hw1.Utilities.BankUtilities;
public class Employee extends User implements EmployeeInterface{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 6075316305104448561L;
	private static Scanner scan = new Scanner(System.in);
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
	public void checkApplications() {
		boolean valid = true;
		Iterator<Customer> iter = this.custList.iterator();
		while(iter.hasNext()){
			Customer c = (Customer) iter.next();
			if(!c.isActive()){
				System.out.println("Client's personal information");
				System.out.println(c.toString());
				while(valid){
					System.out.println("Please enter a 1 or 2");
					System.out.println("(1)Approve Application");
					System.out.println("(2)Deny Application");
					if(scan.hasNextInt()){
						int tmp = scan.nextInt();
						switch(tmp){
						case 1:
							c.setActive(true);
							BankUtilities.writeEmployee(this);
							BankUtilities.writeUser(this);
							BankUtilities.writeUser(c);
							valid = false;
							break;
						case 2:
							iter.remove();
							BankUtilities.writeEmployee(this);
							BankUtilities.writeUser(this);
							valid = false;
							break;
						}
						
					}
				}
			}
		}
		System.out.println("You have no more applications to review");
		
	}

	@Override
	public void viewCustomerAsset(String username) {
		
		for(Customer c : this.custList){
			if(c.getUserName().equals(username)){
				System.out.println(c.getFirstName()+" "+c.getLastName()+"'s Account ");
				c.viewBalance();
				return;
			}
		}
		System.out.println("You do not have client with that username.\nCheck your list of assigned clients\n");
		
	}

	@Override
	public void viewCustomerList() {
		for(Customer c : this.custList){
			System.out.println(c.toString());
			System.out.println("Account Activated:" + c.isActive()+"\n");
		}
		
	}
	

	
	
	
	
	
}
