package com.MS.BankApp;

import java.util.Scanner;
import com.MS.BankApp.Application;

public class Employee extends User{
	String privileges = "employee";
	String menuchoice;

	public Employee(String name) {
		// TODO Auto-generated constructor stub
		this.name = name;
	}

	public void menu() {
		// TODO Auto-generated method stub
		while(!"end".equals(menuchoice))
		{
		
			Application.logger.info("1. View your customer account balances");
			Application.logger.info("2. Approve account requests");
			Application.logger.info("3. Deny account requests");
			Application.logger.info("4. Logout\n");
			
			Scanner scan = new Scanner(System.in);
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
				this.approveAccounts();
				break;
			}
			case("3"):
			{
				this.denyAccounts();
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
				Application.logger.error("Input not recognized.\nReturning to menu");
				break;
			}
			}
		}
		
	}

	private void denyAccounts() {
		// TODO Auto-generated method stub
		Application.logger.info("Deny which account request? (username)");
		User.scan = new Scanner(System.in);
		String denieduser = User.scan.nextLine();
		
		for(int i = 0; i < Application.newusercount; i++)
		{
			if(Application.namelist[i].equals(denieduser) && Application.assignedto[i].equals(this.name))
			{
				Application.requests[i] = "null";
			}
			else if(Application.namelist[i].equals(denieduser) && !Application.assignedto[i].equals(this.name))
			{
				Application.logger.error("This customer is not assigned to you");
			}
			else if("null".equals(Application.requests[i].toLowerCase()))
			{
				Application.logger.error("Error: Customer does not have a pending request.");
			}
		}
		System.out.println();
		
	}

	private void approveAccounts() {
		// TODO Auto-generated method stub
		
		Application.logger.info("Approve which account request? (username)");
		User.scan = new Scanner(System.in);
		String approveduser = User.scan.nextLine();
		
		for(int i = 0; i < Application.newusercount; i++)
		{
			if(Application.namelist[i].equals(approveduser) && Application.assignedto[i].equals(this.name))
			{
				if("checking".equals(Application.requests[i].toLowerCase()))
				{
					Application.checlist[i] = "0";
					Application.acctlist[i] = Integer.toString(Integer.parseInt(Application.acctlist[i])+1);
					Application.requests[i] = "null";
					Application.logger.debug("Checking account for " + Application.namelist[i] + " created!");
				}
				else if("savings".equals(Application.requests[i].toLowerCase()))
				{
					Application.savlist[i] = "0";
					Application.acctlist[i] = Integer.toString(Integer.parseInt(Application.acctlist[i])+1);
					Application.requests[i] = "null";
					Application.logger.debug("Savings account for " + Application.namelist[i] + " created!");
				}
				else if("null".equals(Application.requests[i].toLowerCase()))
				{
					Application.logger.error("Error: Customer does not have a pending request.");
				}
			}
			else if(Application.namelist[i].equals(approveduser) && !Application.assignedto[i].equals(this.name))
			{
				Application.logger.error("This customer is not assigned to you");
			}
			/*else
			{
				System.out.println("Customer does not exist");
			}*/
		}
		System.out.println();
		
	}

	private void viewAccounts() {
		// TODO Auto-generated method stub
		
		Application.logger.info("Showing your customers accounts:");
		for(int i = 0; i<Application.privlist.length;i++)
		{
			String s = Application.privlist[i];
			if("customer".equals(s) && this.name.equals(Application.assignedto[i]))
			{
				Application.logger.debug("User=" + Application.namelist[i] + " Checking balance="
						+ Application.checlist[i] + " Savings balance="+ Application.savlist[i]
						+ " Pending requests="+ Application.requests[i]);
			}
		}
		System.out.println();
		
	}


}
