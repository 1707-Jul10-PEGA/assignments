package com.cg.q19;

import java.util.ArrayList;

import com.cg.q9.Primes;

public class MyArrayList {

	//Variables
	private int even;
	private int odd;
	ArrayList<Integer> myArrayList;

	//Constructor
	public MyArrayList() {
		even = 0;
		odd = 0;
		myArrayList = new ArrayList<Integer>();
	}

	//Creates array list with numbers from 1...n
	public void createArrayList(int n) {
		for (int i = 1; i <= n; i++) {
			myArrayList.add(i);
		}
	}

	//Removes all primes inside array list
	public void removePrimes() {
		Primes p = new Primes();
		myArrayList.removeAll(p.checkForPrimes(myArrayList));
	}

	//Sums the even and odd numbers
	public void sumEvenOdd() {
		for (Integer i : myArrayList) {
			if ((i % 2) == 0) {
				even += i;
			} else {
				odd += i;
			}
		}
	}

	//Getters
	public ArrayList<Integer> getMyArrayList() {
		return myArrayList;
	}
	public int getEven() {
		return even;
	}
	public int getOdd() {
		return odd;
	}

	//Setters
	public void setOdd(int odd) {
		this.odd = odd;
	}
	
	public void setEven(int even) {
		this.even = even;
	}
	public void setMyArrayList(ArrayList<Integer> myArrayList) {
		this.myArrayList = myArrayList;
	}
	
}
