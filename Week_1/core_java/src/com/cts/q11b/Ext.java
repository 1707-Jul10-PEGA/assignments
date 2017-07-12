//Carson Stephens
//07-11-2017

package com.cts.q11b;

//Class to be imported externally
public class Ext
{
	//Two float variables to be accessed
	private float x;
	private float y;
	
	//Constructor
	public Ext(float x, float y)
	{
		this.setX(x);
		this.setY(y);
	}

	//Access x value
	public float getX() {
		return x;
	}

	//Change x value
	public void setX(float x) {
		this.x = x;
	}
	
	//Access y value
	public float getY() {
		return y;
	}

	//Change y value
	public void setY(float y) {
		this.y = y;
	}
}