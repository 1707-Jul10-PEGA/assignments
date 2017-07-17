package com.dv.bankingapp;

public class Dashboard implements DashboardInterface {
	
	@Override
	public boolean doCustomerOption(User authUser, int code) {
		boolean loopBack = true;
	
		switch(code) {
			case 0:
				((Customer) authUser).viewAccount();
				break;
			case 1:
				((Customer) authUser).apply(authUser);
				break;
			case 2:
				((Customer) authUser).viewBalance();
				break;
			case 3:
				((Customer) authUser).deposit(authUser);
				break;
			case 4:
				((Customer) authUser).withdraw(authUser);
				break;
			default:
				System.out.println("\nExiting ...");
				loopBack = false;
				break;
		}
		
		return loopBack;
		
	}

	@Override
	public boolean doEmployeeOption(User authUser, int code) {
		boolean loopBack = true;

		switch(code) {
			case 0:
				((Employee) authUser).viewAccount();
				break;
			case 1:
				((Employee) authUser).viewApplications();
				break;
			case 2:
				((Employee) authUser).approveApp();
				break;
			case 3:
				((Employee) authUser).viewBalance();
				break;
			case 4:
				((Employee) authUser).denyApp();
				break;
			default:
				System.out.println("\nExiting ...");
				loopBack = false;
				break;
		}
		
		return loopBack;
		
	}

	@Override
	public boolean doAdminOption(User authUser, int code) {
		boolean loopBack = true;
	
		switch(code) {
			case 0:
				((Admin) authUser).viewAccount();
				break;
			case 1:
				((Admin) authUser).viewAccount();
				break;
			case 2:
				// edit user
				break;
			case 3:
				// delete user
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
		System.out.println("0: View account status");
		System.out.println("1: View account for user");
		System.out.println("2: Edit a user");
		System.out.println("3: Delete a user");
		System.out.println("Enter any other number to exit.\n");
		
		return getIntegerCode();
	}

	@Override
	public void viewOptions(User authUser) {
		int code = 0;
		boolean loop = true;
		String authUserType = authUser.getType();
		
		while(loop) {
			switch(authUserType) {
				case "Customer":
					code = getCustomerOptions();
					loop = doCustomerOption(authUser, code);
					break;
				case "Employee":
					code = getEmployeeOptions();
					loop = doEmployeeOption(authUser, code);
					break;
				case "Admin":
					code = getAdminOptions();
					loop = doAdminOption(authUser, code);
					break;
				default:
					System.out.println(authUser + " not authenticated.");
					loop = false;
					break;
			}
		}

	}

	@Override
	public void prompt(User authUser) {
	
		viewOptions(authUser);
		
	}

}
