package com.WL.q7;

import java.util.Comparator;

public class Employee {
	int age;
	String name;
	String department; 
	
	public Employee(int age, String name, String department)
	{
		this.setAge(age);
		this.setName(name);
		this.setDepartment(department);
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}

}
