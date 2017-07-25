package com.revature.bankingapp.main;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.revature.bankingapp.entities.user.Customer;
import com.revature.bankingapp.entities.user.Employee;
import com.revature.bankingapp.entities.user.SystemUser;
import com.revature.bankingapp.dao.SystemUserDao;

public class Authentication {

	Connection conn = null;
	ResultSet resultSet = null;
	Statement statement = null;

	public <T> SystemUser userAuthentication(String username, String password, SystemUser u)
			throws FileNotFoundException, IOException {

		SystemUser user = null;

		SystemUserDao userdao = new SystemUserDao();

		userdao.setup();
		try {
			user = userdao.getUserByUsername(username);

			if (user != null) {
				if (!user.getPassword().equals(password)) {
					return null;
				}else
					return user;
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println(user);

		return user;

	}
}
