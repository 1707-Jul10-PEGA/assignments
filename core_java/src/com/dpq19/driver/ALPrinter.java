package com.dpq19.driver;

import java.util.ArrayList;
import java.util.Iterator;

public class ALPrinter {
	
	private ArrayList<Integer> ia;

	public ALPrinter() {
		ia = new ArrayList<Integer>();
		for (int x = 1; x <= 10; x++) {
			this.ia.add(x);
		}
		this.toString();
		this.sumEven();
		this.sumOdd();
		this.noPrimes();
	}
	
	public void sumEven() {
		int sum = 0;
		for (int x: this.ia) {
			if(x % 2 == 0) {
				sum += x;
			}
		}
		System.out.println(sum);
	}
	
	public void sumOdd() {
		int sum = 0;
		for (int x: this.ia) {
			if(x % 2 == 1) {
				sum += x;
			}
		}
		System.out.println(sum);
	}
	
	public void noPrimes() {
		Iterator<Integer> i = ia.iterator();
		while (i.hasNext()) {
			int x = i.next();
			if(x < 4) {
				i.remove();
			}
			else if(x % 2 == 0) {
			}
			else {
				boolean r = true;
				for(int x1 = 3; x1 < x; x1++) {
					if (x % x1 == 0) {
						r = false;
					}
				}
				if (r) {
					i.remove();
				}
			}
		}
		System.out.println(this.toString());
	}

	@Override
	public String toString() {
		return this.ia.toString();
	}
	
	public static void main(String[] args) {
		ALPrinter alp = new ALPrinter();
	}
}
