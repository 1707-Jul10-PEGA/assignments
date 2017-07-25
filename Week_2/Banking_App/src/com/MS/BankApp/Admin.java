package com.MS.BankApp;

import java.sql.SQLException;
import java.util.Scanner;
import com.MS.BankApp.Application;
import com.MS.OJDBC.UserDAO;

public class Admin extends User{
	String privileges = "admin";
	String menuchoice;

	public Admin(String name) {
		// TODO Auto-generated constructor stub
		this.name = name;
	}
/*
 * (non-Javadoc)
 * @see com.MS.BankApp.functions#menu()
 * 
 * Menu function for administrators. Allows user to select from
 * any of the admin functions. Loops back to menu UNLESS the user
 * selects logout (in which case, it goes back to the login menu)
 */
	public void menu() 
	{
		// TODO Auto-generated method stub
		
		while(!"end".equals(menuchoice))
		{
			UserDAO dao = new UserDAO();
			Application.logger.info("1. View all account balances");
			Application.logger.info("2. Change user name");
			Application.logger.info("3. Change account balance");
			Application.logger.info("4. View bank logs");
			Application.logger.info("5. Logout\n");
		
			User.scan = new Scanner(System.in);
			menuchoice = scan.nextLine();
		
			switch(menuchoice)
			{
			case("1"):
			{
				this.viewAccounts();
				break;
			}
			case("2"):
			{
				Application.logger.info("Enter old/new usernames like so: \"OldName:NewName\"");
				User.scan = new Scanner(System.in);
				String userchange = User.scan.nextLine();
				this.changeUser(userchange);
				break;
			}
			case("3"):
			{
				Application.logger.info("Enter user/account/newbalance to be changed like so: \"User:account:newbalance\"\n");
				Application.logger.info("Note: Enter null as newbalance to remove an account");
				User.scan = new Scanner(System.in);
				String balancechange = User.scan.nextLine();
				this.changeBalance(balancechange);
				break;
			}
			case("4"):
			{
				try {
					dao.viewLog();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;
			}
			case("5"):
			{
				this.logout();
				menuchoice = "end";
				break;
			}
			default:
			{
				Application.logger.error("Input not recognized. \nReturning to menu");
				break;
			}
			}
		}
		
	}
/*
 * Changes the username corresponding to an account. Input string should be
 * of the format "Olduser:Newuser"
 */
	public void changeUser(String userchange) {
		// TODO Auto-generated method stub
		UserDAO dao = new UserDAO();
		
		int changeflag = 0;
		String readdata[] = new String[2];
		readdata = userchange.split(":");
		
		for(int i=0; i<Application.newusercount; i++)
		{
			if(Application.namelist[i].equals(readdata[0]))
			{
				Application.logger.debug("Username changed from "+Application.namelist[i]+" to "+readdata[1]);
				Application.namelist[i] = readdata[1];
				
				try {
					dao.saveLog("Changed username", readdata[1], "", "");
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				changeflag = 1;
			}
		}
		if(changeflag==0)
		{
			Application.logger.error("Account not found");
		}
	}
/*
 * Changes the balance associated with a users account. Input should
 * be of the format "User:accounttype:amount"
 */
	public void changeBalance(String balancechange) {
		// TODO Auto-generated method stub
		UserDAO dao = new UserDAO();
		
		int changeflag = 0;
		String readdata[] = new String[3];
		readdata = balancechange.split(":");
		
		for(int i=0; i<Application.newusercount; i++)
		{
			if(Application.namelist[i].equals(readdata[0]))
			{
				if("checking".equals(readdata[1].toLowerCase()))
				{
					//Check if input is "null"
					if("null".equals(readdata[2]))
					{
						Application.logger.debug("Removed account "+readdata[1]);
						Application.checlist[i] = "null";
						
						try {
							dao.saveLog("Removed account", readdata[0], readdata[1], "");
						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						
						changeflag = 1;
					}
					//Check if post balance is >=0
					else if(Double.parseDouble(readdata[2]) >= 0)
					{
						//Check is good
						Application.logger.debug(readdata[0]+"'s account "
								+readdata[1]+" changed to "+readdata[2]);
						Application.checlist[i] = readdata[2];
						
						try {
							dao.saveLog("Admin change", readdata[0], readdata[1], readdata[2]);
						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						
						changeflag = 1;
					}
					else
					{
						//Check not passed
						Application.logger.error("Cannot have a negative balance");
						Application.logger.error("Returning to menu");
						changeflag = 1;
					}
				}
				else if("savings".equals(readdata[1].toLowerCase()))
				{
					//Check if input is "null"
					if("null".equals(readdata[2]))
					{
						Application.logger.debug("Removed account "+readdata[1]);
						Application.savlist[Application.userid] = "null";
						
						try {
							dao.saveLog("Removed account", readdata[0], readdata[1], "");
						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						
						changeflag = 1;
					}
					//Check if post balance is >=0
					else if(Double.parseDouble(readdata[2]) >= 0)
					{
						//Check is good
						Application.logger.debug(readdata[0]+"'s account "
								+readdata[1]+" changed to "+readdata[2]);
						Application.savlist[i] = readdata[2];
						
						try {
							dao.saveLog("Admin change", readdata[0], readdata[1], readdata[2]);
						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						
						changeflag = 1;
					}
					else
					{
						//Check not passed
						Application.logger.error("Cannot have a negative balance");
						Application.logger.error("Returning to menu");
						changeflag = 1;
					}
				}
			}
		}
		if(changeflag==0)
		{
			Application.logger.error("Account not found");
		}
		
		
	}
/*
 * Spits all created customer accounts to the console.
 */
	public void viewAccounts() {
		// TODO Auto-generated method stub
		
		for(int i = 0; i<Application.privlist.length;i++)
		{
			String s = Application.privlist[i];
			if("customer".equals(s))
			{
				Application.logger.info("User=" + Application.namelist[i] + " Checking balance="
						+ Application.checlist[i] + " Savings balance="+ Application.savlist[i]
						+ " Pending requests="+ Application.requests[i]);
			}
		}
		System.out.println();
		
	}
	
}
