package q7;


public class Employee implements Comparable<Employee> {

	private String name;
	private int dept;
	private int age;
	
	/*
	 * Constructor
	 */
	
	public Employee(String name, int dept, int age) {
		this.name = name;
		this.dept = dept;
		this.age = age;
	}
	
	@Override
	public String toString() {
		return "Employee [name=" + name + ", dept=" + dept + ", age=" + age + "]";
	}
	
	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + age;
		result = prime * result + dept;
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
		if (dept != other.dept)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

	/*
	 * Getters and Setters
	 */
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getDept() {
		return dept;
	}
	public void setDept(int dept) {
		this.dept = dept;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
	
	@Override
	public int compareTo(Employee arg0) {
		
		if(this.equals(arg0)) {
			return 0;
		}
		
		else if(this.getName().compareTo(arg0.getName()) < 0 ) {
			return -1;
		}
		else {
			return 1;
		}
	}
	
}
