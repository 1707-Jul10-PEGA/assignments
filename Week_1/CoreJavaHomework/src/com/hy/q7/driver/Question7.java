package com.hy.q7.driver;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

//sort two employee based on their name, department, and age using the comparator interface
public class Question7{
	public static void main(String[] args) {
		List<Employee> list = new LinkedList<Employee>();
		list.add(new Employee("John Doe", "Sales", 25));
		list.add(new Employee("Susan Smith", "Finance", 34));
		list.add(new Employee("Kay Johnson", "Sales", 30));
		list.add(new Employee("Jessie Todd", "HR", 27));
		
		System.out.println("List: " + list);
		Collections.sort(list, new NameComparator());
		System.out.println("After sort by name:" + list);
		Collections.sort(list, new DepartmentComparator());
		System.out.println("After sort by department:" + list);
		Collections.sort(list, new AgeComparator());
		System.out.println("After sort by age:" + list);
	}

}
