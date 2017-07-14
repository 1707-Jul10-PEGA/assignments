package com.hy.q7.driver;

import java.util.Comparator;

public class DepartmentComparator implements Comparator<Employee> {

	@Override
	public int compare(Employee a, Employee b) {
		return a.getDepartment().compareToIgnoreCase(b.getDepartment());
	}

}
