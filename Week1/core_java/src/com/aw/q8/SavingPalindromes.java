package com.aw.q8;
// TRY TO FIX THIS CODE LATER, NOT PARTICULARLY SURE WHY IT DOESN'T WORK THE WAY IT SHOULD
import java.util.ArrayList;
import java.util.Arrays;

public class SavingPalindromes {

	public static void main(String[] args) {

		ArrayList <String> originalStrings = new  ArrayList<String>(); //{"karan","madam","tom","civic","radar","sexes","jimmy", "kayak","john","refer","billy","did"};
		ArrayList <String> secondList = new ArrayList<String>();
		//String[] listOfWords =  {"karan","madam","tom","civic","radar","sexes","jimmy", "kayak","john","refer","billy","did"};
		//System.out.print(Arrays.toString(originalStrings));
		//originalStrings.add(listOfWords.toString());
		//System.out.print(originalStrings.toString());
		originalStrings.add("karan");
		originalStrings.add("madam");
		originalStrings.add("tom");
		originalStrings.add("civic");
		originalStrings.add("radar");
		originalStrings.add("sexes");
		originalStrings.add("jimmy");
		originalStrings.add("kayak");
		originalStrings.add("john");
		originalStrings.add("refer");
		originalStrings.add("billy");
		originalStrings.add("did");
		System.out.println("Original List:	" + originalStrings.toString());
		//System.out.println(originalStrings.get(0));
		//System.out.print(s);
		int temporary;
		String comparison = new String();
		
		
		for (int x = 0; x < originalStrings.size(); x ++){
			StringBuffer comparison1 = new StringBuffer();
			temporary = x;
			comparison = originalStrings.get(temporary);
			//System.out.println(comparison);
			comparison1.append(comparison);
			comparison1.reverse();
			//System.out.println(comparison1);
			{if (comparison1.toString().equals(comparison)){
			secondList.add(originalStrings.get(temporary));// Possibly not adding to string
			//System.out.println("Nice");
			temporary = temporary + 1;
			}
			else {
				temporary = temporary + 1;
				//System.out.println("Not Nice");}  
		}
		
			}
			
	}
		System.out.println("Only Palindromes:	" + secondList.toString());
	}
}








	/*for (int x = 0; x < originalStrings.size(); x++); {
	/*	temporary = 0;
		comparison = originalStrings.get(temporary);
		comparison1.append(comparison);
		comparison1.reverse();
	/*	{if (comparison1.equals(comparison)){
		secondList.add(originalStrings.get(temporary));// Possibly not adding to string
		System.out.println("Nice");
		temporary = temporary + 1;
		}
		else {
			temporary = temporary + 1;
			System.out.println("Not Nice");}  */
	//	System.out.println("Does thing even loop?"); 


//StringBuffer reverse = new StringBuffer();
		/*String comparison = new String();
		StringBuffer comparison1 = new StringBuffer();
		System.out.println(originalStrings.toString());
		//System.out.println(secondList.toString());
		int temporary;
		for (int x = 0; x < originalStrings.size(); x++); {
			temporary = 0;
			comparison = originalStrings.get(temporary);
			comparison1.append(comparison);
			comparison1.reverse();
			//if (comparison1.equals(comparison)){
		//		secondList.add(originalStrings.toString()); // Possibly not adding to string
		//		temporary = temporary + 1;
		//		}
		//	else {
		//		temporary = temporary + 1;
		//	}
			System.out.println(secondList.toString()); */




















		
		
		//if (originalString.get
			//reverse = originalStrings.get(x);
			//if originalStrings.get(x) == originalStrings.toString().
			
	//	}
		//System.out.println(originalStrings);
		//Probably should set a up a for loop to start and end the list
		//During the loop check for even or odd
		//Then inside those loops you something that checks whether or not it's a palindrome
		// If it is a palindrome, add to secondList

