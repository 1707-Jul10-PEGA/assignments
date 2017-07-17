package com.dv.bankingapp;

public interface LoginInterface {

	/* printCodes
	 * print out codes for the user
	 */
	public void printCodes();

	/* promptWelcome
	 * return code 0, 1, 2, or 3 to create specified user
	 */
	public int promptWelcome();

	/* removeSpaces
	 * removes spaces from user name
	 */
	public String removeSpaces(String userName);
	
	/* isUserAvailable
	 * return true if user exists
	 */
	public boolean userExists(String userName);
	
	/* isCorrectPassword
	 * return true if passwords match; else false
	 */
	public boolean isPasswordCorrect(User user, String pw);
	
	/* promptLogin
	 * return an existing user
	 */
	public User promptLogin();
	
	/* saveUser
	 * write user to file
	 */
	public void saveUser(User user, String userName, String pw, String type);

	/* createCustomer
	 * return customer with valid credentials
	 */
	public Customer createCustomer();
	
	/* createEmployee
	 * return employee with valid credentials
	 */
	public Employee createEmployee();
	
	/* createAdmin
	 * return admin with valid credentials
	 */
	public Admin createAdmin();

	/* prompt
	 * return user that wishes to access their account dashboard
	 */
	public User prompt();

}
