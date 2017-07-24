package com.TS.banking.resources;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Savepoint;
import java.sql.Statement;

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
	public boolean getBalanceInfo(String login, int task) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int insertBalanceInfo(String status, String login, String firstName, String lastName, Double money)
			throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteBalanceInfo(String login) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateBalanceInfo(String login, String newInfo, String field) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean getLoginInfo(String login, int task) throws SQLException {
		// TODO Auto-generated method stub
		conn.setAutoCommit(false);
		
		String sql = "SELECT * FROM LoginInfo WHERE loginID=?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, login);
		ResultSet rs = pstmt.executeQuery(sql);
		if (task == 1)
		{
			while(rs.next())
			{
				System.out.println("Id is: " + rs.getInt(1));
				System.out.println("Question is: " + rs.getString(2));
				System.out.println("Answer is : " + rs.getString(3));
			}
		}
		
		if (rs.next() == false)
		{ return false; }
		conn.commit();
		conn.setAutoCommit(true);
		return true;
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
		//return pstmt.executeUpdate();

		Savepoint s = conn.setSavepoint();
		int num = pstmt.executeUpdate();
		ResultSet rs = pstmt.getGeneratedKeys();
		if (num > 1){
			conn.rollback();
		}
		conn.commit();
		conn.setAutoCommit(true);
		//return rs.getInt(1);
		return num;
	}

	@Override
	public int deleteLoginInfo(String login) throws SQLException {
		// TODO Auto-generated method stub
		conn.setAutoCommit(false);
		
		String sql = "DELETE FROM LoginInfo WHERE loginID=?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, login);
		//return pstmt.executeUpdate();

		Savepoint s = conn.setSavepoint();
		int num = pstmt.executeUpdate();
		ResultSet rs = pstmt.getGeneratedKeys();
		if (num > 1){
			conn.rollback();
		}
		conn.commit();
		conn.setAutoCommit(true);
		//return rs.getInt(1);
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
		//return pstmt.executeUpdate();

		Savepoint s = conn.setSavepoint();
		int num = pstmt.executeUpdate();
		ResultSet rs = pstmt.getGeneratedKeys();
		if (num > 1){
			conn.rollback();
		}
		conn.commit();
		conn.setAutoCommit(true);
		//return rs.getInt(1);
		return num;
	}

}
