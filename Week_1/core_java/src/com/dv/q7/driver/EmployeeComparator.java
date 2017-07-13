package com.dv.q7.driver;

import java.util.Comparator;

public class EmployeeComparator implements Comparator<Employee>{

	@Override
	public int compare(Employee e1, Employee e2) {
		
		// if employees are the same
		if(e1.equals(e2)) {
			return 0;
		}
		
		// sort by name
		//else if(e1.getName().compareTo(e2.getName()) < 0) {
		//	return -1;
		//}
		
		// sort by department
		//else if(e1.getDep().compareTo(e2.getDep()) < 0) {
		//	return -1;
		//}
		
		// sort by age
		else if((e1.getAge() - e2.getAge()) < 0) {
			return -1;
		}
		
		else {
			return 1;
		}
	}

}