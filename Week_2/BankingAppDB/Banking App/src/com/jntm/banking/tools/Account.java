package com.jntm.banking.tools;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DecimalFormat;
import java.util.ArrayList;

import org.apache.log4j.Logger;

import com.jntm.banking.database.ConnectionFactory;

public class Account implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	// This is the ID of the Customer that owns the account
	private String ownerID;
	// This is the unique identifier for the account
	private String uniqueID;
	// This is the amount of money in it.
	private double balance;

	private static Logger log = Logger.getRootLogger();

	private static int accountCount = 0;
	// This is the list of all accounts in the system.
	public static ArrayList<Account> accList = new ArrayList<Account>();

	public Account(String ownerID) {
		super();
		accountCount++;
		this.ownerID = ownerID;
		this.balance = 0.00;
		this.uniqueID = accountCount + 100 + "";
		log.trace("New Account: " + this.uniqueID);
	}

	public static void readAccounts() throws SQLException {
		log.trace("Accounts being read into memory.");
		// Empties the accList
		// Then fills it from the DB
		accList.clear();

		Connection conn = ConnectionFactory.getInstance().getConnection();

		String insertSQL = "";

		Statement state = conn.createStatement();

		insertSQL = "SELECT * FROM bank_account";
		ResultSet rs = state.executeQuery(insertSQL);

		while (rs.next()) {
			
			Account a = new Account(rs.getString(3));
			a.setBalance(rs.getDouble(5));
			a.setUniqueID(rs.getDouble(4) + "");
			accList.add(a);
			
		}

		conn.close();

//		 String filename = "accountList.txt";
//		
//		 try {
//		 FileInputStream fis = new FileInputStream(filename);
//		 ObjectInputStream ois = new ObjectInputStream(fis);
//		
//		 boolean gate = true;
//		 while (gate) {
//		 Object obj = ois.readObject();
//		
//		 if (obj != null) {
//		 accList.add((Account) obj);
//		 accountCount++;
//		 } else {
//		 gate = false;
//		 }
//		
//		 }
//		 ois.close();
//		
//		 System.out.println("Accounts read successfully!");
//		
//		 PrintWriter pw;
//		 try {
//		 pw = new PrintWriter(filename);
//		 pw.close();
//		 } catch (FileNotFoundException e1) {
//		 // TODO Auto-generated catch block
//		 e1.printStackTrace();
//		 }
//		
//		 } catch (IOException | ClassNotFoundException e) {
//		 // e.printStackTrace();
//		 }

	}

	public static void writeAccounts() throws SQLException {
		log.trace("Accounts being written to file.");
		
		
		Connection conn = ConnectionFactory.getInstance().getConnection();

		
		String insertSQL = "";
		
		
		int counter=1;
		for (Account x : Account.accList) {
			
			insertSQL = "Update bank_account set user_id=(Select user_id from bank_user where realuserID = ?), realacctid=?, realuserid=?, balance=? where acct_id =?";
			//insertSQL = "INSERT into bank_account (user_id, realAcctID, realUserID, balance) values((Select user_id from bank_user where realuserID = ?),?,?,?)";
			PreparedStatement stmt = conn.prepareStatement(insertSQL);
			stmt.setString(1, x.getOwnerID());
			stmt.setString(2, x.getUniqueID());
			stmt.setString(3, x.getOwnerID());
			stmt.setDouble(4, Double.parseDouble(x.getBalance()));
			stmt.setDouble(5, counter);
			counter++;
			stmt.execute();
			stmt.close();
		}
		counter=1;

		// Clears the text file "accountList"
		// Then fills it with the contents of accList
		// Then clears accList
//		 String filename = "accountList.txt";
//		
//		 PrintWriter pw;
//		 try {
//		 pw = new PrintWriter(filename);
//		 pw.close();
//		 } catch (FileNotFoundException e1) {
//		 // TODO Auto-generated catch block
//		 e1.printStackTrace();
//		 }
//		
//		 try {
//		 FileOutputStream fos = new FileOutputStream(filename);
//		 ObjectOutputStream oos = new ObjectOutputStream(fos);
//		 for (Account x : accList) {
//		 oos.writeObject(x);
//		 }
//		 oos.close();
//		 System.out.println("Accounts have been saved successfully!");
//		
//		 } catch (IOException e) {
//		 System.out.println("WriteAccounts filewriting failed.");
//		 e.printStackTrace();
//		 }

		accList.clear();

	}

	public static void addToList(Account x) {
		// Justs adds a new account to accList
		// run whenever a new account is made.
		accList.add(x);
	}

	public String getUniqueID() {
		return uniqueID;
	}

	public void setUniqueID(String uniqueID) {
		this.uniqueID = uniqueID;
	}

	public String getOwnerID() {
		return ownerID;
	}

	public void setOwnerID(String ownerID) {
		this.ownerID = ownerID;
	}

	public String getBalance() {
		DecimalFormat myFormatter = new DecimalFormat("##0.00");

		return myFormatter.format(balance);
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public void depositMoney(double deposit) {
		balance += deposit;
	}

	public void withdrawMoney(double withdraw) {
		balance -= withdraw;
	}

	public String toString() {
		DecimalFormat myFormatter = new DecimalFormat("##0.00");
		return "This is Account #" + uniqueID + ". Balance is $" + myFormatter.format(balance) + ", " + ownerID;
	}

}
