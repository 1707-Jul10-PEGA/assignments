package com.wh.q7;

public class Q7 {

	public static void main(String[] args) {
		Employee o1 = new Employee("Adam West", "Batman", 50);
		Employee o2 = new Employee("Bruce Wayne", "Batman", 50);
		Employee o3 = new Employee("Bruce Wayne", "Batman", 50);
		Employee o4 = new Employee("Adam West", "Superman", 25);
		EmployeeComparator comp = new EmployeeComparator();
		
		System.out.println("o1 compared to o1: " + comp.compare(o1, o1));
		System.out.println("o1 compared to o2: " + comp.compare(o1, o2));
		System.out.println("o2 compared to o1: " + comp.compare(o2, o1));
		System.out.println("o2 compared to o3: " + comp.compare(o2, o3));
		System.out.println("o3 compared to o2: " + comp.compare(o3, o2));
		System.out.println("o3 compared to o4: " + comp.compare(o3, o4));
	}

}
