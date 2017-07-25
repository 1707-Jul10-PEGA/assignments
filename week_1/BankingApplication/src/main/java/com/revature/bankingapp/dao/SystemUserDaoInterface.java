package com.revature.bankingapp.dao;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import com.revature.bankingapp.entities.user.SystemUser;

public interface SystemUserDaoInterface {
	
	void setup() throws FileNotFoundException, IOException;

	SystemUser getSysteUser(String id) throws SQLException;
	
	SystemUser getUserByUsername(String username) throws SQLException;
	
	int saveSystemUser(SystemUser user);
	
	int updateSystemUser(SystemUser user);
	
	List<SystemUser> getAllSystemUsers();
	
	
}
