package com.wh.banking_app;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.sql.Savepoint;

import org.apache.log4j.Logger;

public class TransactionLogDao {

    private static Logger Log = Logger.getRootLogger();
    private Connection conn = null;

    public void setup() throws SQLException {

	conn = ConnectionFactory.getInstance().getConnection();

    }

    public TransactionLogDao() throws SQLException {

	setup();

    }

    public int saveLog(String action, int userID, int accID, double amount) throws SQLException {
	Log.info("Logging transaction.");
	try {
	    conn.setAutoCommit(false);

	    String sql = "INSERT INTO TRANSACTION_LOG(ID, TIME_STAMP, ACTIVITY, U_ID, ACCOUNT, AMOUNT ) values(?, ?, ?, ?, ?, ?)";
	    PreparedStatement pstmt = conn.prepareStatement(sql);
	    pstmt.setInt(1, 0);
	    pstmt.setString(2, "25-jul-17 03.57.56.249762000");
	    pstmt.setString(3, action);
	    pstmt.setLong(4, userID);
	    pstmt.setLong(5, accID);
	    pstmt.setDouble(6, amount);

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
	    Log.error("Failed to log activity!");
	    return -1;
	}
    }

}
