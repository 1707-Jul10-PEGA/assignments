package com.TS.banking.resources;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Savepoint;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.TS.banking.pojo.BalanceInfo;
import com.TS.banking.pojo.LoginInfo;

public class BankingAppDaoImpl implements BankingAppDao {
	Connection conn = null;
	
	public void setup(){
		
		conn = ConnectionFactory.getInstance().getConnection();
	}
	
	public BankingAppDaoImpl(){
		setup();
	}
	
	@Override
	public BalanceInfo getBalanceInfo(String login, int task) throws SQLException {
		// TODO Auto-generated method stub
		boolean check = false;
		BalanceInfo values = new BalanceInfo();
		
		conn.setAutoCommit(false);

		if(task == 2)
		{
			String sql = "SELECT * FROM BalanceInfo WHERE applicationStatus='unlooked'";
			Statement stmt = conn.createStatement();
			ResultSet rss = stmt.executeQuery(sql);
			if(!rss.next())
			{ return null; }
			values.setApplicationStatus(rss.getString(1));
			values.setLoginID(rss.getString(2));
			values.setFirstName(rss.getString(3));
			values.setLastName(rss.getString(4));
			values.setBalance(rss.getDouble(5));
			System.out.println("\nAPPLICATION TO APPROVE...");
			System.out.println("Online ID : " + values.getLoginID());
        	System.out.println("First Name: " + values.getFirstName());
        	System.out.println("Last Name : " + values.getLastName());
			
			return values;
		}
		
		String sql = "SELECT * FROM BalanceInfo WHERE loginID=?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, login);
		ResultSet rs = pstmt.executeQuery();
		while(rs.next())
		{
			values.setApplicationStatus(rs.getString(1));
			//if (task == 1) { System.out.print(values.ge()); }
			values.setLoginID(rs.getString(2));
			//if (task == 1) { System.out.print(values.getLoginPassword()); }
			values.setFirstName(rs.getString(3));
			//if (task == 1) { System.out.println(values.getPosition()); }
			values.setLastName(rs.getString(4));
			
			values.setBalance(rs.getDouble(5));

			check = true;
		}
		
		conn.commit();
		conn.setAutoCommit(true);
		
		if (check == false)
		{ return null; }
		return values;
	}

	@Override
	public int insertBalanceInfo(String status, String login, String firstName, String lastName, Double money)
			throws SQLException {
		// TODO Auto-generated method stub
		conn.setAutoCommit(false);
		
		String sql = "INSERT INTO BalanceInfo(applicationStatus, loginID, firstName, lastName, balance) values(?, ?, ?, ?, ?)";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, status);
		pstmt.setString(2, login);
		pstmt.setString(3, firstName);
		pstmt.setString(4, lastName);
		pstmt.setDouble(5, money);
		
