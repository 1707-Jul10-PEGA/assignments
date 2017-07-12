package com.WL.q14;

import java.time.LocalDate;

public class Q14 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int x = 1;
		
		switch (x) {
		case 1:
			System.out.println(Math.sqrt(49.3));
			break;

		case 2:
			System.out.println(LocalDate.now());
			break;
		case 3:
			String myStr = "I am learning core java";
			String[] mySplits = myStr.split(" ");
			for(String str : mySplits){
			System.out.println(str);
		}
			break;
		default:
			System.out.println("No case selected.");
			break;
		}
		
		
		}

	}


