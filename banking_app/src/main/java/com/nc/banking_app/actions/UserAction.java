package com.nc.banking_app.actions;

import java.io.IOException;
import java.io.Serializable;
import java.util.List;
import java.util.Scanner;

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

	public void control(List<Users> myList, int userIndex)
			throws IOException, NumberFormatException, ClassNotFoundException {

		// Customer's actions
		if ("Customer".equalsIgnoreCase(myList.get(userIndex).getType())) {
			String userInput = "M";
			boolean flag = true;
			// Loops forever until user put in Q
			while (flag) {
				System.err.println("ApplyForAccount(A) or ViewBalance(V) or Withdraw(W) or Deposit(D) or Quit(Q)");
				userInput = sc.nextLine();

				// Apply for account
				if ("A".equalsIgnoreCase(userInput)) {
					cApplyForAccount(myList, userIndex);
					ld.listToFile(myList);
					// View accoount's balance
				} else if ("V".equalsIgnoreCase(userInput)) {
					cViewBalance(myList.get(userIndex));
					// Withdraw from account
				} else if ("W".equalsIgnoreCase(userInput)) {
					cWithdraw(myList, userIndex);
					ld.listToFile(myList);
					// Deposit from account
				} else if ("D".equalsIgnoreCase(userInput)) {
					cDeposit(myList, userIndex);
					ld.listToFile(myList);
					// Quit from section
				} else if ("Q".equalsIgnoreCase(userInput)) {
					flag = false;
				}
			}

			// Employee's actions
		} else if ("Employee".equalsIgnoreCase(myList.get(userIndex).getType())) {
			String userInput = "M";
			boolean flag = true;
			while (flag) {
				System.err.println("ApproveDenyApplications(A) or ViewCustomersBalances(V) or Quit(Q)");
				userInput = sc.nextLine();

				// Look at, then approve or deny accounts
				if ("A".equalsIgnoreCase(userInput)) {
					eApproveDenyApplications(myList);
					ld.listToFile(myList);
					// Look at anyone's account balance
				} else if ("V".equalsIgnoreCase(userInput)) {
					eViewCustomersBalances(myList);
					// Quit section
				} else if ("Q".equalsIgnoreCase(userInput)) {
					flag = false;
				}
			}

			// Admin's actions
		} else if ("Admin".equalsIgnoreCase(myList.get(userIndex).getType())) {
			String userInput = "M";
			boolean flag = true;
			while (flag) {
				System.err.println(
						"ViewAnyAccounts(V) or EditAnyAccount(E) or CreateUser (C) or DeleteUser (D) or Quit(Q)");
				userInput = sc.nextLine();

				if ("V".equalsIgnoreCase(userInput)) {
					aViewAnyAccounts(myList);
					// Look at anyone's account balance
				} else if ("E".equalsIgnoreCase(userInput)) {
					aEditAnyAccount(myList);
					ld.listToFile(myList);
				} else if ("C".equalsIgnoreCase(userInput)) {
					String type ="";
					do{
						System.out.println("What is the type? Customer(C), Employee(E) or Admin(A)");
						type = sc.nextLine();
					}while("C".equalsIgnoreCase(type) || "E".equalsIgnoreCase(type) || "A".equalsIgnoreCase(type));
					String name = new String();
					while(name.isEmpty()){
						System.out.println("What is the name? ");
						name = sc.nextLine();
					}
					Users newUser = userFactory.getType(type, name, 0.0, 0);
					myList.add(newUser);

					ld.listToFile(myList);

				} else if ("D".equalsIgnoreCase(userInput)) {
					for (int x = 0; x < myList.size(); x++) {
						System.out.print(myList.get(x).getName() + ", ");
					}
					System.err.println("\nPick User To Delete or Quit(Q)");
					String name = sc.nextLine();
					if ("Q".equalsIgnoreCase(name)) {
						break;
					} else {
						for (int x = 1; x < myList.size(); x++) {
							if (myList.get(x).getName().equalsIgnoreCase(name)) {
								myList.remove(x);
							}
						}

					}

					ld.listToFile(myList);

					// Quit section
				} else if ("Q".equalsIgnoreCase(userInput)) {
					flag = false;
				}
			}
		}
		// ld.listToFile(myList);
	}

	private void aViewAnyAccounts(List<Users> myList) {
		// Display all name
		for (int x = 0; x < myList.size(); x++) {
			System.out.print(myList.get(x).getName() + ", ");
		}

		while (true) {
			System.err.print("\nPick user or Quit(Q)");
			String name = sc.nextLine();
			// Ignore name if empty
			if (name.isEmpty()) {
				// Exit section
			} else if ("Q".equalsIgnoreCase(name)) {
				break;
				// Look at account
			} else {

				for (int x = 0; x < myList.size(); x++) {
					if (myList.get(x).getName().equalsIgnoreCase(name)) {
						System.out.println("Name: " + myList.get(x).getName());
						System.out.println("Type: " + myList.get(x).getType());
						System.out.println("Balance: " + myList.get(x).getBalance());
						if (myList.get(x).getMemeber() == 0) {
							System.out.println("Account Status: Not Activated");
						} else if (myList.get(x).getMemeber() == -1) {
							System.out.println("Account Status: Wait For Approval");
						} else if (myList.get(x).getMemeber() == 1) {
							System.out.println("Account Status: Activated");
						}
					}

				}
			}
		}
	}

	private void aEditAnyAccount(List<Users> myList) throws IOException, NumberFormatException, ClassNotFoundException {
		//
		//
		for (int x = 0; x < myList.size(); x++) {
			System.out.print(myList.get(x).getName() + ", ");
		}

		while (true) {
			System.err.println("\nPick user or Quit(Q)");
			String name = sc.nextLine();
			// Ignore name if empty
			if (name.isEmpty()) {
				// Exit section
			} else if ("Q".equalsIgnoreCase(name)) {
				break;
				// Look at account
			} else {

				for (int x = 0; x < myList.size(); x++) {
					if (name.equalsIgnoreCase(myList.get(x).getName())) {
						while (true) {
							System.err.println("Edit Name(N) or Balance(B) or AccountStatus(A) or Quit(Q)");
							String userInput = sc.nextLine();
							if ("N".equalsIgnoreCase(userInput)) {
								System.out.println("What is the new name? ");
								myList.get(x).setName(sc.nextLine());
								ld.listToFile(myList);
							} else if ("B".equalsIgnoreCase(userInput)) {
								System.out.println("What is the new balance? ");
								double b = sc.nextDouble();
								if (b > 0) {
									myList.get(x).setBalance(b);
									ld.listToFile(myList);
								}

							} else if ("A".equalsIgnoreCase(userInput)) {
								System.err.println(
										"What is the new account status? NotActivated(0) or WaitForApproval(-1) or Activated(1)");
								int acc = sc.nextInt();
								if (acc == 0 || acc == 1 || acc == -1) {
									myList.get(x).setMemeber(acc);
									ld.listToFile(myList);
								}

							} else if ("Q".equalsIgnoreCase(userInput)) {
								break;
							}
						}
					}

				}
			}
		}
	}

	// employee's action of viewing anyone's balance
	private void eViewCustomersBalances(List<Users> myList) {
		String name = new String();
		while (true) {

			// Get name or exit section
			System.err.println("The user's name or Quit(Q)");
			name = sc.nextLine();
			if (name.isEmpty()) {
			} else if ("Q".equalsIgnoreCase(name)) {
				break;
			} else {
				// Look at all users on the list
				for (int x = 0; x < myList.size(); x++) {
					if (myList.get(x).getName().equalsIgnoreCase(name)) {
						// Display balance
						System.out.println(
								myList.get(x).getName() + "'s balance is $" + myList.get(x).getBalance() + "\n");
						break;
					}
				}
			}
		}
	}

	// employee's action of Approve or Deny accounts (NOT DONE YET)
	private void eApproveDenyApplications(List<Users> myList) throws IOException {
		String name = new String();
		String userInput = new String();

		while (true) {

			// Check and select a name
			for (int x = 0; x < myList.size(); x++) {
				if (myList.get(x).getMemeber() == -1) {
					System.out.print(myList.get(x).getName() + ", ");
				}
			}
			System.err.println("\nPick user or Quit(Q)");
			name = sc.nextLine();
			// Ignore name if empty
			if (name.isEmpty()) {
				// Exit section
			} else if ("Q".equalsIgnoreCase(name)) {
				break;
				// Approve or Deny accounts
			} else {

				for (int x = 0; x < myList.size(); x++) {
					if (name.equalsIgnoreCase(myList.get(x).getName()) && myList.get(x).getMemeber() == -1) {
						System.err.println(
								"Approve(A) or Deny(D) " + myList.get(x).getName() + "'s Account or QuitProcess(Q)");
						userInput = sc.nextLine();
						if ("A".equalsIgnoreCase(userInput)) {
							// Approve by Changing member from -1 to 1
							myList.get(x).setMemeber(1);
							break;
						} else if ("D".equalsIgnoreCase(userInput)) {
							// Deny by Changing member from -1 to 0
							myList.get(x).setMemeber(0);
							break;
						} else if ("Q".equalsIgnoreCase(userInput)) {
							break;
						}
					}

				}
			}
		}
	}

	public void cApplyForAccount(List<Users> myList, int userIndex) throws IOException {
		if (myList.get(userIndex).getMemeber() == 0) {
			// Flag that tells if user wants to apply
			myList.get(userIndex).setMemeber(-1);
		}
		
	}

	public void cViewBalance(Users user) {
		if (user.getMemeber() == 1) {
			System.out.println("$" + user.getBalance() + "\n");
		}
	}

	public void cWithdraw(List<Users> myList, int userIndex) {
		if (myList.get(userIndex).getMemeber() == 1) {
			double money = -1;
			System.out.println("How much do you want to withdraw? $");
			money = sc.nextDouble();
			if (money > 0 && money <= myList.get(userIndex).getBalance()) {
				myList.get(userIndex).setBalance(myList.get(userIndex).getBalance() - money);
			}
		}

	}

	public void cDeposit(List<Users> myList, int userIndex) {
		if (myList.get(userIndex).getMemeber() == 1) {
			double money = -1;
			System.out.println("How much do you want to deposit? $");
			money = sc.nextDouble();
			if (money > 0) {
				myList.get(userIndex).setBalance(myList.get(userIndex).getBalance() + money);
			}

		}

	}
}
