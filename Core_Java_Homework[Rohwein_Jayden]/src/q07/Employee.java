package q07;

public class Employee {
	
	private String name,department;
	private int age;
	
	Employee(String name, String department, int age){
		
		this.name = name;
		this.department = department;
		this.age = age;
	}
	
	public String get_name(){
		return name;
	}
	public String get_department(){
		return department;
	}
	public int get_age(){
		return age;
	}

}
