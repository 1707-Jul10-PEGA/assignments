package com.dv.bankingapp;

public interface DashboardInterface {
	
	/* updateUser
	 * update the user information in the database
	 */
	//public void updateUser(User user);

	/* doCustomerOption
	 * return true if option succeeds
	 */
	public boolean doCustomerOption(int code);

	/* doEmployeeOption
	 * return true if option succeeds
	 */
	public boolean doEmployeeOption(int code);

	/* doAdminOption
	 * return true if option succeeds
	 */
	public boolean doAdminOption(int code);

	/* getIntegerCode
	 * returns an integer from user input
	 */
	public int getIntegerCode();

	/* printCustomerOptions
	 * return an integer code for specified customer option; -1 for error
	 */
	public int getCustomerOptions();

	/* printEmployeeOptions
	 * return an integer code for specified employee option; -1 for error
	 */
	public int getEmployeeOptions();

	/* printAdminOptions
	 * return an integer code for specified admin option; -1 for error
	 */
	public int getAdminOptions();

	/* printOptions
	 * view options for user 
	 */
	public void viewOptions();

	/* prompt
	 * main prompt for the dashboard
	 */
	public void prompt();

}
