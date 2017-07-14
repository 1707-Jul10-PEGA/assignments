package com.MS.Q7.driver;

import java.util.*;

/*
 * The employee class has 3 input parameters (ideally input at instantiation):
 * name, age, and department. Also includes the toString function that displays
 * the requested information when a specific employee is selected in the list
 */

class Employee {
	   String name;
	   int age;
	   String department;
	   Employee() {
	   }
	   Employee(String n, int a, String d) {
	      this.name = n;
	      this.age = a;
	      this.department = d;
	   }
	   public String toString()
	    {
	        return this.name + " " + this.age +
	                           " " + this.department;
	    }
	   
	}


/*
 * Sorting functions implement the Comparator interface. Depending on the
 * data type, the return function changes.
 */
class SortByAge implements Comparator<Employee>
{
	public int compare(Employee a, Employee b)
	{
		return a.age - b.age;
	}
}

class SortByName implements Comparator<Employee>
{
	public int compare(Employee a, Employee b)
	{
		return a.name.compareTo(b.name);
	}
}



class SortByDepartment implements Comparator<Employee>
{
	public int compare(Employee a, Employee b)
	{
		return a.department.compareTo(b.department);
	}
}

/*
 * The main function creates the ArrayList and populates it with two employees.
 * It then displays the employees in various orders depending on how they are sorted.
 * It sorts them by each supplied variable and displays them accordingly.
 */
	public class Main {
	public static void main(String[] args) {
		
		ArrayList<Employee> ar = new ArrayList<Employee>();
		ar.add(new Employee("Ted", 24, "IT"));
		ar.add(new Employee("Nate", 66, "Sales"));
		
		System.out.println("Unsorted: ");
        for (int i=0; i<ar.size(); i++)
            System.out.println(ar.get(i));
        
        Collections.sort(ar, new SortByName());
        
        System.out.println("\nSorted by name: ");
        for (int i=0; i<ar.size(); i++)
            System.out.println(ar.get(i));
		
        Collections.sort(ar, new SortByAge());
        
        System.out.println("\nSorted by age: ");
        for (int i=0; i<ar.size(); i++)
            System.out.println(ar.get(i));
        
        Collections.sort(ar, new SortByDepartment());
        
        System.out.println("\nSorted by department: ");
        for (int i=0; i<ar.size(); i++)
            System.out.println(ar.get(i));
	}

}
