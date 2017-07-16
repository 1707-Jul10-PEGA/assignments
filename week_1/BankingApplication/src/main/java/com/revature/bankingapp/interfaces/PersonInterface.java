package com.revature.bankingapp.interfaces;

public interface PersonInterface {

	/**
	 * Login method starts the authentication
	 * process.
	 * @return 1 if login successful, -1 if fail
	 */
	public int login(int id);
	
	
	/**
	 * Logs User out of the system
	 * @return 1 if logout sucessful, -1 if fail
	 */
	public int logout(int id);
	
		
	
}
