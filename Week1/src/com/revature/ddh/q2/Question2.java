package com.revature.ddh.q2;

import java.util.ArrayList;

public class Question2 {
	static int stop = 0;
	static int[] arr;
	public static void main(String[] args) {
		int x = 100;
		fibo(x);
	}


	public static int fibo(int n) {
		//n = 5;
		stop++;
		int arr[];
		String done = "First 25 complete";
		if (stop > 25) {
			//System.out.println("done");
			return n;
		}

		if (n == 1) {
			return 1;

		}

		else if(n == 0) {
			return 0;
		}
		else {		
		int	y = n-1;
		int x = n-2;	
			System.out.println(y + " " + x);
			return fibo(n-1) + fibo(n-2);
		}


	}


}
