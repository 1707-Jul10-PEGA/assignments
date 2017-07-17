package com.MS.BankApp;

import java.util.Scanner;
import com.MS.BankApp.Application;

public class Admin extends User{
	String privileges = "admin";
	String menuchoice;

	public Admin(String name) {
		// TODO Auto-generated constructor stub
		this.name = name;
	}

	public void menu() 
	{
		// TODO Auto-generated method stub
		
		while(!"end".equals(menuchoice))
		{
		
			Application.logger.info("1. View all account balances");
			Application.logger.info("2. Change user name");
			Application.logger.info("3. Change account balance");
			Application.logger.info("4. Logout\n");
		
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
				this.changeUser();
				break;
			}
			case("3"):
			{
				this.changeBalance();
				break;
			}
			case("4"):
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

	private void changeUser() {
		// TODO Auto-generated method stub
		Application.logger.info("Enter old/new usernames like so: \"OldName:NewName\"");
		User.scan = new Scanner(System.in);
		String userchange = User.scan.nextLine();
		String readdata[] = new String[2];
		readdata = userchange.split(":");
		
		for(int i=0; i<Application.namelist.length; i++)
		{
			if(Application.namelist[i].equals(readdata[0]))
			{
				Application.logger.debug("Username changed from "+Application.namelist[i]+" to "+readdata[1]);
				Application.namelist[i] = readdata[1];
			}
		}
	}

	private void changeBalance() {
		// TODO Auto-generated method stub
		Application.logger.info("Enter user/account/newbalance to be changed like so: \"User:account:newbalance\"\n");
		Application.logger.info("Note: Enter null as newbalance to remove an account");
		User.scan = new Scanner(System.in);
		String balancechange = User.scan.nextLine();
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
					}
					//Check if post balance is >=0
					else if(Double.parseDouble(readdata[2]) >= 0)
					{
						//Check is good
						Application.logger.debug("Balance for "+readdata[0]+" for account "
								+readdata[1]+" changed to "+readdata[2]);
						Application.checlist[i] = readdata[2];
					}
					else
					{
						//Check not passed
						Application.logger.error("Cannot have a negative balance");
						Application.logger.error("Returning to menu");
					}
				}
				else if("savings".equals(readdata[1].toLowerCase()))
				{
					//Check if input is "null"
					if("null".equals(readdata[2]))
					{
						Application.logger.debug("Removed account "+readdata[1]);
						Application.savlist[Application.userid] = "null";
					}
					//Check if post balance is >=0
					else if(Double.parseDouble(readdata[2]) >= 0)
					{
						//Check is good
						Application.savlist[i] = readdata[2];
					}
					else
					{
						//Check not passed
						Application.logger.error("Cannot have a negative balance");
						Application.logger.error("Returning to menu");
					}
				}
			}
		}
		
		
	}

	private void viewAccounts() {
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
