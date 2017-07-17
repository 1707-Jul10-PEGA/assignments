package com.users;

import java.io.Serializable;

import com.interfaces.Menu;

public class Employee extends User implements Menu, Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 2310874586316300994L;
	double salary;
	String department;
	String ID;

	@Override
	public String toString() {
		return "Employee [salary=" + salary + ", department=" + department + ", ID=" + ID + ", getFirstName()="
				+ getFirstName() + ", getLastName()=" + getLastName() + ", getUserName()=" + getUserName()
				+ ", getPassword()=" + getPassword() + ", getAge()=" + getAge()	+ ", toString()=" + super.toString() + ", hashCode()=" + hashCode() + ", getClass()=" + getClass()
				+ "]";
	}

	@Override
	public void displayMenu() {

	}

	@Override
	public boolean optionInput() {
		return false;

	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Employee other = (Employee) obj;
		if (ID == null) {
			if (other.ID != null)
				return false;
		} else if (!ID.equals(other.ID))
			return false;
		if (department == null) {
			if (other.department != null)
				return false;
		} else if (!department.equals(other.department))
			return false;
		if (Double.doubleToLongBits(salary) != Double.doubleToLongBits(other.salary))
			return false;
		return true;
	}

}
