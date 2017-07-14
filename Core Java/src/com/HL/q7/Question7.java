package com.HL.q7;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Question7
{
	public static void main(String[] args)
	{
		List<Employee> list = new ArrayList<Employee>();
		list.add(new Employee("Hung Le", "Software", 28));
		list.add(new Employee("Mickey Mouse", "Hardware", 35));
		
		Collections.sort(list, new Employee());
		for(Employee e: list)
		{
			System.out.print("Name: "+e.getName() +", Department: "+e.getDepartment() +", Age: "+e.getAge() + ". ");
		}
	}
}
