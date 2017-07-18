package com.cg.bankingapp;

import java.io.Serializable;

public abstract class User implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7477586490858301485L;

	// Variables
	private String name;
	private String username;
	private String password;
	private String accessRights;

	// Constructor
	protected User(String name, String username, String password, String userType) {
		this.setName(name);
		this.username = username;
		this.password = password;
		this.setAccessRights(userType);
	}

	protected User() {
	}

	// Gettters
	public String getName() {
		return name;
	}

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
	public void setName(String name) {
		this.name = name;
	}

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
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
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
}
