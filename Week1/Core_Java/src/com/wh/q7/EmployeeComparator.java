package com.wh.q7;

import java.util.Comparator;

public class EmployeeComparator implements Comparator<Employee> {

    public EmployeeComparator() {
    }

    @Override
    public int compare(Employee o1, Employee o2) {
	if (o1.equals(o2)) {
	    return 0;
	} else
	    return o1.hashCode() - o2.hashCode();
    }

}
