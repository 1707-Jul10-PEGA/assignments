package com.revature.bankingapp.entities.user;

import java.util.UUID;

public class SystemUser  {
	

	private UUID userId;
	private String firstname;
	private String lastname;
	private String username;
	private String password;
	private String dob;
	private String address;
	
	
	/**
	 * Default constructor.Sets a random UI without setting the rest of the
	 * elements
	 */
	public SystemUser() {
//		this.userId = UUID.randomUUID();
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
	public SystemUser(String firstname, String lastname, String username, String password, String dob, String address) {
		super();
		this.userId = UUID.randomUUID();
		this.firstname = firstname;
		this.lastname = lastname;
		this.username = username;
		this.password = password;
		this.dob = dob;
		this.address = address;
		
	}
	
	public SystemUser(String firstname, String lastname, String username, String password, String dob, String address, String userId) {
		super();
		this.userId = UUID.fromString(userId);
		this.firstname = firstname;
		this.lastname = lastname;
		this.username = username;
		this.password = password;
		this.dob = dob;
		this.address = address;
		
	}
	
	public SystemUser(String firstname, String lastname, String username, String password, String dob, String address, UUID userId) {
		super();
		this.userId = userId;
		this.firstname = firstname;
		this.lastname = lastname;
		this.username = username;
		this.password = password;
		this.dob = dob;
		this.address = address;
		
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
		return lastname;
	}

	public void setLastName(String lastName) {
		this.lastname = lastName;
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

	public UUID getUserId() {
		return userId;
	}
	
	public void setUserId(UUID id) {
		this.userId = id;
	}
	
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return ""
				+ "First Name: " + firstname + "\n"
				+ "Last Name: " + lastname + "\n"
				+ "Username: " + username + "\n"
				+ "Password: " + password + "\n"
				+ "Date of Birth: " + dob + "\n"
				+ "Address: " + address + "\n"
			    + "UserID:  " + this.userId.toString();

	}

}
