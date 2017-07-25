package com.dv.bankingapp;

import java.sql.SQLException;

public class Dashboard implements DashboardInterface {
	
	@Override
	public boolean doCustomerOption(int code) throws SQLException {
		boolean loopBack = true;
	
		switch(code) {
			case 0:
				((Customer) Driver.authUser).viewAccount();
				break;
			case 1:
				((Customer) Driver.authUser).apply();
				break;
			case 2:

				if(((Customer) Driver.authUser).getStatus() == 3) {
					((Customer) Driver.authUser).viewBalance();
				}
				
				else {
					System.out.println("To access this feature, your account must be verified.");
				}
				
				break;
			case 3:

				if(((Customer) Driver.authUser).getStatus() == 3) {
					((Customer) Driver.authUser).deposit();
				}
				
				else {
					System.out.println("To access this feature, your account must be verified.");
				}

				break;
			case 4:

				if(((Customer) Driver.authUser).getStatus() == 3) {
					((Customer) Driver.authUser).withdraw();
				}
				
				else {
					System.out.println("To access this feature, your account must be verified.");
				}

				break;
			default:
				System.out.println("\nExiting ...");
				loopBack = false;
				break;
		}
		
		return loopBack;
		
	}

	@Override
	public boolean doEmployeeOption(int code) throws SQLException {
		boolean loopBack = true;

		switch(code) {
			case 0:
				((Employee) Driver.authUser).viewAccount();
				break;
			case 1:
				((Employee) Driver.authUser).viewApplications();
				break;
			case 2:
				((Employee) Driver.authUser).approveApp();
				break;
			case 3:
				((Employee) Driver.authUser).selectCustomerBalance();
				break;
			case 4:
				((Employee) Driver.authUser).denyApp();
				break;
			default:
				System.out.println("\nExiting ...");
				loopBack = false;
				break;
		}
		
		return loopBack;
		
	}

	@Override
	public boolean doAdminOption(int code) throws SQLException {
		boolean loopBack = true;
	
		switch(code) {
			case 0:
				((Admin) Driver.authUser).viewAccount();
				break;
			case 1:
				((Admin) Driver.authUser).viewAllAccounts();
				break;
			case 2:
				((Admin) Driver.authUser).viewUserAccount();
				break;
			case 3:
				((Admin) Driver.authUser).deleteUserAccount();
				break;
			default:
				System.out.println("\nExiting ...");
				loopBack = false;
				break;
		}
		
		return loopBack;
		
	}

	@Override
	public int getIntegerCode() {
		int code = 0;
		boolean loop = true;
		
		while(loop) {
			try {
				code = Integer.parseInt(Driver.read.nextLine());
				loop = false;
			}
			
			catch (NumberFormatException e) {
				System.out.println("Input entered was not a number.");
				System.out.println("Enter one of the following codes above.");
			}
		}
		
		return code;

	}

	@Override
	public int getCustomerOptions() {
		System.out.println("\n===== Customer Account Options =====");
		System.out.println("0: View account status");
		System.out.println("1: Request application");
		System.out.println("2: View account balance");
		System.out.println("3: Deposit");
		System.out.println("4: Withdraw\n");
		System.out.println("Enter any other number to exit.");
		
		return getIntegerCode();
		
	}

	@Override
	public int getEmployeeOptions() {
		System.out.println("\n===== Employee Account Options =====");
		System.out.println("0: View account information");
		System.out.println("1: View pending applications");
		System.out.println("2: Approve pending application");
		System.out.println("3: View customer balance");
		System.out.println("4: Deny pending application\n");
		System.out.println("Enter any other number to exit.");
		
		return getIntegerCode();
	}

	@Override
	public int getAdminOptions() {
		System.out.println("\n===== Admin Account Options =====");
		System.out.println("0: View account information");
		System.out.println("1: View all accounts");
		System.out.println("2: View user information");
		System.out.println("3: Delete user");
		System.out.println("Enter any other number to exit.\n");
		
		return getIntegerCode();
	}

	@Override
	public void viewOptions() throws SQLException {
		int code = 0;
		boolean loop = true;
		String authUserType = Driver.authUser.getType();
		
		while(loop) {
			switch(authUserType) {
				case "Customer":
					code = getCustomerOptions();
					loop = doCustomerOption(code);
					break;
				case "Employee":
					code = getEmployeeOptions();
					loop = doEmployeeOption(code);
					break;
				case "Admin":
					code = getAdminOptions();
					loop = doAdminOption(code);
					break;
				default:
					System.out.println(Driver.authUser + " not authenticated.");
					loop = false;
					break;
			}
		}

	}

	@Override
	public void prompt() throws SQLException {
	
		viewOptions();
		
	}

}
