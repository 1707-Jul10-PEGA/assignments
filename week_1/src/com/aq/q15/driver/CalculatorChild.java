package com.aq.q15.driver;

public class CalculatorChild implements Calculator{

	public Number add(Number a, Number b) {
		Number ret =  a.doubleValue() + b.doubleValue();
		
		if(!(a instanceof Double) && !(a instanceof Float)) {
			ret = Math.floor(ret.doubleValue());
			ret = Math.round(ret.doubleValue());
		}
		return ret;
	}
	
	

	public Number sub(Number a, Number b) {
		Number ret = a.doubleValue() - b.doubleValue();
		
		if(!(a instanceof Double) && !(a instanceof Float)) {
			ret = Math.floor(ret.doubleValue());
			ret = Math.round(ret.doubleValue());
		}
		
		return ret;
	}

	public Number mul(Number a, Number b) {
		Number ret = a.doubleValue() * b.doubleValue();
		
		if(!(a instanceof Double) && !(a instanceof Float)) {
			ret = Math.floor(ret.doubleValue());
			ret = Math.floor(ret.doubleValue());
		}
		
		return ret;
	}

	public Number div(Number a, Number b) {
		Number ret = a.doubleValue() / b.doubleValue();
		
		if(!(a instanceof Double) && !(a instanceof Float)) {
			ret = Math.floor(ret.doubleValue());
			ret = Math.round(ret.doubleValue());
		}
		
		return ret;
	}

}
