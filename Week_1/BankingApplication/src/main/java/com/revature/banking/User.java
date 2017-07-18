package com.revature.banking;

import java.util.ArrayList;
import java.util.Arrays;

public abstract class User {
	private String firstName;
	private String lastName;
	private int age;
	private String phone;
	private String address;
	private String username;
	private String password;
	private String type;
	
	public User(String firstName, String lastName, int age, String phone,
			String address, String username, String password, String type) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
		this.phone = phone;
		this.address = address;
		this.username = username;
		this.password = password;
		this.type = type;
	}
	
	
	
	@Override
	public String toString() {
		return "\nfirstName="
				+ firstName + ", lastName=" + lastName + ", age=" + age + ", phone=" + phone + ", address=" + address
				+ ", username=" + username + ", password=" + password ;
	}



	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((address == null) ? 0 : address.hashCode());
		result = prime * result + age;
		result = prime * result + ((firstName == null) ? 0 : firstName.hashCode());
		result = prime * result + ((lastName == null) ? 0 : lastName.hashCode());
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		result = prime * result + ((phone == null) ? 0 : phone.hashCode());
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
		if (address == null) {
			if (other.address != null)
				return false;
		} else if (!address.equals(other.address))
			return false;
		if (age != other.age)
			return false;
		if (firstName == null) {
			if (other.firstName != null)
				return false;
		} else if (!firstName.equals(other.firstName))
			return false;
		if (lastName == null) {
			if (other.lastName != null)
				return false;
		} else if (!lastName.equals(other.lastName))
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		if (phone != other.phone)
			return false;
		if (username == null) {
			if (other.username != null)
				return false;
		} else if (!username.equals(other.username))
			return false;
		return true;
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



	public boolean setAge(int age) {
		if(age < 0) {
			return false;
		}
		this.age = age;
		return true;
	}



	public String getPhone() {
		return phone;
	}



	public void setPhone(String phone) {
		this.phone = phone;
	}



	public String getAddress() {
		return address;
	}



	public void setAddress(String address) {
		this.address = address;
	}



	public String getUsername() {
		return username;
	}



	public void setUsername(String username) {
		this.username = username;
	}



	public String getPassword() {
		return password;
	}



	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getType() {
		return type;
	}



	public void setType(String type) {
		this.type = type;
	}



	public boolean login(String username, String password) {
		if(username.equals(this.username) && password.equals(this.password)) {
			return true;
		}
		System.out.print(this.username +"==" + username + " : "+ this.password+ "=="+ password);
		return false;
	}

	public double viewBalance(int id) {
		double balance =  Main.getBankAcc().get(id).getBalance();
		System.out.println("Account: " + id + "\nBalance: $" + balance);
		return balance;
	}
}
