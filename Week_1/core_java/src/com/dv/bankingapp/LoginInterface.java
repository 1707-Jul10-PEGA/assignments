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
	 * prompt for existing users
	 */
	public int promptLogin();
	
	/* saveUser
	 * write user to file
	 */
	public void saveUser(User user, String userName, String pw);

	/* createCustomer
	 * return 1 if customer entered available credentials
	 */
	public int createCustomer();
	
	/* createEmployee
	 * return 1 if employee entered available credentials
	 */
	public int createEmployee();
	
	/* createAdmin
	 * return 1 if admin entered available credentials
	 */
	public int createAdmin();

	/* prompt
	 * return 1 if user is verified; else 0
	 */
	public int prompt();

}
