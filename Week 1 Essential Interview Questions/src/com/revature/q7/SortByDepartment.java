package com.revature.q7;

import java.util.Comparator;

public class SortByDepartment implements Comparator<Employee> {
	public int compare(Employee a, Employee b){
		return a.getDepartment().compareTo(b.getDepartment());
	}
}
