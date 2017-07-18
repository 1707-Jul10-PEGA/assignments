package com.users;

import java.io.Serializable;
import java.util.InputMismatchException;
import java.util.Scanner;

import com.interfaces.Menu;

public class Admin extends Employee implements Menu, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6198406213991514241L;
	private static String[] menuString = {
			"\n=====\nMENU\n=====\n1 )Add balance\n2 )Subtract balance\n3 )Approve/Deny\n4 )View balances\n5) End\n=====\n" };
	private static String[] optionString = { "Select an option:" };
	private int menuIndex;

	@Override
	public void displayMenu() {
		System.out.print(menuString[menuIndex]);
	}

	@Override
	public boolean optionInput() {
		System.out.print(optionString[menuIndex]);
		Scanner cScan = new Scanner(System.in);
		String input = cScan.nextLine();
		int custUID1;
		boolean found1;
		switch (input) {
		case "1":
			while (true) {
				try {
					System.out.print("Enter the UID of the customer: ");
					custUID1 = cScan.nextInt();
				} catch (InputMismatchException e) {
					System.out.println("  **Invalid UID input detected");
					continue;
				}
				break;
			}
			found1 = false;
			for (User ac : AllUsers.users.get(AllUsers.CUSTOMER_INDEX)) {
				if (ac.getUniqueID() == custUID1) {
					System.out
							.println("\tName: " + ((Customer) ac).getFirstName() + " " + ((Customer) ac).getLastName());
					for (Customer.Account account : ((Customer) ac).accountBalances) {
						double amount = 0;
						while (true) {
							try {
								System.out.print(
										"How much to add to this account (" + account.getAccountName() + "): ");
								cScan = new Scanner(System.in);
								amount = cScan.nextDouble();
								break;
							} catch (InputMismatchException e) {
								System.out.println(" ** Invalid input");
								continue;
							}

						}
						account.addBalance(amount);
						System.out.println("  ** Added: " + amount + " **\n");
						System.out.println("Balance: " + account.getBalance());
					}

					found1 = true;
					break;
				}
			}
			if (!found1) {
				System.out.println("\t No such customer with that specific UID");
			}
			return true;
		case "2":
			while (true) {
				try {
					System.out.print("Enter the UID of the customer: ");
					custUID1 = cScan.nextInt();
				} catch (InputMismatchException e) {
					System.out.println("  **Invalid UID input detected");
					continue;
				}
				break;
			}
			found1 = false;
			for (User ac : AllUsers.users.get(AllUsers.CUSTOMER_INDEX)) {
				if (ac.getUniqueID() == custUID1) {
					System.out
							.println("\tName: " + ((Customer) ac).getFirstName() + " " + ((Customer) ac).getLastName());
					for (Customer.Account account : ((Customer) ac).accountBalances) {
						double amount = 0;
						while (true) {
							try {
								System.out.print(
										"How much to subract from this account (" + account.getAccountName() + "): ");
								cScan = new Scanner(System.in);
								amount = cScan.nextDouble();
								break;
							} catch (InputMismatchException e) {
								System.out.println(" ** Invalid input");
								continue;
							}

						}
						account.addBalance(amount);
						System.out.println("  ** Subtracted: " + amount + " **\n");
						System.out.println("Balance: " + account.getBalance());
					}

					found1 = true;
					break;
				}
			}
			if (!found1) {
				System.out.println("\t No such customer with that specific UID");
			}
			return true;
			case "3":
				System.out.print("Enter the UID of the customer: ");
				int custUID111;
				while (true) {
					try {
						cScan = new Scanner(System.in);
						custUID111 = cScan.nextInt();
					} catch (InputMismatchException e) {
						System.out.println("  **Invalid UID input detected");
						continue;
					}
					break;
				}
				boolean found111 = false;
				for (User ac : AllUsers.users.get(AllUsers.CUSTOMER_INDEX)) {
					if (ac.getUniqueID() == custUID111) {
						System.out.println(
								"\tName: " + ((Customer) ac).getFirstName() + " " + ((Customer) ac).getLastName());
						for (Customer.Account account : ((Customer) ac).pendingAccounts) {
							String aOrD;
							while (true) {
								System.out.println("Approve/Deny account: " + account.getAccountName());
								cScan = new Scanner(System.in);
								aOrD = cScan.nextLine();
								if ("approve".equalsIgnoreCase(aOrD)) {
									((Customer) ac).accountBalances.add(account);
									System.out.println("\t Added account");
									break;
								} else if ("deny".equalsIgnoreCase(aOrD)) {
									System.out.println("\t Account denied");
								} else {
									System.out.println("   **Please type \"approve\" or \"deny\"");
								}
							}
						}

						found111 = true;
						((Customer) ac).pendingAccounts.clear();
						break;
					}
				}
				if (!found111) {
					System.out.println("\t No such customer with that specific UID");
				}
				return true;
			case "4":
				System.out.print("Enter the UID of the customer: ");
				int custUID;
				while (true) {
					try {
						cScan = new Scanner(System.in);
						custUID = cScan.nextInt();
					} catch (InputMismatchException e) {
						System.out.println("  **Invalid UID input detected");
						continue;
					}
					break;
				}
				boolean found = false;
				for (User ac : AllUsers.users.get(AllUsers.CUSTOMER_INDEX)) {
					if (ac.getUniqueID() == custUID) {
						System.out.println(
								"\tName: " + ((Customer) ac).getFirstName() + " " + ((Customer) ac).getLastName());
						((Customer) ac).displayAccounts();
						found = true;
						break;
					}
				}
				if (!found) {
					System.out.println("\t No such customer with that specific UID");
				}
				return true;
			case "5":
				AllUsers.writeAllUsers();
				break;
			}
		
	return false;

}

	@Override
	public String toString() {
		return "Admin [getFirstName()=" + getFirstName() + ", getLastName()=" + getLastName() + ", getUserName()="
				+ getUserName() + ", getPassword()=" + getPassword() + ", getAge()=" + getAge() + ", toString()="
				+ super.toString() + ", hashCode()=" + hashCode() + ", getClass()=" + getClass() + "]";
	}

	public Admin() {
		super();
		// TODO Auto-generated constructor stub
		this.setAge(23);
		this.setFirstName("Admin");
		this.setLastName("Admin");
		this.setUserName("Admin");
		this.setPassword("abc123");
		menuIndex = 0;
	}

}
