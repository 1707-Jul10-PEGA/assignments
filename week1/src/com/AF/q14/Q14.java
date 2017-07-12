package com.AF.q14;

import java.time.LocalDate;

public class Q14 {
	
	public static void handleCase(String s) {
		
		double s_double = 0.0;
		
		if ( s == "isInt") {
			System.out.println("Invalid Request");
			return;
		}
		
		try {
			s_double = Double.parseDouble(s);
			s = "isInt";
			
		} catch(NumberFormatException e) {}
		
		switch(s) {
			case "isInt":
				System.out.println(Math.sqrt(s_double));
				break;
			case "today's date":
				System.out.println(LocalDate.now());
				break;
				
			case "split string":
				String[] temp = new String("I am Learning Core Java").split(" ");
				for (String t : temp) {
					System.out.println(t);
				}
				break;
			default:
				System.out.println("Invalid Request");
		}
	}
				
	public static void main(String[] args) {
		handleCase("5");
		handleCase("today's date");
		handleCase("split string");
		
	}
}
