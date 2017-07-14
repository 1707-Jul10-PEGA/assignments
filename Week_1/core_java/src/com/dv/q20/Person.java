package com.dv.q20;


public class Person {
	
	private String firstName;
	private String lastName;
	int age;
	private String state;
	
	// no args constructor
	public Person() {
		super();
	}

	// overloaded constructor with all fields
	public Person(String firstName, String lastName, int age, String state) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
		this.state = state;
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

	@Override
	public boolean equals(Object obj) {
	
		// check if object references are the same
		if(this == obj) {
			return true;
		}
		
		if(obj == null) {
			return false;
		}
		
		if(getClass() != obj.getClass()) {
			return false;
		}
		
		// create a person object
		Person other = (Person) obj;
		
		// check first name
		if(firstName == null) {
			if(other.firstName != null) {
				return false;
			}
		}
		
		else if(!firstName.equals(other.firstName)) {
			return false;
		}
		
		// check last name
		if(lastName == null) {
			if(other.lastName != null) {
				return false;
			}
		}
		
		else if(!lastName.equals(other.lastName)) {
			return false;
		}
		
		// check age
		if(age == 0) {
			if(other.age != 0) {
				return false;
			}
		}
		
		else if(!(age == other.age)) {
			return false;
		}

		// check state
		if(state == null) {
			if(other.state != null) {
				return false;
			}
		}
		
		else if(!state.equals(other.state)) {
			return false;
		}
		
		return true;
	}

	@Override
	public String toString() {
		return "Name " + firstName + " " + lastName + "\nAge: " + age + " years" + "\nState: " + state;
	}
	
}
