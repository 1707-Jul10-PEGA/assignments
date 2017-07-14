package com.revature.ddh.question19;

import java.util.ArrayList;
import com.revature.ddh.question9.*;

public class OneToTen {

	public static void main(String[] args) {
		ArrayList<Integer> arr = new ArrayList<Integer>();
		for(int i=0; i <=10; i++) {
			arr.add(i);
		}
		int evenVal = 0;
		
		for (int j = 0; j <arr.size(); j++) {
			if (arr.get(j) % 2 == 0) {
				evenVal += j;
				System.out.println(evenVal);
				
			}
		}
		for (int j = 0; j <arr.size(); j++) {
			if (arr.get(j) % 2 == 1) {
				evenVal += j;
				System.out.println(evenVal);
				
			}
		}
		for (int j = 0; j <arr.size(); j++) {
			Question9.Prime(j);
				System.out.println(evenVal);
				
			}
		}
	}

