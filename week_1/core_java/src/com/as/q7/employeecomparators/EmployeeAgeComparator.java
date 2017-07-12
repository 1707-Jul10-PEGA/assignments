package com.as.q7.employeecomparators;

import java.util.Comparator;

import com.as.q7.employee.Employee;

/*
 * Class for comparing the ages of Employees
 */
public class EmployeeAgeComparator implements Comparator<Employee>{

	@Override
	public int compare(Employee arg0, Employee arg1) {
		return arg0.getAge() - arg1.getAge();
	}

}
