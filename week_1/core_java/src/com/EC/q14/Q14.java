package com.EC.q14;
import java.util.Calendar;
public class Q14 {
	
	private static String [] strArr;
	
	public static void main(String[] args) {
		exampleSwitch(0);
		exampleSwitch(1);
		exampleSwitch(2);
	

	}
	
	public static void exampleSwitch(int caseStmt){
		switch(caseStmt){
		case 0:
			System.out.println("Sqaure root of 49 is: " + (int) Math.sqrt(49));
			break;
		case 1:
			Calendar rightNow = Calendar.getInstance();
			System.out.println(rightNow.getTime());
			break;
		case 2:
			String str = "I am learning Core Java";
			strArr = str.split(" ");
		}
	}

}
