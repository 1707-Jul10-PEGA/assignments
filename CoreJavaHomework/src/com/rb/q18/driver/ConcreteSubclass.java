package com.rb.q18.driver;

import java.util.Scanner;

public class ConcreteSubclass implements AbstractSuperclass {

	String string;
	
	public ConcreteSubclass(){
		super();
	}
	
	@Override
	public boolean checkUpper(String str) {
		// TODO Auto-generated method stub
		
		for(int i = 0; i<str.length(); i++){
			if(str.charAt(i) >=65 && str.charAt(i) <= 90){
				return true;
			}
		}
		
		return false;
	}

	@Override
	public String makeUpper(String str) {
		// TODO Auto-generated method stub
		String newString = str.toUpperCase();
		return newString;
	}

	@Override
	public void consolePrint(String str) {
		// TODO Auto-generated method stub
		
		int i = 0;
		
		boolean print = true;
		
		try (Scanner scan = new Scanner(str)){
			i = scan.nextInt();
		}catch(Exception e){
			System.out.println("No Integer");
			print = false;
		}
		
		if(print){
			i += 10;
			
			System.out.println(i);
		}
	}
}
