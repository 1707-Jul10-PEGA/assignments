//Jake Maynard
//Access another package's floats.
package com.jntm.q11.driver;

public class Main {

	public static void main(String[] args) {
		//I already had a package with a class in it, so I borrowed it
		//these values come from com.jntm.q7.driver, which was 
		//the employee sorting question. 
		
		com.jntm.q7.driver.Employee person = new com.jntm.q7.driver.Employee("Stan", "CPS", 78);
		
		System.out.println(person.val1);
		System.out.println(person.val2);
	}

}
