package q14;

import java.time.LocalDateTime;
import java.util.Scanner;

public class SwitchCase {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		System.out.println("1 - find square root of number\n"
				+ "2 -  display today's date\n"
				+ "3 - store \" I am learning core java\" into a string array");
	
	
		int i = scan.nextInt();
		
		switch( i ){
		case 1:
			System.out.println( " find the square root of what number?");
			System.out.println( Math.sqrt(scan.nextInt()));
			break;
		case 2:
			
			System.out.println( LocalDateTime.now());
			break;
		case 3:
			
			String[] str = "I am learning Core Java".split(" ");
			for(String s:str){
				System.out.println(s);
			}
		}
	}
}
