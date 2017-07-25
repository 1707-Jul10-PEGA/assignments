package com.cg.bankingapp;

import java.io.Serializable;

public abstract class User implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7477586490858301485L;

	// Variables
	private String firstname;
	private String lastname;
	private String username;
	private String password;
	private String accessRights;
	private int status;
	private int userid;

	// Constructor
	protected User(int userid, String firstname, String lastname, String username, String password, String userType,int status) {
		this.userid = userid;
		this.firstname = firstname;
		this.setLastname(lastname);
		this.username = username;
		this.password = password;
		this.setAccessRights(userType);
		this.setStatus(status);
	}

	protected User() {
	}

	public User(String firstname, String lastname, String username, String password, String userType, int status) {
		this.firstname = firstname;
		this.setLastname(lastname);
		this.username = username;
		this.password = password;
		this.setAccessRights(userType);
		this.setStatus(status);
	}

	// Gettters
	public String getUsername() {
		return username;
	}

	public String getAccessRights() {
		return accessRights;
	}

	public String getPassword() {
		return password;
	}

	// Setters
	protected void setPassword(String password) {
		this.password = password;
	}

	/**
	 * @param username
	 *            the username to set
	 */
	public void setUsername(String username) {
		this.username = username;
	}

	private void setAccessRights(String userType) {
		if ("Employee".equalsIgnoreCase(userType)) {
			this.accessRights = "employee";
		} else if ("Admin".equalsIgnoreCase(userType)) {
			this.accessRights = "admin";
		} else {
			this.accessRights = "customer";
		}
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		if (accessRights == null) {
			if (other.accessRights != null)
				return false;
		} else if (!accessRights.equals(other.accessRights))
			return false;
		if (password != other.password)
			return false;
		if (username == null) {
			if (other.username != null)
				return false;
		} else if (!username.equals(other.username))
			return false;
		return true;
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

	protected int getStatus() {
		return status;
	}

	protected void setStatus(int status) {
		this.status = status;
	}

	public int getUserid() {
		return userid;
	}

	public void setUserid(int userid) {
		this.userid = userid;
	}
}
