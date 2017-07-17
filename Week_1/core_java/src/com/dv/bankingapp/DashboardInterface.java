package com.dv.bankingapp;

public interface DashboardInterface {

	/* doCustomerOption
	 * return true if option succeeds
	 */
	public boolean doCustomerOption(User authUser, int code);

	/* doEmployeeOption
	 * return true if option succeeds
	 */
	public boolean doEmployeeOption(User authUser, int code);

	/* doAdminOption
	 * return true if option succeeds
	 */
	public boolean doAdminOption(User authUser, int code);

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
	 * view options for user type
	 */
	public void viewOptions(User authUser);

	/* prompt
	 * main prompt for the dashboard
	 */
	public void prompt(User authUser);

}
