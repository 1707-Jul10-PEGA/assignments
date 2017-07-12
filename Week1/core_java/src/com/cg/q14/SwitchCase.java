package com.cg.q14;

import java.time.LocalDate;

public class SwitchCase {
	public static void main(String [] args){
		for(int i = 1; i < 4; i++){
			switch(i){
				case 1: System.out.println("The square root of 9 is " +Math.sqrt(9));
						break;
				case 2: System.out.println(LocalDate.now());
						break;
				case 3: String str = "I am learning Core Java";
						String [] str1 = str.split(" ");
						for(String j:str1){
							System.out.println(j);
						}
						break;
			}
		}
	}
}
