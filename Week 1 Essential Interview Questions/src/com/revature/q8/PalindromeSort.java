package com.revature.q8;

import java.util.ArrayList;
import java.util.Scanner;

public class PalindromeSort {
	public static void main(String[] args){
		ArrayList<String> myWords = new ArrayList<String>();
		
		System.out.println("Hello! I will sort words into palindromes and non-palindromes. "
				+ "\nPlease enter one word at a time, followed by the return key. When you're finished, enter the word \"end\"\n: ");
		Scanner sIn = new Scanner(System.in);
		String word;
		while(sIn.hasNextLine()){
			word = sIn.nextLine();
			if(word != null){
				
				if(word.equals("end")){
					break;
				}
				
				myWords.add(word);
			
			}
			else{
				break;
			}
		}
		sIn.close();
		
		ArrayList<String> pali = new ArrayList<String>();
		System.out.println("Thanks! Unsorted, here is your list:\n");
		for(int x = 0; x < myWords.size(); x++)
		{
			System.out.print("\"" + myWords.get(x) + "\"  ");
		}
		System.out.println();
		
		System.out.println("Here is the sublist of palindromes:\n");
		for (int x = 0; x < myWords.size(); x++)
		{
			if(isPalindrome(myWords.get(x)) == true)
				{
					pali.add(myWords.get(x));
				}
		}
		for (int x = 0; x  < pali.size(); x++){
			System.out.print("\"" + pali.get(x) + "\" ");
		}

		
	} 
	
	
	
	public static boolean isPalindrome (String input){
		
		StringBuilder mySB = new StringBuilder(input);
		
		String backW = mySB.reverse().toString();
		mySB.reverse();
		
		String forW = mySB.toString();
		
		if(forW.equals(backW)){
			return true;
		}
		else
		{
			return false;
		}
		
		
		
	}
}
