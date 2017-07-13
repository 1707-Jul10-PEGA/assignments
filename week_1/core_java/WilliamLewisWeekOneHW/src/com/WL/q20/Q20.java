package com.WL.q20;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Q20 {

	public static void main(String[] args) {
		
		
		String filename = "C:\\Users\\William\\assignments\\week_1\\core_java\\WilliamLewisWeekOneHW\\src\\Data.txt";
		
		
		String myStrings = readFile(filename);
		
		//Split string via linebreaks
		String[] myLines = myStrings.split("\n"); 
		//Loop through each line and formated it.
		for(String str : myLines)
		{
			System.out.println(formatLine(str));
		}
		

	}
	/**
	 * 
	 * @param file: Name of the .txt file to be read, with path. For file format see formatLine(String str)
	 * @return returns a string version of txt file, preserving the line breaks
	 */
	public static String readFile(String file) {

		try {
			FileReader fileRead = new FileReader(file);
			BufferedReader bufferedReader = new BufferedReader(fileRead);
			StringBuffer stringBuffer = new StringBuffer();
			String line;
			//As long as the next line exists, keep reading.
			while ((line = bufferedReader.readLine()) != null) {
				stringBuffer.append(line);
				stringBuffer.append("\n");
			}
			fileRead.close();
			return stringBuffer.toString();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			return null;
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
	}
	/**
	 * 
	 * @param str, This should be a single line from the .txt file, formated FirstName:LastName:Age:State
	 * @return returns a properly formated version of each line, see Q20 details for example.
	 */
	public static String formatLine(String str)
	{
		StringBuffer formatedString = new StringBuffer(); 
		String[] myStringParts = str.split(":"); 
		//This could all be in one long append, but I separated it for readability, note the new line is done here
		formatedString.append("Name: " + myStringParts[0] + " " + myStringParts[1] + " \n" );
		formatedString.append("Age: " + myStringParts[2] + " years \n" );
		formatedString.append("State: " + myStringParts[3] + " State \n" );
		return formatedString.toString();
	}

}
