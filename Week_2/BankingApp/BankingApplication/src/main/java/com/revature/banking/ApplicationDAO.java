package com.revature.banking;

import java.sql.SQLException;

public interface ApplicationDAO {
	Application getApplication(int id) throws SQLException;
	
	int saveUser(Application app) throws SQLException;
	
	void updateApplication(int id,Application app) throws SQLException;
	
	java.util.List<Application> getAllApplication() throws SQLException;
	
	int deleteApplication(int ... ids) throws SQLException;
}
