package com.EC.q7;

import java.util.Comparator;

public class EmployeeComparatorByAge implements Comparator<Employee> {

	@Override
	public int compare(Employee arg0, Employee arg1) {
		if (arg0.getAge() == arg1.getAge()) {
			return 0;
		} else if (arg0.getAge() > arg1.getAge()) {
			return 1;
		} else {
			return -1;
		}

	}

}
