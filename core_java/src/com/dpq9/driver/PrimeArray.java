package com.dpq9.driver;

import java.util.ArrayList;

public class PrimeArray {
	
	private ArrayList intArr;

	public PrimeArray() {
		intArr = new ArrayList<Integer>();
		this.populate();
	}
	
	public ArrayList<Integer> getIntArr() {
		return intArr;
	}

	public void setIntArr(ArrayList intArr) {
		this.intArr = intArr;
	}

	public boolean prime(int n) {
		if (n % 2 == 0){
			return false;
		}
		else {
			for(int x = 3; x < n; x += 2) {
				if (n % x == 0) {
					return false;
				}
			}
			return true;
		}
	}
	
	public void populate() {
		int y = 1;
		while(y <= 100) {
			this.getIntArr().add(y);
			y++;
		}
	}
	
	public void printPrimes() {
		for (int x = 0; x < this.getIntArr().size(); x++) {
			if (this.prime(this.getIntArr().get(x))) {
				System.out.println(this.getIntArr().get(x));
			}
		}
	}
	
	public static void main(String[] args) {
		PrimeArray pa = new PrimeArray();
		pa.printPrimes();
	}
}
