package com.TS.banking.actions;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import java.util.StringTokenizer;

import org.apache.log4j.Logger;

import com.TS.banking.pojo.Storage;

public class LoginAction {
	public static boolean ERROR = false;
	public static int privilege;
	private static Logger Log = Logger.getRootLogger();
	private static String filename = "LoginInfo.txt";
	
	private static Logger loginLog = Logger.getLogger("loginInfoLogger");
	private static Logger balanceLog = Logger.getLogger("balanceInfoLogger");
	
	public static boolean login()
	{
		Scanner scan = new Scanner(System.in);
		Scanner scanline = new Scanner(System.in);
		String onlineID;
		String passcode;
		
		Log.trace("Hello, do you have an account?\n");
		Log.trace("Y/N?: ");
		String reply = scanline.nextLine();
		
		Log.info("\n");
		
		if("Y".equals(reply))
		{
			Log.trace("WELCOME!\n");
			Log.trace("Online ID: ");
			onlineID = scan.nextLine();
			
			Log.trace("Passcode : ");
			passcode = scan.nextLine();
			Log.trace("\n\n\n\n\n");
			try {
				if(searchBalanceInfo(onlineID, passcode))
				{ return true; }
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return false;
		}
		if("N".equals(reply))
		{
			Log.info("Would you like to apply for an account?\n");
			Log.trace("Y/N?: ");
			reply = scanline.nextLine();
			if("Y".equals(reply))
			{
				try {
					apply();
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if("N".equals(reply))
			{
				privilege = 4;
				return true;
			}
		}	
		return false;
	}
	
	private static boolean searchBalanceInfo(String id, String passcode) throws FileNotFoundException
	{
		BufferedReader br = new BufferedReader(new FileReader(filename));
		String tokenizedString;
		int stringChecker = 0;
		int found = 0;
		
		try {
		    String line = br.readLine();

		    while (line != null) {
		    	StringTokenizer tokenizer = new StringTokenizer(line);
				while (tokenizer.hasMoreTokens())
				{
					tokenizedString = tokenizer.nextToken();
					//System.out.println(found);
					if (passcode.equals(tokenizedString) && found == 1 && stringChecker < 3)
					{ found += 1; }
					if (id.equals(tokenizedString) && found == 0 && stringChecker < 3)
					{ 
						Storage.userID = tokenizedString;
						found += 1; 
					}
					if (found == 2)
					{ tokenizedString = tokenizer.nextToken(); }
					if (found == 2 && (Integer.valueOf(tokenizedString) == 1 || Integer.valueOf(tokenizedString) == 2 || Integer.valueOf(tokenizedString) == 3 ))
					{
						privilege = Integer.valueOf(tokenizedString);
						return true; 
					}
					
					stringChecker += 1;
					if(stringChecker == 4)
					{
						Log.error("ERROR! Log file has been corrupted\n\n");
						ERROR = true;
						return false;
					}
					if(!tokenizer.hasMoreTokens())
					{
						stringChecker = 0;
						found = 0;
					}
				}

		        line = br.readLine();
		    }
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
		    try {
				br.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return false;
	}
	
	private static void apply() throws FileNotFoundException
	{
		Scanner scanLine = new Scanner(System.in);
		String onlineID;
		String passcode;
		
		String firstName;
		String lastName;
		String balance = "0.00";
		
		boolean exists = true;
		
		Log.info("ACCOUNT APPLICATION START...\n");
		do
		{
			Log.info("What will be your Online ID: ");
			onlineID = scanLine.nextLine();
			BufferedReader ch = new BufferedReader(new FileReader(filename));
			String tokenizedString;
			try {
			    String line = ch.readLine();
			    while (line != null) {
			    	StringTokenizer tokenizer = new StringTokenizer(line);
			    	if(!tokenizer.hasMoreTokens())
			    		break;
					tokenizedString = tokenizer.nextToken();
			        if(onlineID.equals(tokenizedString))
			        {
			        	exists = false;
			        	Log.error("\nThis ID already exists! please type another ID\n");
			        	break;
			        }
			      
			        line = ch.readLine();
			    }
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
			    try {
					ch.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			} 
		}while(!exists);
		
		Log.info("What will be your passcode: ");
		passcode = scanLine.nextLine();
		
		Log.info("First Name: ");
		firstName = scanLine.nextLine();
		
		Log.info("Last Name: ");
		lastName = scanLine.nextLine();
		
		loginLog.trace(onlineID + " " + passcode + " " + 1);
		balanceLog.trace("unlooked" + " " + onlineID + " " + " " + firstName + " " + lastName + " " + balance);
	}
	public static void error()
	{
		Log.error("ERROR! Log file has been corrupted\n\n");
	}
	
	private LoginAction()
	{
		
	}
}
