package com.bank.menu;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.apache.log4j.Logger;

import com.bank.admin.Admin;
import com.bank.customer.Customer;
import com.bank.driver.Driver;
import com.bank.employee.Employee;
import com.bank.withdrawl_deposit.WithdrawlDeposit;

public class StartingMenuClass extends Menu {
	
	private static Scanner scan = new Scanner(System.in);
	private List<Employee> privateE;
	private ArrayList<Customer> privateC;
	private List<Admin> privateA;
	private ArrayList<String[]> toApprove;
	Logger log = Logger.getLogger(StartingMenuClass.class.getName());
	
	public ArrayList<String[]> getToApprove() {
		return toApprove;
	}

	public void setToApprove(ArrayList<String[]> toApprove) {
		this.toApprove = toApprove;
	}

	public List<Employee> getPrivateE() {
		return privateE;
	}

	public void setPrivateE(List<Employee> privateE) {
		this.privateE = privateE;
	}

	public List<Customer> getPrivateC() {
		return privateC;
	}

	public void setPrivateC(ArrayList<Customer> privateC) {
		this.privateC = privateC;
	}

	public List<Admin> getPrivateA() {
		return privateA;
	}

	public void setPrivateA(List<Admin> privateA) {
		this.privateA = privateA;
	}

	@Override
	public void menuHandler(List<Admin> admins, List<Employee> employees, ArrayList<Customer> customers, ArrayList<String[]> toApprove) {
		setPrivateA(admins);
		setPrivateC(customers);
		setPrivateE(employees);
		setToApprove(toApprove);
		startingMenu();
	}
	@Override
	void startingMenu(){
		Logger log = Logger.getLogger(Driver.class.getName());
		
				//opening menu prompt
		List<Admin> admins = getPrivateA();
		ArrayList<Customer> customers = (ArrayList<Customer>)getPrivateC();
		List<Employee> employees = getPrivateE();
	
		System.out.println("Choose an option.\n 1: Admin Login\n 2: Employee Login:\n 3: Customer Login:\n 4: New User\n 5: Close");
		String userIn;
		String passIn;
		
		String next = scan.nextLine();
		switch(next){
		case "1":
			System.out.println("Admin Login:");
			System.out.println("\nPlease enter username:\n");
			userIn = scan.nextLine();
			System.out.println("\nPlease enter password:\n");
			passIn = scan.nextLine();
		
			for(int x = 0; x < admins.size(); x++){
				if(userIn.equals(admins.get(x).getuName()) && passIn.equals(admins.get(x).getPass())){
					
					System.out.println("Welcome, " + admins.get(x).getfName() + " " + admins.get(x).getlName());
					adminMenu(admins.get(x), customers);
					return;
				}
			}
			System.out.println("Wrong credentials");
			startingMenu();
		break;
		case "2":
			System.out.println("Employee Login");
			System.out.println("\nPlease enter username:\n");
			userIn = scan.nextLine();
			System.out.println("\nPlease enter password:\n");
			passIn = scan.nextLine();
			for(int x = 0; x < employees.size(); x++){
				if(userIn.equals(employees.get(x).getuName()) && passIn.equals(employees.get(x).getPass())){
					System.out.println("Welcome, " + employees.get(x).getfName() + " " + employees.get(x).getlName());
					empMenu(employees.get(x), customers);
					return;
				}
			}
			System.out.println("Wrong credentials");
			startingMenu();
			break;
		case "3":
			System.out.println("Customer Login");
			System.out.println("\nPlease enter username:\n");
			userIn = scan.nextLine();
			System.out.println("\nPlease enter password:\n");
			passIn = scan.nextLine();
		
			for(int x = 0; x < customers.size(); x++){
				if(userIn.equals(customers.get(x).getuName()) && passIn.equals(customers.get(x).getPass())){
					
					System.out.println("Welcome, " + customers.get(x).getfName() + " " + customers.get(x).getlName());
					custMenu(customers.get(x), customers);
					return;
				}
			}
			System.out.println("Wrong credentials");
			startingMenu();
		break;
		case "4":
			System.out.print("Welcome, new Customer! \nSubmit username: ");
			String newUse = scan.nextLine();
			System.out.println("Submit password: ");
			String newPass = scan.nextLine();
			System.out.println("First Name: ");
			String first = scan.nextLine();
			System.out.println("Last Name: ");
			String last = scan.nextLine();
			

			customers.add(addCustomer(newUse, newPass, customers, first, last));
			System.out.println("Thanks. Going to login menu");
			startingMenu();
		break;
		case "5":
			System.out.println("Goodbye!");
			return;
		default:

			System.out.println("Invalid input");
			startingMenu();
		}
	}

