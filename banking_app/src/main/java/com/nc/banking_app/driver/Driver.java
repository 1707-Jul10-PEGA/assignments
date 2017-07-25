package com.nc.banking_app.driver;

import java.io.FileReader;
import java.io.IOException;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import junit.framework.TestCase;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import com.nc.banking_app.actions.LoadData;
import com.nc.banking_app.actions.StartingApp;
import com.nc.banking_app.actions.UserAction;
import com.nc.banking_app.doa.ConnectionFactory;
import com.nc.banking_app.users.UserFactory;
import com.nc.banking_app.users.Users;

public class Driver implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	final static Logger logger = Logger.getLogger(Driver.class);

	public static void main(String[] args) throws IOException, NumberFormatException, ClassNotFoundException {
		PropertyConfigurator.configure("log4j.properties");

		List<Users> myList = new ArrayList<Users>();
		logger.debug("Start List: \n" + myList.toString());
		LoadData load = new LoadData();

		
		//Connection to database
		Connection conn = ConnectionFactory.getConnection();
		
		// Loop forever
		while (true) {
			int userIndex = -1;
			load.fileToList(myList);
			// Login or Registration
			StartingApp start = new StartingApp();
			logger.debug("After StartingApp: \n" + myList.toString());
			userIndex = start.control(myList, conn);
			// Skip if no user is selected
			if (userIndex < myList.size() && userIndex >= 0) {
				// Action section
				UserAction act = new UserAction();
				act.control(myList, userIndex);
				logger.debug("After UserAction: \n" + myList.toString());
			}
			// Reset user to nothing
			load.listToFile(myList);
		}
	}

}
