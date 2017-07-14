package com.jntm.q7.driver;

import java.util.Comparator;

public class Employee {
	//This is an employee class.
	//There are getters, setters, and constructors.
	String name;
	String department;
	int age;
	
	//These variables only exist to be used by q11, otherwise, ignore them.
	//They are not used in this program.
	public float val1 = 1.04f;
	public float val2 = 3.14f;
	
	
	
	public Employee(String name, String department, int age){
		this.name=name;
		this.department=department;
		this.age=age;
		
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
	
	public String toString(){
		return this.name + ", " + this.department +", "+ this.age;
	}
	
}


//This is the sorting override for the different parameters.

class SortByName implements Comparator<Employee>{
	public int compare(Employee a, Employee b){
		return a.name.compareTo(b.name);
	}
}

class SortByDepartment implements Comparator<Employee>{
	public int compare(Employee a, Employee b){
		return a.department.compareTo(b.department);
	}
}

class SortByAge implements Comparator<Employee>{
	public int compare(Employee a, Employee b){
		return a.age - b.age;
	}
}
