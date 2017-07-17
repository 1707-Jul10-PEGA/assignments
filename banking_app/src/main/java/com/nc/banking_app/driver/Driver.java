package com.nc.banking_app.driver;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import com.nc.banking_app.actions.LoadData;
import com.nc.banking_app.actions.StartingApp;
import com.nc.banking_app.actions.UserAction;
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
		logger.debug("Current list: \n" + myList.toString());
		LoadData load = new LoadData();

		// Loop forever
		while (true) {
			int userIndex = -1;
			load.fileToList(myList);
			logger.debug("After f2l: \n" + myList.toString());
			// System.out.println(myList);
			// Login or Registration
			StartingApp start = new StartingApp();
			logger.debug("After StartingApp: \n" + myList.toString());
			userIndex = start.control(myList);
			// System.out.println(myList);
			// Skip if no user is selected
			if (userIndex < myList.size() && userIndex >= 0) {
				// Action section
				UserAction act = new UserAction();
				act.control(myList, userIndex);
				logger.debug("After UserAction: \n" + myList.toString());
			}
			// System.out.println(myList);
			// Reset user to nothing
			load.listToFile(myList);
		}
	}

}
