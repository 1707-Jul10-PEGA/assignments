package com.hy.q7.driver;

import java.util.Comparator;

//sort two employee based on their name, department, and age using the comparator interface
public class Question7 implements Comparator<Employee>{

	@Override
	public int compare(Employee e1, Employee e2) {
		if(e1.getName().compareTo(e2.getName()) > 0)
		{
			if(e1.getDepartment().compareTo(e2.getDepartment()) > 0){
				return 1;
			}
		}
		return 0;
	}

}
