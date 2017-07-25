package com.dv.bankingapp;

import java.sql.SQLException;

public interface DashboardInterface {
	
	/* updateUser
	 * update the user information in the database
	 */
	//public void updateUser(User user);

	/* doCustomerOption
	 * return true if option succeeds
	 */
	public boolean doCustomerOption(int code) throws SQLException;

	/* doEmployeeOption
	 * return true if option succeeds
	 */
	public boolean doEmployeeOption(int code) throws SQLException;

	/* doAdminOption
	 * return true if option succeeds
	 */
	public boolean doAdminOption(int code) throws SQLException;

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
	public void viewOptions() throws SQLException;

	/* prompt
	 * main prompt for the dashboard
	 */
	public void prompt() throws SQLException;

}
