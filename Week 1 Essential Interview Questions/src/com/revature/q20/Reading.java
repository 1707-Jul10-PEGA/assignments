package com.revature.q20;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Reading {
	public static void main(String[] args) throws IOException {
		
		
		Scanner scan = new Scanner(new File("C:\\people.txt"));
		scan.useDelimiter(":|\\n");
		while(scan.hasNext())
		{
			People p = new People(scan.next() + " " + scan.next(), scan.nextInt(), scan.next());
			System.out.println("Name: " + p.getName() + "\nAge: " + p.getAge() + "\nState: " + p.getState() + " State\n");
	
		}
		scan.close();
	}
}
