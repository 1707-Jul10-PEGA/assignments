package com.as.q11.floats;

/*
 * Class to hold the two floats to be accessed
 */
public class FloatsHolder {

	//the first float number
	private float float1;
	
	//the second float number
	private float float2;
	
	/*
	 * assigns the floats default values
	 */
	public FloatsHolder() {
		setFloat1(1.0f);
		setFloat2(2.0f);
	}
	
	/*
	 * getter for the first float number
	 */
	public float getFloat1() {
		return float1;
	}
	
	/*
	 * getter for the second float number
	 */
	public float getFloat2() {
		return float2;
	}
	
	/*
	 * setter for the first float number
	 */
	public void setFloat1(float f) {
		float1 = f;
	}
	
	/*
	 * setter for the second float number
	 */
	public void setFloat2(float f) {
		float2 = f;
	}
}
