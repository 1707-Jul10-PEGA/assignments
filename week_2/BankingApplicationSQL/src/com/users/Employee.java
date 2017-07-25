package com.users;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.Scanner;

import com.interfaces.BankingApplicationEmployeeDao;
import com.interfaces.Menu;
import com.util.dao.BankingApplicationEmployeeDaoImplementation;

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
		BankingApplicationEmployeeDao ed = new BankingApplicationEmployeeDaoImplementation();
		System.out.print(optionString[0]);
		Scanner cScan = new Scanner(System.in);
		String input = cScan.nextLine();
		switch (input) {
		case "1":
			try {
				ed.viewCustomerBalances(this.getUser_id());
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return true;
		case "2":
			try {
				ed.approveDeny(this.getUser_id());
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return true;
		case "3":
			return false;
		default:
			return true;
		}

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
