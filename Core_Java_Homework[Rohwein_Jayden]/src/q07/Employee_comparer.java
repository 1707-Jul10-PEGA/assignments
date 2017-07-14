package q07;

import java.util.Comparator;

public class Employee_comparer implements Comparator<Employee> {

	@Override
	public int compare(Employee arg0, Employee arg1) {
		if(arg0.get_age() == arg1.get_age() && 
			arg0.get_department().equals(arg1.get_department()) &&
			arg0.get_name().equals(arg1.get_name()))
			return 1;
			
		return 0;
	}

}
