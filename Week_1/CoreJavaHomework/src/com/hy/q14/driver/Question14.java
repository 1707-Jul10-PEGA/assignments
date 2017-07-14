package com.hy.q14.driver;

import java.util.Date;

public class Question14 {
	private void printSwitch(int num){
		switch(num){
		case 1:	System.out.println(Math.sqrt(Math.random()));
				break;
		case 2: System.out.println(new Date());
				break;
		case 3:
			String temp = "I am learning Core Java";
			String[] res = temp.split(" ");
			for(String s: res){
				System.out.println(s);
			}
		}
	}
	
	public static void main(String[] args) {
		Question14 q14 = new Question14();
		q14.printSwitch(1);
		q14.printSwitch(2);
		q14.printSwitch(3);
		
	}
}
