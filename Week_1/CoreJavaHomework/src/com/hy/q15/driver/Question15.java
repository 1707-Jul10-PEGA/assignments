package com.hy.q15.driver;

public class Question15 <T extends Number>implements InterfaceMath {

	@Override
	public T addition(Number a, Number b) {
		Number ret = a.doubleValue() + b.doubleValue();
		
		if(!(a instanceof Double) && !(a instanceof Float)){
			
			ret = Math.floor(ret.doubleValue());
			ret = Math.round(ret.doubleValue());
			
		}
		
		return (T) ret;
	}

	@Override
	public T subtraction(Number a, Number b) {
		Number ret = a.doubleValue() - b.doubleValue();
		
		if(!(a instanceof Double) && !(a instanceof Float)){
			
			ret = Math.floor(ret.doubleValue());
			ret = Math.round(ret.doubleValue());
			
		}
		
		return (T) ret;
	}

	@Override
	public T multiplication(Number a, Number b) {
		Number ret = a.doubleValue() * b.doubleValue();
		
		if(!(a instanceof Double) && !(a instanceof Float)){
			
			ret = Math.floor(ret.doubleValue());
			ret = Math.round(ret.doubleValue());
			
		}
		
		return (T) ret;
	}

	@Override
	public T division(Number a, Number b) {
		Number ret = a.doubleValue() / b.doubleValue();
		
		if(!(a instanceof Double) && !(a instanceof Float)){
			
			ret = Math.floor(ret.doubleValue());
			ret = Math.round(ret.doubleValue());
			
		}
		
		return (T) ret;
	}

}
