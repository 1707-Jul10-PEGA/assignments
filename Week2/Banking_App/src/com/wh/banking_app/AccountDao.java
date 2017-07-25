package com.wh.banking_app;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.sql.Savepoint;
import java.util.List;

import org.apache.log4j.Logger;

public class AccountDao {
    private static Logger Log = Logger.getRootLogger();
    private Connection conn = null;

    public void setup() throws SQLException {

	conn = ConnectionFactory.getInstance().getConnection();

    }

    public AccountDao() throws SQLException {

	setup();

    }

    public Account getPendingAccount() throws SQLException {
	Log.info("Getting account from database.");
	String sql = "SELECT * FROM BANK_ACCOUNT WHERE STATUS = 'PENDING'";
	PreparedStatement pstmt = conn.prepareStatement(sql);

	ResultSet rs = pstmt.executeQuery();

	if (rs.next()) {
	    CheckingAccount ca = new CheckingAccount();
	    ca.setId(rs.getInt(2));
	    ca.setBalance(rs.getDouble(3));
	    ca.setUserID(rs.getInt(4));
	    rs.close();
	    pstmt.close();
	    return ca;
	}
	Log.error("failed to get account!");
	return null;
    }
    
    public Account getAccount(Customer customer) throws SQLException {
	Log.info("Getting account from database.");
	String sql = "SELECT * FROM BANK_ACCOUNT WHERE U_ID = ?";
	PreparedStatement pstmt = conn.prepareStatement(sql);
	pstmt.setLong(1, customer.getId());

	ResultSet rs = pstmt.executeQuery();

	if (rs.next()) {
	    CheckingAccount ca = null;
	    switch (rs.getString(6)) {
	    case "PENDING":
		ca = new CheckingAccount(customer,rs.getDouble(3), 0);
		break;
	    case "APPROVED":
		ca = new CheckingAccount(customer,rs.getDouble(3), 1);
		break;
	    case "DENIED":
		ca = new CheckingAccount(customer,rs.getDouble(3), -1);
		break;
	    default:
		Log.error("Account found has no status!!!");
		break;
	    }
	    ca.setId(rs.getInt(2));
	    ca.setUserID(rs.getInt(4));
	    pstmt.close();
	    rs.close();
	    return ca;
	}
	Log.error("failed to get account!");
	return null;
    }

    public int saveAccount(Account acc, Customer customer) throws SQLException {
	Log.info("Saving account to database.");
	try {
	    CheckingAccount ca = (CheckingAccount) acc;
	    conn.setAutoCommit(false);

	    String sql = "INSERT INTO BANK_ACCOUNT(LAST_ACCESSED, ACC_ID, BALANCE, U_ID, ACC_TYPE, STATUS ) values(?, ?, ?, ?, ?, ?)";
	    PreparedStatement pstmt = conn.prepareStatement(sql);
	    pstmt.setString(1, "25-jul-17 03.57.56.249762000");
	    pstmt.setLong(2, ca.getId());
	    pstmt.setDouble(3, ca.viewBalance());
	    pstmt.setLong(4, customer.getId());
	    pstmt.setLong(5, 0);
	    pstmt.setString(6, customer.getCheckingAccount().status());

	    Savepoint s = conn.setSavepoint();

	    int num = pstmt.executeUpdate();

	    // ResultSet rs = pstmt.getGeneratedKeys();
	    if (num > 1) {
		conn.rollback();
	    }

	    conn.commit();

	    conn.setAutoCommit(true);

	    pstmt.close();

	    // rs.next();

	    return 1;// rs.getInt(1);
	} catch (SQLIntegrityConstraintViolationException e) {
	    Log.error("Failed to save account!");
	    e.printStackTrace();
	    return -1;
	}
    }

    public void updateAccount(Account acc) throws SQLException {
	Log.info("updating account in database.");
	try {
	    CheckingAccount ca = (CheckingAccount) acc;
	    conn.setAutoCommit(false);

	    String sql = "UPDATE BANK_ACCOUNT SET LAST_ACCESSED = ?, BALANCE = ?, STATUS = ? WHERE ACC_ID = ? AND U_ID = ?";
	    PreparedStatement pstmt = conn.prepareStatement(sql);
	    pstmt.setString(1, "25-jul-17 03.57.56.249762000");
	    pstmt.setDouble(2, ca.viewBalance());
	    pstmt.setString(3, acc.status());
	    pstmt.setInt(4, ca.getId());
	    pstmt.setInt(5, ca.getUserID());

	    Savepoint s = conn.setSavepoint();

	    int num = pstmt.executeUpdate();

	    // ResultSet rs = pstmt.getGeneratedKeys();
	    if (num > 1) {
		conn.rollback();
	    }

	    conn.commit();

	    conn.setAutoCommit(true);

	    pstmt.close();

	    // rs.next();

	} catch (SQLIntegrityConstraintViolationException e) {
	    Log.error("Failed to save account!");
	}

    }

    List<Account> getAllAccount() throws SQLException {
	return null;
    }

    int deleteAccount(int... ids) throws SQLException {
	return 0;
    }
}
