package com.nc.q7;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import com.nc.q7.*;
public class Q7 {
	public static void main(String[] args) {
		//Create 2 employees
		List<Employee> people = Arrays.asList(
                new Employee("Kool", "HR", 43),
                new Employee("John", "Development", 23)
        );
		
		
		
		Collections.sort(people, new Employee());
		Employee[] fin = (Employee[]) people.toArray();
		System.out.println(fin[0].getName()+fin[1].getName());
		
		
	}
}
