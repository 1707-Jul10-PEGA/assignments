package q19;

/*
 * Q19: Create an ArrayList and insert integers 1 through 10. Display the ArrayList.
 * Add all the even numbers up and display the result. Add all the odd numbers up
 * and display the result. Remove the prime numbers from the ArrayList and print
 * out the remaining ArrayList.
 */


import java.util.*;

public class ArrayListMods {
	
	public static void main(String[] args) {
		ArrayList<Integer> x = new ArrayList<Integer>();

		for(int i = 1; i <= 10; i++) {
			x.add(i);
		}
		
		addEven(x);
		addOdd(x);
		removePrime(x);

	}
	
	public static void addEven(ArrayList<Integer> a) {
		int sum = 0;
		for (double num : a) {
			if((num % 2) == 0) {
				sum += num;
			}
		}
		System.out.println("Sum of Even Numbers: " + sum);
	
	}
	
	public static void addOdd(ArrayList<Integer> a) {
		int sum = 0;
		for (double num : a) {
			if((num % 2) == 1) {
				sum += num;
			}
		}
		System.out.println("Sum of Odd Numbers: " + sum);
	} 
	
	public static void removePrime(ArrayList<Integer> a){

		/*for(int num : a ) {
			if(isPrime(num)) {
				a.remove(num);
			}
		}*/
		
		Iterator<Integer> num = a.iterator();
		while(num.hasNext()) {
			int temp = num.next(); //num references "a"
			if (isPrime(temp)) {
				num.remove(); // this is why no need for "a"
			}
		}
		System.out.println(a);
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
