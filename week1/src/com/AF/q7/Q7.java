package com.AF.q7;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

class Employee {
	private String name;
	private String department;
	private int age;
	
	public String getName() {
		return this.name;
	}
	
	public String getDepartment() {
		return this.department;
	}
	
	public int getAge() {
		return this.age;
	}
	
	Employee(String name, String department, int age) {
		this.name = name;
		this.department = department;
		this.age = age;
	}
	
}

class SortByName implements Comparator<Employee> {

	@Override
	public int compare(Employee a, Employee b) {
		return a.getName().compareTo(b.getName());
	}
}

class SortByDepartment implements Comparator<Employee> {

	@Override
	public int compare(Employee a, Employee b) {
		return a.getDepartment().compareTo(b.getDepartment());
	}
	
}

class SortByAge implements Comparator<Employee> {
	public int compare(Employee a, Employee b) {
		return a.getAge() - b.getAge();
	}
}

public class Q7 {
	public static void main(String[] args){
		
		ArrayList<Employee> employeeList = new ArrayList<Employee>();
		employeeList.add(new Employee("Alice", "HR", 47));
		employeeList.add(new Employee("Bob", "Exe", 38));
		
		Collections.sort(employeeList, new SortByName());
		
		System.out.println("Sort By Name: ");
		for (Employee e : employeeList) {
			System.out.println(e.getName());
		}
		
		Collections.sort(employeeList, new SortByDepartment());
		
		System.out.println("Sort By Department: ");
		for (Employee e : employeeList) {
			System.out.println(e.getName());
		}
		
		Collections.sort(employeeList, new SortByAge());
		
		System.out.println("Sort By Age: ");
		for (Employee e : employeeList) {
			System.out.println(e.getName());
		}
    }
}