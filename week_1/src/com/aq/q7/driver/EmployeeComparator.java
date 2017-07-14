package com.aq.q7.driver;

import java.util.Comparator;

import com.aq.q7.pojo.Employee;

public class EmployeeComparator implements Comparator<Employee> {
	
	@Override
	public int compare(Employee e1, Employee e2) {
		// TODO Auto-generated method stub
		if (e1.getAge() == e2.getAge()) { return 0;}
		else if (e1.getAge() > e2.getAge()) {return 1; }
		else {return -1;}

	}
}
