 package driver;

import java.lang.reflect.Array;

public class StringBuilder1 {

	public static void main(String [] args) {
	
	StringBuilder s = new StringBuilder();
	System.out.println(s.capacity());
	s.append("nah son");
	System.out.println(s);
	s.append("Bring that Back");
	System.out.println(s);
	s.setLength(4);
	System.out.println(s);
	System.out.println(s.capacity());
	s.append("doesitlooklikeiwasleftoffbadandbougie");
	System.out.println(s.capacity());
	boolean b = true;
	s.append(b);
	System.out.println(s);
	s.delete(4, 7);
	System.out.println(s);
	
	//palindrone example
	String p = "racecaR";
	System.out.println(p.toString());
	String temp="";
	String reverse = "";
	

	StringBuilder reversey = new StringBuilder(p);
	reversey.reverse();
	System.out.println(reversey);
	
	
	

		
	}
	
	/*int [] start = {12};
	ArrayPractice(start);
	

	}
	
	
	public static void ArrayPractice(int[] arr) {
	  int[] array1 = {2,4,5,3,24,65,42,56,7,84};
	  System.out.println(array1.length);
	 */ 
	}


