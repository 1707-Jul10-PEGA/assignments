package com.revature.ddh.q8;

import java.util.ArrayList;


public class Question8 {

	
	public static void main(String[] args) {
		
		
		
		
		String one = "karan";
		String two = "madam";
		String three = "tom";
		String four = "civic";
		String five = "radar";
		String six = "sexes";
		String seven ="jimmy";
		String eight ="kayak";
		String nine ="john";
		String ten ="refer";
		String eleven ="billy";
		String twelve ="did";
		
	
		ArrayList<String> arr = new ArrayList<String> ();
		arr.add(one);
		arr.add(two);
		arr.add(three);
		arr.add(four);
		arr.add(five);
		arr.add(six);
		arr.add(seven);
		arr.add(eight);
		arr.add(nine);
		arr.add(ten);
		arr.add(eleven);
		arr.add(twelve);

		
		ArrayList<String> ans = new ArrayList<String>();
		
		
		ans.add(palidroneSearch(one, arr));
		ans.add(palidroneSearch(two,arr));
		ans.add(palidroneSearch(three,arr));
		ans.add(palidroneSearch(four,arr));
		ans.add(palidroneSearch(five,arr));
		ans.add(palidroneSearch(six,arr));
		ans.add(palidroneSearch(seven,arr));
		ans.add(palidroneSearch(eight,arr));
		ans.add(palidroneSearch(nine,arr));
		ans.add(palidroneSearch(ten,arr));
		ans.add(palidroneSearch(eleven,arr));
		ans.add(palidroneSearch(twelve,arr));
		System.out.println(ans);
		
	}
	
	public static String palidroneSearch(String str, ArrayList<String> arr) {
		StringBuilder palin = new StringBuilder(str);
		ArrayList<String> drones = new ArrayList<String>();
		String x = palin.reverse().toString();
	
		
		palin.reverse();
		if (str.equals(x)) {
		drones.add((palin.toString())); 	
		}
		
		return (drones.toString());
	}
}
