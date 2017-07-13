package com.jntm.q14.driver;

import java.util.Date;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) {

		//Feel free to alter this switch to whichever branch you like (1-3)
		int x=3;
		
		
		switch(x){
		//If x is 1, output a square root.
		case 1 : System.out.println(Math.sqrt(100));
			break;
		//If 2, output date.
		case 2: Date now = new Date();
				System.out.println(now);
			break;
		//If 3, break down a sentence into an array.
		case 3: 
			//StringTokenizer is used to break it.
			String str = "I am learning Core Java";
			String[] arr = new String[5];
			StringTokenizer s = new StringTokenizer(str);
			int index =0;	
			while(s.hasMoreTokens()){
					arr[index]= s.nextToken();
					index++;
				}
			
			for(int y = 0; y<5;y++){
				System.out.println(arr[y]);
			}
			
			break;
		
		}
		
		
	}

}
