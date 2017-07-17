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

import com.TS.banking.pojo.Storage;

public class Employee extends BalanceViewer{
	private static Logger Log = Logger.getRootLogger();
	
	public static void menuAction() {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		Scanner scanLine = new Scanner(System.in);
		
		Log.info("Hello " + Storage.userID + ", what would you like to do?:\n");
		
		while(true)
		{
			Log.info("1. Approve/Deny applications\n");
			Log.info("2. View a customer's account balance\n");
			Log.info("3. Exit\n");
			Log.info("Please choose: ");
			int menuNumber = scan.nextInt();
			Log.info("\n");
			
			switch(menuNumber)
			{
			case 1:
				try {
					approveOrDeny();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				break;
			case 2:
				Log.info("Which customer's account balance would you like to view?: ");
				String customer = scanLine.nextLine();
				try {
					Log.info(viewBalance(customer));
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				//viewBalance(customer);
				break;
			case 3:
				return;
			default:
				Log.error("Invalid choice\n");
			}
		}
		
	}
	
	private static void approveOrDeny() throws IOException
	{
		Scanner scanLine = new Scanner(System.in);
		
		File tempFile = new File("tempBalanceInfo.txt");
		BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile));
		
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
//		    	if(!tokenizer.hasMoreTokens())
//		    		break;
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
			        	Log.info(Storage.print());
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
		if(!unlookedFound)
		{ 
			Log.info("There are currently no applications\n");
			return;
		}
		
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
//			    	if(!tokenizer.hasMoreTokens())
//			    		break;
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
		Storage.replaceFile();
		tempFile.delete();
	}
	
	private Employee()
	{
		
	}
}
