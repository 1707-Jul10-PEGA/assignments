package q3ReverseString;

import java.util.Scanner;

public class ReverseString {
	public static String reverseString(String sIn)
	{
		if(sIn.length() == 0)
		{
			return "";
		}
		else
		{
			
			return sIn.charAt(sIn.length() - 1) + reverseString(sIn.substring(0, sIn.length() - 1));
		}
	}
	public static void main(String[] args)
	{
		System.out.println("Hello! I'm going to reverse a word for you. Please input a string");
		System.out.print(": ");
		Scanner sIn = new Scanner(System.in);
		String chaCha = sIn.nextLine();
		String done = reverseString(chaCha);
		System.out.println("Thank you! Here is your reversed string: " + done);
		sIn.close();
	}
}
