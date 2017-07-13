package com.wh.q18;

public class Q18Sub extends Q18{
	
	public Q18Sub(){}

	@Override
	public boolean hasUpperCase(String str) {
		char[] cArr = str.toCharArray();
		for(char c : cArr){
			if(65 <= c && c <= 90){
				return true;
			}
		}
		return false;
	}

	@Override
	public String toUpperCase(String str) {
		return str.toUpperCase();
	}

	@Override
	public void toIntAddTen(String str) {
		try{
			Integer i = new Integer(str);
			System.out.println(i+10);
		}catch(NumberFormatException e){
			System.out.println("String is not an Integer");
			//e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		Q18Sub q = new Q18Sub();
		System.out.println("hasUpperCase Check using @[: "+q.hasUpperCase("@["));
		System.out.println("hasUpperCase Check using AZ: "+q.hasUpperCase("AZ"));
		System.out.println("toUpperCase Check using all lower case: "+q.toUpperCase("all lower case"));
		System.out.print("toIntegerAddTen Check using abc: ");
		q.toIntAddTen("abc");
		System.out.print("toIntegerAddTen Check using 100: ");
		q.toIntAddTen("100");
		
	}
	
}
