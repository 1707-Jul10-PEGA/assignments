package com.revature.q20;

public class People {
	private String name;
	private String state;
	private int age;
	
	public People(String nameIn,int ageIn, String stateIn){
		//when i used this, com.revature.q7.employee....
		this.name = nameIn;
		this.age = ageIn;
		this.state = stateIn;
	}
	
	public String getName(){
		return name;
	}
	public String getState(){
		return state;
	}
	public int getAge(){
		return age;
	}
}
