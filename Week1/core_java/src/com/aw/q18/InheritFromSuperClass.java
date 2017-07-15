package com.aw.q18;

public class InheritFromSuperClass 
{
	
	public static void main(String[]args) 
	{
		
		InsideAbstract q = new InsideAbstract();
		//System.out.println(q.upperCaseCheck("az"));
		//System.out.println("UpperCase Check using AZ: " + q.upperCaseCheck("AZ"));
		System.out.println("UpperCase Check using @[: " + q.upperCaseCheck("@["));
		System.out.println("UpperCase Check using AZ: " + q.upperCaseCheck("AZ"));
		System.out.println("UpperCase Check using all lower case: " + q.upperCaseCheck("all lower case"));
		System.out.print(" Check using abc: ");
		q.plusTen("abc");
		System.out.print("Plus Check using 100: ");
		q.plusTen("100"); 
	}
}
