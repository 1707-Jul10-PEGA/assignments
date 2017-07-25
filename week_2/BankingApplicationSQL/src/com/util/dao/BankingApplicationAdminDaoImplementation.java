package com.util.dao;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import com.interfaces.BankingApplicationAdminDao;

public class BankingApplicationAdminDaoImplementation extends BankingApplicationEmployeeDaoImplementation implements BankingApplicationAdminDao {

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

}
