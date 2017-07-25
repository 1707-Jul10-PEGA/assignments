package com.bank.employee;

import java.util.ArrayList;
import java.util.List;

import com.bank.customer.Customer;
import com.bank.factory.BankAccount;
import com.bank.factory.BankAccountFactory;
import com.bank.user.User;

public class Employee extends User{

	/**
	 * 
	 */
	
	private static final long serialVersionUID = 1333819143353397143L;
//	private List<BankAccount> approvedAccounts = new ArrayList<BankAccount>();
	
	public Employee() {
		super();
//		approvedAccounts = new ArrayList<BankAccount>();
	}

	public Employee(int db_id, String getfName, String getlName, String getuName, String pass, String position) {
		// TODO Auto-generated constructor stub
		this.setdbID(db_id);
		this.setfName(getfName);
		this.setlName(getlName);
		this.setuName(getuName);
		this.setPass(pass);
		this.setPosition(position);
		
	}

	public void addAccount(Customer c, String accountId, Employee starter){
			BankAccountFactory accountFactory = new BankAccountFactory();
			BankAccount bank1 = accountFactory.createBankAccount("checking", c, starter, accountId);
			c.appendAccountList(bank1);
//			this.appendApprovedAccounts(bank1);
	}
	
	public void approveAccount(List<User> userIn, String accountID, String owner){
		
	}
	
//	public void appendApprovedAccounts(BankAccount bank){
//		if(this.getuName().equals(bank.getNameOfStarter().getuName())){
//				this.approvedAccounts.add(bank);
//		}
//	}
	public void viewApprovedAccounts(List<Customer> userIn){
		for(int x = 0; x < userIn.size(); x++){
			if(userIn.get(x).getAccountList().size() != 0){
				for(int y = 0; y < userIn.get(x).getAccountList().size(); y++){
					if(userIn.get(x).getAccountList().get(y).getNameOfStarter().equals(this)){
						System.out.println("Approved Account: \n ID: " + userIn.get(x).getAccountList().get(y).getID());
						System.out.println(" Balance: " + userIn.get(x).getAccountList().get(y).viewBalance());
						System.out.println(" Approved by: " + userIn.get(x).getAccountList().get(y).getNameOfStarter().getlName() + ", " + userIn.get(x).getAccountList().get(y).getNameOfStarter().getfName());
					}
				}
			}
		}
	
		
		
		
		
//		for(int x = 0; x < approvedAccounts.size(); x++){
//			System.out.println("Approved Account:\n Account# " + approvedAccounts.get(x).getID());
//			System.out.println("Balance: " + approvedAccounts.get(x).viewBalance());
//			System.out.println("Approved By: " + approvedAccounts.get(x).getNameOfStarter().getlName() + ", " + approvedAccounts.get(x).getNameOfStarter().getfName());
//		}
	}
}