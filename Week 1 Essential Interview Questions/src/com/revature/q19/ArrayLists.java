package com.revature.q19;

//yay for learning
import com.revature.q9.*;
import java.util.ArrayList;

public class ArrayLists {
	public static void main(String[] args) {
		ArrayList<Integer> myAL = new ArrayList<Integer>();
		int evenRes = 0;
		int oddRes = 0;
		for(int x = 0; x < 10; x++){
			myAL.add(x + 1);
		}
		
		System.out.println("ArrayList: " + myAL);
		for (int x = 0; x < myAL.size(); x++){
			if(myAL.get(x)%2 == 0){
				evenRes += myAL.get(x);
			}
			else{
				oddRes += myAL.get(x);
			}
			
		}
		for (int x = 0; x < myAL.size(); x++){
			if(Primes.isPrime(myAL.get(x))){
				myAL.remove(x);
			}
		}
		System.out.println("Even Sum: " + evenRes + "\nOdd Sum: " + oddRes + "\nNew ArrayList (Without Primes): " + myAL);
		
		
	}
}
