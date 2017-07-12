//Carson Stephens
//07-10-2017

package com.cts.q7;

import java.util.*;

//A class to represent an employee
class Employee
{
	String name, department;
	int age;
	
	//Constructor
	public Employee(String name, String department, int age)
	{
		this.name = name;
		this.department = department;
		this.age = age;
	}
}

//A class to sort the employees by name
class Sort_By_Name implements Comparator<Employee>
{
	//Returns -1 if a.name is "less" than b.name and does nothing
	//Returns 0 if a.name is "equal" to b.name and does nothing
	//Returns 1 if a.name is "greater" than b.name and switches a and b
	public int compare(Employee a, Employee b)
	{
		return a.name.compareTo(b.name);
	}
}

//A class to sort the employees by department
class Sort_By_Department implements Comparator<Employee>
{
	//Returns -1 if a.department is "less" than b.department and does nothing
	//Returns 0 if a.department is "equal" to b.department and does nothing
	//Returns 1 if a.department is "greater" than b.department and switches a with b
	public int compare(Employee a, Employee b)
	{
		return a.department.compareTo(b.department);
	}
}

//A class to sort hte employees by age
class Sort_By_Age implements Comparator<Employee>
{
	//Returns negative if a.age is less than b.age and does nothing
	//Returns 0 if a.age is equal to b.age and does nothing
	//Returns positive if a.age is greater than b.age and switches a and b
	public int compare(Employee a, Employee b)
	{
		return a.age - b.age;
	}
}

public class Driver
{
	public static void main (String[] args)
	{
		System.out.println("Q7");
		
		//Set up a scanner for input
		try (Scanner scanner = new Scanner(System.in))
		{
			//Initialize ArrayList for employees
			ArrayList<Employee> emp = new ArrayList<Employee>();
			
			//Initialize variables for input
			String name = "";
			String department = "";
			int age = 0;
			
			//Take inputs for 1st employee
			System.out.println("1st Employee");
			System.out.print("Name: ");
			name = scanner.nextLine();
			System.out.print("Department: ");
			department = scanner.nextLine();
			System.out.print("Age: ");
			age = scanner.nextInt();
			scanner.nextLine();
			
			//Construct the 1st employee and add to ArrayList
			Employee a = new Employee(name, department, age);
			emp.add(a);
			
			//Take inputs for 2nd employee
			System.out.println("2nd Employee");
			System.out.print("Name: ");
			name = scanner.nextLine();
			System.out.print("Department: ");
			department = scanner.nextLine();
			System.out.print("Age: ");
			age = scanner.nextInt();
			
			//Construct the 2nd employee and add to ArrayList
			Employee b = new Employee(name, department, age);
			emp.add(b);
		
			//Print employees list as is
			System.out.println("Unsorted Employees");
			for (int x = 0; x < emp.size(); x++)
			{
				Employee e = emp.get(x);
				System.out.println(e.name + "\t" + e.department + "\t" + e.age);
			}
			
			//Sort list by name
			Collections.sort(emp, new Sort_By_Name());
			
			//Print employees list by name
			System.out.println("Sorted Employees (Name)");
			for (int x = 0; x < emp.size(); x++)
			{
				Employee e = emp.get(x);
				System.out.println(e.name + "\t" + e.department + "\t" + e.age);
			}
			
			//Sort list by department
			Collections.sort(emp, new Sort_By_Department());
			
			//Print employees list by department
			System.out.println("Sorted Employees (Department)");
			for (int x = 0; x < emp.size(); x++)
			{
				Employee e = emp.get(x);
				System.out.println(e.name + "\t" + e.department + "\t" + e.age);
			}
			
			//Sort list by age
			Collections.sort(emp, new Sort_By_Age());
			
			//Print employees list by age
			System.out.println("Sorted Employees (Age)");
			for (int x = 0; x < emp.size(); x++)
			{
				Employee e = emp.get(x);
				System.out.println(e.name + "\t" + e.department + "\t" + e.age);
			}
			
		}
		
	}
}