package com.WL.q7;

import java.util.ArrayList;

public class q7 {

	public static void main(String[] args) {
		// Sort two employees based on name, department, and age using Comparator interface

		ArrayList<Employee> myStaff = new ArrayList<Employee>();

		//Some test cases to try out
		Employee joe = new Employee(20, "joe", "physics");
		Employee joeClone = new Employee(20, "joe", "physics");
		Employee joeTwin = new Employee(20, "joe", "Chemistry");
		Employee joeSis = new Employee(20, "Jane", "physics");
		Employee joeMom = new Employee(22, "joe", "physics");
		
		 myStaff.add(joeClone);
		 myStaff.add(joeTwin);
		 myStaff.add(joeSis);
		 myStaff.add(joeMom);
		 
		 EmployeeComparator myCom = new EmployeeComparator();
		 for(Employee x: myStaff)
		 {
			 System.out.println(myCom.compare(joe, x));
		 }
		
		
		
		
		
	}
	

}
