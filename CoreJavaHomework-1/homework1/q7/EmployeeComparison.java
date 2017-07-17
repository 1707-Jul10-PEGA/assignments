package q7;


import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class EmployeeComparison {

	public static void main(String[] args) {
		
		Employee Bruno = new Employee("Bruno", 1558, 50);
		Employee Andrew = new Employee("Andrew" , 2312 , 22);
		Employee Jason = new Employee("Jason" , 1331, 31);
		
		LinkedList<Employee> empList = new LinkedList<Employee>();
		
		empList.add(Bruno);
		empList.add(Andrew);
		empList.add(Jason);
		
		System.out.println("Without Sort: \n\t" + empList);
		
		Collections.sort(empList);
		System.out.println("With Sort by Name: \n\t" + empList);
		
		Collections.sort(empList, new EmployeeComparatorDept());
		System.out.println("With Sort by Dept: \n\t" + empList);
		
		Collections.sort(empList, new EmployeeComparatorAge());
		System.out.println("With Sort by Age: \n\t" + empList);
		
		

	}

}
