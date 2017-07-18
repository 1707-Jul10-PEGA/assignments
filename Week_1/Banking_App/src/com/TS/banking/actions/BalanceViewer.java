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

/*
 * BalanceViewer is the class that is inherited by all user classes, able to view
 * balance information
 */
public class BalanceViewer {
	private static Logger Log = Logger.getRootLogger();
	/*
	 * Takes in a string, checks to see if that user exists, and returns the output String
	 */
	public static String viewBalance(String user) throws IOException
	{
		File searchFile = new File("BalanceInfo.txt");
		int balanceInfoFields = 0;
		BufferedReader br = new BufferedReader(new FileReader(searchFile));
		String tokenizedString;
	
		/*Searches through the file for the specific user and initializes the string to return*/
		try {
		    String line = br.readLine();

		    while (line != null) {
		    	StringTokenizer tokenizer = new StringTokenizer(line);
				while (tokenizer.hasMoreTokens())
				{
					tokenizedString = tokenizer.nextToken();
					if(balanceInfoFields == 0 && ("unlooked".equals(tokenizedString) || "denied".equals(tokenizedString)))
					{
						break;
					}
					if(balanceInfoFields == 1 && !user.equals(tokenizedString))
					{
						balanceInfoFields = 0;
						break;
					}
					/*balance fields initializing sequence*/
					if(balanceInfoFields == 1)
					{ 
						Storage.userID = user; 
					}
					if(balanceInfoFields == 2)
					{ Storage.firstName = tokenizedString; }
					if(balanceInfoFields == 3)
					{ Storage.lastName = tokenizedString; }
					if(balanceInfoFields == 4)
					{ Storage.money = Double.valueOf(tokenizedString); }
					
					balanceInfoFields += 1;
					if(!tokenizer.hasMoreTokens())
					{
						return Storage.print();
					}
				}

		        line = br.readLine();
		    }
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			br.close();
		}
		return "No account balance associated with this user\n";
	}
	
	/*
	 * This method searches for every unlooked balance accounts. Employee will then be able to
	 * approve or deny the unlooked accounts which will then be activated when approved. Unlooked
	 * accounts are treated as applications
	 */
	public static void approveOrDeny() throws IOException
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
			        	Log.info("\nAPPLICATION TO APPROVE...\n");
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
		Log.info("\n");
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
}
