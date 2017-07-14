package com.revature.ddh.day2;

public class Wrapper {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Integer i = new Integer(5);
		
		int k = i;
		
		i = 7;
		
		int j = addFive(new Integer(2));
		
		printAll(1,2,3,4,5,6,7);
		
	
	}
	
	public static Integer addFive(Integer i) {
		
		return i + 5;
	}
	
	public static int addOne(int i) {
		
		return i + 1;
	}
	
	public static void printAll(int ... intArr) {
		
		for(int i: intArr) {
			System.out.println(i);
		}
	}

}
