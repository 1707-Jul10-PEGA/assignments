package com.EC.q7;

import java.util.Comparator;

public class EmployeComparatorByDept implements Comparator<Employee> {

	@Override
	public int compare(Employee arg0, Employee arg1) {
		// TODO Auto-generated method stub
		return arg0.getDepartment().compareTo(arg1.getDepartment());
	}

}
