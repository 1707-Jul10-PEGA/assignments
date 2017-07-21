package com.dpq3.driver;

public class StringReversal {
	
	private String reversible;
	
	public StringReversal() {
		this.reversible = "not tacocat";	//because tacocat is a palindrome
	}
	
	public StringReversal(String in) {	//flexible constructor lets you input the string to be reversed
		this.reversible = in;
	}

	public String getReversible() {
		return reversible;
	}

	public void setReversible(String reversible) {
		this.reversible = reversible;
	}
	
	public String flip() {
		int l = this.getReversible().length();
		for (int x = l - 1; x >= 0; x--) {	//walks through the string from the last index
			this.setReversible(this.getReversible() + this.getReversible().charAt(x));		//tacks on the string in reverse a character at a time
		}
		this.setReversible(this.getReversible().substring(l));
		return this.getReversible();
	}
	
	public static void main(String[] args) {
		StringReversal flipper = new StringReversal();
		System.out.println(flipper.flip());
	}
	
}
