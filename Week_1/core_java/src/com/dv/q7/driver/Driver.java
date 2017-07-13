package com.dv.q7.driver;

import java.util.*;

public class Driver {

	public static void main(String[] args) {
	
		Employee e1 = new Employee("John", "Sales", 25);
		Employee e2 = new Employee("Billy", "Customer Services", 30);
		
		List<Employee> eList = new ArrayList<Employee>();
		eList.add(e1);
		eList.add(e2);
		
		Collections.sort(eList, new EmployeeComparator());
		System.out.println(eList);
	}

}