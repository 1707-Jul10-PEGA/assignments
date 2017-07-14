package com.rb.q7.driver;

import java.util.Scanner;

public class Employee {
	
	private static Scanner SCAN;
	private String name;
	private String department;
	private int age;
	
	public Employee(){
		
		// prompt name input and read in
		System.out.print("Input name: ");
		name = SCAN.nextLine();
		// prompt department input and read in
		System.out.print("Input department: ");
		department = SCAN.nextLine();
		// prompt age input and read in
		System.out.print("Input age: ");
		age = SCAN.nextInt();
		// remove the newline character from inputting the integer
		SCAN.nextLine();
	}
	
	// Getters for the fields for the instances of this class
	public String getName() {
		return name;
	}
	
	public String getDepartment() {
		return department;
	}
	
	public int getAge() {
		return age;
	}
	
	// Opening and closing the scanner in the constructor did
	// not reopen the scanner, so it is done from the calling
	// class
	public static void openScanner(){
		SCAN = new Scanner(System.in);
	}
	
	public static void closeScanner(){
		SCAN.close();
	}

	@Override
	public String toString() {
		return "Employee [name=" + name + ", department=" + department + ", age=" + age + "]";
	}
	
	
}