	@Override
	public void empMenu(Employee e, List<Customer> customers) {

		System.out.println("Please choose an option below:\n 1: View Account Info\n 2: Approve an Account\n 3: Logout\n");
		
		
		String next = scan.nextLine();
		switch (next){
		case "1":
				e.viewApprovedAccounts(getPrivateC());
				empMenu(e, customers);
				break;
		case "2":
			
			
				
				//index 0 has the account number, index 1 has the applicant username
				
					System.out.println("Approve " + getToApprove().get(0)[0] + " " + getToApprove().get(0)[1] + "?");
					String app = scan.nextLine();
					switch (app) {
					case "1" :
						for(int y = 0; y < customers.size(); y++){
							
							if(getToApprove().get(0)[1].equals(customers.get(y).getuName())){
								System.out.println("Approved");
								e.addAccount(customers.get(y), toApprove.get(0)[0], e);
								toApprove.remove(0);
								empMenu(e, customers);
							}
						}
					break;
					case "2" :
						System.out.println("Denied");
						toApprove.remove(0);
					return;
					default:
						System.out.println("Whoops2. Try again");
						empMenu(e, customers);
					break;
					}
			
//			for(int x = 0; x < customers.size(); x++){
//				if(customers.get(x).getAccountsToProcess().get(x).equals(sIn)){
//					System.out.println("Account " + customers.get(x).getAccountList().get(x).getID().toString() + "\n 1: Approve\n :2 Deny");
//					String appDeny = scan.nextLine();
//					if(appDeny.equals("1")){
//						e.addAccount(customers.get(x), sIn, e);
//						customers.get(x).getAccountList().get(x).deposit(123);
//					}
//					else {
//						System.out.println("Removing");
//						customers.get(x).getAccountsToProcess().remove(x);
//					}
//				}
//			}
			
			break;
		case "3":
			System.out.println("Thank you for banking with us!");
			startingMenu();
			break;
		default:
			System.out.println("Invalid input");
			empMenu(e, customers);	
		}
		return;
		
	}
	
	
	
	@Override
	public void custMenu(Customer user, ArrayList<Customer> custIns) {
			System.out.println("Please choose an option below:\n 1: View Account Info\n 2: Apply for New Account\n 3: Withdrawl/Deposti\n 4: Logout\n");
			
		
			String next = scan.nextLine();
			switch (next){
			case "1":
				accountInfoMenu(user, custIns);
				break;
			case "2":
				System.out.println("Enter a number for the type of account you'd like:\n 1: Checking\n 2: Savings");
				String type = scan.nextLine();
	
				switch (type){
				case "1": 
					((Customer) user).requestAccount("checking");
					System.out.println("Thanks for your application! A bank representative will get back to you when your application has been processed.");
					custMenu(user, custIns);
					break;
				case "2":
					((Customer) user).requestAccount("savings");
					System.out.println("Thanks for your application! A bank representative will get back to you when your application has been processed.");
					custMenu(user, custIns);
				default:
					System.out.println("Error");
				}
					break;
			case "3":
				accountEditMenu(user, custIns);
				break;
			case "4":
				System.out.println("Thank you for banking with us!");
				startingMenu();
				return;
			default:
				System.out.println("Invalid input");
				custMenu(user, custIns);
				break;
			}

	}
	
	
	public void accountInfoMenu(Customer user, List<Customer> userList){
		for(int x = 0; x < user.getAccountList().size(); x++){
			System.out.print("Account List:\n ");
			System.out.println("Account ID: " + user.getAccountList().get(x).getID());
			String output = String.format("%.2f", user.getAccountList().get(x).viewBalance());
			System.out.println(" Balance is: " + output);
		}
		if(user.getAccountList().size() == 0){
			System.out.println("You have no accounts.");
			custMenu(user, (ArrayList<Customer>) userList);
		}
		else{
			accountEditMenu(user, userList);
		}
	}
	
	
	public void accountEditMenu(Customer user, List<Customer> userList) {
		System.out.println("Select an option: \n 1: Withdraw\n 2: Deposit\n 3: Go Back\n 4: Logout");
		switch(scan.nextLine()){
		
		case "1":
			System.out.println("Please enter account ID:\n");
			String idIn = scan.nextLine();
			double amountIn = 0;
			
				for(int x = 0; x < user.getAccountList().size(); x++){
					if(user.getAccountList().get(x).getID().equalsIgnoreCase(idIn)){
						System.out.println("Please enter amount to withdraw: \n");
						amountIn = scan.nextDouble();
						WithdrawlDeposit wd = new WithdrawlDeposit();
						wd.accountWithdrawl(user, idIn, amountIn);
						log.trace("Withdrew	" + String.format("%.2f", amountIn) + " from " + idIn + " on " + LocalDateTime.now());
						System.out.println("Back to Customer Menu:\n");
						accountInfoMenu(user, userList);
					}
					else{
						System.out.println("Whoops. Try once more");
						accountEditMenu(user, userList);
					}
				}
				return;
		case "2":
			System.out.println("Please enter account ID:\n");
			idIn = scan.nextLine();
			amountIn = 0;
			
				for(int x = 0; x < user.getAccountList().size(); x++){
					if(user.getAccountList().get(x).getID().equalsIgnoreCase(idIn)){
						System.out.println("Please enter amount to deposit: \n");
						amountIn = scan.nextDouble();
						WithdrawlDeposit wd = new WithdrawlDeposit();
						wd.accountDeposit(user,  idIn,  amountIn);
						log.trace(user.getlName() + ", " + user.getfName() + " deposited $" + String.format("%.2f", amountIn) + " from " + idIn + " on " + LocalDateTime.now());
						System.out.println("Back to Customer Menu");
						accountInfoMenu(user, userList);
					}
					else{
						System.out.println("Whoops. Try once more");
						accountEditMenu(user, userList);
					}
				}
				return;
		case "3":
			custMenu(user, (ArrayList<Customer>) userList);
			break;
		case "4":
			System.out.println("Thank you for banking with us!");
			startingMenu();
			return;
		default:
			System.out.println("Invalid input");
			accountInfoMenu(user, userList);
			break;
		}
	}
	
	
	
