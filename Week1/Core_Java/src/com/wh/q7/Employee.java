package com.wh.q7;

public class Employee {
	
	/** String variable to hold names of employees. */
	private String name;
	
	/** String variable to hold which department this employee works for. */
	private String department;
	
	/** Int variable to hold the age of the employee */
	private int age;
	
	private void setName(String name){
		this.name = name;
	}
	
	public String getName(){
		return this.name;
	}

	private void setDepartment(String department){
		this.department = department;
	}
	
	public String getDepartment(){
		return this.department;
	}
	
	private void setAge(int age){
		this.age = age;
	}
	
	public int getAge(){
		return this.age;
	}

	public Employee(String name, String department, int age){
		setName(name);
		setDepartment(department);
		setAge(age);
	}
}
