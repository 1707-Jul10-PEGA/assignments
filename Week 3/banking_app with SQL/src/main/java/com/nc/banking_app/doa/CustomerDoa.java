package com.nc.banking_app.doa;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import oracle.jdbc.internal.OracleTypes;

public class CustomerDoa {
	Scanner sc = new Scanner(System.in);
	public void CreateAccount(Connection conn, int userIndex){
		CallableStatement cstmt = null;
		String name = new String();
		// Get name
		while (name.isEmpty()) {
			System.out.println("Name of Account? ");
			name = sc.nextLine();
		}
		try {
			cstmt = conn.prepareCall("{call NEW_ACCOUNT(?, ?)}");
			cstmt.setString(1, name);
			cstmt.setInt(2, userIndex);
			cstmt.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	public void cViewAccounts(Connection conn, int userIndex){
		boolean flag = false;
		while (true) {
			CallableStatement cstmt = null;
			ResultSet rs = null;
			try {
				cstmt = conn.prepareCall("{call GET_ALL_ACC_NAME(?,?)}");
				cstmt.registerOutParameter(1, OracleTypes.CURSOR);
				cstmt.setInt(2, userIndex);
				cstmt.execute();
				rs = (ResultSet) cstmt.getObject(1);
				while(rs.next()){
					System.out.print(rs.getString(1) + ", ");
				}
				
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			
		}
	}
	
	public void Deposit(Connection conn, int userIndex){
		CallableStatement cstmt = null;
		String name = new String();
		int money = 0;
		while (name.isEmpty()) {
			System.out.println("Name of Account? ");
			name = sc.nextLine();
		}

			System.out.println("Amount of Money? ");
			money = sc.nextInt();

		try {
			cstmt = conn.prepareCall("{call DEPOSIT(?,?,?,?,?)}");
			cstmt.setString(1, name);
			cstmt.setInt(2, userIndex);
			cstmt.registerOutParameter(3, OracleTypes.INTEGER);
			cstmt.setInt(4, money);
			cstmt.registerOutParameter(5, OracleTypes.INTEGER);
			cstmt.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void Withdraw(Connection conn, int userIndex){
		CallableStatement cstmt = null;
		String name = new String();
		int money = 0;
		while (name.isEmpty()) {
			System.out.println("Name of Account? ");
			name = sc.nextLine();
		}

			System.out.println("Amount of Money? ");
			money = sc.nextInt();

		try {
			cstmt = conn.prepareCall("{call WITHDRAW(?,?,?,?,?)}");
			cstmt.setString(1, name);
			cstmt.setInt(2, userIndex);
			cstmt.registerOutParameter(3, OracleTypes.INTEGER);
			cstmt.setInt(4, money);
			cstmt.registerOutParameter(5, OracleTypes.INTEGER);
			cstmt.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
