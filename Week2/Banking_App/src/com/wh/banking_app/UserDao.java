package com.wh.banking_app;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.sql.Savepoint;
import java.util.List;

import org.apache.log4j.Logger;

public class UserDao {
    private static Logger Log = Logger.getRootLogger();
    private Connection conn = null;

    public void setup() throws SQLException {

	conn = ConnectionFactory.getInstance().getConnection();

    }

    public UserDao() throws SQLException {

	setup();

    }

    public User getUser(int userID) throws SQLException {
   	Log.info("Getting user from database.");
   	String sql = "SELECT * FROM USER_TABLE WHERE U_ID = ?";
   	PreparedStatement pstmt = conn.prepareStatement(sql);
   	pstmt.setInt(1, userID);

   	ResultSet rs = pstmt.executeQuery();

   	if (rs.next()) {
   	    int priv_id = rs.getInt(7);
   	    if (priv_id == 1) {
   		Customer c1 = new Customer(rs.getString(5), rs.getInt(6));
   		c1.setId(rs.getInt(1));
   		rs.close();
   		pstmt.close();
   		return c1;
   	    } else if (priv_id == 2) {
   		Employee e1 = new Employee(rs.getString(5), rs.getInt(6));
   		e1.setId(rs.getInt(1));
   		rs.close();
   		pstmt.close();
   		return e1;
   	    } else if (priv_id == 0) {
   		Admin a1 = new Admin(rs.getString(5), rs.getInt(6));
   		a1.setId(rs.getInt(1));
   		rs.close();
   		pstmt.close();
   		return a1;
   	    }
   	}
   	rs.close();
   	pstmt.close();
   	return null;
       }
    
    public User getUser(String username, int password) throws SQLException {
	Log.info("Getting user from database.");
	String sql = "SELECT * FROM USER_TABLE WHERE USERNAME = ? AND U_PASSWORD = ?";
	PreparedStatement pstmt = conn.prepareStatement(sql);
	pstmt.setString(1, username);
	pstmt.setLong(2, password);

	ResultSet rs = pstmt.executeQuery();

	if (rs.next()) {
	    int priv_id = rs.getInt(7);
	    if (priv_id == 1) {
		Customer c1 = new Customer(rs.getString(5), rs.getInt(6));
		c1.setId(rs.getInt(1));
		rs.close();
		pstmt.close();
		return c1;
	    } else if (priv_id == 2) {
		Employee e1 = new Employee(rs.getString(5), rs.getInt(6));
		e1.setId(rs.getInt(1));
		rs.close();
		pstmt.close();
		return e1;
	    } else if (priv_id == 0) {
		Admin a1 = new Admin(rs.getString(5), rs.getInt(6));
		a1.setId(rs.getInt(1));
		rs.close();
		pstmt.close();
		return a1;
	    }
	}
	rs.close();
	pstmt.close();
	return null;
    }

    public int saveUser(User user, int type) throws SQLException {
	Log.info("Saving user to database.");
	try {
	    conn.setAutoCommit(false);

	    String sql = "INSERT INTO USER_TABLE(U_ID, FIRST_NAME, LAST_NAME, AGE, USERNAME, U_PASSWORD, U_PRIVILEGES ) values(?, ?, ?, ?, ?, ?, ?)";
	    PreparedStatement pstmt = conn.prepareStatement(sql);
	    pstmt.setLong(1, 1);
	    pstmt.setString(2, "");
	    pstmt.setString(3, "");
	    pstmt.setLong(4, 0);
	    pstmt.setString(5, user.getName());
	    pstmt.setLong(6, user.getPassword());
	    pstmt.setLong(7, type);

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
	    Log.error("Failed to save user!");
	    return -1;
	}
    }

    public void updateUser(User user) throws SQLException {

    }

    public int deleteUser(int... ids) throws SQLException {
	return 0;

    }

    public List<User> getAllUsers() throws SQLException {
	return null;

    }

    private static void checkClass(User user) {
	System.out.println(user.getClass());
    }

    public static void main(String[] args) throws SQLException {
	Employee e1 = new Employee("CrissD", 1234);
	Customer c1 = new Customer("Blake", 1111);
	UserDao ud1 = new UserDao();
	ud1.saveUser(e1, 2);
	ud1.saveUser(c1, 1);
	User u1 = ud1.getUser("CrissD", 1234);
	System.out.println(u1.getClass());
    }
}
