package com.TS.banking.actions;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Scanner;
import java.util.StringTokenizer;

import org.apache.log4j.Logger;

import com.TS.banking.pojo.BalanceInfo;
import com.TS.banking.pojo.LoginInfo;
import com.TS.banking.resources.BankingAppDaoImpl;
import com.TS.banking.resources.Storage;
import com.TS.banking.resources.UserInputTest;

public class LoginAction {
	public static boolean ERROR = false;
	public static int privilege;
	private static Logger Log = Logger.getRootLogger();
	private static String filename = "LoginInfo.txt";
	
	private static Logger loginLog = Logger.getLogger("loginInfoLogger");
	private static Logger balanceLog = Logger.getLogger("balanceInfoLogger");
	
	/*
	 * Login screen where customers may login or apply for accounts
	 */
	public static boolean login() throws SQLException
	{
		Scanner scan = new Scanner(System.in);
		Scanner scanline = new Scanner(System.in);
		String onlineID;
		String passcode;
		
		/*Asks if the user has an account*/
		Log.trace("Hello, do you have an account?\n");
		Log.trace("Y/N/Exit: ");
		String reply = scanline.nextLine();
		
		Log.info("\n");
		
		/*Asks the user for online id and passcode in order to log in*/
		if("Y".equals(reply))
		{
			Log.trace("WELCOME!\n");
			Log.trace("Online ID: ");
			onlineID = scan.nextLine();
			Log.trace("Passcode : ");
			passcode = scan.nextLine();
			Log.trace("\n\n");
			try {
				if(searchBalanceInfo(onlineID, passcode))
				{ return true; }
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			Log.error("Your online ID or passcode is incorrect, please try again\n\n");
			return false;
		}
		/*Asks the user if he or she would like to make an account and creates an application if so*/
		if("N".equals(reply))
		{
			Log.info("Would you like to apply for an account?\n");
			Log.trace("Y/N?: ");
			reply = scanline.nextLine();
			if("Y".equals(reply))
			{
				try {
					apply();
					privilege = 5;
					return true;
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
			Log.error("Invalid choice\n");
		}	
		if("Exit".equals(reply))
		{
			privilege = 6;
			return true;
		}
		return false;
	}
	
	/*
	 * This method takes in the user's onlineID and passcode and checks it with the data
	 * in LoginInfo.txt in order to see if the user is able to log in. Returns true if
	 * the user put in the correct id and password associated with an account 
	 */
	private static boolean searchBalanceInfo(String id, String passcode) throws FileNotFoundException
	{
		BankingAppDaoImpl connect = new BankingAppDaoImpl();
		LoginInfo value = new LoginInfo();
		try {
			value = connect.getLoginInfo(id, 0);
			if (value == null)
			{ return false; }
			
			if (value.getLoginPassword().equals(passcode))
			{
				Storage.userID = value.getLoginID();
				privilege = value.getPosition();
				return true;
			}
			
			return false;
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		Log.error("ERROR! Application has been corrupted\n\n");
		ERROR = true;
		return false;
	
		/*
		 * Implementation with txt files from previous iteration of banking app
		 */
//		BufferedReader br = new BufferedReader(new FileReader(filename));
//		String tokenizedString;
//		int stringChecker = 0;
//		int found = 0;
//		
//		/*Searches through LoginInfo.txt*/
//		try {
//		    String line = br.readLine();
//
//		    while (line != null) {
//		    	StringTokenizer tokenizer = new StringTokenizer(line);
//				while (tokenizer.hasMoreTokens())
//				{
//					tokenizedString = tokenizer.nextToken();
//					
//					if (passcode.equals(tokenizedString) && found == 1 && stringChecker < 3)
//					{ found += 1; }
//					if (id.equals(tokenizedString) && found == 0 && stringChecker < 3)
//					{ 
//						Storage.userID = tokenizedString;
//						found += 1; 
//					}
//					if (found == 2)
//					{ tokenizedString = tokenizer.nextToken(); }
//					if (found == 2 && (Integer.valueOf(tokenizedString) == 1 || Integer.valueOf(tokenizedString) == 2 || Integer.valueOf(tokenizedString) == 3 ))
//					{
//						privilege = Integer.valueOf(tokenizedString);
//						return true; 
//					}
//					
//					stringChecker += 1;
//					if(stringChecker == 4)
//					{
//						Log.error("ERROR! Log file has been corrupted\n\n");
//						ERROR = true;
//						return false;
//					}
//					if(!tokenizer.hasMoreTokens())
//					{
//						stringChecker = 0;
//						found = 0;
//					}
//				}
//
//		        line = br.readLine();
//		    }
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} finally {
//		    try {
//				br.close();
//			} catch (IOException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//		}
//		return false;
	}
	
	/*
	 * Allows the customer to apply for an account, all information inputted by the user
	 * will be stored in the same file as the other accounts but will be flagged as
	 * "unlooked". "Unlooked" accounts will be skipped until the application is approved
	 */
	private static void apply() throws FileNotFoundException, SQLException
	{
		BankingAppDaoImpl connect = new BankingAppDaoImpl();
		LoginInfo loginCheck = new LoginInfo();
		Scanner scanLine = new Scanner(System.in);
		String onlineID;
		String passcode;		
		String firstName;
		String lastName;
		Double balance = 0.00;
		
		Log.info("ACCOUNT APPLICATION START...\n");
		while(true)
		{
			
			Log.info("What will be your Online ID: ");
			onlineID = scanLine.nextLine();
			loginCheck = connect.getLoginInfo(onlineID, 0);
			if(loginCheck != null)
			{
				Log.error("\nThis ID already exists! please type another ID\n");
				continue;
			}
			break;
		}
		
		while(true)
		{
			Log.info("What will be your passcode: ");
			passcode = scanLine.nextLine();
			if(UserInputTest.testNoWhitespace(passcode) == false)
			{
				Log.error("Passcode may not contain a space\n");
				continue;
			}
			break;
			
		}
		
		Log.info("First Name: ");
		firstName = scanLine.nextLine();
		Log.info("Last Name: ");
		lastName = scanLine.nextLine();
		connect.insertLoginInfo(onlineID, passcode, 1);
		connect.insertBalanceInfo("unlooked", onlineID, firstName, lastName, balance);
		
		/*
		 * Old method that persisted using txt files...
		 */
//		boolean exists = true;
//		
//		Log.info("ACCOUNT APPLICATION START...\n");
//		/*Asks for online ID from user*/
//		int onlineIDCheck = 0;
//		do
//		{
//			/*Checks to make sure there are no whitespaces in user input*/
//			do
//			{
//				Log.info("What will be your Online ID: ");
//				onlineID = scanLine.nextLine();
//				if(UserInputTest.testNoWhitespace(onlineID) == false)
//				{
//					Log.error("ID may not contain a space\n");
//					onlineIDCheck = 1;
//					continue;
//				}
//				onlineIDCheck = 0;
//			}while(onlineIDCheck == 1);
//			/*Checks to make sure online ID is not already registered*/
//			BufferedReader ch = new BufferedReader(new FileReader(filename));
//			String tokenizedString;
//			try {
//			    String line = ch.readLine();
//			    while (line != null) {
//			    	StringTokenizer tokenizer = new StringTokenizer(line);
//			    	if(!tokenizer.hasMoreTokens())
//			    		break;
//					tokenizedString = tokenizer.nextToken();
//			        if(onlineID.equals(tokenizedString))
//			        {
//			        	exists = false;
//			        	Log.error("\nThis ID already exists! please type another ID\n");
//			        	break;
//			        }
//			      
//			        line = ch.readLine();
//			    }
//			} catch (IOException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			} finally {
//			    try {
//					ch.close();
//				} catch (IOException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
//			} 
//		}while(!exists);
//		
//		/*Asks for passcode from user, checks to make sure there are no whitespaces*/
//		int passcodeCheck = 0;
//		do
//		{
//			Log.info("What will be your passcode: ");
//			passcode = scanLine.nextLine();
//			if(UserInputTest.testNoWhitespace(passcode) == false)
//			{
//				Log.error("Passcode may not contain a space\n");
//				passcodeCheck = 1;
//				continue;
//			}
//			passcodeCheck = 0;
//		}while(passcodeCheck == 1);
//		
//		/*Asks for first name from user, checks to make sure there are no white spaces*/
//		int firstNameCheck = 0;
//		do
//		{
//			Log.info("First Name: ");
//			firstName = scanLine.nextLine();
//			if(UserInputTest.testNoWhitespace(firstName) == false)
//			{
//				Log.error("First Name may not contain a space\n");
//				firstNameCheck = 1;
//				continue;
//			}
//			firstNameCheck = 0;
//		}while(firstNameCheck == 1);
//		
//		/*Asks for last name from user, checks to make sure there are no white spaces*/
//		int lastNameCheck = 0;
//		do
//		{
//			Log.info("Last Name: ");
//			lastName = scanLine.nextLine();
//			if(UserInputTest.testNoWhitespace(lastName) == false)
//			{
//				Log.error("Last Name may not contain a space\n");
//				lastNameCheck = 1;
//				continue;
//			}
//			lastNameCheck = 0;
//		}while(lastNameCheck == 1);
//		
//		loginLog.trace(onlineID + " " + passcode + " " + 1);
//		balanceLog.trace("unlooked" + " " + onlineID + " " + firstName + " " + lastName + " " + balance);
	}
	
	public static void error()
	{
		Log.error("ERROR! Log file has been corrupted\n\n");
	}
	
	private LoginAction()
	{
		
	}
}
