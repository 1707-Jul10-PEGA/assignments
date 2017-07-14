/*
 * Tae Song
 * Question 7 - CompareName class that implements Comparator
 */
package com.TS.Q7.driver;

import java.util.Comparator;

public class CompareName implements Comparator<Employee> {
	/*Used to sort by name*/
	@Override
	public int compare(Employee o1, Employee o2) {
		// TODO Auto-generated method stub
		return o1.name.compareTo(o2.name);
	}

}
