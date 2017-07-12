//Carson Stephens
//07-11-2017

package com.cts.q16;

public class Driver
{
	public static void main(String[] args)
	{
		System.out.println("Q16");
		
		//For all strings in the args[] array
		for (String s: args)
		{
			//Find and return their lengths
			System.out.println("Length of \"" + s + "\": " + s.length());
		}
	}
}