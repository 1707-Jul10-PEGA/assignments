package com.aq.q8.driver;

import java.util.ArrayList;
import java.util.Arrays;

public class PalindromeSort {
	public static void main(String[] args) {
		String[] words = {"karan","madam","tom","civic","radar","sexes","jimmy","kayak","john","refer","billy","did"};
		ArrayList<String> strings = new ArrayList<String>();
		ArrayList<String> palindromes = new ArrayList<String>();
		strings.addAll(Arrays.asList(words));
//		System.out.println(mySort("karan"));
		for (String s: words) {
			if(mySort(s)) {palindromes.add(s);}
		}
		System.out.println(palindromes);
		
		
		//List<String> wordArray = new ArrayList(Collection<? extends String>);
	}
	
	public static boolean mySort(String s) {
		double d = (double) s.length();
		if (d % 2 == 0) {
			for(int i = 0; i < d/2; i++) {
				if (s.charAt(i) != s.charAt(s.length() - 1 - i)) { return false;}
			} 
			return true;
		}
		else {
			for(int i = 0; i < d/2 - 1; i++) {
//				System.out.println(s.charAt(i));
//				System.out.println(s.charAt(s.length() - 1 - i));
				if (s.charAt(i) != s.charAt(s.length() - 1 - i)) { return false;}
			} 
			return true;
			
		}
	}
}
