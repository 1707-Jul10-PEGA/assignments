package com.aq.q7.pojo;

public class Employee  {
	
	private String name;
	private String department;
	private int    age; 
	
	public Employee(String eName, String eDpt, int eAge){	
		super();
		name = eName;
		department = eDpt;
		age = eAge;
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
	public static void main(String[] args) {
		
	}

	@Override
	public String toString() {
		return "Employee [name=" + name + ", department=" + department + ", age=" + age + "]";
	}
	
	
}
