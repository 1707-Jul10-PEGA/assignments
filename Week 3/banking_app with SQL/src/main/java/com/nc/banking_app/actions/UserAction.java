package com.nc.banking_app.actions;

import java.io.IOException;
import java.io.Serializable;
import java.sql.Connection;
import java.util.List;
import java.util.Scanner;

import com.nc.banking_app.doa.CustomerDoa;
import com.nc.banking_app.doa.EmployeeDOA;
import com.nc.banking_app.doa.UserDOA;
import com.nc.banking_app.users.Account;
import com.nc.banking_app.users.UserFactory;
import com.nc.banking_app.users.Users;

public class UserAction implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Scanner sc = new Scanner(System.in);
	private LoadData ld = new LoadData();
	private UserFactory userFactory = new UserFactory();

	public void control(final int userIndex, Connection conn)
			throws IOException, NumberFormatException, ClassNotFoundException {

		// Customer's actions
		UserDOA uDOA = new UserDOA();
		int userType = uDOA.getUserType(conn, userIndex);
		
		//Customer
		if (userType == 1) {
			String userInput = "M";
			boolean flag = true;
			// Loops forever until user put in Q
			while (flag) {
				System.err.println("CreateAccount(C) or ViewAccounts(V) or Withdraw(W) or Deposit(D) or Quit(Q)");
				userInput = sc.nextLine();
				CustomerDoa cDOA = new CustomerDoa();
				// Apply for account
				if ("C".equalsIgnoreCase(userInput)) {
					//cCreateAccount(myList.get(userIndex));
					//ld.listToFile(myList);
					// View accoount's balance
					cDOA.CreateAccount(conn, userIndex);
				} else if ("V".equalsIgnoreCase(userInput)) {
					//cViewAccounts(myList.get(userIndex));
					//ld.listToFile(myList);
					// Withdraw from account
					cDOA.cViewAccounts(conn, userIndex);
					
				} else if ("W".equalsIgnoreCase(userInput)) {
					//cWithdraw(myList.get(userIndex));
					//ld.listToFile(myList);
					// Deposit from account
					cDOA.Withdraw(conn, userIndex);
				} else if ("D".equalsIgnoreCase(userInput)) {
					//cDeposit(myList.get(userIndex));
					//ld.listToFile(myList);
					// Quit from section
					cDOA.Deposit(conn, userIndex);
				} else if ("Q".equalsIgnoreCase(userInput)) {
					flag = false;
				}
			}

			// Employee's actions
		} else if (userType == 2) {
			EmployeeDOA eDOA = new EmployeeDOA();
			String userInput = "M";
			boolean flag = true;
			while (flag) {
				System.err.println("ApproveDenyApplications(A) or ViewCustomersBalances(V) or Quit(Q)");
				userInput = sc.nextLine();

				// Look at, then approve or deny accounts
				if ("A".equalsIgnoreCase(userInput)) {
					//eApproveDenyApplications(myList);
					//ld.listToFile(myList);
					// Look at anyone's account balance
					eDOA.appDeny(conn, userIndex);
				} else if ("V".equalsIgnoreCase(userInput)) {
					//eViewCustomersBalances(myList);
					// Quit section
				} else if ("Q".equalsIgnoreCase(userInput)) {
					flag = false;
				}
			}

			// Admin's actions
		} else if (userType == 3) {
			String userInput = "M";
			boolean flag = true;
			while (flag) {
				System.err.println(
						"ViewAnyAccounts(V) or EditAnyAccount(E) or CreateUser (C) or DeleteUser (D) or Quit(Q)");
				userInput = sc.nextLine();

				if ("V".equalsIgnoreCase(userInput)) {
					//aViewAnyAccounts(myList);
					// Look at anyone's account balance
				} else if ("E".equalsIgnoreCase(userInput)) {
					//aEditAnyAccount(myList);
					//ld.listToFile(myList);
				} else if ("C".equalsIgnoreCase(userInput)) {
					String type = "";
					do {
						System.err.println("What is the type? Customer(C), Employee(E) or Admin(A)");
						type = sc.nextLine();
					} while ("C".equalsIgnoreCase(type) || "E".equalsIgnoreCase(type) || "A".equalsIgnoreCase(type));
					String name = new String();
					while (name.isEmpty()) {
						System.err.println("What is the name? ");
						name = sc.nextLine();
					}
					Users newUser = userFactory.getType(type, name, 0.0, 0);
					//myList.add(newUser);

					//ld.listToFile(myList);

				} else if ("D".equalsIgnoreCase(userInput)) {
					//for (int x = 0; x < myList.size(); x++) {
					//	System.out.print(myList.get(x).getName() + ", ");
					//}
					System.err.println("\nPick User To Delete or Quit(Q)");
					String name = sc.nextLine();
					if ("Q".equalsIgnoreCase(name)) {
						break;
					} else {
					//	for (int x = 1; x < myList.size(); x++) {
					//		if (myList.get(x).getName().equalsIgnoreCase(name)) {
					//			myList.remove(x);
							}
						}
					}

					//ld.listToFile(myList);

					// Quit section
				//} else if ("Q".equalsIgnoreCase(userInput)) {
				//	flag = false;
				//}
			//}
		}
		// ld.listToFile(myList);
	}

	private void aViewAnyAccounts(List<Users> myList) {
		while (true) {
			String input = new String();
			int userID = 0;
			int accID = 0;
			boolean flag = false;

			for (int x = 0; x < myList.size(); x++) {
				String marker = "";
				if (myList.get(x).getType().equalsIgnoreCase("Customer")) {
					marker = "(C)";
				} else if (myList.get(x).getType().equalsIgnoreCase("Employee")) {
					marker = "(E)";
				} else if (myList.get(x).getType().equalsIgnoreCase("Admin")) {
					marker = "(A)";
				}

				System.out.print(myList.get(x).getName() + marker + ", ");

			}
			// Get name or exit section
			System.err.println("\nThe user's name or Quit(Q)");
			input = sc.nextLine();

			for (int x = 0; x < myList.size(); x++) {
				if (myList.get(x).getName().equalsIgnoreCase(input)) {
					userID = x;
					flag = true;
					break;
				}
			}

			if ("Q".equalsIgnoreCase(input)) {
				break;
			} else if (flag) {
				// Look at all users on the list
				for (int y = 0; y < myList.get(userID).getAccount().size(); y++) {
					System.out.print(myList.get(userID).getAccount().get(y).getAccName());
				}
				System.err.println("\nThe account's name or Quit(Q)");
				input = sc.nextLine();

				for (int y = 0; y < myList.get(userID).getAccount().size(); y++) {
					if (myList.get(userID).getAccount().get(y).getAccName().equalsIgnoreCase(input)) {
						System.out
								.println("The balance is $" + myList.get(userID).getAccount().get(accID).getBalance());
						break;
					}
				}
			}
		}
	}

	private void aEditAnyAccount(List<Users> myList) throws IOException, NumberFormatException, ClassNotFoundException {

		for (int x = 0; x < myList.size(); x++) {
			String marker = "";
			if (myList.get(x).getType().equalsIgnoreCase("Customer")) {
				marker = "(C)";
			} else if (myList.get(x).getType().equalsIgnoreCase("Employee")) {
				marker = "(E)";
			} else if (myList.get(x).getType().equalsIgnoreCase("Admin")) {
				marker = "(A)";
			}
			System.out.print(myList.get(x).getName() + marker + ", ");
		}

		while (true) {
			System.err.println("\nPick user or Quit(Q)");
			String name = sc.nextLine();
			boolean flag = false;
			int userID = 0;
			for (int x = 0; x < myList.size(); x++) {
				if (myList.get(x).getName().equalsIgnoreCase(name)) {
					userID = x;
					flag = true;
					break;
				}
			}
			if ("Q".equalsIgnoreCase(name)) {
				break;
				// Look at account
			} else if (flag) {

				while (true) {
					System.err.println("Edit Name(N) or Account(A) or Quit(Q)");
					String userInput = sc.nextLine();
					if ("N".equalsIgnoreCase(userInput)) {
						while(true){
							System.err.println("What is the new name? ");
							name = sc.nextLine();
							if(name.isEmpty()){
								
							} else{
								myList.get(userID).setName(name);
								break;
							}
						}
						
					} else if ("A".equalsIgnoreCase(userInput)) {
						
						for (int y = 0; y < myList.get(userID).getAccount().size(); y++) {
								System.out.print(myList.get(userID).getAccount().get(y).getAccName() + ", ");
						}
						System.err.println("\nPick account or Quit(Q)");
						String accN = sc.nextLine();
						flag = false;
						int accID = 0;
						for (int y = 0; y < myList.get(userID).getAccount().size(); y++) {
							if (accN.equalsIgnoreCase(myList.get(userID).getAccount().get(y).getAccName())) {
								accID = y;
								flag = true;
								break;
							}
						}
						if ("Q".equalsIgnoreCase(accN)) {
							break;
						} else if (flag) {

							while (true) {

								System.err.println("Edit Name(N) or Status(S) or Balance(B) or Delete(D) or QuitProcess(Q)");
								userInput = sc.nextLine();
								if (userInput.isEmpty()) {

								} else if ("N".equalsIgnoreCase(userInput)) {
									while(true){
										System.err.println("What is the new name? ");
										name = sc.nextLine();
										if(name.isEmpty()){
											
										} else{
											myList.get(userID).getAccount().get(accID).setAccName(name);;
											break;
										}
									}
								} 
								else if ("D".equalsIgnoreCase(userInput)) {
									myList.get(userID).getAccount().remove(accID);
									break;
								} else if ("S".equalsIgnoreCase(userInput)) {
									while(true){
										System.err.println("Inactive(I) or Active(A) or Waiting(W)");
										String input = sc.nextLine();
										if("I".equalsIgnoreCase(input)){
											myList.get(userID).getAccount().get(accID).setActive(0);
											break;
										}else if ("A".equalsIgnoreCase(input)){
											myList.get(userID).getAccount().get(accID).setActive(1);
											break;
										}else if("W".equalsIgnoreCase(input)){
											myList.get(userID).getAccount().get(accID).setActive(-1);
											break;
										}
									}
								}else if ("B".equalsIgnoreCase(userInput)) {
									while(true){
										System.err.println("What is the new balance? or Quit(Q)");
										double input = sc.nextDouble();
										if(input >= 0){
											myList.get(userID).getAccount().get(accID).setBalance(input);
											System.out.println("The new balance is $" + myList.get(userID).getAccount().get(accID).getBalance());
											break;
										}
									}
									
								}
								else if ("Q".equalsIgnoreCase(userInput)) {
									break;
								}
							}
						}
						
					} else if ("Q".equalsIgnoreCase(userInput)) {
						break;
					}
				}
			}
		}
	}

	// employee's action of viewing anyone's balance
	private void eViewCustomersBalances(List<Users> myList) {
		while (true) {
			String input = new String();
			int userID = 0;
			int accID = 0;
			boolean flag = false;

			for (int x = 0; x < myList.size(); x++) {
				if (myList.get(x).getType().equalsIgnoreCase("Customer")) {
					System.out.println(myList.get(x).getName() + ", ");
				}
			}
			// Get name or exit section
			System.err.println("The user's name or Quit(Q)");
			input = sc.nextLine();

			for (int x = 0; x < myList.size(); x++) {
				if (myList.get(x).getName().equalsIgnoreCase(input)
						&& myList.get(x).getType().equalsIgnoreCase("Customer")) {
					userID = x;
					flag = true;
					break;
				}
			}

			if ("Q".equalsIgnoreCase(input)) {
				break;
			} else if (flag) {
				// Look at all users on the list
				for (int y = 0; y < myList.get(userID).getAccount().size(); y++) {
					System.out.println(myList.get(userID).getAccount().get(y).getAccName());
				}
				System.err.println("The account's name or Quit(Q)");
				input = sc.nextLine();

				for (int y = 0; y < myList.get(userID).getAccount().size(); y++) {
					if (myList.get(userID).getAccount().get(y).getAccName().equalsIgnoreCase(input)
							&& myList.get(userID).getType().equalsIgnoreCase("Customer")) {
						System.out
								.println("The balance is $" + myList.get(userID).getAccount().get(accID).getBalance());
						break;
					}
				}
			}
		}
	}

	// employee's action of Approve or Deny accounts (NOT DONE YET)
	private void eApproveDenyApplications(List<Users> myList) throws IOException {
		while (true) {
			String name = new String();
			String accN = new String();
			String userInput = new String();
			boolean flag = false;
			// Check and select a name
			for (int x = 0; x < myList.size(); x++) {
				for (int y = 0; y < myList.get(x).getAccount().size(); y++) {
					if (myList.get(x).getAccount().get(y).getActive() == -1) {
						System.out.println(myList.get(x).getName() + ", ");
						break;
					}
				}
			}
			System.err.println("\nPick user or Quit(Q)");
			int userID = 0;
			name = sc.nextLine();
			for (int x = 0; x < myList.size(); x++) {
				for (int y = 0; y < myList.get(x).getAccount().size(); y++) {
					if (myList.get(x).getName().equalsIgnoreCase(name)
							&& myList.get(x).getAccount().get(y).getActive() == -1) {
						flag = true;
						userID = x;
						break;
					}
					if (flag) {
						break;
					}
				}
			}
			// Ignore name if empty
			if ("Q".equalsIgnoreCase(name)) {
				break;

			} else if (flag) {
				while (true) {
					for (int y = 0; y < myList.get(userID).getAccount().size(); y++) {
						if (myList.get(userID).getAccount().get(y).getActive() == -1) {
							System.out.print(myList.get(userID).getAccount().get(y).getAccName() + ", ");
						}
					}
					System.err.println("Pick account or Quit(Q)");
					accN = sc.nextLine();
					flag = false;
					int accID = 0;
					for (int y = 0; y < myList.get(userID).getAccount().size(); y++) {
						if (accN.equalsIgnoreCase(myList.get(userID).getAccount().get(y).getAccName())
								&& myList.get(userID).getAccount().get(y).getActive() == -1) {
							accID = y;
							flag = true;
							break;
						}
					}
					if ("Q".equalsIgnoreCase(accN)) {
						break;
					} else if (flag) {

						while (true) {

							System.err.println("Approve(A) or Deny(D) or QuitProcess(Q)");
							userInput = sc.nextLine();
							if (userInput.isEmpty()) {

							} else if ("A".equalsIgnoreCase(userInput)) {
								myList.get(userID).getAccount().get(accID).setActive(1);
								break;
							} else if ("D".equalsIgnoreCase(userInput)) {
								myList.get(userID).getAccount().get(accID).setActive(0);
								break;
							}
						}
					}
				}
			}
		}
	}

	public void cCreateAccount(Users user) throws IOException {
		while (true) {
			String name = new String();
			System.err.println("What is your new account's name? or Quit(Q)");
			name = sc.nextLine();
			if (name.isEmpty()) {

			} else if ("Q".equalsIgnoreCase(name)) {
				break;
			} else {
				Account newA = new Account(name);
				user.getAccount().add(newA);
			}
		}
	}

	public void cViewAccounts(Users user) {
		while (true) {
			String name = new String();
			for (int x = 0; x < user.getAccount().size(); x++) {
				String marker = "";
				if (user.getAccount().get(x).getActive() == 0) {
					marker = "(Inactive)";
				} else if (user.getAccount().get(x).getActive() == -1) {
					marker = "(Waiting)";
				} else if (user.getAccount().get(x).getActive() == 1) {
					marker = "(Active)";
				}
				System.out.print(user.getAccount().get(x).getAccName() + marker + ", ");
			}

			System.err.println("\nChoose an account? or Quit(Q)");
			name = sc.nextLine();
			if (name.isEmpty()) {

			} else if ("Q".equalsIgnoreCase(name)) {
				break;
			} else {
				for (int x = 0; x < user.getAccount().size(); x++) {
					if (user.getAccount().get(x).getAccName().equalsIgnoreCase(name)) {
						System.out.println(user.getAccount().get(x).getAccName() + " has $"
								+ user.getAccount().get(x).getBalance());
						if (user.getAccount().get(x).getActive() == 0) {
							while (true) {
								System.err.println("Do you want to activate? Yes(Y) or No(N)");
								String input = sc.nextLine();
								if (input.isEmpty()) {
								} else if ("Y".equalsIgnoreCase(input)) {
									user.getAccount().get(x).setActive(-1);
									System.out.println("Waiting for employee review...");
									break;
								} else if ("N".equalsIgnoreCase(input)) {
									break;
								}
							}
						}
					}
				}
			}
		}
	}

	public void cWithdraw(Users user) {
		String name = new String();
		boolean flag = false;
		while (true) {
			for (int x = 0; x < user.getAccount().size(); x++) {
				if (user.getAccount().get(x).getActive() == 1) {
					System.out.print(user.getAccount().get(x).getAccName() + ", ");
				}
			}

			System.err.println("\nChoose an account? or Quit(Q)");
			name = sc.nextLine();
			flag = false;
			for (int x = 0; x < user.getAccount().size(); x++) {
				if (user.getAccount().get(x).getAccName().equalsIgnoreCase(name)
						&& user.getAccount().get(x).getActive() == 1) {
					flag = true;
					break;
				}
			}
			if ("Q".equalsIgnoreCase(name)) {
				break;
			} else if (flag) {
				for (int x = 0; x < user.getAccount().size(); x++) {
					if (user.getAccount().get(x).getAccName().equalsIgnoreCase(name)
							&& user.getAccount().get(x).getActive() == 1) {
						double money = -1;
						System.err.println("How much do you want to withdraw?");
						money = sc.nextDouble();
						if (money > 0 && money <= user.getAccount().get(x).getBalance()) {
							double newB = user.getAccount().get(x).getBalance() - money;
							user.getAccount().get(x).setBalance(newB);
							System.out.println("Your new balance is: $" + user.getAccount().get(x).getBalance());
							break;
						}
					}
				}
			}
		}
	}

	public void cDeposit(Users user) { /// List<Users> myList, int userIndex
		String name = new String();
		boolean flag = false;

		while (true) {
			for (int x = 0; x < user.getAccount().size(); x++) {
				if (user.getAccount().get(x).getActive() == 1) {
					System.out.print(user.getAccount().get(x).getAccName() + ", ");
				}
			}

			System.err.println("\nChoose an account? or Quit(Q)");
			name = sc.nextLine();
			flag = false;
			for (int x = 0; x < user.getAccount().size(); x++) {
				if (user.getAccount().get(x).getAccName().equalsIgnoreCase(name)
						&& user.getAccount().get(x).getActive() == 1) {
					flag = true;
					break;
				}
			}
			if ("Q".equalsIgnoreCase(name)) {
				break;
			} else if (flag) {
				for (int x = 0; x < user.getAccount().size(); x++) {
					if (user.getAccount().get(x).getAccName().equalsIgnoreCase(name)
							&& user.getAccount().get(x).getActive() == 1) {
						double money = -1;
						System.err.println("How much do you want to deposit?");
						money = sc.nextDouble();
						if (money > 0) {
							double newB = user.getAccount().get(x).getBalance() + money;
							user.getAccount().get(x).setBalance(newB);
							System.out.println("Your new balance is: $" + user.getAccount().get(x).getBalance());
							break;
						}
					}
				}
			}
		}
	}
}
