package com.wh.q6;
/**
 * Q6. Write a program to determine if an integer is even without using the modulus
 *  operator(%)
 * @author Wei
 *
 */
public class Q6 {

	private static boolean evenCheck(int i){
		if(Integer.lowestOneBit(i)!=1){
			return true;
		}
		return false;
	}
	
	public static void main(String[] args) {
		System.out.println(evenCheck(143));//check odd
		System.out.println(evenCheck(126));//check even
	}

}
