package com.EC.q7;

import java.util.ArrayList;
import java.util.List;

public class Q7 {

	public static void main(String[] args) {
		List<Employee> list = new ArrayList<Employee>();
		list.add(new Employee("Joshua Chen","Contractor",26));
		list.add(new Employee("Elliot Chen","Programmer",22));
		
		System.out.println("Before sort:");
		for(Employee i : list){
			System.out.println(i.toString());
		}
		
		java.util.Collections.sort(list, new EmployeeComparatorByName());
		
		System.out.println("\nAfter sorting by name:");
		printArr(list);
		
		System.out.println("\nAfter sorting by department:");
		java.util.Collections.sort(list, new EmployeComparatorByDept());
		printArr(list);
		
		System.out.println("\nAfter Sorting by age");
		java.util.Collections.sort(list, new EmployeeComparatorByAge());
		printArr(list);

	}
	
	public static void printArr(List <Employee> arr){
		for(Employee i : arr){
			System.out.println(i.toString());
		}
	}

}
