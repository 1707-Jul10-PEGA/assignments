package com.revature.ddh.question9;
import java.util.ArrayList;

public class Question9 {


	public static void main(String[] args) {
		ArrayList <Integer>  arr = new ArrayList<Integer>();
		for(int i = 0; i <=100; i++) {
			arr.add(i);
		}

		for(int k: arr) {
			Prime(k);
		}
	}

	public static int  Prime(int n) {

		if( n % 2 == 0) {
			//System.out.println("Prime it is not");
		}
		else {
			for(int i = 3; i < n; i+=2) {
				//System.out.println(j);
				System.out.println("Prime number " + n);

			}
		}
		return n ;


	}

}
