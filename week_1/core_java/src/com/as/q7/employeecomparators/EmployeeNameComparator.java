package com.as.q7.employeecomparators;

import java.util.Comparator;

import com.as.q7.employee.Employee;

/*
 * Class for comparing the names of Employees lexicographically
 */
public class EmployeeNameComparator implements Comparator<Employee> {

	@Override
	public int compare(Employee o1, Employee o2) {
		return o1.getName().compareTo(o2.getName());
	}

}
