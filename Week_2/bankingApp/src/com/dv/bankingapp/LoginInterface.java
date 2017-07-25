package com.dv.bankingapp;

import java.sql.SQLException;

public interface LoginInterface {

	/* printCodes
	 * print out codes for the user
	 */
	public void printCodes();

	/* promptWelcome
	 * return code 0, 1, 2, or 3 to create specified user
	 */
	public int promptWelcome();

	/* hasSpaces
	 * returns true if username contains spaces
	 */
	public boolean hasSpaces(String userName);
	
	/* hasTooManyCharacters
	 * return true if username has a length greater than 10
	 */
	public boolean hasTooManyCharacters(String userName);
	
	/* isUserAvailable
	 * return true if user exists within the database
	 */
	public boolean userExists(String userName);
	
	/* isCorrectPassword
	 * return true if passwords in the database match; else false
	 */
	public boolean isPasswordCorrect(int uid, String pw) throws SQLException;

	/* getUser
	 * return an existing user id from the database
	 */
	public int getUserID(String userName) throws SQLException;
	
	/* getUserType
	 * return a user type for a user id
	 */
	public String getUserType(int uid) throws SQLException;
	
	/* authenticateCustomer
	 * authenticate a customer at login
	 */
	public void authenticateCustomer(int uid) throws SQLException;
	
	/* authenticateEmployee
	 * authenticate an employee at login
	 */
	public void authenticateEmployee(int uid) throws SQLException;
	
	/* authenticateAdmin
	 * authenticate an admin at login
	 */
	public void authenticateAdmin(int uid) throws SQLException;
	
	/* setAuthUser
	 * set the authenticated user from a given user id
	 */
	public void setAuthUser(int uid) throws SQLException;
	
	/* promptLogin
	 * return an existing user
	 */
	public void promptLogin();

	/* insertUser
	 * return the number of rows inserted; insert the user into the users table within the database
	 */
	public int insertUser(User user) throws SQLException;
	
	/* insertCustomer
	 * return the number of rows inserted; insert the customer into the customers table
	 */
	public int insertCustomer(Customer customer) throws SQLException;

	/* insertEmployee
	 * return the number of rows inserted; insert the employee into the employees table
	 */
	public int insertEmployee(Employee employee) throws SQLException;

	/* createCustomer
	 * create customer with valid credentials
	 */
	public void createCustomer();
	
	/* createEmployee
	 * create employee with valid credentials
	 */
	public void createEmployee();
	
	/* createAdmin
	 * create admin with valid credentials
	 */
	public void createAdmin();

	/* prompt
	 * prompt user that wishes to access their account dashboard
	 */
	public void prompt();

}
