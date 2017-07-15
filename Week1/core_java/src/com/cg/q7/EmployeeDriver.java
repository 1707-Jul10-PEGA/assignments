package com.cg.q7;

public class EmployeeDriver {
	public static void main(String [] args){
		Employee a = new Employee("Pedro", 40, "IT");
		Employee b = new Employee("Juan", 35, "HR");
		Employee c = new Employee("Pedro", 40, "IT");
		
		System.out.println(a.compareEmployees(a,b));
		System.out.println(a.compareEmployees(a,c));
	}
}
