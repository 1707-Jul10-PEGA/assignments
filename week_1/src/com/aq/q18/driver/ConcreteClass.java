package com.aq.q18.driver;

public class ConcreteClass extends SuperAbstract {

	ConcreteClass(){
		super();
	}
	
	@Override
	public boolean upperCaseCheck(String s) {
		// TODO Auto-generated method stub
		// 
		for (int i = 0; i < s.length(); i++) {
			Character c = s.charAt(i);
			if ((int)c >= 65 && (int)c <= 90 ) { return true;}
		}
		return false;
	}

	@Override
	String toUpper(String s) {
		// TODO Auto-generated method stub
		String newS ="";
		for (int i = 0; i < s.length(); i++) {
			Character c = s.charAt(i);
			Character newC = Character.toUpperCase(c);
			newS += newC;
		}
		return newS;
	}

	@Override
	void addTen(String s) {
		// TODO Auto-generated method stub
		try {
			Integer i = Integer.valueOf(s);
			System.out.println(i + 10);
		}catch(Error e) {
			System.out.println("You need to enter an int");
		}
	}
	
}
