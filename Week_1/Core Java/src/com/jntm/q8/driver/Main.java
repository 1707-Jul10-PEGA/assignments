//Jake Maynard
//recognize palindromes, save in an arraylist
package com.jntm.q8.driver;

import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {
		//Take all palindromes from a list.
		
		//Init arraylist
		ArrayList<String> palindromes = new ArrayList<String>();

		//Fill it.
		ArrayList<String> lis = new ArrayList<String>();
		lis.add("karan");
		lis.add("madam");
		lis.add("tom");
		lis.add("civic");
		lis.add("radar");
		lis.add("sexes");
		lis.add("jimmy");
		lis.add("kayak");
		lis.add("john");
		lis.add("refer");
		lis.add("billy");
		lis.add("did");

		
		//Check for palindromes
		for (int x = 0; x < lis.size(); x++) {
			if (isPalindrome(lis.get(x))) {
				palindromes.add(lis.get(x));
			}
		}

		//Output all palindromes
		for (int x = 0; x < palindromes.size(); x++) {
			System.out.println(palindromes.get(x));
		}

	}

	//Check by comparing outermost chars to find a mismatch
	//If there are none, it's a palindrome.
	public static boolean isPalindrome(String str) {

		for(int x=0; x<=str.length()/2;x++){
			if(str.charAt(x)!=str.charAt(str.length()-x-1)){
				return false;
			}
		}
		
		
		return true;
	}
}
