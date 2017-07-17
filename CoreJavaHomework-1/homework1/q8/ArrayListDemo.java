package q8;

import java.util.ArrayList;

public class ArrayListDemo {

	public static void main(String[] args) {
		
		ArrayList<String> total = new ArrayList<String>();
		ArrayList<String> palindromes = new ArrayList<String>();
		
		total.add("karan");
		total.add("madam");
		total.add("tom");
		total.add("civic");
		total.add("radar");
		total.add("sexes");
		total.add("jimmy");
		total.add("kayak");
		total.add("john");
		total.add("refer");
		total.add("billy");
		total.add("did");
		
		for(String s : total) {
			if (isPalindrome(s)) {
				palindromes.add(s);
			}
			
		}
		for(String s : palindromes) {
			System.out.println(s);
		}

		
	}
	
	public static boolean isPalindrome(String s) {
		int length = s.length();
		for (int i = 0; i < (length/2); ++i) {
			if(s.charAt(i) != s.charAt(length - i -1)) {
				return false;
			}
		}
		return true;
	}
	
}