package com.md.q7;

import java.awt.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import javax.crypto.spec.DESedeKeySpec;

/**
 * Sort two employees based on their name, department and age using the 
 * Comparator interface
 * @author Martin Delira
 *
 */
public class SortByComparator {

	public static void main(String[] args) {
		
		Employee e1 = new Employee("Martin Delira","IT",26);
		Employee e2 = new Employee("Joane Smith","Engineering",29);
		Employee e3 = new Employee("Edgar Jimenez","Process Engineer",32);
		
		ArrayList<Employee> employeeList = new ArrayList<Employee>();
		employeeList.add(e1);
		employeeList.add(e2);
		employeeList.add(e3);
		
		System.out.println("Sorting by Name");
		Collections.sort(employeeList,new NameComparator());
		System.out.println(employeeList + "\n");
		
		System.out.println("Sorting by Department");
		Collections.sort(employeeList,new DepartmentComparator());
		System.out.println(employeeList + "\n");
		
		System.out.println("Sorting by Age");
		Collections.sort(employeeList,new AgeComparator());
		System.out.println(employeeList);
		
		
		
	}

		
	
}
