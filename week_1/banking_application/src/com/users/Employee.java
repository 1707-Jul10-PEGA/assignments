package com.users;

import java.io.Serializable;
import java.util.InputMismatchException;
import java.util.Scanner;

import com.interfaces.Menu;

public class Employee extends User implements Menu, Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 2310874586316300994L;
	double salary;
	String department;
	String ID;

	@Override
	public String toString() {
		return "Employee [salary=" + salary + ", department=" + department + ", ID=" + ID + ", getFirstName()="
				+ getFirstName() + ", getLastName()=" + getLastName() + ", getUserName()=" + getUserName()
				+ ", getPassword()=" + getPassword() + ", getAge()=" + getAge() + ", toString()=" + super.toString()
				+ ", hashCode()=" + hashCode() + ", getClass()=" + getClass() + "]";
	}

	private static String[] menuStrings = {
			"\n=====\nMENU\n=====\n1 )View balances\n2 )Deny/Approve\n3 )End session\n=====\n",
			"Enter deposit amount: ", "Enter withdrawal amount: ", "** BYE **" };
	private static String[] optionString = { "Enter an option (1, 2, 3, ..): " };
	private int menuIndex;

	@Override
	public void displayMenu() {
		System.out.print(menuStrings[menuIndex]);
	}

	@Override
	public boolean optionInput() {
		System.out.print(optionString[menuIndex]);
		Scanner cScan = new Scanner(System.in);
		String input = cScan.nextLine();
		switch (input) {
		case "1":
			System.out.print("Enter the UID of the customer: ");
			int custUID;
			while (true) {
				try {
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
					System.out
							.println("\tName: " + ((Customer) ac).getFirstName() + " " + ((Customer) ac).getLastName());
					((Customer) ac).displayAccounts();
					found = true;
					break;
				}
			}
			if (!found) {
				System.out.println("\t No such customer with that specific UID");
			}
			return true;
		case "2":
			System.out.print("Enter the UID of the customer: ");
			int custUID1;
			while (true) {
				try {
					custUID1 = cScan.nextInt();
				} catch (InputMismatchException e) {
					System.out.println("  **Invalid UID input detected");
					continue;
				}
				break;
			}
			boolean found1 = false;
			for (User ac : AllUsers.users.get(AllUsers.CUSTOMER_INDEX)) {
				if (ac.getUniqueID() == custUID1) {
					System.out.println("\tName: " + ((Customer) ac).getFirstName() + " " + ((Customer) ac).getLastName());
					for (Customer.Account account : ((Customer) ac).pendingAccounts) {
						String aOrD;
						while (true) {
							System.out.println("Approve/Deny account: " + account.getAccountName());
							cScan = new Scanner(System.in);
							aOrD = cScan.nextLine();
							if("approve".equalsIgnoreCase(aOrD)){
								((Customer)ac).accountBalances.add(account);
								System.out.println("\t Added account");
								break;
							}else if("deny".equalsIgnoreCase(aOrD)){
								System.out.println("\t Account denied");
							}else{
								System.out.println("   **Please type \"approve\" or \"deny\"");
							}
						}
					}
					
					found1 = true;
					((Customer)ac).pendingAccounts.clear();
					break;
				}
			}
			if (!found1) {
				System.out.println("\t No such customer with that specific UID");
			}
			return true;
		case "3":
			AllUsers.writeAllUsers();
			return false;

		}

		return false;

	}

	public Employee() {
		super();
		// TODO Auto-generated constructor stub
		this.setAge(23);
		this.setFirstName("Employee");
		this.setLastName("Employee");
		this.setUserName("Emp");
		this.setPassword("abc123");
		menuIndex = 0;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Employee other = (Employee) obj;
		if (ID == null) {
			if (other.ID != null)
				return false;
		} else if (!ID.equals(other.ID))
			return false;
		if (department == null) {
			if (other.department != null)
				return false;
		} else if (!department.equals(other.department))
			return false;
		if (Double.doubleToLongBits(salary) != Double.doubleToLongBits(other.salary))
			return false;
		return true;
	}

}
