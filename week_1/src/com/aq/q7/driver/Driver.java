package com.aq.q7.driver;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.aq.q7.pojo.Employee;

public class Driver {
	public static void main(String[] args) {
		Employee e1 = new Employee("Michael","Accounting",30);
		Employee e2 = new Employee("Janet","Finance",29);
		
		List<Employee> employees = new ArrayList<Employee>();
		employees.add(e1); 
		employees.add(e2);
		
		System.out.println(employees);
			
		System.out.println("Running Sort by Age");
		Collections.sort(employees,new EmployeeComparator());
		System.out.println(employees);
	}
}
