package com.bank.util;

public class UserInput {
	public boolean inputAge(int age){
		
		if(age < 0){
			return false;
		}
		return true;	
	}
	public boolean inputName(String name){
		if("".equals(name)){
			return false;
		}
		return true;
	}
	public boolean inputShoes(String shoe){
		if("Nike".equalsIgnoreCase(shoe) || "adidas".equals(shoe)){
			return true;
		}
		return false;
	}
}