		int num = pstmt.executeUpdate();
		conn.commit();
		conn.setAutoCommit(true);
		return num;
	}

	@Override
	public int deleteBalanceInfo(String login) throws SQLException {
		// TODO Auto-generated method stub
		conn.setAutoCommit(false);
		
		String sql = "DELETE FROM BalanceInfo WHERE loginID=?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, login);

		int num = pstmt.executeUpdate();
		conn.commit();
		conn.setAutoCommit(true);
		return num;
	}

	@Override
	public int updateBalanceInfo(String login, String newInfo, String field) throws SQLException {
		// TODO Auto-generated method stub
		conn.setAutoCommit(false);
		
		String tempSQL= "UPDATE BalanceInfo SET $field=? WHERE loginID=?";
		String sql = tempSQL.replace("$field", field);
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, newInfo);
		if ("balance".equals(field))
		{
			pstmt.setDouble(1, Double.valueOf(newInfo));
		}
		pstmt.setString(2, login);

		int num = pstmt.executeUpdate();
		conn.commit();
		conn.setAutoCommit(true);
		return num;
	}
	
	@Override
	public int updateBalanceMoney(String login, Double money) throws SQLException {
		// TODO Auto-generated method stub
		conn.setAutoCommit(false);
		
		String sql= "UPDATE BalanceInfo SET balance=? WHERE loginID=?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setDouble(1, money);
		pstmt.setString(2, login);

		int num = pstmt.executeUpdate();
		conn.commit();
		conn.setAutoCommit(true);
		return num;
	}

	@Override
	public LoginInfo getLoginInfo(String login, int task) throws SQLException {
		// TODO Auto-generated method stub
		boolean check = false;
		LoginInfo values = new LoginInfo();
		
		conn.setAutoCommit(false);

		String sql = "SELECT * FROM LoginInfo WHERE loginID=?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, login);
		ResultSet rs = pstmt.executeQuery();
		while(rs.next())
		{
			values.setLoginID(rs.getString(1));
			if (task == 1) { System.out.print(values.getLoginID()); }
			values.setLoginPassword(rs.getString(2));
			if (task == 1) { System.out.print(values.getLoginPassword()); }
			values.setPosition(rs.getInt(3));
			if (task == 1) { System.out.println(values.getPosition()); }
			check = true;
		}
		
		conn.commit();
		conn.setAutoCommit(true);
		
		if (check == false)
		{ return null; }
		return values;
	}

	@Override
	public int insertLoginInfo(String login, String password, int role) throws SQLException {
		// TODO Auto-generated method stub
		conn.setAutoCommit(false);
		
		String sql = "INSERT INTO LoginInfo(loginID, loginPassword, position) values(?, ?, ?)";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, login);
		pstmt.setString(2, password);
		pstmt.setInt(3, role);
		
		int num = pstmt.executeUpdate();
		conn.commit();
		conn.setAutoCommit(true);
		return num;
	}

	@Override
	public int deleteLoginInfo(String login) throws SQLException {
		// TODO Auto-generated method stub
		conn.setAutoCommit(false);
		
		String sql = "DELETE FROM LoginInfo WHERE loginID=?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, login);

		int num = pstmt.executeUpdate();
		conn.commit();
		conn.setAutoCommit(true);
		return num;
	}

	@Override
	public int updateLoginInfo(String login, String newInfo, String field) throws SQLException {
		// TODO Auto-generated method stub
		conn.setAutoCommit(false);
		
		String tempSQL= "UPDATE LoginInfo SET $field=? WHERE loginID=?";
		String sql = tempSQL.replace("$field", field);
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, newInfo);
		pstmt.setString(2, login);

		int num = pstmt.executeUpdate();
		conn.commit();
		conn.setAutoCommit(true);
		return num;
	}

	@Override
	public void insertLogTable(String command, String user) throws SQLException {
		// TODO Auto-generated method stub
		DateFormat dateFormatMDY = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
		Date now = new Date();
		String vDateMDY = dateFormatMDY.format(now);
		String vDateMDYSQL =  vDateMDY ;
		
		vDateMDYSQL = vDateMDYSQL.replaceAll("/", "-");
		
		conn.setAutoCommit(false);
		
		String sql = "INSERT INTO Log (currentTime, deposit, withdraw, appeals, denial, userName) values(TO_DATE(?,'mm-dd-yyyy hh24:mi:ss'), ?, ?, ?, ?, ?)";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, vDateMDYSQL);
		if("deposit".equals(command))
		{ pstmt.setInt(2, 1); }
		else
		{ pstmt.setInt(2, 0); }
		
		if("withdraw".equals(command))
		{ pstmt.setInt(3, 1); }
		else
		{ pstmt.setInt(3, 0); }
		
		if("appeals".equals(command))
		{ pstmt.setInt(4, 1); }
		else
		{ pstmt.setInt(4, 0); }
		
		if("denial".equals(command))
		{ pstmt.setInt(5, 1); }
		else
		{ pstmt.setInt(5, 0); }
		
		pstmt.setString(6, user);
		
		pstmt.executeUpdate();
		conn.commit();
		conn.setAutoCommit(true);
	}
}
