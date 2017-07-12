package com.EC.q7;

public class Employee {
	
	private String name;
	private int age;
	private String department;
	
	public Employee(){
		setName(null);
		setAge(0);
		setDepartment(null);
	}
	
	public Employee(String name, String department,int age){
		this.name = name;
		this.department = department;
		this.age = age;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	
	public static void sortEmployees
	
}
