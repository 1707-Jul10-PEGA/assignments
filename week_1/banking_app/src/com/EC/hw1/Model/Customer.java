package com.EC.hw1.Model;

import java.text.DecimalFormat;
import java.util.Scanner;

import com.EC.hw1.Interfaces.CustomerInterface;

public class Customer extends User implements CustomerInterface {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6016377397393863930L;
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

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	@Override
	public void viewBalance() {
		DecimalFormat df2 = new DecimalFormat(".##");
		System.out.println(("CASH ACCOUNT: $"+df2.format(this.bankAccount.getCashAccount()+this.bankAccount.getSavingAccount())));
		System.out.println("CHECKING: $" + df2.format(this.bankAccount.getCashAccount()));
		System.out.println("SAVING: $" + df2.format(this.bankAccount.getSavingAccount()));
		System.out.println("CREDIT: $"+df2.format(this.bankAccount.getCreditAccount()));
		

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
			if(scan.hasNextInt()){
				int tmp2 = scan.nextInt();
				if(tmp2>=1&&tmp2<=4){
					switch (tmp2) {
					case 1:
						this.bankAccount.setCashAccount(this.bankAccount.getCashAccount() + money);
						valid=false;
						break;
					case 2:
						this.bankAccount.setSavingAccount(this.bankAccount.getSavingAccount() + money);
						valid=false;
						break;
					case 3:
						this.bankAccount.setCreditAccount(this.bankAccount.getCreditAccount() - money);
						valid=false;
						break;
					case 4:
						valid=false;
						break;
					}

				}else{
					ATM();		
				}
			}else{
				ATM();
				//clear invalid input
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
			if(scan.hasNextInt()){
				int tmp = scan.nextInt();
				if(tmp>=1&&tmp<=3){
					switch (tmp) {
					case 1:
						if (money > this.bankAccount.getCashAccount()) {
							System.out.println("Not enough money in your account");
							return;
						}
						this.bankAccount.setCashAccount(this.bankAccount.getCashAccount() - money);
						valid=false;
						break;
					case 2:
						if(money > this.bankAccount.getSavingAccount()){
							System.out.println("Not enough money in your account");
							valid=false;
							return;
						}
						this.bankAccount.setSavingAccount(this.bankAccount.getSavingAccount() - money);
						valid=false;
						break;
					case 3:
						this.bankAccount.setCreditAccount(this.bankAccount.getCreditAccount()+money);
					}


				}else{
					ATM();		
				}
			}else{
				ATM();
				//clear invalid input
				scan.next();
			}
			
		}
		
	}
	
	private static void ATM(){
		System.out.println("Please enter a number between 1-4");
		System.out.println("(1)CHECKING ACCOUNT");
		System.out.println("(2)SAVING ACCOUNT");
		System.out.println("(3)CREDIT ACCOUNT");
		System.out.println("(4)BACK");
	}

}
