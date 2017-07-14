package com.cg.q11.part1;

public class FloatValues {
	
	//Variables
	private float f1;
	private float f2;
	
	//Constructor
	public FloatValues(){
		 f1 = randomNumber();
		 f2 = randomNumber();
	}
	
	//Getter and setter for float value 1
	public float getF1() {
		return f1;
	}
	public void setF1(float f1) {
		this.f1 = f1;
	}
	
	//Getter and setter for float value 2
	public float getF2() {
		return f2;
	}
	public void setF2(float f2) {
		this.f2 = f2;
	}
	
	//Return a random float value using the Math library
	public float randomNumber (){
		return (float) Math.random();
	}
	
	
}
