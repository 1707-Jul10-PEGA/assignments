package com.rb.q20.driver;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ParseData {

	public static void main(String args[]) {
		
		// create file input and a null scanner
		File input = new File("data.txt");
		Scanner data = null;
		
		// try to create a scanner from the file
		// if the file isn't there, catch and print error
		
		try{
			data = new Scanner(input);
		}catch(FileNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("File not found");
		}
		
		
		// for each line, delimit the string on the colon
		// and pass that to another scanner. From that scanner
		// read each part in and format each line
		while(data.hasNextLine()){
			Scanner parse = new Scanner(data.nextLine());
			Scanner read = parse.useDelimiter(":");
			System.out.println("Name: " + read.next() + " " + read.next());
			System.out.println("Age: " + read.nextInt() + " years");
			System.out.println("State: " + read.next() + " State\n");
			read.close();
			parse.close();
		}
		
		data.close();
	}
}