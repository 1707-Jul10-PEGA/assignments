package com.bank.menu;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.bank.admin.Admin;
import com.bank.customer.Customer;
import com.bank.employee.Employee;
import com.bank.user.User;

public abstract class Menu {

	abstract void menuHandler(List<Admin> admins, List<Employee> employees, ArrayList<Customer> customers, ArrayList<String[]> toApprove) throws SQLException;
	abstract void startingMenu() throws SQLException;
	abstract User addCustomer(String username, String password, List<Customer> userList, String first, String last) throws SQLException;
	abstract void empMenu(Employee e, List<Customer> customers) throws SQLException;
	abstract void custMenu(Customer c, ArrayList<Customer> customers) throws SQLException;
	abstract void adminMenu(Admin a, List<Customer> customers) throws SQLException;
}
