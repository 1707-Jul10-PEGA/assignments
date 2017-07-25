package com.bank.withdrawl_deposit;

import com.bank.customer.Customer;

public class WithdrawlDeposit {
	
	public WithdrawlDeposit() {
		super();
	
	}

	public void accountWithdrawl(Customer c, String id, double amount){
		for(int x = 0; x < c.getAccountList().size(); x++){
			if(c.getAccountList().get(x).getID().equalsIgnoreCase(id)){
				c.getAccountList().get(x).withdraw(amount);
				System.out.println(amount + " withdrawn.\n New Balance: " + c.getAccountList().get(x).viewBalance());
			}
		}
	}
	public void accountDeposit(Customer c, String id, double amount){
		for(int x = 0; x < c.getAccountList().size(); x++){
			if(c.getAccountList().get(x).getID().equalsIgnoreCase(id)){
				c.getAccountList().get(x).deposit(amount);
				System.out.println(amount + " deposited.\n New Balance: " + c.getAccountList().get(x).viewBalance());
			}
		}
	}
}
