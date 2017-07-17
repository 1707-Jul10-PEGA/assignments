package com.TS.banking.actions;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.StringTokenizer;

import org.apache.log4j.Logger;

import com.TS.banking.resources.Storage;
import com.TS.banking.resources.UserInputTest;

/*
 * Employee class which gives function to a employee that has logged in
 */
public class Employee extends BalanceViewer{
	private static Logger Log = Logger.getRootLogger();
	
	/*
	 * Invokes a menu for employees that are logged in
	 */
	public static void menuAction() {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		Scanner scanLine = new Scanner(System.in);
		
		Log.info("Hello " + Storage.userID + ", what would you like to do?:\n");
		/*Loops through the menu commands until the employee exits*/
		while(true)
		{
			Log.info("\n1. Approve/Deny applications\n");
			Log.info("2. View a customer's account balance\n");
			Log.info("3. Exit\n");
			Log.info("Please choose: ");
			/*Checking user input before switch statement goes out*/
			String menuNumber = scanLine.nextLine();
			if(!UserInputTest.testIsInt(menuNumber))
			{ 
				Log.info("Invalid choice\n");
				continue;
			}
			
			switch(Integer.valueOf(menuNumber))
			{
			case 1:
				/*Approve or deny applications.*/
				try {
					approveOrDeny();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				break;
			case 2:
				/*Asks user which account he or she would like to view*/
				Log.info("Which customer's account balance would you like to view?: ");
				String customer = scanLine.nextLine();
				try {
					Log.info(viewBalance(customer));
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				Log.info("\n");
				break;
			case 3:
				/*Exits the while loop*/
				return;
			default:
				Log.error("Invalid choice\n");
			}
		}
		
	}
	
	/*
	 * This method searches for every unlooked balance accounts. Employee will then be able to
	 * approve or deny the unlooked accounts which will then be activated when approved. Unlooked
	 * accounts are treated as applications
	 */
	private static void approveOrDeny() throws IOException
	{
		Scanner scanLine = new Scanner(System.in);
		
		File tempFile = new File("tempBalanceInfo.txt");
		BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile));
		
		/*Searches through the file and prints out the application, if any*/
		int iterator = 0;
		boolean unlookedFound = false;
		BufferedReader approver = new BufferedReader(new FileReader("BalanceInfo.txt"));
		String tokenizedString;
		try {
		    String line = approver.readLine();
		    while (line != null) 
		    {
		    	if(unlookedFound)
		    	{ break; }
		    	StringTokenizer tokenizer = new StringTokenizer(line);
		    	while(tokenizer.hasMoreTokens())
		    	{
		    		tokenizedString = tokenizer.nextToken();
			        if("approved".equals(tokenizedString) || "denied".equals(tokenizedString))
			        {
			        	break;
			        }
			        if(iterator == 1)
			        {
			        	Storage.userID = tokenizedString;
			        }
			        if(iterator == 2)
			        {
			        	Storage.firstName = tokenizedString;
			        }
			        if(iterator == 3)
			        {
			        	Storage.lastName = tokenizedString;
			        }
			        if(iterator == 4)
			        {
			        	Storage.money = Double.valueOf(tokenizedString);
			        	Log.info("APPLICATION TO APPROVE...\n");
			        	Log.info("Online ID : " + Storage.userID + "\n");
			        	Log.info("First Name: " + Storage.firstName + "\n");
			        	Log.info("Last Name : " + Storage.lastName + "\n");
			        	iterator = 0;
			        	unlookedFound = true;
			        	break;
			        }
			        iterator += 1;
			        
		    	}
		    	line = approver.readLine();
		    }
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
		    try {
				approver.close();
				//writer.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		/*exits if there are no applications to look at*/
		if(!unlookedFound)
		{ 
			Log.info("There are currently no applications\n");
			return;
		}
		
		/*Finds the string to be replaced, and rewrites it to a temporary file. Rewrites to main file using temporary file*/
		Log.info("\nApprove or Deny?: ");
		String approval = scanLine.nextLine();
		int balanceInfoFields = 0;
		int approvalLimiter = 0;
		BufferedReader approveChanger = new BufferedReader(new FileReader("BalanceInfo.txt"));
		if("Approve".equals(approval) || "Deny".equals(approval))
		{
			try {
			    String line = approveChanger.readLine();
			    iterator = 0;
			    while (line != null) {
			    	StringTokenizer tokenizer = new StringTokenizer(line);
			    	while(tokenizer.hasMoreTokens())
			    	{
			    		tokenizedString = tokenizer.nextToken();
				        if(("approved".equals(tokenizedString) || "denied".equals(tokenizedString)))
				        {
				        	writer.write(line + "\n");
				        	break;
				        }
				        if("unlooked".equals(tokenizedString) && approvalLimiter == 1)
				        {
				        	writer.write("unlooked ");
				        }
				        if("unlooked".equals(tokenizedString) && approvalLimiter == 0)
				        {
				        	if("Approve".equals(approval))
				        	{ writer.write("approved "); }
				        	if("Deny".equals(approval))
				        	{ writer.write("denied "); }
				        	approvalLimiter += 1;
				        }
				        if(iterator == 1)
				        {
				        	Storage.userID = tokenizedString;
				        	writer.write(Storage.userID + " ");
				        }
				        if(iterator == 2)
				        {
				        	Storage.firstName = tokenizedString;
				        	writer.write(Storage.firstName + " ");
				        }
				        if(iterator == 3)
				        {
				        	Storage.lastName = tokenizedString;
				        	writer.write(Storage.lastName + " ");
				        }
				        if(iterator == 4)
				        {
				        	Storage.money = Double.valueOf(tokenizedString);
				        	writer.write(Storage.money + "\n");
				        	iterator = 0;
				        	break;
				        }
				        
				        iterator += 1;
			    	}
			    	line = approveChanger.readLine();
			    }
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
			    try {
					approveChanger.close();
					writer.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		else
		{
			Log.error("Invalid Choice\n");
		}
		/*replaces the temporary file with the main file and then deletes the temporary file*/
		Storage.replaceFile();
		tempFile.delete();
	}
	
	private Employee()
	{
		
	}
}
