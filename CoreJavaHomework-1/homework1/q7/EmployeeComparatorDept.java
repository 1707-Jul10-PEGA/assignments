package q7;

import java.util.Comparator;


public class EmployeeComparatorDept implements Comparator<Employee>{

	public int compare(Employee o1, Employee o2) {
		// TODO Auto-generated method stub
		int dept = (o1.getDept() - o2.getDept()); // What to compare to! - in this case: value
		return dept; 
		// TODO Auto-generated method stub

	}

}
