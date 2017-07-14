package com.wh.q7;

/**
 * The Employee class
 * 
 * @author Wei
 * 
 */
public class Employee {

    /** String variable to hold names of employees. */
    private String name;

    /** String variable to hold which department this employee works for. */
    private String department;

    /** Int variable to hold the age of the employee */
    private int age;

    private void setName(String name) {
	this.name = name;
    }

    public String getName() {
	return this.name;
    }

    private void setDepartment(String department) {
	this.department = department;
    }

    public String getDepartment() {
	return this.department;
    }

    private void setAge(int age) {
	this.age = age;
    }

    @Override
    public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + age;
	result = prime * result + ((department == null) ? 0 : department.hashCode());
	result = prime * result + ((name == null) ? 0 : name.hashCode());
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
	Employee other = (Employee) obj;
	if (age != other.age)
	    return false;
	if (department == null) {
	    if (other.department != null)
		return false;
	} else if (!department.equals(other.department))
	    return false;
	if (name == null) {
	    if (other.name != null)
		return false;
	} else if (!name.equals(other.name))
	    return false;
	return true;
    }

    @Override
    public String toString() {
	return "Employee [name=" + name + ", department=" + department + ", age=" + age + "]";
    }

    public int getAge() {
	return this.age;
    }

    public Employee(String name, String department, int age) {
	setName(name);
	setDepartment(department);
	setAge(age);
    }
}
