package com.EC.q2;

public class Fibonacii {

	public static void printFibonacci(int x) {
		//seed values F(0)=0 and F(1)=1
		int n0 = 0;
		int n1 = 1;
		System.out.print(n0+" "+n1);
		for(int i = 2; i <= x; i++){
			//F(n) = F(n-1)+F(n-2)
			int n3 = n1+n0;
			System.out.print(" "+n3);
			n0=n1;
			n1=n3;
		}
		System.out.println();
	}
}
