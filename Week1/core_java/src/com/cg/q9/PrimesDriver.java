package com.cg.q9;

public class PrimesDriver {
	public static void main(String[] args) {
		Primes p = new Primes();
		
		//Create array, if array contain primes and print it
		p.printPrimes(p.checkForPrimes(p.createArray(100)));
	}
}
