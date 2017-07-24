package com.HL.q15;

interface Calculator
{
	public double add(double a, double b);
	public double minus(double a, double b);
	public double mult(double a, double b);
	public double div(double a, double b);
}
class MyCal implements Calculator
{
	public double add(double a, double b)
	{
		return a+b;
	}
	public double minus(double a, double b)
	{
		return a-b;
	}
	public double mult(double a, double b)
	{
		return a*b;
	}
	public double div(double a, double b)
	{
		return a/b;
	}

}

