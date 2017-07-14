package com.revature.ddh.q7;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

import com.revature.ddh.q7.Employee;


public class question7 implements Comparator<Employee>{

	
	

	private String name;
	private String department;
	private int age;
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Employee e = new Employee("Marcus", "Physics", 24 );
		Employee x = new Employee( "tom", "sales", 35);
		
		List eList = new LinkedList();

		eList.add(e);
		eList.add(x);
		
		Collections.sort(eList);
	}


	
}
