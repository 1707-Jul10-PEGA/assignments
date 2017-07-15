package com.aw.q9;

import java.util.ArrayList;

public class StorePrime {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Integer>numbers = new ArrayList<Integer> ();
		for (int x = 2; x < 101; x++) { //START AT 2 CAUSE 1 IS NOT PRIME
		    numbers.add(x); //Using a loop is a better idea than individually putting each one in
		    }
		for (int x : numbers)
			{	
			boolean prime = true;
			for (int y = 1; y <= x; y++) //This will divide x by an increasing amount of numbers
				{
				if (x % y == 0 && (y != 1) && (x != y)) //if the number has no remainder, that implies numbers can divide in easily
					{
				//	if () // if one of the factors is not equal to 1 (which hints that it may be it's own value) but by making it so that the condition also includes x not being able to be equal to y it prints out the that the number has to be composite
					//	{
						prime = false;
				//		}
					}
				}
			if (prime)
			{
				System.out.println(x);
			}
		}
	}
}

//x
//}