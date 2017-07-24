//Carson Stephens

package com.cts.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.cts.pojo.Account;
import com.cts.pojo.Admin;
import com.cts.pojo.Customer;
import com.cts.pojo.Employee;
import com.cts.pojo.Userpass;
import com.cts.util.ConnectionFactory;

public class BankingDaoImpl implements BankingDao
{
	Connection conn = null;
	
	public void setup()
	{
		conn = ConnectionFactory.getInstance().getConnection();
	}
	
	public void disconnect()
	{
		try
		{
			conn.close();
		} catch (SQLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public BankingDaoImpl()
	{
		setup();
	}
	
	@Override
	public Userpass getUserpass(String username) throws SQLException
	{
		Statement stmt = conn.createStatement();
		String sql = "select * from userpass where username = '" + username + "'";
		ResultSet rs = stmt.executeQuery(sql);
		if (rs.next())
		{
			Userpass u = new Userpass(rs.getString(1), rs.getString(2));
			rs.close();
			stmt.close();
			return u;
		}
		return null;
	}
	
	
	@Override
	public Admin getAdmin(int id) throws SQLException
	{
		Statement stmt = conn.createStatement();
		String sql = "select * from admin where id = " + id;
		ResultSet rs = stmt.executeQuery(sql);
		if (rs.next())
		{
			Admin a = new Admin(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5));
			rs.close();
			stmt.close();
			return a;
		}
		return null;
	}
	
	@Override
	public Admin loginAdmin(String username, String password) throws SQLException
	{
		Statement stmt = conn.createStatement();
		String sql = "select * from admin where username = '" + username + "' and password = '" + password + "'";
		ResultSet rs = stmt.executeQuery(sql);
		if (rs.next())
		{
			Admin a = new Admin(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5));
			rs.close();
			stmt.close();
			return a;
		}
		return null;
	}
	
