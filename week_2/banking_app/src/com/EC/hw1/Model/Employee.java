package com.EC.hw1.Model;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

import org.apache.log4j.Logger;

import com.EC.hw1.Interfaces.EmployeeInterface;
import com.EC.hw1.Utilities.DAOUtilities;
import com.EC.hw2.DAO.EmployeeDAO;


public class Employee extends User implements EmployeeInterface {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6075316305104448561L;
	private static Logger log = Logger.getRootLogger();
	private static Scanner scan = new Scanner(System.in);
	private Account account;
	private List<Customer> custList = new LinkedList<Customer>();

	public Employee() {
		super();
	}

	public Employee(String firstName, String lastName, String userName, String password, Account account,
			LinkedList<Customer> custList) {
		super(firstName, lastName, userName, password);
		this.account = account;
		this.custList = custList;
	}

	public void addCustomer(Customer c) {
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
	
	public void setAccount(Account account){
		this.account = account;
	} 

	@Override
	public void checkApplications() {
		EmployeeDAO dao = DAOUtilities.getEmployeeDAO();
		boolean valid = true;
		Iterator<Customer> iter = this.custList.iterator();
		while (iter.hasNext()) {
			Customer c = (Customer) iter.next();
			if (!c.getBankAccount().isActive()) {
				System.out.println("Client's personal information");
				System.out.println(c.toString());
				valid = true;
				while (valid) {
					System.out.println("Please enter a 1 or 2");
					System.out.println("(1)Approve Application");
					System.out.println("(2)Deny Application");
					if (scan.hasNextInt()) {
						int tmp = scan.nextInt();
						switch (tmp) {
						case 1:
							if(dao.aproveApplication(c.getUser_id())){
								c.getBankAccount().setActive(true);
								log.trace(this.getUserName() + " approved " + c.getFirstName() + "'s application");
								valid = false;
							}else{
								System.out.println("unable to approve " + c.getUserName() + "for a bank account");
								log.trace("Failed to approve application for " + c.getUserName());
								valid = false;
							}
							
							break;
						case 2:
							if(dao.denyApplication(c.getUser_id())){
								iter.remove();
								valid = false;
								log.trace(this.getUserName() + " denied " + c.getFirstName() + "'s application");
								log.trace(c.getUserName() + " was removed from the database");
							}else{
								valid = false;
								System.out.println("unable to deny " + c.getUserName() + "for a bank account");
								log.trace("Failed to deny application for " + c.getUserName());
							}
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

		for (Customer c : this.custList) {
			if (c.getUserName().equals(username)) {
				System.out.println(c.getFirstName() + " " + c.getLastName() + "'s Account ");
				c.viewBalance();
				return;
			}
		}
		System.out.println("You do not have client with that username.\nCheck your list of assigned clients\n");

	}

	@Override
	public void viewCustomerList() {
		if (this.custList.size() == 0) {
			System.out.println("No customers");
		} else {
			for (Customer c : this.custList) {
				System.out.println(c.toString());
				System.out.println("Account Activated:" + c.getBankAccount().isActive() + "\n");
			}

		}

	}

}
