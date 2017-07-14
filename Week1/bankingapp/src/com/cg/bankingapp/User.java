package com.cg.bankingapp;

public abstract class User{


	// Variables
	private String name;
	private String username;
	private int password;
	private String userType;
	private String accessRights;


	// Constructor
	public User(String name, String username, String password, String userType) {
		this.setName(name);
		this.username = username;
		this.password = password.hashCode();
		this.userType = userType;
		this.setAccessRights(this.userType);
	}

	// Gettters
	public String getName() {
		return name;
	}
	public String getUsername() {
		return username;
	}

	public String getUserType() {
		return userType;
	}

	public String getAccessRights() {
		return accessRights;
	}
	
	public int getPassword() {
		return password;
	}

	// Setters
	public void setName(String name) {
		this.name = name;
	}
	public void setUsername(String username) {
		this.username = username;
	}

	public void setPassword(String password) {
		this.password = password.hashCode();
	}

	public void setUserType(String userType) {
		this.userType = userType;
	}

	public void setAccessRights(String userType) {
		if ("Employee".equalsIgnoreCase(userType)) {
			this.accessRights = "employee";
		} else if ("Admin".equalsIgnoreCase(userType)) {
			this.accessRights = "admin";
		} else {
			this.accessRights = "customer";
		}
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((accessRights == null) ? 0 : accessRights.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + password;
		result = prime * result + ((userType == null) ? 0 : userType.hashCode());
		result = prime * result + ((username == null) ? 0 : username.hashCode());
		return result;
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
		if (userType == null) {
			if (other.userType != null)
				return false;
		} else if (!userType.equals(other.userType))
			return false;
		if (username == null) {
			if (other.username != null)
				return false;
		} else if (!username.equals(other.username))
			return false;
		return true;
	}
	
	public abstract String toString();


	
}
