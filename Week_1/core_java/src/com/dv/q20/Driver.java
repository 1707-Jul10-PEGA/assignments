package com.dv.q20;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Driver {

	public static void printList(List<String> strList) {
		String[] currPersonInfo = new String[4];		// hold the four fields for a person
		
		// grab the current person's info, create a person for each line in the list, and print it out
		for(String s : strList) {
			currPersonInfo = s.split(":");
			Person p = new Person(currPersonInfo[0], currPersonInfo[1], Integer.parseInt(currPersonInfo[2]), currPersonInfo[3]);
			System.out.println(p);
			System.out.println();
		}
		
	}

	public static List<String> readFromFile(String fileName) {
		BufferedReader br = null;
		String currLine;
		
		// list of people's information from text file
		List<String> strList = new ArrayList<String>();
		
		try {
		
			// pass in a Reader for buffered reader 
			br = new BufferedReader(new FileReader(fileName));
			
			// read until the end of the file
			// careful to only call readLine once, as it moves the buffered reader to a new line
			// this reads every line in the text file as element to the list
			while((currLine = br.readLine()) != null) {
				strList.add(currLine);
			}
		}
		
		catch(FileNotFoundException e) {
			e.printStackTrace();
		}

		catch(IOException e) {
			e.printStackTrace();
		}
		
		return strList;
		
	}

	public static void main(String[] args) {
		String fileName = "C:\\Users\\Dillon\\Documents\\java\\assignments\\Week_1\\core_java\\src\\com\\dv\\q20\\Data.txt";
		List<String> strList = readFromFile(fileName);
		
		printList(strList);

	
	}

}
