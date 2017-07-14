package com.MS.Q3.driver;

public class ReverseString {
	
	
	/*
	 * Reverso works by taking in a string and converting that to a character array.
	 * It then switches the first and last character in the array (without a placeholder)
	 * and works inward towards the center. When the begin and end variables meet (or pass)
	 * in the middle, the function stops and sends the reversed character array as a string.
	 */
	public String Reverso(String in)
	{
		char[] work = in.toCharArray();
		int begin = 0;
		int end = in.length() - 1;
		while(begin < end)
		{
			
			work[begin] = (char)((int) work[begin] + (int) work[end]);
			work[end] = (char)((int) work[begin] - (int) work[end]);
			work[begin] = (char)((int) work[begin] - (int) work[end]);
			
			begin++;
			end--;
		}
		return new String(work);
	}

	/*
	 * The main method creates a new ReverseString object first, then it takes an
	 * example string and runs it through the .Reverso function. Finally, it spits
	 * out the reversed string.
	 */
	
	public static void main(String[] args) {
		
		ReverseString Example = new ReverseString();
		String input = "Example Text";
		System.out.println("Your inputted text was: " + input);
		input = Example.Reverso(input);
		System.out.println("Your reversed text is: " + input);

		
	}

}
