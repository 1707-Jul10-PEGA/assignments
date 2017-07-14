//Jake Maynard
//Compare two employees with comparator interface
package com.jntm.q7.driver;

import java.util.ArrayList;
import java.util.Collections;

public class Main {

	public static void main(String[] args) {
		//Sort employees based on different parameters.
		
		//Make and fill Arraylist
		ArrayList<Employee> lis = new ArrayList<Employee>();
		lis.add(new Employee("Jenny", "Marketing", 89));
		lis.add(new Employee("Rick", "R&D", 34));
		lis.add(new Employee("Sarah", "Baking", 56));
		lis.add(new Employee("Aki", "Management", 53));
		
		//Print unsorted.
		System.out.println("Unsorted Employees");
		for(int x=0; x<lis.size(); x++){
			System.out.println(lis.get(x));
		}
		
		//Sort by name
		System.out.println("\nSorted by Name");
		Collections.sort(lis, new SortByName());
		
		for(int x=0; x<lis.size(); x++){
			System.out.println(lis.get(x));
		}
		
		//sort by department
		System.out.println("\nSorted by Department");
		Collections.sort(lis, new SortByDepartment());
		
		for(int x=0; x<lis.size(); x++){
			System.out.println(lis.get(x));
		}
		
		
		//and by age
		System.out.println("\nSorted by Age");
		Collections.sort(lis, new SortByAge());
		
		for(int x=0; x<lis.size(); x++){
			System.out.println(lis.get(x));
		}
	
	}
	
	
	
}
