package com.revature.bankingapp.dao;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.attribute.UserPrincipalLookupService;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.Properties;
import java.util.UUID;

import com.revature.bankingapp.utils.ConnectionFactory;
import com.revature.bankingapp.dao.interfaces.SystemUserDaoInterface;
import com.revature.bankingapp.entities.user.Customer;
import com.revature.bankingapp.entities.user.Employee;
import com.revature.bankingapp.entities.user.SystemUser;

public class SystemUserDao implements SystemUserDaoInterface {

	Connection conn = null;
	ResultSet resultSet = null;
	ConnectionFactory connFactory = null;

	@Override
	public SystemUser getSysteUserById(String id) throws SQLException {
		// TODO Auto-generated method stub
		conn = connFactory.getConnection();
		String sql = "SELECT * FROM SYSTEM_USER WHERE USER_ID = '" + id + "'";
		Statement statement = conn.createStatement();
		resultSet = statement.executeQuery(sql);

		SystemUser user = null;

		while (resultSet.next()) {
			String user_id = resultSet.getString("USER_ID");
			String firstname = resultSet.getString("F_NAME");
			String lastname = resultSet.getString("L_NAME");
			String username = resultSet.getString("USERNAME");
			String password = resultSet.getString("PASS_WORD");
			String dob = resultSet.getString("DOB");
			String address = resultSet.getString("ADDRESS");
			conn.close();
			return user = new SystemUser(firstname, lastname, username, password, dob, address, user_id);
			
		}
		conn.close();
		return user;
	}
	
	public SystemUser getSysteUserById(UUID id) throws SQLException {
		return getSysteUserById(id.toString());
	}
	

	@Override
	public SystemUser getUserByUsername(String usernameIn) throws SQLException {
		Connection conn = connFactory.getConnection();
		String sql = "SELECT * FROM SYSTEM_USER WHERE USERNAME = '" + usernameIn + "'";

		Statement statement = conn.createStatement();
		resultSet = statement.executeQuery(sql);

		SystemUser user = null;
		
		if (resultSet.next()) {
			String user_id = resultSet.getString("USER_ID");
			String firstname = resultSet.getString("F_NAME");
			String lastname = resultSet.getString("L_NAME");
			String username = resultSet.getString("USERNAME");
			String password = resultSet.getString("PASS_WORD");
			String dob = resultSet.getString("DOB");
			String address = resultSet.getString("ADDRESS");

		
			user = new SystemUser(firstname, lastname, username, password, dob, address, user_id);
			conn.close();
			return user;
		}

		conn.close();
		return null;

	}

	@Override
	public int saveSystemUser(SystemUser user) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateSystemUser(SystemUser user) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<SystemUser> getAllSystemUsers() {
		// TODO Auto-generated method stub
		return null;
	};

	@Override
	public void setup() throws FileNotFoundException, IOException {
		// TODO Auto-generated method stub
		connFactory = ConnectionFactory.getInstance();
	}

	public SystemUserDao() {
		try {
			setup();
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
