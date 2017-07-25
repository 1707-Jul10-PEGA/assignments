package com.revature.banking;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author hy150
 *
 */
public class Customer extends User {
	
	private ArrayList<Integer> acctIndex;
	private int customerIndex;

	public Customer(String firstName, String lastName, int age, String phone, String address, String username,
			String password, ArrayList<Integer> acctIndex, int customerIndex, int User_ID) {
		super(firstName, lastName, age, phone, address, username, password, "customer",User_ID);
		this.acctIndex = acctIndex;
		this.customerIndex = customerIndex;
	}
	
	public void deposit(int accountId, double amount) {
		Main.bankAcc.get(accountId).deposit(amount);
	}
	
	public void withdraw(int accountId, double amount) {
		Main.bankAcc.get(accountId).withdraw(amount);
	}
	
	public void applyForAccount() {
		
		try {
			System.out.println("What type of account do you want? Please input saving or checking");
			Scanner sc = new Scanner(System.in);
			String type = sc.nextLine();
			System.out.println("How much do you want to put in?");
			Double amount = Double.parseDouble(sc.nextLine());
			Main.application.add(new Application(this,type,amount));
			System.out.println("Application created. Please wait up to 7 to 14 days to process");
		}
		catch(Exception e) {
			System.out.println("Error: Application not created!");
		}
		
	}
	
	public boolean displayAccounts() {
		ArrayList<BankAccount> bList = Main.getBankAcc();
		if( getAcctIndex() == null ||  getAcctIndex().isEmpty()) {
			System.out.print("No existing accounts\n");
			return false;
		}
		for(Integer i: getAcctIndex()) {
			System.out.println("[" + i + "]" + bList.get(i));
		}
		return true;
	}
	
	/**
	 * Checks to see if the user holds a particular account.
	 * @param index
	 * @return
	 */
	public boolean hasAccount(int index) {
		for(Integer i: getAcctIndex()) {
			if(index == i) {
				return true;
			}
		}
		return false;
	}

	public ArrayList<Integer> getAcctIndex() {
		return acctIndex;
	}

	public void setAcctIndex(ArrayList<Integer> acctIndex) {
		this.acctIndex = acctIndex;
	}

	public int getCustomerIndex() {
		return customerIndex;
	}

	public void setCustomerIndex(int customerIndex) {
		this.customerIndex = customerIndex;
	}

	@Override
	public String toString() {
		return "\n" + super.toString() + "acctIndex=" + acctIndex + ", customerIndex=" + customerIndex ;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((acctIndex == null) ? 0 : acctIndex.hashCode());
		result = prime * result + customerIndex;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Customer other = (Customer) obj;
		if (acctIndex == null) {
			if (other.acctIndex != null)
				return false;
		} else if (!acctIndex.equals(other.acctIndex))
			return false;
		if (customerIndex != other.customerIndex)
			return false;
		return true;
	}

	public User getUserFromDB(int id) throws SQLException{
		Connection conn = ConnectionFactory.getInstance().getConnection();
		String sql = "select * from BANK_USER U where U.USERID = " + id;
		Statement s = conn.createStatement();
		ResultSet rs = s.executeQuery(sql);
		String type = "";
		while(rs.next()) {
			if(rs.getInt(7) == 1) {
				type = "admin";
			}
			else if(rs.getInt(7) == 2) {
				type = "employee";
			}
			else if(rs.getInt(7) == 3) {
				type = "customer";
			}
			return Main.uFactory.createUser(type, rs.getString(2), rs.getString(3), rs.getInt(4), rs.getString(5), rs.getString(6), 
					rs.getString(8),rs.getString(9), null, -1, rs.getInt(1));
		}
			
		return null;

	}
	
	public int saveUser() throws SQLException{
		Connection conn = ConnectionFactory.getInstance().getConnection();
		String sql = "insert into BANK_USER(USERID, FIRSTNAME, LASTNAME, AGE, ADDRESS, PHONE,PID,UserName,Password) values(?, ?, ?, ?, ?, ?, ?, ?, ?)";
		
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, getUser_ID());
		pstmt.setString(2, getFirstName());
		pstmt.setString(3, getLastName());
		pstmt.setInt(4, getAge());
		pstmt.setString(5, getAddress());
		pstmt.setString(6, getPhone());
		String type = getType();
		if(type.equalsIgnoreCase("admin")){
			pstmt.setInt(7, 0);
		}
		else if(type.equalsIgnoreCase("employee")){
			pstmt.setInt(7, 1);
		}
		else if(type.equalsIgnoreCase("customer")){
			pstmt.setInt(7, 2);
		}
		pstmt.setString(8,getUsername());
		pstmt.setString(9,getPassword());
		return pstmt.executeUpdate();
	}

	@Override
	public void updateUser(int User_ID) throws SQLException {
		
	}

	@Override
	public List<User> getAllUser() throws SQLException {
		return null;
	}

	@Override
	public int deleteUser(int... ids) throws SQLException {
		return -1;
	}


	
	
	
	
	
}
