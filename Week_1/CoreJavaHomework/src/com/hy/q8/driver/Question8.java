package com.hy.q8.driver;

import java.util.ArrayList;

//Program that saves all palindrome into an Arraylist
public class Question8 {
	public ArrayList<String> palindrome(ArrayList<String> list){
		ArrayList<String> res = new ArrayList<String>();
		for(String s: list){
			int j = s.length()-1;
			int i = 0;
			boolean isPalindrome = true;
			while(isPalindrome && i < j){
				if(s.charAt(i) != s.charAt(j)){
					isPalindrome = false;
				}
				i++;
				j--;
			}
			if(isPalindrome){
				res.add(s);
			}
		}
		return res;
	}
	
	public static void main(String[] args) {
		ArrayList<String> list = new ArrayList<String>();
		list.add("karan");
		list.add("madam");
		list.add("tom");
		list.add("civic");
		list.add("radar");
		list.add("sexes");
		list.add("jimmy");
		list.add("kayak");
		list.add("john");
		list.add("refer");
		list.add("billy");
		list.add("did");
		Question8 q8 = new Question8();
		ArrayList<String> palindrome = q8.palindrome(list);
		
		System.out.print(palindrome);
	}
}
