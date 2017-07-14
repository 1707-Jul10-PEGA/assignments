package com.MS.Q5.driver;

public class StringConcat {
	
	/*
	 * The Concat function takes a String str and an integer idx. It creates an empty stringbuilder
	 * called sb and appends characters from the input string until it counts up to idx. At this
	 * point, it returns the stringbuilder value as a string.
	 */
	public String Concat(String str, int idx)
	{
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<idx;i++)
		{
			sb.append(str.charAt(i));
		}
		return sb.toString();
	}
	//This function posts the string argument, in this case the output substring.
	public void Post(String str)
	{
		System.out.println("Substring is :" + str);
	}
	/*
	 * The main statement sets up and prints the string and the number of characters to be
	 * displayed. It then cuts the string using the Concat function and displays the
	 * new substring using the Post function.
	 * 
	 * If the cut integer is GREATER THAN the initial length of the supplied string, it
	 * throws an OOB exception.
	 */
	public static void main(String[] args) {
		String example = "Three little pigs";
		System.out.println("Original string is: " + example);
		int cut = 10;
		System.out.println("Concat length is :" + cut);
		StringConcat newcut = new StringConcat();
		example = newcut.Concat(example, cut);
		newcut.Post(example);

	}

}
