package com.TS.banking.pojo;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.StringTokenizer;

import org.apache.log4j.Logger;

public class Storage {
	public static String userID;
	public static String firstName;
	public static String lastName;
	public static Double money;
	
	private static DecimalFormat moneyDecimals = new DecimalFormat("#.00");
	
	public static String print()
	{
		return ("This is " + userID + "'s balance...\n" +
				"First Name: " + firstName + "\n" + 
				"Last  Name: " + lastName + "\n" +
				"Balance: $" + moneyDecimals.format(money) + "\n"//moneyDecimals.format(money)
				);
	}
	
	public static void replaceFile() throws IOException
	{
		File tempFile = new File("tempBalanceInfo.txt");
		BufferedReader reader = new BufferedReader(new FileReader(tempFile));
		
		File newFile = new File("BalanceInfo.txt");
		BufferedWriter writer = new BufferedWriter(new FileWriter(newFile));
		newFile.delete();
		
		String tokenizedString;
		try {
		    String line = reader.readLine();

		    while (line != null) {
		    	writer.write(line + "\n");
		    	StringTokenizer tokenizer = new StringTokenizer(line);
		    	line = reader.readLine();
		    }
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
		    try {
				reader.close();
				writer.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	private Storage()
	{
		
	}
}