	@Override
	public void adminMenu(Admin a, List<Customer> customers) {
		System.out.println("Admin menu:");
		System.out.println("Selenct an option:\n 1: View/Edit accounts\n 2: Approve/Deny Accounts\n 3: Logout");
		String input = scan.nextLine();
		switch (input){
		case "1":
			System.out.print("Enter Customer's first name: ");
			String custF = scan.nextLine();
			System.out.print("Enter Customer's last name: ");
			String custL = scan.nextLine();
			for(int x = 0; x < customers.size(); x++){
				if(customers.get(x).getfName().equals(custF) && customers.get(x).getlName().equals(custL)){
					System.out.println("user found");
					accountInfoMenu((Customer)customers.get(x), customers);
				}
			}
			System.out.println("user not found. back to menu");	
			adminMenu(a, customers);
			break;
			
		case "2":
			System.out.println("Enter Account ID: ");
			String sIn = scan.nextLine();
			
			
			for(int x = 0; x < customers.size(); x++){
				Customer cIn = customers.get(x);
				if(cIn.getAccountsToProcess().get(x).equals(sIn)){
					System.out.println("Account " + cIn.getAccountList().get(x).getID().equals(sIn) + "\n 1: Approve\n :2 Deny");
					String appDeny = scan.nextLine();
					if(appDeny.equals("1")){
						a.addAccount(cIn, sIn, (Employee)a);						
					}
					else {
						cIn.getAccountsToProcess().remove(x);
					}
				}
			}
		}
		
	}

	@Override
	public Customer addCustomer(String username, String password, List<Customer> userList, String first, String last) {
		
		for(int x = 0; x < userList.size(); x++){
			if(userList.get(x).getuName().equals(username)){
				System.out.println("Username already exists. Go to login?\n 1: Yes\n 2: No");
				String input = scan.nextLine();
				if(input.equals("1")){
					startingMenu();
				}
				else{
					System.out.println("Pick new username.");
					username = scan.nextLine();
					System.out.println("Choose a password.");
					password = scan.nextLine();
					addCustomer(username, password, userList, first, last);
				}
			}
		}
		Customer newC = new Customer();
		newC.setfName(first);
		newC.setlName(last);
		newC.setPass(password);
		newC.setuName(username);
		newC.setPosition("customer");
		
		System.out.println("Added new user " + newC.getlName() + ", " + newC.getfName());
		return newC;
		
	}

}
