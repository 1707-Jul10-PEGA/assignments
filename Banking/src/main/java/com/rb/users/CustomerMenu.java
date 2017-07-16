package com.rb.users;

public class CustomerMenu extends Menu {
	
	public static void customerMenu(Customer customer){
		
		boolean loggedIn = true;
		
		do {
			
			int mainMenuInput = -1;
			int subMenuInput = -1;
			double amount = -1.0;
			
			System.out.println("Choose an action:\n  1 - Deposit");
			System.out.println("  2 - Withdraw\n  3 - View Accounts");
			System.out.println("  4 - Apply for a new account\n");
			System.out.println("  0 - Log out");
			
			mainMenuInput = readInput();
			
			switch(mainMenuInput){
			case 1:
				
				System.out.println("Which account do you want " 
						+ "to deposit into?");
				customer.printAccounts();
				
				subMenuInput = readInput();

				System.out.println("How much are you depositing?");
				
				amount = readAmount();
				
				
				if(subMenuInput < 0 || amount <= 0.0){
					
				} else {
					customer.accessAccount(subMenuInput).deposit(amount);
				}
				break;
			
			case 2:
				
				System.out.println("Which account do you want " 
					+"to withdraw from?");
				customer.printAccounts();
				
				subMenuInput = readInput();
				
				System.out.println("How much would you like to withdraw?");
				
				amount = readAmount();
				
				
				if(subMenuInput < 0 || amount <= 0.0){
					
				} else {
					customer.accessAccount(subMenuInput).withdraw(amount);
				}
				
				break;
				
			case 3:
				System.out.println("These are your accounts:\n");
				customer.printAccounts();
				break;
				
			case 4:
				
				System.out.println("What type of account do you " 
					+ "want to apply for?\n\n  1 - Checking\n  "
					+ "2 - Savings\n  0 - Cancel");
				
				subMenuInput = readInput();
				
				if(subMenuInput == 0) {
					break;
				}else if (subMenuInput == 1 || subMenuInput == 2){
					customer.apply(subMenuInput);
				}else{
					// TODO error logging
				}
				break;
			
			case 0:
				System.out.println("Thank you. Goodbye.");
				loggedIn = false;
				break;
			
			default:
				System.out.println("Invalid input. Please try again.");
				break;
			}
		
		} while (loggedIn);
	}
}
