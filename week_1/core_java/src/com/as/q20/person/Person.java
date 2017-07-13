package com.as.q20.person;

public class Person {
	private String firstName;
	
	private String lastName;
	
	private String age;
	
	private String state;
	
	public Person() {
		this.setFirstName("");
		this.setLastName("");
		this.setAge("");
		this.setState("");
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}
	
	@Override
	public String toString() {
		String ret = ("Name: " + firstName + " " + lastName + "\n" +
					  "Age: " + age + "\n" + 
					  "State: " + state + " State");
		return ret;
	}
}
