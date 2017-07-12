//Carson Stephens
//07-11-2017

package com.cts.q11;

//Import the file from the external package
import com.cts.q11b.Ext;

public class Driver
{
	public static void main(String[] args)
	{
		System.out.println("Q11");
		
		//Initialize the external class for an example
		Ext example = new Ext(5, 2);
		
		//Print the example's values
		System.out.println("Imported Class");
		System.out.println(example.getX() + ", " + example.getY());
	}
}