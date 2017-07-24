//Carson Stephens

package com.cts.dao;

import java.sql.SQLException;
import java.util.List;

import com.cts.pojo.Userpass;
import com.cts.pojo.Admin;
import com.cts.pojo.Employee;
import com.cts.pojo.Customer;
import com.cts.pojo.Account;

public interface BankingDao
{
	Userpass getUserpass(String username) throws SQLException;
	
	Admin getAdmin(int id) throws SQLException;
	
	Admin loginAdmin(String username, String password) throws SQLException;
	
	Employee getEmployee(int id) throws SQLException;
	
	Employee loginEmployee(String username, String password) throws SQLException;
	
	Customer getCustomer(int id) throws SQLException;
	
	Customer loginCustomer(String username, String password) throws SQLException;
	
	Account getAccount(int id) throws SQLException;

	int saveAdmin(Admin a) throws SQLException;
	
	int saveEmployee(Employee e) throws SQLException;
	
	int saveCustomer(Customer c) throws SQLException;
	
	int saveAccount(Account ac) throws SQLException;
	
	void updateUserpass(Userpass u, String username) throws SQLException;
	
	void updateAdmin(Admin a) throws SQLException;
	
	void updateEmployee(Employee e) throws SQLException;
	
	void updateCustomer(Customer c) throws SQLException;
	
	void updateAccount(Account ac) throws SQLException;
	
	List<Userpass> getAllUserpasses() throws SQLException;
	
	List<Admin> getAllAdmins() throws SQLException;
	
	List<Employee> getAllEmployees() throws SQLException;
	
	List<Customer> getAllCustomers() throws SQLException;
	
	List<Account> getAllCustomerAccounts(int id) throws SQLException;
	
	int deleteAdmin(int id) throws SQLException;
	
	int deleteEmployee(int id) throws SQLException;
	
	int deleteCustomer(int id) throws SQLException;
	
	int deleteAccount(int customer) throws SQLException;
	
	void deposit(Customer c, int account, double d) throws SQLException;
	
	void withdraw(Customer c, int account, double w) throws SQLException;
	
	void apply(Customer c, String type) throws SQLException;
	
	void approve(Employee e, Customer c) throws SQLException;
	
	void reject(Employee e, Customer c) throws SQLException;
	
	void approve(Admin a, Customer c) throws SQLException;
	
	void reject(Admin a, Customer c) throws SQLException;
	
	List<Customer> viewOwnCustomers(Employee e) throws SQLException;
	
	void log(String username, int account, double amount, String action) throws SQLException;
	
	void printLogs() throws SQLException;
}
