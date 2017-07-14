package com.bc.q7.driver;

import java.util.ArrayList;
import java.util.Comparator;

public class Driver {
	public static void main(String[] args) {
		ArrayList<Employee> empList = new ArrayList<Employee>();
		empList.add(new Employee("John", "Sales", 42));
		empList.add(new Employee("John", "Sales", 30));
		empList.add(new Employee("Sally", "Finance", 28));
		empList.add(new Employee("Bryan", "Software" , 28));
		empList.sort(new EmployeeComparator());
		System.out.println(empList);
	}
}

class Employee {
	private String name;
	private String department;
	private int age;

	@Override
	public String toString() {
		return "Employee [name=" + name + ", department=" + department + ", age=" + age + "]";
	}

	public Employee(String name, String department, int age) {
		super();
		this.name = name;
		this.department = department;
		this.age = age;
	}

	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
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
}
//Ranked comparison
class EmployeeComparator implements Comparator<Employee> {

	@Override
	public int compare(Employee arg0, Employee arg1) {
		if (arg0 == arg1) {
			return 0;
		}
		if (arg0.equals(arg1)) {
			return 0;
		}
		if (arg0.getName() == null && arg1.getName() != null) {
			return -1;
		}
		if (arg0.getName() == null && arg1.getName() == null) {
			if (arg0.getDepartment().equals(arg1.getDepartment())) {
				return arg0.getAge() - arg1.getAge();
			} else {
				if (arg0.getDepartment().compareTo(arg1.getDepartment()) < 0) {
					return -1;
				} else if (arg0.getDepartment().compareTo(arg1.getDepartment()) > 0) {
					return 1;
				}
			}
		}
		if (arg0.getName() != null && arg1.getName() == null) {
			return 1;
		}
		if (arg0.getName() != null && arg1.getName() != null) {
			if (arg0.getName().compareTo(arg1.getName()) < 0) {
				return -1;
			} else if (arg0.getName().compareTo(arg1.getName()) > 0) {
				return 1;
			} else {
				if (arg0.getDepartment().equals(arg1.getDepartment())) {
					return arg0.getAge() - arg1.getAge();
				} else {
					if (arg0.getDepartment().compareTo(arg1.getDepartment()) < 0) {
						return -1;
					} else if (arg0.getDepartment().compareTo(arg1.getDepartment()) > 0) {
						return 1;
					}
				}
			}
		}

		return 0;
	}

}
