package com.as.q7.driver;

import com.as.q7.employee.Employee;
import com.as.q7.employeecomparators.EmployeeNameComparator;

public class Driver {

	public static void main(String[] args) {
		//Employees to compare
		Employee mark = new Employee("Mark", "Marketing", 46);
		Employee thomas = new Employee("Thomas", "Sales", 35);
		EmployeeNameComparator nameComp = new EmployeeNameComparator();
		int nameResult = nameComp.compare(mark, thomas);
		System.out.println(nameResult);
	}
	
}
