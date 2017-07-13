package com.wh.q8;

import java.util.ArrayList;

public class Q8 {
	public static void main(String[] args){
		ArrayList<String> wordList = new ArrayList<String>(10);
		wordList.add("karan");
		wordList.add("madam");
		wordList.add("tom");
		wordList.add("civic");
		wordList.add("radar");
		wordList.add("sexes");
		wordList.add("jimmy");
		wordList.add("kayak");
		wordList.add("john");
		wordList.add("refer");
		wordList.add("billy");
		wordList.add("did");
		StringBuilder sb;
		ArrayList<String> palindromes = new ArrayList<String>(10);
		for(String s: wordList){
			sb = new StringBuilder(s);
			if(s.equals(sb.reverse().toString())){
				palindromes.add(s);
			}
		}
		
		System.out.println("WordList: "+ wordList);
		System.out.println("Palindromes: "+ palindromes);
	}
}
