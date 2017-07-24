package com.dv.bankingapp;

public class Admin extends User {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5495653096119619552L;
	
	@Override
	public void viewAccount() {
		System.out.println("\n===== Account Information =====");
		System.out.println("Account type: " + this.getType());
		System.out.println("Username : " + this.getUserName());
		System.out.println("Password : " + this.getPw());
	}
	
	/* viewAllAccounts
	 * view all accounts in the system
	 */
	public void viewAllAccounts() {
		for(User u : Driver.userList) {
			System.out.println(u);
		}
	
	}
	
	/* printUserInfo
	 * print all the information about the user
	 */
	public void printUserInfo(User user) {
		System.out.println("\n===== User Account Information =====");
		System.out.println("Account Type: " + user.getType());
		System.out.println("Username: " + user.getUserName());
		System.out.println("Password: " + user.getPw());
		
		if(user instanceof Customer) {
			switch(((Customer) user).getStatus()) {
			case 0:
				System.out.println("Status: Not yet applied");
				break;
			case 1:
				System.out.println("Status: Pending");
				break;
			case 2:
				System.out.println("Status: Denied");
				break;
			case 3:
				System.out.println("Status: Verified");
				break;
			default:
				System.out.println("Status: Unknown");
				break;
			
			}

			System.out.println("Balance: $" + ((Customer) user).getBalance());
		}
		
		if(user instanceof Employee) {
			if(((Employee) user).getCustomer() == null) {
				System.out.println("No customer associated.");
			}
			
			else {
				System.out.println("Customer: " + ((Employee) user).getCustomer().getUserName());
			}
		}
	
	}

	/* editUserAccount
	 * edit the account of a user
	 */
	public void viewUserAccount() {
		int i = 0;
		int userListSize = Driver.userList.size();
		String userName;
		User user = null;
	
		System.out.println("\nList of accounts: ");
		viewAllAccounts();
		
		// enter userName of account
		System.out.print("Enter name of user to edit: ");
		userName = Driver.read.nextLine();
		
		// search for user with userName and grab that user
		while(i < userListSize){
			if(Driver.userList.get(i).getUserName().equals(userName)) {
				user = Driver.userList.get(i);
			}
			
			i++;
		}
		
		if(user == null) {
			System.out.println("User " + userName + " was not found!");
		}
		
		else {
			printUserInfo(user);
		}

	}
	
	/* deleteUser
	 * delete the specified user from users.txt
	 */
	public void deleteUser(User user) {
		int i = 0;
		int userListSize = Driver.userList.size();
		String associatedCustomer;
		User currUser;
	
		// if customer to be deleted is associated with an employee
		// remove the associated customer from the employee
		if(user instanceof Customer) {
			while(i<userListSize) {
				currUser = (Driver.userList.get(i));
				
				if(currUser instanceof Employee) {
					associatedCustomer = ((Employee) currUser).getCustomer().getUserName();
					if(associatedCustomer.equals(user.getUserName())) {
						((Employee) Driver.userList.get(i)).setCustomer(null);
					}
				}

				i++;
			}
		}
	
		// update file
		Driver.userList.remove(user);
		Driver.serialUser.writeUserList(Driver.userList);
		System.out.println("Successfully deleted user " + user.getUserName());
	}
	
	/* deleteUserAccount
	 * delete the account of a user
	 */
	public void deleteUserAccount() {
		int i = 0;
		int userListSize = Driver.userList.size();
		String userName;
		User user = null;
		
		System.out.println("\nList of accounts: ");
		viewAllAccounts();
		
		// enter userName of account
		System.out.print("Enter name of user to delete: ");
		userName = Driver.read.nextLine();
		
		// search for user with userName and grab that user
		while(i < userListSize) {
			if(Driver.userList.get(i).getUserName().equals(userName)) {
				user = Driver.userList.get(i);
			}
			
			i++;
		}
		
		if(user == null) {
			System.out.println("User " + userName + " was not found!");
		}
		
		else {
			deleteUser(user);
		}
	
	}
	
}
