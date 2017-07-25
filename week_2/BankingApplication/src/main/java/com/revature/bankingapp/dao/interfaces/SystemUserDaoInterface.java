package com.revature.bankingapp.dao.interfaces;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import com.revature.bankingapp.entities.user.SystemUser;

public interface SystemUserDaoInterface {

	SystemUser getSysteUser(String id) throws SQLException;

	int saveSystemUser(SystemUser user);

	int updateSystemUser(SystemUser user);

	void setup() throws FileNotFoundException, IOException;

	List<SystemUser> getAllSystemUsers();

	SystemUser getUserByUsername(String usernameIn) throws SQLException;

}
