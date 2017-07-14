package com.md.q20;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * Create a notepad file named Data.txt and enter the following:
 * 
 * Mickey:Mouse:35:Arizona
 * Hulk:Hogan:50:Virginia
 * Roger:Rabbit:22:California
 * Wonder:Woman:18:Montana
 * 
 * Write a program that would read from the file and print it out to
 * the screen in the following format:
 * 
 * Name: Mickey Mouse
 * Age: 35 years
 * State: Arizona State
 * 
 * NOTES: changed toString method in Person to match the format specified
 * 
 * @author Martin Delira
 *
 */
public class ReadFromFile {

	public static void main(String[] args) {
				
		/*Try with resources*/
		try(BufferedReader br = new BufferedReader(new FileReader("src/com/md/q20/Data.txt"))){
			String personString = br.readLine();
			
			while(personString != null) {
				String[] personArray = personString.split(":");
				Person p = new Person(personArray[0],personArray[1],Integer.parseInt(personArray[2]),personArray[3]);
				System.out.println(p.toString());
				personString = br.readLine();
			}
						
		} catch (IOException e) {
			System.err.println("File not found");
			e.printStackTrace();
		}
	}
}
