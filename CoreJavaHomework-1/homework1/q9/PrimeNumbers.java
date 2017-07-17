package q9;

import java.util.*;

public class PrimeNumbers {

	public static void main(String[] args) {
		
		ArrayList<Integer> numbers = new ArrayList<Integer>();
		
		for(int i = 1; i <= 100; i++) {
			numbers.add(i);
		}
		
		for(int num : numbers ) {
			if (isPrime(num)) {
				System.out.println(num);
			}
			
		}
		
	}
	

	public static boolean isPrime(int num) {
		if (num == 2) {
			return true;
		}
		if (num%2 == 0) {
			return false;
		}
		for(int i = 3; i*i<=num; i+=2) {
			if(num%i==0) {
				return false;
			}
		}
		return true;
	}
}
