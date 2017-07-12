package com.as.q19;

import java.util.ArrayList;
import java.util.Iterator;

public class Driver {
	public static void main(String[] args) {
		ArrayList<Integer> l = new ArrayList<Integer>();
		//populate the list with integers 1 - 10
		for (int i = 1; i < 11; i++) {
			l.add(i);
		}
		//display the list
		System.out.println(l);
		
		//sum up the even numbers
		int evenSum = 0;
		for (int i: l) {
			if (i % 2 == 0) {
				evenSum += i;
			}
		}
		//display the even sum
		System.out.println(evenSum);
		
		//sum up the even numbers
		int oddSum = 0;
		for (int i: l) {
			if (i % 2 == 1) {
				oddSum += i;
			}
		}
		//display the odd sum
		System.out.println(oddSum);
		
		//remove the prime numbers
		Iterator<Integer> iter = l.iterator();
		
		while (iter.hasNext()){
			Integer num = iter.next();
			//check that the number is not even or 2 and greater than 1
			if ((num % 2 == 1 || Math.abs(num) == 2) && num > 1) {
				//2 is the only even prime number and as such gets a special case
				//all other prime numbers greater than 2 are odd
				if (num > 2) {
					//flag to see if a mod operation returned a 0
					boolean mod0 = false;
					//perform modulus division on the prime number candidate 
					//using all odd integers greater than 3 less than the candidate
					for(int j = 2; j < num; j++) {
						if (num % j == 0){
							mod0 = true;
						}
					}
					//if all modulus operations yielded a result greater than 0
					//then it is a prime number
					if (!mod0) {
						iter.remove();
					}
				} else {
					iter.remove();;
				}
			}
		}
		//display the modified list
		System.out.println(l);
	}
}
