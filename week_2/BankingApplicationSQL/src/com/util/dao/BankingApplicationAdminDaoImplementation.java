package com.util.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import com.interfaces.BankingApplicationAdminDao;
import com.users.Customer;

public class BankingApplicationAdminDaoImplementation extends BankingApplicationEmployeeDaoImplementation
		implements BankingApplicationAdminDao {

	public BankingApplicationAdminDaoImplementation() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public void runSQL() {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		String sql = scan.nextLine();
		Statement stmt;
		try {
			stmt = conn.createStatement();
			stmt.executeQuery(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("SQL executed");

	}

	private ResultSet customerUsers() throws SQLException{
		String sqlStatement = "SELECT * FROM ALLUSERS WHERE USER_TYPE_ID = 0";
		PreparedStatement pstmt;
		pstmt = conn.prepareStatement(sqlStatement);
		ResultSet rs = pstmt.executeQuery();
		return rs;
	}
	
	private ResultSet employeeUsers() throws SQLException{
		String sqlStatement = "SELECT * FROM ALLUSERS WHERE USER_TYPE_ID = 1";
		PreparedStatement pstmt;
		pstmt = conn.prepareStatement(sqlStatement);
		ResultSet rs = pstmt.executeQuery();
		return rs;
	}
	
	@Override
	public void depositAny() throws SQLException {
		// TODO Auto-generated method stub
		ResultSet rs = customerUsers();
		while(rs.next()){
			System.out.println("USER_ID: " + rs.getInt(1) +", First name: " + rs.getString(3) 
			+ ", last name: " + rs.getString(4) + ", age:" + rs.getInt(5));
		}
		Scanner scan = new Scanner(System.in);
		while(true){
			try{
				System.out.print("Select user you want to deposit into: ");
				scan = new Scanner(System.in);
				int input = scan.nextInt();
				new BankingApplicationCustomerDaoImplementation().deposit(input);
				break;
			}catch(InputMismatchException e){
					System.out.println("Enter the correct user_id.");
			}
			
		}

	}

	@Override
	public void withdrawAny() throws SQLException {
		// TODO Auto-generated method stub
		ResultSet rs = customerUsers();
		while(rs.next()){
			System.out.println("USER_ID: " + rs.getInt(1) +", First name: " + rs.getString(3) 
			+ ", last name: " + rs.getString(4) + ", age:" + rs.getInt(5));
		}
		Scanner scan = new Scanner(System.in);
		while(true){
			try{
				System.out.print("Select user you want to withdraw from: ");
				scan = new Scanner(System.in);
				int input = scan.nextInt();
				new BankingApplicationCustomerDaoImplementation().withdraw(input);
				break;
			}catch(InputMismatchException e){
					System.out.println("Enter the correct user_id.");
			}
			
		}

	}

	@Override
	public void approveDenyAny() throws SQLException {
		// TODO Auto-generated method stub
		ResultSet rs = employeeUsers();
		while(rs.next()){
			System.out.println("USER_ID: " + rs.getInt(1) +", First name: " + rs.getString(3) 
			+ ", last name: " + rs.getString(4) + ", age:" + rs.getInt(5));
		}
		Scanner scan = new Scanner(System.in);
		while(true){
			try{
				System.out.print("Select employee you want to approve/deny accounts for: ");
				scan = new Scanner(System.in);
				int input = scan.nextInt();
				new BankingApplicationEmployeeDaoImplementation().approveDeny(input);
				break;
			}catch(InputMismatchException e){
					System.out.println("Enter the correct user_id.");
			}
			
		}

	}

	@Override
	public void viewAnyBalance() throws SQLException {
		// TODO Auto-generated method stub
		ResultSet rs = customerUsers();
		while(rs.next()){
			System.out.println("USER_ID: " + rs.getInt(1) +", First name: " + rs.getString(3) 
			+ ", last name: " + rs.getString(4) + ", age:" + rs.getInt(5));
		}
		Scanner scan = new Scanner(System.in);
		while(true){
			try{
				System.out.print("Select user you want to view balances: ");
				scan = new Scanner(System.in);
				int input = scan.nextInt();
				List<Customer.Account> ca = viewBalances(input);
				for(Customer.Account ac : ca){
					System.out.println("Account: " + ac.getAccountName() + ", balance:" + ac.getBalance());
				}
				break;
			}catch(InputMismatchException e){
					System.out.println("Enter the correct user_id.");
			}
			
		}

	}

	@Override
	public void createEmployee() throws SQLException {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		System.out.println("Creating a new Employee...");
		System.out.print("Enter first name: ");
		String firstname = scan.nextLine();
		System.out.print("Enter last name: ");
		String lastName = scan.nextLine();
		int age = 0;
		scan = new Scanner(System.in);
		while (true) {
			try{
			System.out.print("Enter age: ");
			age = scan.nextInt();
			break;
			}catch(InputMismatchException e){
				System.out.println("Input a valid age.");
			}
		}
		scan = new Scanner(System.in);
		System.out.print("Enter username: ");
		String userName = scan.nextLine();
		scan = new Scanner(System.in);
		System.out.print("Enter password: ");
		String passWord = scan.nextLine();

		String sqlStatement = "INSERT INTO ALLUSERS VALUES(0,?,?,?,?,1,?)";
		PreparedStatement pstmt = conn.prepareStatement(sqlStatement);
		pstmt.setString(1, passWord);
		pstmt.setString(2, firstname);
		pstmt.setString(3, lastName);
		pstmt.setInt(4, age);
		pstmt.setString(5, userName);
		ResultSet rs = pstmt.executeQuery();

	}
	public static void main(String[] args) {
		BankingApplicationAdminDao ad = new BankingApplicationAdminDaoImplementation();
		try {
			ad.viewAnyBalance();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
