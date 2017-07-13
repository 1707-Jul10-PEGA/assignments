package com.revature.q7;

import java.util.Comparator;

public class SortByAge implements Comparator<Employee> {
	
	public int compare(Employee a, Employee b){
		
		return a.getAge() - b.getAge();
	}
}

