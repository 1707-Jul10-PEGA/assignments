package com.dpq12.driver;

public class EvenPrinter {
	
	int[] intArr;

	public EvenPrinter() {
		int x = 1;
		intArr = new int[100];
		while (x <= 100) {
			intArr[x - 1] = x;
			x++;
		}
	}
	
	public void print() {
		for (int y: intArr) {
			if (y % 2 == 0) {
				System.out.println(y);
			}
		}
	}
	
	public static void main(String[] args) {
		EvenPrinter ep = new EvenPrinter();
		ep.print();
	}

}
