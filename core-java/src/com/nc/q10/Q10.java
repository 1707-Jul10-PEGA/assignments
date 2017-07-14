package com.nc.q10;
import java.util.*;

public class Q10 {

	public static void main(String[] args) {
		//Get first and second int
		System.out.print("Type the first int: ");
		Scanner sc = new Scanner(System.in);
		int firstNum = sc.nextInt();  
		System.out.print("Type the second int: ");
		int secondNum = sc.nextInt();
		
		//If first number is less then second number then print first number, and vice versa
		int minNum = (firstNum < secondNum) ? firstNum : secondNum;
		
		System.out.println(minNum);
	}

}