	@Override
	public Employee getEmployee(int id) throws SQLException
	{
		Statement stmt = conn.createStatement();
		String sql = "select * from employee where id = " + id;
		ResultSet rs = stmt.executeQuery(sql);
		if (rs.next())
		{
			Employee e = new Employee(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5));
			rs.close();
			stmt.close();
			return e;
		}
		return null;
	}
	
	@Override
	public Employee loginEmployee(String username, String password) throws SQLException
	{
		Statement stmt = conn.createStatement();
		String sql = "select * from employee where username = '" + username + "' and password = '" + password + "'";
		ResultSet rs = stmt.executeQuery(sql);
		if (rs.next())
		{
			Employee e = new Employee(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5));
			rs.close();
			stmt.close();
			return e;
		}
		return null;
	}
	
	@Override
	public Customer getCustomer(int id) throws SQLException
	{
		Statement stmt = conn.createStatement();
		String sql = "select c.* from customer c, employee e where c.employee = e.id and c.id = " + id;
		ResultSet rs = stmt.executeQuery(sql);
		if (rs.next())
		{
			List<Account> ac = getAllCustomerAccounts(rs.getInt(1));
			Customer c = new Customer(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getInt(6), ac);
			rs.close();
			stmt.close();
			return c;
		}
		return null;
	}
	
	@Override
	public Customer loginCustomer(String username, String password) throws SQLException
	{
		Statement stmt = conn.createStatement();
		String sql = "select c.* from customer c, employee e where c.employee = e.id and c.username = '" + username + "' and c.password = '" + password + "'";
		ResultSet rs = stmt.executeQuery(sql);
		if (rs.next())
		{
			List<Account> ac = getAllCustomerAccounts(rs.getInt(1));
			Customer c = new Customer(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getInt(6), ac);
			rs.close();
			stmt.close();
			return c;
		}
		return null;
	}
	
	@Override
	public Account getAccount(int id) throws SQLException
	{
		Statement stmt = conn.createStatement();
		String sql = "select * from account where id = " + id;
		ResultSet rs = stmt.executeQuery(sql);
		if (rs.next())
		{
			Account ac = new Account(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getDouble(4), rs.getInt(5), rs.getInt(6));
			rs.close();
			stmt.close();
			return ac;
		}
		return null;
	}
	
	@Override
	public int saveAdmin(Admin a) throws SQLException
	{
		String sql = "insert into admin(id, firstname, lastname, username, password) values(?, ?, ?, ?, ?)";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		if (a.getId() == 0)
		{
			int count = 1;
			while (getAdmin(count) != null)
			{
				count++;
			}
			pstmt.setInt(1, count);
		}
		pstmt.setString(2, a.getFirstname());
		pstmt.setString(3, a.getLastname());
		pstmt.setString(4, a.getUsername());
		pstmt.setString(5, a.getPassword());
		pstmt.executeUpdate();
		pstmt.close();
		return 0;
	}
	
	@Override
	public int saveEmployee(Employee e) throws SQLException
	{
		String sql = "insert into employee(id, firstname, lastname, username, password) values(?, ?, ?, ?, ?)";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		if (e.getId() == 0)
		{
			int count = 1;
			while (getEmployee(count) != null)
			{
				System.out.println("Employee " + count + " taken");
				count++;
			}
			pstmt.setInt(1, count);
		}
		pstmt.setString(2, e.getFirstname());
		pstmt.setString(3, e.getLastname());
		pstmt.setString(4, e.getUsername());
		pstmt.setString(5, e.getPassword());
		pstmt.executeUpdate();
		pstmt.close();
		return 0;
	}
	
	@Override
	public int saveCustomer(Customer c) throws SQLException
	{
		String sql = "insert into customer(id, firstname, lastname, username, password, employee) values(?, ?, ?, ?, ?, ?)";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		if (c.getId() == 0)
		{
			int count = 1;
			while (getCustomer(count) != null)
			{
				count++;
			}
			pstmt.setInt(1, count);
		}
		pstmt.setString(2, c.getFirstname());
		pstmt.setString(3, c.getLastname());
		pstmt.setString(4, c.getUsername());
		pstmt.setString(5, c.getPassword());
		pstmt.setInt(6, c.getEmployee());
		pstmt.executeUpdate();
		pstmt.close();
		return 0;
	}
	
	@Override
	public int saveAccount(Account ac) throws SQLException
	{
		String sql = "insert into account(id, customer, type, balance, applied, approved) values(?, ?, ?, ?, ?, ?)";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		if (ac.getId() == 0)
		{
			int count = 1;
			while (getAccount(count) != null)
			{
				count++;
			}
			pstmt.setInt(1, count);
		}
		pstmt.setInt(2, ac.getCustomer());
		pstmt.setString(3, ac.getType());
		pstmt.setDouble(4, ac.getBalance());
		pstmt.setInt(5, ac.getApplied());
		pstmt.setInt(6, ac.getApproved());
		pstmt.executeUpdate();
		pstmt.close();
		return 0;
	}
	
	@Override
	public void updateUserpass(Userpass u, String username) throws SQLException
	{
		String sql = "update userpass set username = ?, type = ? where username = ?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, u.getUsername());
		pstmt.setString(2, u.getType());
		pstmt.setString(3, username);
		pstmt.executeUpdate();
		pstmt.close();
	}
	
	@Override
	public void updateAdmin(Admin a) throws SQLException
	{
		String sql = "update admin set firstname = ?, lastname = ?, username = ?, password = ? where id = ?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, a.getFirstname());
		pstmt.setString(2, a.getLastname());
		pstmt.setString(3, a.getUsername());
		pstmt.setString(4, a.getPassword());
		pstmt.setInt(5, a.getId());
		pstmt.executeUpdate();
		pstmt.close();
	}
	
	@Override
	public void updateEmployee(Employee e) throws SQLException
	{
		String sql = "update employee set firstname = ?, lastname = ?, username = ?, password = ? where id = ?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, e.getFirstname());
		pstmt.setString(2, e.getLastname());
		pstmt.setString(3, e.getUsername());
		pstmt.setString(4, e.getPassword());
		pstmt.setInt(5, e.getId());
		pstmt.executeUpdate();
		pstmt.close();
	}
	
	@Override
	public void updateCustomer(Customer c) throws SQLException
	{
		String sql = "update customer set firstname = ?, lastname = ?, username = ?, password = ?, employee = ? where id = ?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, c.getFirstname());
		pstmt.setString(2, c.getLastname());
		pstmt.setString(3, c.getUsername());
		pstmt.setString(4, c.getPassword());
		pstmt.setInt(5, c.getEmployee());
		pstmt.setInt(6, c.getId());
		pstmt.executeUpdate();
		pstmt.close();
	}
	
	@Override
	public void updateAccount(Account ac) throws SQLException
	{
		String sql = "update account set customer = ?, type = ?, balance = ?, applied = ?, approved = ? where id = ?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, ac.getCustomer());
		pstmt.setString(2, ac.getType());
		pstmt.setDouble(3, ac.getBalance());
		pstmt.setInt(4, ac.getApplied());
		pstmt.setInt(5, ac.getApproved());
		pstmt.setInt(6, ac.getId());
		pstmt.executeUpdate();
		pstmt.close();
	}
	
	@Override
	public List<Userpass> getAllUserpasses() throws SQLException
	{
		List<Userpass> us = new ArrayList<Userpass>();
		Statement stmt = conn.createStatement();
		String sql = "select * from userpass";
		ResultSet rs = stmt.executeQuery(sql);
		while (rs.next())
		{
			Userpass u = new Userpass(rs.getString(1), rs.getString(2));
			us.add(u);
		}
		rs.close();
		stmt.close();
		return us;
	}
	
	@Override
	public List<Admin> getAllAdmins() throws SQLException
	{
		List<Admin> as = new ArrayList<Admin>();
		Statement stmt = conn.createStatement();
		String sql = "select * from admin";
		ResultSet rs = stmt.executeQuery(sql);
		while (rs.next())
		{
			Admin a = new Admin(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5));
			as.add(a);
		}
		rs.close();
		stmt.close();
		return as;
	}
	
	@Override
	public List<Employee> getAllEmployees() throws SQLException
	{
		List<Employee> es = new ArrayList<Employee>();
		Statement stmt = conn.createStatement();
		String sql = "select * from employee";
		ResultSet rs = stmt.executeQuery(sql);
		while (rs.next())
		{
			Employee e = new Employee(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5));
			es.add(e);
		}
		rs.close();
		stmt.close();
		return es;
	}
	
	@Override
	public List<Customer> getAllCustomers() throws SQLException
	{
		List<Customer> cs = new ArrayList<Customer>();
		Statement stmt = conn.createStatement();
		String sql = "select * from customer";
		ResultSet rs = stmt.executeQuery(sql);
		while (rs.next())
		{
			List<Account> acs = getAllCustomerAccounts(rs.getInt(1));
			Customer c = new Customer(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getInt(6), acs);
			cs.add(c);
		}
		rs.close();
		stmt.close();
		return cs;
	}
	
	@Override
	public List<Account> getAllCustomerAccounts(int customer) throws SQLException
	{
		List<Account> acs = new ArrayList<Account>();
		Statement stmt = conn.createStatement();
		String sql = "select * from account where customer = " + customer;
		ResultSet rs = stmt.executeQuery(sql);
		while (rs.next())
		{
			Account ac = new Account(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getDouble(4), rs.getInt(5), rs.getInt(6));
			acs.add(ac);
		}
		rs.close();
		stmt.close();
		return acs;
	}
	
	@Override
	public int deleteAdmin(int id) throws SQLException
	{		
		String sql = "delete from admin where id = ?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, id);
		pstmt.executeUpdate();
		pstmt.close();
		return 0;
	}
	
	@Override
	public int deleteEmployee(int id) throws SQLException
	{
		String sql = "delete from employee where id = ?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, id);
		pstmt.executeUpdate();
		pstmt.close();
		return 0;
	}
	
	@Override
	public int deleteCustomer(int id) throws SQLException
	{
		String sql = "delete from customer where id = ?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, id);
		pstmt.executeUpdate();
		pstmt.close();
		return 0;
	}
	
	@Override
	public int deleteAccount(int id) throws SQLException
	{
//		Statement stmt = conn.createStatement();
//		String sql = "delete * from account where id = ?";
//		PreparedStatement pstmt = conn.prepareStatement(sql);
//		int count = 0;
//		for (int id : ids)
//		{
//			pstmt.setInt(1, id);
//			if (stmt.executeUpdate(sql) > 0)
//				count++;
//		}
//		return count;
		return 0;
	}
	
	@Override
	public void deposit(Customer c, int account, double d) throws SQLException
	{
		if (d > 0)
		{
			Account ac = getAccount(account);
			if (ac == null)
			{
				System.out.println("ACCOUNT DOES NOT EXIST");
				return;
			}
			if (ac.getCustomer() == c.getId())
			{
				if (ac.getApproved() == 1)
				{
					ac.setBalance(ac.getBalance()+d);
					updateAccount(ac);
					System.out.println("DEPOSIT COMPLETED");
					System.out.format("CURRENT BALANCE IS: %10.2f\n", ac.getBalance());
					log(c.getUsername(), ac.getId(), d, "Deposit");
				}
				else
				{
					System.out.println("ACCOUNT NOT YET APPROVED");
				}
			}
			else
			{
				System.out.println("ACCOUNT DOES NOT BELONG TO USER");
			}
		}
		else
		{
			System.out.println("DEPOSIT AMOUNT MUST BE GREATER THAN $0.00");
		}
	}
	
	@Override
	public void withdraw(Customer c, int account, double w) throws SQLException
	{
		if (w > 0)
		{
			Account ac = getAccount(account);
			if (ac == null)
			{
				System.out.println("ACCOUNT DOES NOT EXIST");
				return;
			}
			if (ac.getCustomer() == c.getId())
			{
				if (ac.getApproved() == 1)
				{
					ac.setBalance(ac.getBalance()-w);
					updateAccount(ac);
					System.out.println("WITHDRAW COMPLETED");
					System.out.format("CURRENT BALANCE IS: %10.2f\n", ac.getBalance());
					log(c.getUsername(), ac.getId(), w, "Withdraw");
				}
				else
				{
					System.out.println("ACCOUNT NOT YET APPROVED");
				}
			}
			else
			{
				System.out.println("ACCOUNT DOES NOT BELONG TO USER");
			}
		}
		else
		{
			System.out.println("WITHDRAW AMOUNT MUST BE GREATER THAN $0.00");
		}
	}
	
	@Override
	public void apply(Customer c, String type) throws SQLException
	{
		String sql = "select applied from account where customer = ? and applied = 1";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, c.getId());
		if (!pstmt.executeQuery().next())
		{
			Account ac = new Account(0, c.getId(), type, 0.0, 1, 0);
			saveAccount(ac);
			log(c.getUsername(), ac.getId(), 0.0, "Apply");
		}
		else
		{
			System.out.println("APPLICATION STILL PENDING");
		}
		pstmt.close();
	}
	
	@Override
	public void approve(Employee e, Customer c) throws SQLException
	{
		if (c.getEmployee() == e.getId())
		{
			String sql = "select applied from account where customer = ? and applied = 1";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, c.getId());
			ResultSet rs = pstmt.executeQuery();
			if (rs.next())
			{
				Account ac = getAccount(rs.getInt(1));
				ac.setApproved(1);
				ac.setApplied(0);
				updateAccount(ac);
				log(e.getUsername(), ac.getId(), 0.0, "Approve");
			}
			else
			{
				System.out.println("CUSTOMER DOES NOT HAVE PENDING APPLICATION");
			}
			rs.close();
			pstmt.close();
		}
		else
		{
			System.out.println("CUSTOMER DOES NOT BELONG TO USER");
		}
	}
	
	@Override
	public void reject(Employee e, Customer c) throws SQLException
	{
		if (c.getEmployee() == e.getId())
		{
			String sql = "select applied from account where customer = ? and applied = 1";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, c.getId());
			ResultSet rs = pstmt.executeQuery();
			if (rs.next())
			{
				Account ac = getAccount(rs.getInt(1));
				deleteAccount(ac.getId());
				log(e.getUsername(), ac.getId(), 0.0, "Reject");
			}
			else
			{
				System.out.println("CUSTOMER DOES NOT HAVE PENDING APPLICATION");
			}
			rs.close();
			pstmt.close();
		}
		else
		{
			System.out.println("CUSTOMER DOES NOT BELONG TO USER");
		}
	}
	
	@Override
	public void approve(Admin a, Customer c) throws SQLException
	{
		String sql = "select applied from account where customer = ? and applied = 1";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, c.getId());
		ResultSet rs = pstmt.executeQuery();
		if (rs.next())
		{
			Account ac = getAccount(rs.getInt(1));
			ac.setApproved(1);
			ac.setApplied(0);
			updateAccount(ac);
			log(a.getUsername(), ac.getId(), 0.0, "Approve");
		}
		else
		{
			System.out.println("CUSTOMER DOES NOT HAVE PENDING APPLICATION");
		}
		rs.close();
		pstmt.close();
	}
	
	@Override
	public void reject(Admin a, Customer c) throws SQLException
	{
		String sql = "select applied from account where customer = ? and applied = 1";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, c.getId());
		ResultSet rs = pstmt.executeQuery();
		if (rs.next())
		{
			Account ac = getAccount(rs.getInt(1));
			deleteAccount(ac.getId());
			log(a.getUsername(), ac.getId(), 0.0, "Reject");
		}
		else
		{
			System.out.println("CUSTOMER DOES NOT HAVE PENDING APPLICATION");
		}
		rs.close();
		pstmt.close();
	}
	
	@Override
	public List<Customer> viewOwnCustomers(Employee e) throws SQLException
	{
		List<Customer> cs = new ArrayList<Customer>();
		Statement stmt = conn.createStatement();
		String sql = "select * from customer where employee = " + e.getId();
		ResultSet rs = stmt.executeQuery(sql);
		while (rs.next())
		{
			List<Account> acs = getAllCustomerAccounts(rs.getInt(1));
			Customer c = new Customer(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getInt(6), acs);
			cs.add(c);
		}
		rs.close();
		stmt.close();
		return cs;
	}
	
	@Override
	public void log(String username, int account, double amount, String action) throws SQLException
	{
		String sql = "insert into log(tstamp, userinvolved, accountinvolved, amount, action) values(?, ?, ?, ?, ?)";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
		pstmt.setString(1, timeStamp);
		pstmt.setString(2, username);
		pstmt.setInt(3, account);
		pstmt.setDouble(4, amount);
		pstmt.setString(5, action);
		pstmt.executeUpdate();
		pstmt.close();
	}
	
	@Override
	public void printLogs() throws SQLException
	{
		Statement stmt = conn.createStatement();
		String sql = "select * from log";
		ResultSet rs = stmt.executeQuery(sql);
		System.out.println("LOGS");
		System.out.format("\t%25s%25s%15s%18s%25s\n", "TIMESTAMP", "USER", "ACCOUNT", "AMOUNT", "ACTION");
		while (rs.next())
		{
			System.out.format("\t%25s%25s%15d%18.2f%25s\n", rs.getString(1), rs.getString(2), rs.getInt(3), rs.getFloat(4), rs.getString(5));
		}
		rs.close();
		stmt.close();
	}
}
