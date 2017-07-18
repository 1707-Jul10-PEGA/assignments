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
		
		Log.info("EMPLOYEE MENU\n");
		/*Loops through the menu commands until the employee exits*/
		while(true)
		{
			Log.info("1. Approve/Deny applications\n");
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
				Log.info("\n");
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
	
	private Employee()
	{
		
	}
}
