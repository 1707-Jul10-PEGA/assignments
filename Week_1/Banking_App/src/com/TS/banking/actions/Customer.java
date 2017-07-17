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

public class Customer extends BalanceViewer{
	private static Logger Log = Logger.getRootLogger();
//	private static Logger loginLog = Logger.getLogger("loginInfoLogger");
//	private static Logger balanceLog = Logger.getLogger("balanceInfoLogger");
//	balanceLog.trace("This is the report log");
//	loginLog.trace("This is the debug log");
	
	public static void menuAction() {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		Scanner scanDouble = new Scanner(System.in);
		
		Log.info("Hello " + Storage.userID + ", what would you like to do?:\n");
		while(true)
		{
			Log.info("1. View account balance\n");
			Log.info("2. Withdraw money\n");
			Log.info("3. Deposit money\n");
			Log.info("4. Exit\n");
			Log.info("Please choose: ");
			int menuNumber = scan.nextInt();
			System.out.println("Still Works");//
			Log.info("\n");
			
			switch(menuNumber)
			{
			case 1:
				//viewBalance(userID)
				try {
					Log.info(viewBalance(Storage.userID));
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				Log.info("\n");
				break;
			case 2:
				Log.info("How much money would you like to withdraw?: ");
				double withdrawNumber = scanDouble.nextDouble();
				Log.info("\n");
				
				try {
					withdrawOrDeposit(withdrawNumber, "withdraw", Storage.userID);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;
			case 3:
				Log.info("How much money would you like to deposit?: ");
				double depositNumber = scanDouble.nextDouble();
				Log.info("\n");
				
				try {
					withdrawOrDeposit(depositNumber, "deposit", Storage.userID);
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
	
	private static void withdrawOrDeposit(double money, String command, String user) throws IOException
	{
		File test = new File("test.txt"); /////////
		File File = new File("BalanceInfo.txt");
		BufferedReader withdrawer = new BufferedReader(new FileReader(File));
		
		File tempFile = new File("tempBalanceInfo.txt");
		BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile));
		
		int balanceInfoFields = 0;
		boolean flag = false;
		
		String statusStore = "";
		
		String tokenizedString;
		try {
		    String line = withdrawer.readLine();

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
						balanceInfoFields = 0;
						break;
					}
					/*balance fields initializing sequence*/
					if(balanceInfoFields == 1)
					{
						flag = true;
						Storage.userID = user; 
						writer.write(statusStore + " ");
						writer.write(Storage.userID + " ");
					}
					if(balanceInfoFields == 2)
					{ 
						Storage.firstName = tokenizedString; 
						writer.write(Storage.firstName + " ");
					}
					if(balanceInfoFields == 3)
					{ 
						Storage.lastName = tokenizedString; 
						writer.write(Storage.lastName + " ");
					}
					if(balanceInfoFields == 4)
					{ 
						//Storage.money = Double.valueOf(tokenizedString);
						double calculateMoney = 0.0;
						if("deposit".equals(command))
						{
							calculateMoney = Double.valueOf(tokenizedString) + money;
						}
						
						if((Double.valueOf(tokenizedString) - money) < 0)
						{
							Log.error("Your account balance is $" + tokenizedString + ", please enter an ammount less than that value...\n");
							writer.write(tokenizedString + "\n");
							balanceInfoFields = 0;
							break;
							
						}
						if("withdraw".equals(command) && (Double.valueOf(tokenizedString) - money) > 0)
						{
							calculateMoney = Double.valueOf(tokenizedString) - money;
						}
						
						Storage.money = calculateMoney;
						writer.write(String.valueOf(Storage.money + "\n"));	
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
		        line = withdrawer.readLine();
		    }
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
		    try {
				withdrawer.close();
				writer.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		Storage.replaceFile();
		//tempFile.delete();
	}
	
	private Customer()
	{
		
	}
}
