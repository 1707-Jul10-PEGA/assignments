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
			if(i == 1){
				continue;
			}
			if(i == 2){
				primes[counter] = i;
				counter++;
				System.out.println(i);
			}else{
				for(int j = 0; j < arr.length; j++){
					for(int k: primes){
						if()
					}
				}
			}
		}
		
	}
	
	public static void main(String[] args) {
		printPrimes(createArray(9));
	}

}
