package com.wh.q3;
/**
 * Reverse a string without using a temporary variable.
 *  Do NOT use reverse() in the StringBuffer or the StringBuilder API.
 * @author Wei
 *
 */
public class Q3 {

	private static String myReverse(String args){
		if(args.length() == 0) {
			return "";
		}
		return args.substring(args.length()-1).concat(myReverse(args.substring(0, args.length()-1)));
	}
	
	public static void main(String[] args) {
		System.out.print(myReverse("Temporary"));
	}

}
