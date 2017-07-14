package com.nc.q18;

public class test {

	public static void main(String[] args) {
		//Display results
		MySubclass bob = new MySubclass();
		
		//1
		System.out.println("Does \"lol\" have uppercase? " + bob.upperCase("lol"));
		System.out.println("Does \"Kingsman\" have uppercase? " + bob.upperCase("Kingsman"));
		//2
		System.out.println(bob.lowerToUpper("Hello My Name Is..."));
		//3
		bob.strToInt("16");
	}

}
