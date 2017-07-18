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
				Application.logger.info("Approve which account request? (username)");
				User.scan = new Scanner(System.in);
				String approveduser = User.scan.nextLine();
				this.approveAccounts(approveduser);
				break;
			}
			case("3"):
			{
				Application.logger.info("Deny which account request? (username)");
				User.scan = new Scanner(System.in);
				String denieduser = User.scan.nextLine();
				this.denyAccounts(denieduser);
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
/*
 * Denies the account request from a customer. Customer must be assigned to this employee
 * and have a pending request.
 */
	public void denyAccounts(String denieduser) {
		// TODO Auto-generated method stub
		int deniedflag = 0;
		for(int i = 0; i < Application.newusercount; i++)
		{
			if(Application.namelist[i].equals(denieduser) && Application.assignedto[i].equals(this.name)
					&& !"null".equals(Application.requests[i].toLowerCase()))
			{
				Application.logger.info("Application for " + Application.requests[i] + " denied!");
				deniedflag = i;
			}
			else if(Application.namelist[i].equals(denieduser) && !Application.assignedto[i].equals(this.name))
			{
				Application.logger.error("This customer is not assigned to you");
			}
			else if(Application.namelist[i].equals(denieduser) && "null".equals(Application.requests[i].toLowerCase()))
			{
				Application.logger.error("Error: Customer does not have a pending request.");
			}
		}
		if(deniedflag > 0)
		{
			Application.requests[deniedflag] = "null";
		}
		System.out.println();
		
	}
/*
 * Approves a customers account request. Customer must be assigned to this
 * employee. Number of accounts is updated and account begins at 0.
 */
	public void approveAccounts(String approveduser) {
		// TODO Auto-generated method stub
		
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
/*
 * View the accounts of all customers assigned to this employee.
 */
	public void viewAccounts() {
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
