package com.HL.q8;

import java.util.ArrayList;

public class Question8
{
	public static void main(String[] args)
	{
		ArrayList<String> myList = new ArrayList<>();
		myList.add("karan");
		myList.add("madam");
		myList.add("tom");
		myList.add("civic");
		myList.add("radar");
		myList.add("sexes");
		myList.add("jimmy");
		myList.add("kayak");
		myList.add("john");
		myList.add("refer");
		myList.add("billy");
		myList.add("did");
		ArrayList<String> newList = new ArrayList<>();
		for(int i=0; i<myList.size(); i++)
		{
			if(myList.get(i).equals(new StringBuilder(myList.get(i)).reverse().toString()))
			{
				newList.add(myList.get(i));
			}
		}
		System.out.println("My list:");
		System.out.println(myList);
		System.out.println("My palindromes list:");
		System.out.println(newList);
	}
}
