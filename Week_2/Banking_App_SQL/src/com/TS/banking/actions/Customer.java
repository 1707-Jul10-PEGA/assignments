package com.TS.banking.actions;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Scanner;
import java.util.StringTokenizer;

import org.apache.log4j.Logger;

import com.TS.banking.pojo.BalanceInfo;
import com.TS.banking.resources.BankingAppDaoImpl;
import com.TS.banking.resources.Storage;
import com.TS.banking.resources.UserInputTest;

/*
 * Customer class which gives function to a customer that has logged in
 */
public class Customer extends BalanceViewer{
	private static Logger Log = Logger.getRootLogger();
	
	/*
	 * Invokes a menu for customers that are logged in
	 */
	public static void menuAction() throws SQLException {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		Scanner scanDouble = new Scanner(System.in);
		Scanner scanLine = new Scanner(System.in);
		
		/*Loops through the menu commands until the customer exits*/
		Log.info("Hello " + Storage.userID + ", what would you like to do?:\n");
		while(true)
		{
			Log.info("1. View account balance\n");
			Log.info("2. Withdraw money\n");
			Log.info("3. Deposit money\n");
			Log.info("4. Exit\n");
			Log.info("Please choose: ");
			/*Checks to make sure that the user input a number for the switch statement*/
			String menuNumber = scan.nextLine();
			if(!UserInputTest.testIsInt(menuNumber))
			{ 
				Log.info("Invalid choice\n");
				continue;
			}
			
			switch(Integer.valueOf(menuNumber))
			{
			case 1:
				/*Views customer's account balance*/
				try {
					Log.info(viewBalance(Storage.userID));
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				Log.info("\n");
				break;
			case 2:
				/*Checks to make sure that the user input a number for withdrawal*/
				Log.info("How much money would you like to withdraw?: ");
				String withdrawNumber = scanLine.nextLine();
				if(!UserInputTest.testIsInt(withdrawNumber))
				{ 
					Log.info("Invalid choice\n");
					continue;
				}
				/*Withdraws the money from the balance*/
				try {
					withdrawOrDeposit(Double.valueOf(withdrawNumber), "withdraw", Storage.userID);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;
			case 3:
				/*Checks to make sure that the user input a number for depositing*/
				Log.info("How much money would you like to deposit?: ");
				String depositNumber = scanLine.nextLine();
				if(!UserInputTest.testIsInt(depositNumber))
				{ 
					Log.info("Invalid choice\n");
					continue;
				}
				/*Deposits the money to the balance*/
				try {
					withdrawOrDeposit(Double.valueOf(depositNumber), "deposit", Storage.userID);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
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
	 * takes in the money, the command (withdraw or deposit), and the user's name in order to
	 * iterate the file, find the user and his/her balance, and withdraw or deposit from the balance
	 */
	private static void withdrawOrDeposit(double money, String command, String user) throws IOException, SQLException
	{
		double newMoney = 0;
		BankingAppDaoImpl connect = new BankingAppDaoImpl();
		BalanceInfo valueBalance = new BalanceInfo();
		
		valueBalance = connect.getBalanceInfo(user, 0);
		if("unlooked".equals(valueBalance.getApplicationStatus()))
		{
			Log.error("No account balance associated with this user\n");
			return;
		}
		if("deposit".equals(command))
		{ 
			connect.insertLogTable("deposit", user);
			newMoney = valueBalance.getBalance() + money; 
		}
		if("withdraw".equals(command))// && (valueBalance.getBalance() - money) > 0)
		{ 
			if ( (valueBalance.getBalance() - money < 0) )
			{
				Log.error("Your account balance is $" + valueBalance.getBalance() + ", please enter an amount less than that value...\n");
				return;
			}
			connect.insertLogTable("withdraw", user);
			newMoney = valueBalance.getBalance() - money;
		}
		connect.updateBalanceMoney(user, newMoney);
		
		/*
		 * Old method used when Banking App persisted using txt files
		 */
//		File test = new File("test.txt"); /////////
//		File File = new File("BalanceInfo.txt");
//		BufferedReader withdrawer = new BufferedReader(new FileReader(File));
//		
//		File tempFile = new File("tempBalanceInfo.txt");
//		BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile));
//		
//		int balanceInfoFields = 0;
//		boolean flag = false;
//		
//		String statusStore = ""; //Used for storing a specific output string (the appplication status)
//		/*finds the user in the file, and either deposits or withdraws from the balance*/
//		String tokenizedString;
//		try {
//		    String line = withdrawer.readLine();
//
//		    while (line != null) {
//		    	
//		    	StringTokenizer tokenizer = new StringTokenizer(line);
//				while (tokenizer.hasMoreTokens())
//				{
//					tokenizedString = tokenizer.nextToken();
//
//					if(balanceInfoFields == 0 && ("unlooked".equals(tokenizedString) || "denied".equals(tokenizedString)))
//					{
//						statusStore = tokenizedString;
//						break;
//					}
//					else
//					{
//						statusStore = "approved";
//					}
//					if(balanceInfoFields == 1 && !user.equals(tokenizedString))
//					{
//						balanceInfoFields = 0;
//						break;
//					}
//					/*balance fields initializing sequence*/
//					if(balanceInfoFields == 1)
//					{
//						flag = true;
//						Storage.userID = user; 
//						writer.write(statusStore + " ");
//						writer.write(Storage.userID + " ");
//					}
//					if(balanceInfoFields == 2)
//					{ 
//						Storage.firstName = tokenizedString; 
//						writer.write(Storage.firstName + " ");
//					}
//					if(balanceInfoFields == 3)
//					{ 
//						Storage.lastName = tokenizedString; 
//						writer.write(Storage.lastName + " ");
//					}
//					/*This is where the withdrawal or deposit happens*/
//					if(balanceInfoFields == 4)
//					{ 
//						double calculateMoney = 0.0;
//						if("deposit".equals(command))
//						{
//							calculateMoney = Double.valueOf(tokenizedString) + money;
//						}
//						
//						if((Double.valueOf(tokenizedString) - money) < 0 && (!"deposit".equals(command)) )
//						{
//							Log.error("Your account balance is $" + tokenizedString + ", please enter an ammount less than that value...\n");
//							writer.write(tokenizedString + "\n");
//							balanceInfoFields = 0;
//							break;
//							
//						}
//						if("withdraw".equals(command) && (Double.valueOf(tokenizedString) - money) > 0)
//						{
//							calculateMoney = Double.valueOf(tokenizedString) - money;
//						}
//						
//						Storage.money = calculateMoney;
//						writer.write(String.valueOf(Storage.money + "\n"));	
//						balanceInfoFields = 0;
//						break;
//					}
//					
//					balanceInfoFields += 1;
//				}
//				if (flag == false)
//				{
//					writer.write(line + "\n");
//				}
//				flag = false;
//		        line = withdrawer.readLine();
//		    }
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} finally {
//		    try {
//				withdrawer.close();
//				writer.close();
//			} catch (IOException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//		}
//		/*Writes the value of the temporary file to the main file and then deletes the temporary file*/
//		Storage.replaceFile();
//		tempFile.delete();
	}
	
	private Customer()
	{
		
	}
}
