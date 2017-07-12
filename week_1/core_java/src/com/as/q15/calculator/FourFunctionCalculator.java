package com.as.q15.calculator;

public class FourFunctionCalculator<T extends Number> implements Calculator<T>{

	@Override
	public T addition(Number a, Number b) {
		Number ret = a.doubleValue() + b.doubleValue();
		
		if (!(a instanceof Double) || !(a instanceof Float)) {
			ret = Math.floor(ret.doubleValue());
			ret = Math.round(ret.doubleValue());
		}
		
		return (T) ret;
	}

	@Override
	public T subtraction(Number a, Number b) {
		Number ret = a.doubleValue() - b.doubleValue();
		
		if (!(a instanceof Double) || !(a instanceof Float)) {
			ret = Math.floor(ret.doubleValue());
			ret = Math.round(ret.doubleValue());
		}
		
		return (T) ret;
	}

	@Override
	public T multiplication(Number a, Number b) {
		Number ret = a.doubleValue() * b.doubleValue();
		
		if (!(a instanceof Double) || !(a instanceof Float)) {
			ret = Math.floor(ret.doubleValue());
			ret = Math.round(ret.doubleValue());
		}
		
		return (T) ret;
	}

	@Override
	public T division(Number a, Number b) {
		if (b.doubleValue() == 0.0) {
			return null;
		}
		Number ret = a.doubleValue() / b.doubleValue();
		
		if (!(a instanceof Double) || !(a instanceof Float)) {
			ret = Math.floor(ret.doubleValue());
			ret = Math.round(ret.doubleValue());
		}
		
		return (T) ret;
	}

	

}
