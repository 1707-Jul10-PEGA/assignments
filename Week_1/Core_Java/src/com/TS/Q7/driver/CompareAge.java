/*
 * Tae Song
 * Question 7 - CompareAge class that implements Comparator
 */
package com.TS.Q7.driver;

import java.util.Comparator;

public class CompareAge implements Comparator<Employee> {

	/*Used to sort by age*/
	@Override
	public int compare(Employee o1, Employee o2) {
		// TODO Auto-generated method stub
		return o1.age - o2.age;
	}

}
