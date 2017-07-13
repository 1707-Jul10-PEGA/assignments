package com.wh.q7;

import java.util.Comparator;

public class EmployeeComparator implements Comparator<Employee> {
	
	public EmployeeComparator(){}

	@Override
	public int compare(Employee o1, Employee o2) {
		int empHash1 = o1.getAge() * o1.getDepartment().hashCode() * o1.getName().hashCode();
		int empHash2 = o2.getAge() * o2.getDepartment().hashCode() * o2.getName().hashCode();
		if(empHash1 == empHash2){
			return 0;
		}else if(empHash1 < empHash2){
			return -1;
		}else 
			return 1;
	}

}
