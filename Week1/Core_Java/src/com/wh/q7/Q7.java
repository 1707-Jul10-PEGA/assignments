package com.wh.q7;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Q7. Sort Two employees based on their name, department, and age using the
 * Comparator interface.
 * 
 * @author Wei Huang
 * 
 */
public class Q7 {

    public static void main(String[] args) {

	List<Employee> employeeList = new ArrayList<Employee>(4);
	employeeList.add(new Employee("Bruce Wayne", "Batman", 25));
	employeeList.add(new Employee("Adam West", "Batman", 50));
	EmployeeComparator comp = new EmployeeComparator();

	Collections.sort(employeeList, comp);
	System.out.println(employeeList);

    }

}
