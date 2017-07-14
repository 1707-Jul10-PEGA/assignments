package com.revature.ddh.q7;

public class Employee {
	public String name;
	public String department;
	public int age;
	
	
	public  Employee(String name, String department, int age) {
		this.name = name;
		this.department = department;
		this.age = age;
		
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
		public int compare(Employee emp1) {
			// TODO Auto-generated method stub
			
			if (this.equals(emp1)) {
				return 0;	
			}
			else(emp1.getName().equals(anObject))
			
			return 0;
		}


		@Override
		public int compare(Employee o1, Employee o2) {
			// TODO Auto-generated method stub
			return 0;
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
		
		
		
	
}
