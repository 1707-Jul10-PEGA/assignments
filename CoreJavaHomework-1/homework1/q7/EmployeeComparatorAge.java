package q7;

import java.util.Comparator;


public class EmployeeComparatorAge implements Comparator<Employee>{

	public int compare(Employee o1, Employee o2) {
		// TODO Auto-generated method stub
		int age = (o1.getAge() - o2.getAge()); // What to compare to! - in this case: age
		return age; 
		// TODO Auto-generated method stub
	}
}