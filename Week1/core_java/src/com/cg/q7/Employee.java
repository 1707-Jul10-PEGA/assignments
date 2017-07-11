package com.cg.q7;

public class Employee {
	private String name;
	private int age;
	private String department; 
	
	public Employee(String name, int age, String department){
		this.name = name;
		this.age = age;
		this.department = department;
	}
	
	public static boolean compareEmployees(Employee e1, Employee e2){
		if(e1.name.equals(e2.name) && e1.age == e2.age && e1.department.equals(e2.department))
			return true;
		else
			return false;
	}
	public static void main(String [] args){
		Employee a = new Employee("Pedro", 40, "IT");
		Employee b = new Employee("Juan", 35, "HR");
		Employee c = new Employee("Pedro", 40, "IT");
		
		System.out.println(compareEmployees(a,b));
		System.out.println(compareEmployees(a,c));
	}
}

