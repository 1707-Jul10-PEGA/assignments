package com.rb.q8.driver;

import java.util.ArrayList;

public class Palindrome {

	ArrayList<String> list;
	ArrayList<String> output;
	
	public static void main(String args[]) {
		// TODO Auto-generated method stub
		
		Palindrome p = new Palindrome();
		p.find();
		
	}
	
	public Palindrome(){
		list = new ArrayList<String>();
		output = new ArrayList<String>();
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
	}
	
	private void find(){
		for(String check : list){
			StringBuffer reverse = new StringBuffer(check);
			reverse = reverse.reverse();
			if(check.equals(reverse.toString())){
				output.add(check);
			}
		}
		
		System.out.println(output);
		
	}
	
}
