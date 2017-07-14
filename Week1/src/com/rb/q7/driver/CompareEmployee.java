package com.rb.q7.driver;

import java.util.ArrayList;
import java.util.Comparator;

public class CompareEmployee {
	
	public static void main(String args[]){
		
		new CompareEmployee();
		
	}
	
	public CompareEmployee(){
		
		Employee.openScanner();
		
		Employee e1 = new Employee();
		Employee e2 = new Employee();
		
		Employee.closeScanner();
		
		ArrayList<Employee> employees = new ArrayList<Employee>();
		
		employees.add(e1);
		employees.add(e2);
		
		employees.sort(new CompareByName());
		System.out.println("Employees sorted by name: " + employees);
		
		employees.sort(new CompareByDepartment());
		System.out.println("Employees sorted by department: " + employees);
		
		employees.sort(new CompareByAge());
		System.out.println("Employees sorted by age: " + employees);
	}

	
	
	private class CompareByName implements Comparator<Employee> {
		@Override
		public int compare(Employee e1, Employee e2) {
			return e1.getName().compareTo(e2.getName());
		}
	}
	
	private class CompareByDepartment implements Comparator<Employee> {
		@Override
		public int compare(Employee e1, Employee e2) {
			return e1.getDepartment().compareTo(e2.getDepartment());
		}
	}
	
	private class CompareByAge implements Comparator<Employee> {
		@Override
		public int compare(Employee e1, Employee e2) {
			if(e1.getAge() < e2.getAge()){
				return -1;
			}else if(e1.getAge() > e2.getAge()){
				return 1;
			}else{
				return 0;
			}
		}
	}
}
