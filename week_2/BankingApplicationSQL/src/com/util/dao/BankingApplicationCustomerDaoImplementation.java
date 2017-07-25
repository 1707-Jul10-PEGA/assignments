package com.util.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.InputMismatchException;
import java.util.Scanner;

import com.interfaces.BankingApplicationCustomerDao;

public class BankingApplicationCustomerDaoImplementation extends BankingApplicationDaoImplementation
		implements BankingApplicationCustomerDao {

	public BankingApplicationCustomerDaoImplementation() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public void deposit(int customerID) throws SQLException {
		// TODO Auto-generated method stub
		String sqlStatement = "SELECT * FROM ACCOUNTS WHERE CUSTOMER_ID = ? AND ACCOUNT_STATUS = 'ACTIVE'";
		PreparedStatement pstmt = conn.prepareStatement(sqlStatement);
		pstmt.setInt(1, customerID);
		ResultSet rs = pstmt.executeQuery();
		Scanner scan = new Scanner(System.in);
		double input = 0;
		while (rs.next()) {
			while (true) {
				try {
					
					System.out.print("How much to deposit into " + rs.getString(4) + "? ");
					scan = new Scanner(System.in);
					input = scan.nextDouble();
					if(input < 0){
						System.out.println("NEGATIVE NOT ALLOWED");
						continue;
					}
					sqlStatement = "UPDATE ACCOUNTS SET BALANCE = ? WHERE CUSTOMER_ID = ? AND ACCOUNT_ID = ?";
					pstmt = conn.prepareStatement(sqlStatement);
					pstmt.setDouble(1, input + rs.getDouble(2));
					pstmt.setInt(2, customerID);
					pstmt.setInt(3, rs.getInt(1));
					pstmt.executeQuery();
					
					// add logging to transaction log table
					sqlStatement = "INSERT INTO TRANSACTION_LOG VALUES(0,SYSDATE, 'DEPOSIT' , ?, ?, ?)";
					pstmt = conn.prepareStatement(sqlStatement);
					pstmt.setInt(1, customerID);
					pstmt.setInt(2, rs.getInt(1));
					pstmt.setDouble(3, input);
					pstmt.executeQuery();
					break;
				} catch (InputMismatchException e) {
					System.out.println("Please enter a valid double");
				}

			}
		}

	}

	@Override
	public void withdraw(int customerID) throws SQLException {
		// TODO Auto-generated method stub
		String sqlStatement = "SELECT * FROM ACCOUNTS WHERE CUSTOMER_ID = ? AND ACCOUNT_STATUS = 'ACTIVE'";
		PreparedStatement pstmt = conn.prepareStatement(sqlStatement);
		pstmt.setInt(1, customerID);
		ResultSet rs = pstmt.executeQuery();
		Scanner scan = new Scanner(System.in);
		double input = 0;
		while (rs.next()) {
			while (true) {
				try {
					System.out.print("How much to withdral from " + rs.getString(4) + "? ");
					scan = new Scanner(System.in);
					input = scan.nextDouble();
					
					if((rs.getDouble(2) - input) < 0){
						System.out.println("Excess withdrawl!");
						continue;
					}
					sqlStatement = "UPDATE ACCOUNTS SET BALANCE = ? WHERE CUSTOMER_ID = ? AND ACCOUNT_ID = ?";
					pstmt = conn.prepareStatement(sqlStatement);
					pstmt.setDouble(1, rs.getDouble(2) - input);
					pstmt.setInt(2, customerID);
					pstmt.setInt(3, rs.getInt(1));
					pstmt.executeQuery();
					
					// add logging to transaction log table
					sqlStatement = "INSERT INTO TRANSACTION_LOG VALUES(0,SYSDATE, 'WITHDRAW' , ?, ?, ?)";
					pstmt = conn.prepareStatement(sqlStatement);
					pstmt.setInt(1, customerID);
					pstmt.setInt(2, rs.getInt(1));
					pstmt.setDouble(3, input);
					pstmt.executeQuery();
					break;
				} catch (InputMismatchException e) {
					System.out.println("Please enter a valid double");
				}

			}
		}

	}

	@Override
	public void apply(int customerID) throws SQLException {
		// TODO Auto-generated method stub
		System.out.print("Enter the account you want to apply: ");
		Scanner scan = new Scanner(System.in);
		String input = scan.nextLine();
		// customer id
		// account type
		String sqlStatement = "INSERT INTO ACCOUNTS VALUES(0 , 0 , ? , ?, 'PENDING')";
		PreparedStatement pstmt = conn.prepareStatement(sqlStatement);
		pstmt.setInt(1, customerID);
		pstmt.setString(2, input);
		pstmt.executeQuery();
		System.out.println("Applied for account: " + input);
		

	}

	public static void main(String[] args) {
		BankingApplicationCustomerDao cd = new BankingApplicationCustomerDaoImplementation();
		try {
			cd.deposit(1);
			cd.withdraw(1);
			cd.apply(1);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println("END OF APPLICATION");
	}

}
