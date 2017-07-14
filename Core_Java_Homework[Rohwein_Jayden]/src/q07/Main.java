package q07;

public class Main {

	public static void main(String[] args){
		
		Employee emp1,emp2,emp3;
		Employee_comparer ec = new Employee_comparer();
		
		emp1 = new Employee("justin","sales",42);
		emp2 = new Employee("justin","sales",42);
		emp3 = new Employee("Sarah","accounting",42);
		
		System.out.println (ec.compare(emp1,emp2));

		System.out.println (ec.compare(emp1,emp3));
		
		
		
	}
}
