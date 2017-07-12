package com.nc.q10;
import java.util.*;

public class Q10 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.print("Type the first int: ");
		Scanner sc = new Scanner(System.in);
		int firstNum = sc.nextInt();  
		System.out.print("Type the second int: ");
		int secondNum = sc.nextInt();
		
		int minNum = (firstNum < secondNum) ? firstNum : secondNum;
		
		System.out.println(minNum);
	}

}
