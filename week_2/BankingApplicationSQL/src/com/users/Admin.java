package com.users;

import java.io.Serializable;
import java.util.InputMismatchException;
import java.util.Scanner;

import com.interfaces.BankingApplicationAdminDao;
import com.interfaces.Menu;
import com.util.dao.BankingApplicationAdminDaoImplementation;

public class Admin extends Employee implements Menu, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6198406213991514241L;
	private static String[] menuString = { "\n=====\nMENU\n=====\n1 )Run SQL commands\n2) End\n=====\n" };
	private static String[] optionString = { "Select an option:" };
	private int menuIndex;

	@Override
	public void displayMenu() {
		System.out.print(menuString[menuIndex]);
	}

	@Override
	public boolean optionInput() {
		BankingApplicationAdminDao ad = new BankingApplicationAdminDaoImplementation();
		System.out.print(optionString[menuIndex]);
		Scanner cScan = new Scanner(System.in);
		String input = cScan.nextLine();
		switch (input) {
		case "1":
			ad.runSQL();
			return true;
		case "2":
			return false;
		default:
			return true;
		}


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
