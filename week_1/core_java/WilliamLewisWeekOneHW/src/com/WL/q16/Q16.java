package com.WL.q16;

import java.io.Console;

public class Q16 {

	public static void main(String [] args) {
		//To count total length in case of multiple strings
		int length = 0;
		//iterate through the array, totaling length and printing individual string length
		for(String x : args)
		{
			length = length + x.length();
			System.out.println("This String is length " + x.length());
		}
		System.out.println("Total String length is " + length);


	}

}
