package com.EC.q8;

import java.util.ArrayList;
import java.util.List;

public class Q8 {

	public static void main(String[] args) {
		List<String> nonPalList = new ArrayList<String>();
		List<String> palList = new ArrayList<String>();
		nonPalList.add("karan");
		nonPalList.add("madam");
		nonPalList.add("tom");
		nonPalList.add("civic");
		nonPalList.add("radar");
		nonPalList.add("sexes");
		nonPalList.add("jimmy");
		nonPalList.add("kayak");
		nonPalList.add("john");
		nonPalList.add("refer");
		nonPalList.add("billy");
		nonPalList.add("did");
		
		transferPalindrome(nonPalList,palList);
		
		System.out.println(nonPalList);
		System.out.println(palList);

	}

	public static boolean isPalindrome(String x) {
		if (x.length() == 1) {
			return true;
		}
		if (x.length() % 2 == 0) {
			return false;
		} else {
			int position = (x.length() - 1) / 2;
			for (int i = position - 1, j = position + 1; i >= 0 && j <= x.length(); i--, j++) {
				if (x.charAt(i) != x.charAt(j)) {
					return false;
				}
			}
			return true;
		}

	}
	
	public static void transferPalindrome(List<String>donar,List<String>recipient){
		for(String i : donar){
			if(isPalindrome(i)){
				recipient.add(i);
			}
		}
		//remove the palindrome from the donar list 
		donar.removeAll(recipient);
	}
}
