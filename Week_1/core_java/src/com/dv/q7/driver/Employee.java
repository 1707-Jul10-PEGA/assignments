package com.dv.q7.driver;

public class Employee {

	private String name;
	private String dep;
	private int age;

	public Employee() {
		super();
	}

	public Employee(String name, String dep, int age) {
		super();
		this.name = name;
		this.dep = dep;
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDep() {
		return dep;
	}

	public void setDep(String dep) {
		this.dep = dep;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "Employee [name=" + name + ", dep=" + dep + ", age=" + age + "]";
	}

}