package com.revature.q7;

public class Employee {

	private String name;
	private String department;
	private int age;
	
	public Employee(String nameIn,String deptIn, int ageIn){
		//when i used this, com.revature.q7.employee....
		this.name = nameIn;
		this.age = ageIn;
		this.department = deptIn;
	}
	
	public String getName(){
		return name;
	}
	public String getDepartment(){
		return department;
	}
	public int getAge(){
		return age;
	}
}