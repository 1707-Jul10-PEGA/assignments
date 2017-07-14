package com.md.q20;

public class Person {

private String firstname;
private String lastname;

@Override
public String toString() {
	return "Name: "+getFirstname()+ " " +getLastname()+"\n" + "Age: " + getAge() + " years\n" + "State: " + getState() + "\n\n";
}

private int age;
private String state;

	public Person() {
	}
	
	public Person(String firstname, String lastname, int age, String state) {
		this.firstname = firstname;
		this.lastname = lastname;
		this.age = age;
		this.state = state;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}
	
	

}
