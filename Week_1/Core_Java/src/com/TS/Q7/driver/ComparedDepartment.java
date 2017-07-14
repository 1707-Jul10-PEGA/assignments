/*
 * Tae Song
 * Question 7 - ComparedDepartment class that implements Comparator
 */
package com.TS.Q7.driver;

import java.util.Comparator;

public class ComparedDepartment implements Comparator<Employee> {

	/*Used to sort by department*/
	@Override
	public int compare(Employee o1, Employee o2) {
		// TODO Auto-generated method stub
		return o1.department.compareTo(o2.department);
	}

}
