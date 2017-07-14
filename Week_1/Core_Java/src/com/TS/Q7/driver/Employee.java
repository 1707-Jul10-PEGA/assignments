/*
 * Tae Song
 * Question 7 - Employee class for employee information storage
 */
package com.TS.Q7.driver;

/*
 * Employee class that employee information, also contains overrided toString() method
 */
public class Employee {
	String name;
	String department;
	int age;
	
	public Employee(String name, String department, int age)
	{
		this.name = name;
		this.department = department;
		this.age = age;
	}
	
	/*Override from default toString() in order to print out employee information*/
	@Override
	public String toString()
	{
		return this.name + " " + this.department + " " + this.age;
	}
	
	public void print()
	{
		System.out.println(this.name + " " + this.department + " " + this.age);
	}
}
