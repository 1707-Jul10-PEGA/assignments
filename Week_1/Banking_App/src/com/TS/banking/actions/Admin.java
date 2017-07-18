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
 * Admin class which gives function to a admin that has logged in
 */
public class Admin extends BalanceViewer{
	private static Logger Log = Logger.getRootLogger();
	
	/*
	 * Invokes a menu for admins that are logged in
	 */
	public static void menuAction() throws FileNotFoundException {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		Scanner scanLine = new Scanner(System.in);
		String continueEdit = "Y";
		Log.info("ADMIN MENU\n");
		
		/*Menu commands are looped until the admin exits*/
		while(true)
		{
			Log.info("1. Edit an account's information\n");
			Log.info("2. View a customer's account balance\n");
			Log.info("3. Approve/Deny applications\n");
			Log.info("4. Exit\n");
			Log.info("Please choose: ");
			String menuNumber = scanLine.nextLine();
			if(!UserInputTest.testIsInt(menuNumber))
			{ 
				Log.info("Invalid choice\n");
				continue;
			}
			
			switch(Integer.valueOf(menuNumber))
			{
			case 1:
				do
				{
					boolean editCustomerCheck = true;
					/*Outputs the balance information of the account that the user wishes to edit*/
					Log.info("Which customer's account would you like to edit?: ");
					String editCustomer = scanLine.nextLine();
					try {
						Log.trace(viewBalance(editCustomer));
						if("No account balance associated with this user\n".equals(viewBalance(editCustomer)))
						{ editCustomerCheck = false; }
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					if(editCustomerCheck = true)
					{ break; }
					/*Writes the editted information to a temporary file, then have that file rewrite to the main file*/
					int informationCheck = 0;
					String decision;
					do
					{
						Log.info("\nWhich information would you like to edit?:\n");
						Log.info("1. First Name\n");
						Log.info("2. Last Name\n");
						Log.info("3. Balance\n");
						Log.info("Please choose: ");
						decision = scanLine.nextLine();
						if(!UserInputTest.testIsInt(decision))
						{ 
							Log.info("Invalid choice\n");
							informationCheck = 1;
							continue;
						}
						informationCheck = 0;
					}while(informationCheck == 1);
					
					Log.info("Type in your changes: ");
					String changedString = scanLine.nextLine();
					try {
						editAccounts(changedString, Integer.valueOf(decision), editCustomer);
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
					Log.info("Would you like to continue making changes?\n");
					Log.info("Y/N?: ");
					continueEdit = scanLine.nextLine();
				}while("Y".equals(continueEdit));
				Log.info("\n");
				break;
			case 2:
				/*Checks the user input, then views a customer's account balance*/
				Log.info("Which customer's account balance would you like to view?: ");
				String customer = scanLine.nextLine();
				Log.info("\n");
				try {
					Log.trace(viewBalance(customer));
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				Log.info("\n");
				break;
			case 3:
				/*Approve or deny applications.*/
				try {
					approveOrDeny();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				break;
			case 4:
				return;
			default:
				Log.error("Invalid choice\n");
			}
		}
	}
	
	/*
	 * Takes in a string as the string to edit, an int to signify which fields to edit, and
	 * another string to search for the person's account to edit and then edits the account information
	 * by writing to a temporary file and rewriting to the main file
	 */
	private static void editAccounts(String editThisString, int choice, String user) throws IOException
	{
		File File = new File("BalanceInfo.txt");
		BufferedReader br = new BufferedReader(new FileReader(File));
		
		File tempFile = new File("tempBalanceInfo.txt");
		BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile));
		
		int balanceInfoFields = 0;
		boolean flag = false;
		
		String statusStore = "";
		
		/*reads from file and writes editted information to temporary file*/
		String tokenizedString;
		try {
		    String line = br.readLine();
		    
		    while (line != null) {
		    	StringTokenizer tokenizer = new StringTokenizer(line);
				while (tokenizer.hasMoreTokens())
				{
					tokenizedString = tokenizer.nextToken();

					if(balanceInfoFields == 0 && ("unlooked".equals(tokenizedString) || "denied".equals(tokenizedString)))
					{
						statusStore = tokenizedString;
						break;
					}
					if(balanceInfoFields == 0 && "approved".equals(tokenizedString))
					{
						statusStore = "approved";
					}
					if(balanceInfoFields == 1 && !user.equals(tokenizedString))
					{
						balanceInfoFields = 0;
						break;
					}
					/*balance fields writing to file*/
					if(balanceInfoFields == 1)
					{
						flag = true;
						Storage.userID = user; 
						writer.write(statusStore + " ");
						writer.write(Storage.userID + " ");
					}
					if(balanceInfoFields == 2)
					{ 
						if(choice == 1)
						{
							Storage.firstName = editThisString;
							writer.write(Storage.firstName + " ");
						}
						else
						{
							Storage.firstName = tokenizedString; 
							writer.write(Storage.firstName + " ");
						}
					}
					if(balanceInfoFields == 3)
					{ 
						if(choice == 2)
						{
							Storage.lastName = editThisString;
							writer.write(Storage.lastName + " ");
						}
						else
						{
							Storage.lastName = tokenizedString; 
							writer.write(Storage.lastName + " ");
						}
					}
					if(balanceInfoFields == 4)
					{ 
						if(choice == 3)
						{
							Storage.money = Double.valueOf(editThisString);
							writer.write(Storage.money + "\n");
						}
						else
						{
							Storage.money = Double.valueOf(tokenizedString + "\n");
							writer.write(tokenizedString + "\n");
						}
						balanceInfoFields = 0;
						break;
					}
					
					balanceInfoFields += 1;
				}
				if (flag == false)
				{
					writer.write(line + "\n");
				}
				flag = false;
		        line = br.readLine();
		    }
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
		    try {
				br.close();
				writer.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		/*temporary file is rewritten to main file, then deleted*/
		Storage.replaceFile();
		tempFile.delete();
	}
	
	private Admin()
	{
		
	}
}
