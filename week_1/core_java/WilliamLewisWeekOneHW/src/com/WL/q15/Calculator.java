package com.WL.q15;


//Stolen from our classwork, basic generic calculator
public class Calculator <T extends Number> implements CalculatorInterface<T>{
	
	public T add(T a, T b)
	{
		Number ret = a.doubleValue() + b.doubleValue();
		if(!(a instanceof Double) && !(a instanceof Float)){
			ret = Math.floor(ret.doubleValue());
			ret = Math.round(ret.doubleValue());
		}
		return (T) ret;
	}
	public T subtract(T a, T b)
	{
		Number ret = a.doubleValue() - b.doubleValue();
		if(!(a instanceof Double) && !(a instanceof Float)){
			ret = Math.floor(ret.doubleValue());
			ret = Math.round(ret.doubleValue());
		}
		return (T) ret;
	}
	public T multiply(T a, T b)
	{
		Number ret = a.doubleValue() * b.doubleValue();
		if(!(a instanceof Double) && !(a instanceof Float)){
			ret = Math.floor(ret.doubleValue());
			ret = Math.round(ret.doubleValue());
		}
		return (T) ret;
	}
	public T divide(T a, T b)
	{
		Number ret = a.doubleValue() / b.doubleValue();
		if(!(a instanceof Double) && !(a instanceof Float)){
			ret = Math.floor(ret.doubleValue());
			ret = Math.round(ret.doubleValue());
		}
		return (T) ret;
	}

}
