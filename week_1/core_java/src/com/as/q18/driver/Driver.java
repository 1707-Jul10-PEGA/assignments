package com.as.q18.driver;

import com.as.q18.concreteclass.MyConcreteClass;

public class Driver {
	public static void main(String[] args) {
		MyConcreteClass mc = new MyConcreteClass();
		String str1 = "anUpperCaseString";
		String str2 = "alowercasestring";
		String str3 = "42";
		System.out.println(mc.checkForUpper(str1));
		System.out.println(mc.checkForUpper(str2));
		System.out.println(mc.convertToLower(str1));
		mc.convertToInt(str3);
	}
}
