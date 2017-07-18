package com.bank.menu;

import java.util.ArrayList;
import java.util.List;

import com.bank.admin.Admin;
import com.bank.customer.Customer;
import com.bank.employee.Employee;
import com.bank.user.User;

public abstract class Menu {

	abstract void menuHandler(List<Admin> admins, List<Employee> employees, ArrayList<Customer> customers, ArrayList<String[]> toApprove);
	abstract void startingMenu();
	abstract User addCustomer(String username, String password, List<Customer> userList, String first, String last);
	abstract void empMenu(Employee e, List<Customer> customers);
	abstract void custMenu(Customer c, ArrayList<Customer> customers);
	abstract void adminMenu(Admin a, List<Customer> customers);
}
