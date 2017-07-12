package com.nc.q7;
import com.nc.q7.*;
public class Q7 {
	public static void main(String[] args) {
		//Create 2 employees
		Employee employee1 = new Employee("Blake", "HR", 43);
		Employee employee2 = new Employee("John", "Development", 23);
		
		
		System.out.println("Sort by name: ");
		//Get a number. If it is negative then employee1 is first.
		int num = employee1.getName().compareTo(employee2.getName());
		if(num < 0){
			System.out.println(employee1.getName() + " " + employee1.getDepartment() + " " + employee1.getAge());
			System.out.println(employee2.getName() + " " + employee2.getDepartment() + " " + employee2.getAge());
		}
		else if (num > 0){
			System.out.println(employee2.getName() + " " + employee2.getDepartment() + " " + employee2.getAge());
			System.out.println(employee1.getName() + " " + employee1.getDepartment() + " " + employee1.getAge());
		}
		else{
			System.out.println(employee1.getName() + " " + employee1.getDepartment() + " " + employee1.getAge());
			System.out.println(employee2.getName() + " " + employee2.getDepartment() + " " + employee2.getAge());
		}
		
		System.out.println("\nSort by department: ");
		num = employee1.getDepartment().compareTo(employee2.getDepartment());
		if(num < 0){
			System.out.println(employee1.getName() + " " + employee1.getDepartment() + " " + employee1.getAge());
			System.out.println(employee2.getName() + " " + employee2.getDepartment() + " " + employee2.getAge());
		}
		else if (num > 0){
			System.out.println(employee2.getName() + " " + employee2.getDepartment() + " " + employee2.getAge());
			System.out.println(employee1.getName() + " " + employee1.getDepartment() + " " + employee1.getAge());
		}
		else{
			System.out.println(employee1.getName() + " " + employee1.getDepartment() + " " + employee1.getAge());
			System.out.println(employee2.getName() + " " + employee2.getDepartment() + " " + employee2.getAge());
		}
		
		System.out.println("\nSort by age: ");
		num = employee1.getDepartment().compareTo(employee2.getDepartment());
		if(num < 0){
			System.out.println(employee1.getName() + " " + employee1.getDepartment() + " " + employee1.getAge());
			System.out.println(employee2.getName() + " " + employee2.getDepartment() + " " + employee2.getAge());
		}
		else if (num > 0){
			System.out.println(employee2.getName() + " " + employee2.getDepartment() + " " + employee2.getAge());
			System.out.println(employee1.getName() + " " + employee1.getDepartment() + " " + employee1.getAge());
		}
		else{
			System.out.println(employee1.getName() + " " + employee1.getDepartment() + " " + employee1.getAge());
			System.out.println(employee2.getName() + " " + employee2.getDepartment() + " " + employee2.getAge());
		}
	}
}
