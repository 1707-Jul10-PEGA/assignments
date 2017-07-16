package com.revature.bankingapp.entities.person;

import java.io.Serializable;
import java.util.UUID;

import com.revature.bankingapp.interfaces.PersonInterface;

public class Person implements PersonInterface, Serializable{
	
	
	private String firstname;
	private String lastName;
	private String username;
	private String dob;
	private String address;
	private static final long serialVersionUID = 1L;

	
	
	/* UserId's are unique within the system. There is no need
	 * for special Ids to diferentiate employees from customers
	 * CAN ONLY BE INITIALIZED ONCE*/
	private final UUID userId;
	
	/**
	 * Default constructor.Sets a random UI without setting the rest of the
	 * elements
	 */
	public Person() {
		this.userId = UUID.randomUUID();
	}
	
	/**
	 * Creates a new Person with the specified parameters. 
	 * Used to retrieve users from the database.
	 * 
	 * @param firsttname	-User first name
	 * @param lastName	-User last name
	 * @param username	-User user name
	 * @param dob		-User date of birth
	 * @param address	-User address
	 * @param age		-User Ages
	 * @param userId	-User unique identifier
	 */
	public Person(String firstname, String lastName, String username, String dob, String address, UUID userId) {
		super();
		this.firstname = firstname;
		this.lastName = lastName;
		this.username = username;
		this.dob = dob;
		this.address = address;
		this.userId = userId;
	}

	/**
	 * Creates a new person with the given parameters.
	 * Used to generate a new Person with a new ID
	 * 
	 * @param fistname	-User first name
	 * @param lastName	-User last name
	 * @param username	-User user name
	 * @param dob		-User date of birth
	 * @param address	-User address
	 * @param age		-User Ages
	 */
	public Person(String firstname, String lastName, String username, String dob, String address) {
		super();
		this.firstname = firstname;
		this.lastName = lastName;
		this.username = username;
		this.dob = dob;
		this.address = address;
		this.userId = UUID.randomUUID();
	}

	public int login(int id) {
		// TODO Auto-generated method stub
		return 0;
	}

	public int logout(int id) {
		// TODO Auto-generated method stub
		return 0;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public UUID getUserId() {
		return userId;
	}

}
