package com.nc.banking_app.doa;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Types;
import java.util.List;
import java.util.Scanner;

import com.nc.banking_app.users.Users;

import oracle.jdbc.internal.OracleTypes;

public class LoginDOA {
	Scanner sc = new Scanner(System.in);
	public void registor(Connection conn){
		CallableStatement cstmt = null;
		String name = new String();
		// Get name
		while (name.isEmpty()) {
			System.out.println("What is your name? ");
			name = sc.nextLine();
		}
		try {
			cstmt = conn.prepareCall("{call REG_NEW_USER(?)}");
			cstmt.setString(1, name);
			cstmt.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	
	public int login(Connection conn){
		CallableStatement cstmt = null;
		int rs = -1;
		try {
			String name = new String();
			// Get name
			System.out.println("What is your name? ");
			name = sc.nextLine();
			cstmt = conn.prepareCall("begin ? := LOGIN(?); end;");
			cstmt.setString(2, name);
			cstmt.registerOutParameter(1, java.sql.Types.INTEGER);
			cstmt.execute();
			rs = cstmt.getInt(1);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rs;
	}
}
