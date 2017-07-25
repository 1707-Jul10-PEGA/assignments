package com.util.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import com.interfaces.BankingApplicationEmployeeDao;
import com.users.Customer;

public class BankingApplicationEmployeeDaoImplementation extends BankingApplicationDaoImplementation
		implements BankingApplicationEmployeeDao {

	public BankingApplicationEmployeeDaoImplementation() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public void viewCustomerBalances(int bankerID) throws SQLException {
		String sqlStatement = " SELECT CUSTOMER_ID FROM CUSTOMER WHERE BANKER_ID = ?";
		PreparedStatement pstmt = conn.prepareStatement(sqlStatement);
		pstmt.setInt(1, bankerID);
		ResultSet rs = pstmt.executeQuery();
		System.out.println("Here are your customers: ");

		ResultSet rs2 = null;
		int cID = 0;
		while (rs.next()) {
			sqlStatement = "SELECT FIRSTNAME, LASTNAME FROM ALLUSERS WHERE USER_ID = ?";
			pstmt = conn.prepareStatement(sqlStatement);
			cID = rs.getInt(1);
			pstmt.setInt(1, cID);
			rs2 = pstmt.executeQuery();
			rs2.next();
			System.out.println(
					"CUSTOMER_ID: " + cID + ", First name: " + rs2.getString(1) + ", Last name: " + rs2.getString(2));
		}

		Scanner scan = new Scanner(System.in);
		while (true) {
			try {
				System.out.print(
						"Enter CustomerID where you want to view the balances of (non numeric input to stop viewing): ");
				int input = scan.nextInt();
				List<Customer.Account> ca = viewBalances(input);
				for (Customer.Account ac : ca) {
					System.out.println("Account: " + ac.getAccountName() + ", Balance: " + ac.getBalance());

				}

			} catch (InputMismatchException e) {
				break;
			}

		}

	}

	@Override
	public void approveDeny(int bankerID) throws SQLException {
		// TODO Auto-generated method stub
		String sqlStatement = "SELECT ACCOUNTS.CUSTOMER_ID, ACCOUNTS.ACCOUNT_TYPE, ACCOUNTS.ACCOUNT_STATUS, CUSTOMER.BANKER_ID, ACCOUNTS.ACCOUNT_ID FROM ACCOUNTS INNER JOIN CUSTOMER ON ACCOUNTS.CUSTOMER_ID = CUSTOMER.CUSTOMER_ID WHERE CUSTOMER.BANKER_ID = ? AND (ACCOUNTS.ACCOUNT_STATUS = 'INACTIVE' OR ACCOUNTS.ACCOUNT_STATUS = 'PENDING')";
		PreparedStatement pstmt = conn.prepareStatement(sqlStatement);
		pstmt.setInt(1, bankerID);
		ResultSet rs = pstmt.executeQuery();

		PreparedStatement pstmt2 = null;
		ResultSet rs2 = null;
		Scanner scan = null;
		while (rs.next()) {

			int cID = rs.getInt(1);
			String accType = rs.getString(2);
			String status = rs.getString(3);
			int bID = rs.getInt(4);
			int accID = rs.getInt(5);

			pstmt2 = conn.prepareStatement("SELECT FIRSTNAME, LASTNAME FROM ALLUSERS WHERE USER_ID = ?");
			pstmt2.setInt(1, cID);
			rs2 = pstmt2.executeQuery();
			rs2.next();

			scan = new Scanner(System.in);
			String input = null;
			while (true) {
				scan = new Scanner(System.in);
				System.out.println("First name: " + rs2.getString(1) + ", Last name: " + rs2.getString(2)
						+ ", Account: " + accType + ", Status: " + status);
				System.out.print("APPROVE/DENY :");
				input = scan.nextLine();
				if ("approve".equalsIgnoreCase(input)) {
					pstmt2 = conn
							.prepareStatement("UPDATE ACCOUNTS SET ACCOUNT_STATUS = 'ACTIVE' WHERE ACCOUNT_ID = ?");
					pstmt2.setInt(1, accID);
					pstmt2.executeQuery();
					break;
				} else if ("deny".equalsIgnoreCase(input)) {
					pstmt2 = conn
							.prepareStatement("UPDATE ACCOUNTS SET ACCOUNT_STATUS = 'INACTIVE' WHERE ACCOUNT_ID = ?");
					pstmt2.setInt(1, accID);
					pstmt2.executeQuery();
					break;
				} else {
					System.out.println("Please enter 'approve' or 'deny'");

				}

			}
			// rs2.close();
			// pstmt2.close();

		}

		System.out.println("End of approve/deny process");
		rs.close();
		pstmt.close();
		
	}

	public static void main(String[] args) {
		BankingApplicationEmployeeDao empDao = new BankingApplicationEmployeeDaoImplementation();
		try {
			empDao.approveDeny(8);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			empDao.viewCustomerBalances(8);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("End of Application");
	}

}
