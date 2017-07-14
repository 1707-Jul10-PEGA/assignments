package com.hy.q18.driver;

public class Question18 extends AbstractClass{

	@Override
	boolean isThereUppercase(String s) {
		for(int i = 0; i < s.length(); i++){
			if(Character.isUpperCase(s.charAt(i))){
				return true;
			}
		}
		return false;
	}

	@Override
	String toUppercaseString(String s) {
		// TODO Auto-generated method stub
		return s.toUpperCase();
	}

	@Override
	int convertStringToInteger(String s) {
		// TODO Auto-generated method stub
		int res = Integer.parseInt(s) + 10;
		System.out.println("Result: " + res);
		return res;
	}

}
