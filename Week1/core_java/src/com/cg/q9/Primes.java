package com.cg.q9;

public class Primes {
	public static int [] createArray(int n){
		int [] intArray = new int [n];
		for(int i = 1; i <= n; i++){
			intArray[i-1] = i;
		}
		
		return intArray;
	}
	public static void printPrimes(int [] arr){
		int counter = 0;
		int [] primes = new int[100];
		
		for(int i:arr){			
			//Base case
			if(i <= 1){
				continue;
			}
			else if(i == 2){
				primes[counter] = i;
				counter++;
				//System.out.println(i);
			}else{
				//Check if the number is even
				if(!com.cg.q6.Even.even(i)){
					System.out.println("i = " +i);
					for(int k:primes){
						int temp = gcd(k,i);
						System.out.print(temp + " ");
						
					}
				}
			}
		}
		
	}
	
	public static int gcd(int x, int y){
		if (x > y){
			x = x-y;
		}else{
			y = y-x;
		}
		return x;
	}
	
	public static void main(String[] args) {
		printPrimes(createArray(9));
	}

}
