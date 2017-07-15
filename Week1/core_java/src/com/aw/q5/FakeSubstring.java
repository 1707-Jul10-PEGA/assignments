package com.aw.q5;

public class FakeSubstring {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str = new String();
		int idx = 3;
		str = "Hello";
		//substringer(str, idx);
		System.out.println(substringer(str,idx));
		
	}
	
	public static String substringer(String stringInput, int indexEnd){
		
		String target = "";
		
		for (int x = 0; x <indexEnd; x++)
		{
			target = target + stringInput.charAt(x);
		//	System.out.print(stringInput.charAt(x));
		}
		return target;
		//Read up on return later
		
	}
}
