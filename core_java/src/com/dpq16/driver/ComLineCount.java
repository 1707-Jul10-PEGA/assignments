package com.dpq16.driver;

public class ComLineCount {
	
	private int count;

	public ComLineCount() {
		count = 0;
	}
	
	public void count(String in) {
		for (int x = 0; x < in.length(); x++) {
			count++;
		}
	}

	@Override
	public String toString() {
		return "" + this.count;
	}
	
	public static void main(String[] args) {
		ComLineCount clc = new ComLineCount();
		clc.count(args[0]);
		System.out.println(clc.toString());
	}

}
