package com.EC.q19;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import com.EC.q9.Q9;

public class Q19 {

	public static void main(String[] args) {
		List<Integer> list = new ArrayList<Integer>();
		for (int i = 1; i <= 10; i++) {
			list.add(i);
		}
		System.out.println("Current elements in list: " + list);
		System.out.println("Add all the even numbers between 1-10: " + addEvenNumbers(list));
		System.out.println("Add all the odd numbers between 1-10: " + addOddNumbers(list));
		deletePrimeNumbers(list);
		System.out.println("Delete all prime numbers between 1-10: " + list);
	}

	public static int addEvenNumbers(List<Integer> list) {
		int tmp = 0;
		for (int i : list) {
			if (isEven(i)) {
				tmp += i;
			}
		}
		return tmp;
	}

	public static int addOddNumbers(List<Integer> list) {
		int tmp = 0;
		for (int i : list) {
			if (!isEven(i)) {
				tmp += i;
			}
		}
		return tmp;
	}

	public static void deletePrimeNumbers(List<Integer> list){
		Iterator<Integer> primeIterator = list.iterator();
		while(primeIterator.hasNext()){
			int tmp = primeIterator.next();
			if(Q9.isPrime(tmp)){
				primeIterator.remove();
			}
		}
	}

	public static boolean isEven(int x) {
		if (x % 2 == 0) {
			return true;
		} else {
			return false;
		}
	}

}
