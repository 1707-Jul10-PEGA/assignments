package com.nc.q7;

public class Employee {
	private String name;
	private String department;
	private int age;
	
	public String getName(){
		return name;
	}
	public void setName(String n){
		name = n;
	}
	public String getDepartment(){
		return department;
	}
	public void setDepartment(String d){
		department = d;
	}
	public int getAge(){
		return age;
	}
	public void setAge(int a){
		age = a;
	}
	
	
	public Employee(){
		setName("default");
		setDepartment("None");
		setAge(0);
	}
	public Employee(String n, String d, int a){
		setName(n);
		setDepartment(d);
		setAge(a);
	}
}
