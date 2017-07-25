package com.revature.banking;

import java.sql.SQLException;

public interface User_DAO {
	User getUserFromDB(int id) throws SQLException;
	
	int saveUser() throws SQLException;
	
	void updateUser(int User_ID) throws SQLException;
	
	java.util.List<User> getAllUser() throws SQLException;
	
	int deleteUser(int ... ids) throws SQLException;
}
