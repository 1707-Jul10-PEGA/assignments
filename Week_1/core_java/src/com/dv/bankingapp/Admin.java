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
		// view all info
		// get type
		// print different information to type
		System.out.println(user.getUserName());
	
	}

	/* editUserAccount
	 * edit the account of a user
	 */
	public void viewUserAccount() {
		int i = 0;
		int userListSize = Driver.userList.size();
		String userName;
		User user = null;
	
		System.out.println("List of accounts: ");
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
	
	/* deleteUserAccount
	 * delete the account of a user
	 */
	public void deleteUserAccount() {
	
	}
	
}
