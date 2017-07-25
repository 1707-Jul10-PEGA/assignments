package com.revature.banking;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Employee extends User{

	private ArrayList<Integer> customerList = new ArrayList<Integer>();
	public Employee(String firstName, String lastName, int age, String phone, String address, String username,
			String password, ArrayList<Integer> customerList, int User_ID) {
		super(firstName, lastName, age, phone, address, username, password, "employee",User_ID);
		this.customerList = customerList;
	}
	public void viewCustomerAccount(int index) {
		if(checkIfCustomer(index)) {
			Customer current = (Customer)Main.getCustomerBA().get(index);
			for(int i: current.getAcctIndex()) {
				System.out.println(Main.getBankAcc().get(i));
			}
			
		}
		else {
			System.out.println("Invalid: You have no access to this customer information");
		}
	}
	
	public boolean checkIfCustomer(int index) {
		for(Integer i: customerList) {
			if(index == i) {
				return true;
			}
		}
		return false;
	}
	
	/**
	 * Remove the application from the application ArrayList at index
	 * @param index index of the application in the application arrayList in Main
	 */
	public void approveApplication(int index) {
		Application app = Main.application.get(index);
		Scanner input = new Scanner(System.in);
		System.out.println("Please input name of account:");
		String name = input.nextLine();
		String type = app.getType();
		Double savingInterest = 0.0;
		if("saving".equals(type)) {
			System.out.println("Please input interest in double:");
			savingInterest = Double.parseDouble(input.nextLine());
		}
		System.out.println("Please input Account ID:");
		int id = Integer.parseInt(input.nextLine());
		Main.Log.trace("approving application: " + app);
		BankAccount acc = new BankAccountFactory().createBankAccount(name, type, app.getAmount(), savingInterest,id,app.getCID());
		try {
			Main.Log.trace("Saving Account in Employee : " + acc);
			//setAccountToCustomer(id, app.getCID());
			acc.saveAccount();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		int customerIndex = ((Customer)app.getUser()).getCustomerIndex();
//		Customer currentCustomer = ((Customer)app.getUser());
//		ArrayList<Integer> newAccList = currentCustomer.getAcctIndex();
//		newAccList.add(Main.bankAcc.size()-1);
//		currentCustomer.setAcctIndex(newAccList);
//		Main.customerBA.set(custo1merIndex, currentCustomer);
		Main.application.remove(index);
		System.out.println("Account Approved!");
		
	}
	
	public void denyApplication(int index) {
		Main.application.remove(index);
		System.out.println("Account Denied!");
	}
	public ArrayList<Integer> getCustomerList() {
		return customerList;
	}
	public void setCustomerList(ArrayList<Integer> customerList) {
		this.customerList = customerList;
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
		// TODO Auto-generated method stub
		
	}
	@Override
	public List<User> getAllUser() throws SQLException {
		Connection conn = ConnectionFactory.getInstance().getConnection();
		List<Integer> c_list = getCustomerIDs();
		List<User> list = new ArrayList<User>();
		String sql = "select * from BANK_USER";
		Statement s = conn.createStatement();
		ResultSet rs = s.executeQuery(sql);
		String type = "";
		while(rs.next()) {
			if(c_list.contains(rs.getInt(1))) {
				if(rs.getInt(7) == 1) {
					type = "admin";
				}
				else if(rs.getInt(7) == 2) {
					type = "employee";
				}
				else if(rs.getInt(7) == 3) {
					type = "customer";
				}
				list.add(Main.uFactory.createUser(type, rs.getString(2), rs.getString(3), rs.getInt(4), rs.getString(5), rs.getString(6), 
						rs.getString(8),rs.getString(9), null, -1, rs.getInt(1)));
			}
			
		}
			
		return list;
	}
	@Override
	public int deleteUser(int... ids) throws SQLException {
		return -1;
	}
	public List<Integer> getCustomerIDs() throws SQLException {
		Connection conn = ConnectionFactory.getInstance().getConnection();
		List<Integer> list = new ArrayList<Integer>();
		String sql = "select CID from Customer where UserID = " + getUser_ID();
		Statement s = conn.createStatement();
		ResultSet rs = s.executeQuery(sql);
		String type = "";
		while(rs.next()) {
			list.add(rs.getInt(1));
		}
			
		return list;
	}
	//TODO
	public void displayCustomerAccount() {

		Connection conn = ConnectionFactory.getInstance().getConnection();
		try {
			List<Integer> a_list = getCustomerIDs();
			String sql = "select * from BANK_USER";
			Statement s = conn.createStatement();
			ResultSet rs = s.executeQuery(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	public void setEmployeeToCustomer(int customerIndex, int employeeIndex) {
		Connection conn = ConnectionFactory.getInstance().getConnection();
		String sql = "insert into Customer values(?,?)";
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, customerIndex);
			pstmt.setInt(2, employeeIndex);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	public void setAccountToCustomer(int accountIndex, int customerIndex) {
		Connection conn = ConnectionFactory.getInstance().getConnection();
		String sql = "insert into CUSTOMER_ACCOUNT values(?,?)";
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, customerIndex);
			pstmt.setInt(2, accountIndex);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
}
