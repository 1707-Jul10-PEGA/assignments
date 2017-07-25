package com.revature.banking;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public abstract class BankAccount implements AccountDAO{
	private String acctName;
	private double balance;
	private String type;
	private int ACCID;
	private int CID;
	
	public int getACCID() {
		return ACCID;
	}
	public void setACCID(int aCCID) {
		ACCID = aCCID;
	}
	public BankAccount(String name, double balance, String type, int ACCID,int CID) {
		super();
		this.acctName = name;
		this.balance = balance;
		this.type = type;
		this.ACCID = ACCID;
		this.CID=CID;
	}
	public int getCID() {
		return CID;
	}
	public void setCID(int cID) {
		CID = cID;
	}
	public String getAcctName() {
		return acctName;
	}

	public void setAcctName(String acctName) {
		this.acctName = acctName;
	}
	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return "Account Name=" + acctName + " balance=" + balance + ", type=" + type+"\n";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(balance);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((type == null) ? 0 : type.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BankAccount other = (BankAccount) obj;
		if (Double.doubleToLongBits(balance) != Double.doubleToLongBits(other.balance))
			return false;
		if (type == null) {
			if (other.type != null)
				return false;
		} else if (!type.equals(other.type))
			return false;
		return true;
	}
	
	public double deposit(double amount) {
		double newBalance = this.balance + amount;
		setBalance(newBalance);
		return newBalance;
	}
	public double withdraw(double amount) {
		double newBalance = this.balance - amount;
		setBalance(newBalance);
		return newBalance;
	}
	public BankAccount getAccount(int id) throws SQLException{
		Connection conn = ConnectionFactory.getInstance().getConnection();
		String sql = "select * from Account where A.ACCID = " + id;
		Statement s = conn.createStatement();
		ResultSet rs = s.executeQuery(sql);
		String type = "";
		String name = "";
		double amount = 0;
		double interest = 0;
		while(rs.next()) {
			name = rs.getString(2);
			amount = rs.getDouble(3);
		}
		sql = "select * from Account where A.ACCID = " + id;
		Statement st = conn.createStatement();
		ResultSet rs2 = st.executeQuery(sql);
		return Main.getbFactory().createBankAccount(name, "checking", amount, interest,id, id);

	}
	
	public int saveAccount(BankAccount a) throws SQLException{
		Connection conn = ConnectionFactory.getInstance().getConnection();
		String sql = "insert into Account(?,?,?,?,?,?)";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, getACCID());
		pstmt.setDouble(2, getBalance());
		pstmt.setInt(3, getACCID());
		pstmt.setString(4, "saving");
		pstmt.setString(5, "active");
		pstmt.setInt(6, 1);
		return pstmt.executeUpdate();
	}
	
	public void updateAccount(BankAccount a,String type) throws SQLException{
		
	}
	
	public List<BankAccount> getAllAccount() throws SQLException{
		return null;
	}

	

}
