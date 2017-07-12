package com.AF.q8;

import java.util.ArrayList;

public class Q8 {
	public static void main(String[] args) {
		ArrayList<String> data = new ArrayList<String>();
		ArrayList<String> result = new ArrayList<String>();
		
		data.add("karan");
		data.add("madam");
		data.add("tom");
		data.add("civic");
		data.add("radar");
		data.add("sexes");
		data.add("jimmy");
		data.add("kayak");
		data.add("john");
		data.add("refer");
		data.add("billy");
		data.add("did");
		
		for (String s : data) {
			double numOfIteration = Math.ceil((double)s.length())/2;
			for (int i = 0; i < (int)numOfIteration; i++) {
				if (s.charAt(i) != s.charAt(s.length()-1-i)){
					break;
				}
				if (i == (int)numOfIteration || i == (int)numOfIteration-1) {
					result.add(s);
				}
			}
		}
		System.out.println(result);
	}
}
