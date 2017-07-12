package com.as.q7.driver;

import com.as.q7.employee.Employee;
import com.as.q7.employeecomparators.EmployeeAgeComparator;
import com.as.q7.employeecomparators.EmployeeDepartmentComparator;
import com.as.q7.employeecomparators.EmployeeNameComparator;

public class Driver {

	public static void main(String[] args) {
		//Employees to compare
		Employee mark = new Employee("Mark", "Marketing", 46);
		Employee thomas = new Employee("Thomas", "Sales", 35);
		//compare names and print the result with 
		//negative meaning the first employee's name precedes the second employee's name lexicographically
		//zero means they are equal lexicographically
		//positive means the first employee's name follows the second's name lexicographically
		int nameResult = new EmployeeNameComparator().compare(mark, thomas);
		System.out.println(nameResult);
		//compare departments and print the result with 
		//negative meaning the first employee's department precedes the second employee's department lexicographically
		//zero means they are equal lexicographically
		//positive means the first employee's department follows the second's department lexicographically
		int deptResult = new EmployeeDepartmentComparator().compare(mark, thomas);
		System.out.println(deptResult);
		//compare ages and print the result with 
		//negative meaning the first employee is younger than the second
		//zero meaning their ages are equal
		//positive means the first employee is older than the second
		int ageResult = new EmployeeAgeComparator().compare(mark, thomas);
		System.out.println(ageResult);
	}
	
}
