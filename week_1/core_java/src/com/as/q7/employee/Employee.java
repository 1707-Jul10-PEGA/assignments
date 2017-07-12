package com.as.q7.employee;

public class Employee {

	private String name;
	
	private String department;
	
	private int age;
	
	public Employee() {
		this.setName("");
		this.setDepartment("");
		this.setAge(-1);
	}
	
	public Employee(String n, String d, int a){
		this.setName(n);
		this.setDepartment(d);
		this.setAge(a);
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

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

}
