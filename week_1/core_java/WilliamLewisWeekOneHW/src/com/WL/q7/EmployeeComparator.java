package com.WL.q7;

import java.util.Comparator;

public class EmployeeComparator implements Comparator<Employee>{
	
	
	
	public int compare(Employee a, Employee b)
	{
		if(a.getAge() > b.getAge())
		{
			return 1;
		}
		else if( a.getAge() < b.getAge())
		{
			return -1;
		}
		else 
		{
			if ((a.getDepartment().compareTo(b.getDepartment()) > 0))
			{
				return 1;
				
			}
			else if ((a.getDepartment().compareTo(b.getDepartment()) < 0))
			{
				return -1;
			}
			else 
			{
				if (a.getName().compareTo(b.getName()) > 0)
				{
					return 1;
				}
				else if (a.getName().compareTo(b.getName()) < 0)
				{
					return -1;
				}
				else 
				{
					return 0;
				}
			}
		}
	}
	
	

	 
	 

}
