package com.cg.q7;

public class Employee {
	
	public static void main(String [] args){
		Employee a = new Employee("Pedro", 40, "IT");
		Employee b = new Employee("Juan", 35, "HR");
		Employee c = new Employee("Pedro", 40, "IT");
		
		System.out.println(a.compareEmployees(a,b));
		System.out.println(a.compareEmployees(a,c));
	}
	
	//Variables
	private String name;
	private int age;
	private String department; 
	
	//Constructor 
	public Employee(String name, int age, String department){
		this.name = name;
		this.age = age;
		this.department = department;
	}
	
	//Compare two employees using equals for greater accuracy
	public boolean compareEmployees(Employee e1, Employee e2){
		if(e1.name.equals(e2.name) && e1.age == e2.age && e1.department.equals(e2.department))
			return true;
		else
			return false;
	}
	
}

