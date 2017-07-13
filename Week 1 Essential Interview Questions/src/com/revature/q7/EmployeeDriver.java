package com.revature.q7;

import java.util.ArrayList;

public class EmployeeDriver {
	public static void main (String[] args){
		ArrayList<Employee> myArLi = new ArrayList<Employee>();
		
		myArLi.add(new Employee("Wendell Phipps", "Developer", 23));
	myArLi.add(new Employee("John Doe", "Quality", 42));

	
		System.out.println("UnSorted: ");
		for(int x = 0; x < myArLi.size(); x++){
			System.out.println(myArLi.get(x).getName());
		}
		java.util.Collections.sort(myArLi, new SortByName());
		System.out.println("\nSorted by Name");
		
		for(int x = 0; x < myArLi.size(); x++){
			System.out.println(myArLi.get(x).getName());
		}
		
		java.util.Collections.sort(myArLi, new SortByDepartment());
		System.out.println("\nSorted by Department");
		for(int x = 0; x < myArLi.size(); x++){
			System.out.println(myArLi.get(x).getDepartment());
		}
		
		java.util.Collections.sort(myArLi, new SortByAge());
		for(int x = 0; x < myArLi.size(); x++){
			System.out.println(myArLi.get(x).getAge());
		}
	}
	
}
