package com.rb.q20.driver;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ParseData {

	public static void main(String args[]) {
		// TODO Auto-generated method stub
		
		File input = new File("data.txt");
		
		
		Scanner data = null;
		
		try{
			data = new Scanner(input);
		}catch(FileNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("File not found");
		}
		
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