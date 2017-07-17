package com.as.bankingapp.inputchecker;

import com.as.bankingapp.admin.Admin;
import com.as.bankingapp.customer.Customer;
import com.as.bankingapp.employee.Employee;
import com.as.bankingapp.user.User;

public class InputChecker {

	/*
	 * check that a given string is a valid user name
	 * a username cannot contain any spaces and cannot be exit
	 */
	public static boolean isValidUserName(String name) {
		if (name.split(" ").length > 1 || "exit".equals(name)) {
			return false;
		} else {
			return true;
		}
	}
	
	/*
	 * check that a given string contains only numbers
	 */
	public static boolean isNumber(String num) {
		try {
			Double.valueOf(num);
			return true;
		} catch (NumberFormatException e) {
			return false;
		}
	}
	
	/*
	 * checks that a command is a valid customer command
	 */
	public static boolean isValidCustomerCommand(String command) {
		String[] str = command.split(" ");
		if (str.length > 0 && str.length < 3) {
			if (str.length == 1) {
				//check for view and apply
				if ("view".equals(str[0]) || "apply".equals(str[0])) {
					return true;
				} else {
					return false;
				}
			} else {
				//check for withdraw and deposit
				if ("deposit".equals(str[0]) || "withdraw".equals(str[0])) {
					return InputChecker.isNumber(str[1]);
				} else {
					return false;
				}
			}
		} else {
			return false;
		}
	}
	
	/*
	 * checks that a string is a valid command for an employee
	 */
	public static boolean isValidEmployeeCommand(String command) {
		String[] str = command.split(" ");
		if (str.length == 2) {
				if ("view".equals(str[0]) || "approve".equals(str[0]) || "deny".equals(str[0])) {
					return InputChecker.isNumber(str[1]);
				} else {
					return false;
				}
		}else if (str.length == 1) {
			if ("viewp".equals(str[0]) || "viewmine".equals(str[0])) {
				return true;
			} else {
				return false;
			}
		} else {
			return false;
		}
	}
	
	/*
	 * check that a string is a valid command for an admin
	 */
	public static boolean isValidAdminCommand(String command) {
		boolean employeeCommand = isValidEmployeeCommand(command);
		if (employeeCommand) {
			return employeeCommand;
		}
		String[] str = command.split(" ");
		if (str.length == 1 && "viewall".equals(str[0])) {
			return true;
		} else if (str.length == 3 && "set".equals(str[0])) {
			if (InputChecker.isNumber(str[1])) {
				return InputChecker.isNumber(str[2]);
			} else {
				return false;
			}
		} else {
			return false;
		}
	}
	
	/*
	 * given a command and a user checks if that command is valid for the user to use
	 */
	public static boolean isValidCommand(String com, User user) {
		if ("exit".equals(com) || "loggout".equals(com) || "commands".equals(com)) {
			return true;
		}
		if (user instanceof Customer) {
			return InputChecker.isValidCustomerCommand(com);
		} else if (user instanceof Employee) {
			return InputChecker.isValidEmployeeCommand(com);
		} else if (user instanceof Admin) {
			return InputChecker.isValidAdminCommand(com);
		} else {
			return false;
		}
	}
}
