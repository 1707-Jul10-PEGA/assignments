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

public class Admin extends BalanceViewer{
	private static Logger Log = Logger.getRootLogger();
	
	public static void menuAction() throws FileNotFoundException {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		Scanner scanLine = new Scanner(System.in);
		
		Log.info("Hello " + Storage.userID + ", what would you like to do?:\n");
		
		while(true)
		{
			Log.info("1. Edit an account's information\n");
			Log.info("2. View a customer's account balance\n");
			Log.info("3. Exit\n");
			Log.info("Please choose: ");
			int menuNumber = scan.nextInt();
			Log.info("\n");
			
			switch(menuNumber)
			{
			case 1:
				Log.info("Which customer's account would you like to edit?: ");
				String editCustomer = scanLine.nextLine();
				try {
					Log.trace(viewBalance(editCustomer));
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				Log.info("Which information would you like to edit?:\n");
				Log.info("1. First Name\n");
				Log.info("2. Last Name\n");
				Log.info("3. Balance\n");
				Log.info("Please choose: ");
				int decision = scan.nextInt();
				Log.info("\n");
				
				Log.info("Type in your changes: ");
				String changedString = scanLine.nextLine();
				try {
					editAccounts(changedString, decision, editCustomer);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				break;
			case 2:
				Log.info("Which customer's account balance would you like to view?: ");
				String customer = scanLine.nextLine();
				try {
					Log.trace(viewBalance(customer));
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				Log.info("\n");
				break;
			case 3:
				return;
			default:
				Log.error("Invalid choice\n");
			}
		}
	}
	
	private static void editAccounts(String editThisString, int choice, String user) throws IOException
	{
		File File = new File("BalanceInfo.txt");
		BufferedReader br = new BufferedReader(new FileReader(File));
		
		File tempFile = new File("tempBalanceInfo.txt");
		BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile));
		
		int balanceInfoFields = 0;
		boolean flag = false;
		
		String statusStore = "";
		
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
					else
					{
						statusStore = "approved";
					}
					if(balanceInfoFields == 1 && !user.equals(tokenizedString))
					{
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
						System.out.println(tokenizedString);
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
//					if(!tokenizer.hasMoreTokens())
//					{
//						return;
//					}
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
		Storage.replaceFile();
		tempFile.delete();
	}
	
	private Admin()
	{
		
	}
}
