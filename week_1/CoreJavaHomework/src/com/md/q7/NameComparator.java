package com.md.q7;

import java.util.Comparator;

import com.md.q20.Person;

public class NameComparator implements Comparator<Employee> {

	@Override
	public int compare(Employee o1, Employee o2) {
		return o1.getName().compareTo(o2.getName());
	}

	

}
