package com.nc.banking_app.doa;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;

import oracle.jdbc.internal.OracleTypes;

public class EmployeeDOA {
	private Scanner sc = new Scanner(System.in);
	public void appDeny(Connection conn, int userIndex){
		CallableStatement cstmt = null;
		String name = new String();
		String acc = new String();
		while (name.isEmpty()) {
			System.out.println("Name of Customer? ");
			name = sc.nextLine();
		}
		while (acc.isEmpty()) {
			System.out.println("Name of Account? ");
			acc = sc.nextLine();
		}
		String userInput = new String();
		while (userInput.isEmpty()) {
			System.out.println("Approve(A) or Deny(D)? ");
			userInput = sc.nextLine();
		}
		
		if ("A".equalsIgnoreCase(userInput)) {
			try {
				cstmt = conn.prepareCall("{call Approve_Acc(?,?,?)}");
				cstmt.setString(1, name);
				cstmt.setString(2, acc);
				cstmt.setInt(3, userIndex);
				cstmt.execute();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else if ("D".equalsIgnoreCase(userInput)){
			try {
				cstmt = conn.prepareCall("{call Deny_Acc(?,?,?)}");
				cstmt.setString(1, name);
				cstmt.setString(2, acc);
				cstmt.setInt(3, userIndex);
				cstmt.execute();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
}
