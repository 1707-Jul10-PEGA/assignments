/*
 * Tae Song
 * Question 7
 */
package com.TS.Q7.driver;

import java.util.ArrayList;
import java.util.Collections;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*Initializes ArrayList of employees*/
		ArrayList<Employee> employeeDetails = new ArrayList<Employee>();
		employeeDetails.add(new Employee("Bob", "Walmart", 17));
		employeeDetails.add(new Employee("John", "Shoppers", 15));
		employeeDetails.add(new Employee("Ray", "Macys", 34));
		
		/*Sorts by age*/
		System.out.println("Sorted by Age...");
		Collections.sort(employeeDetails, new CompareAge());
		for (int i = 0; i < employeeDetails.size(); i++)
		{
			employeeDetails.get(i).print();
		}
		
		/*Sorts by department*/
		System.out.println("\nSorted by Department...");
		Collections.sort(employeeDetails, new ComparedDepartment());
		for (int i = 0; i < employeeDetails.size(); i++)
		{
			employeeDetails.get(i).print();
		}
		
		/*Sorts by name*/
		System.out.println("\nSorted by Name...");
		Collections.sort(employeeDetails, new CompareName());
		for (int i = 0; i < employeeDetails.size(); i++)
		{
			employeeDetails.get(i).print();
		}
	}

}
