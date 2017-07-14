package com.dv.q15;


public class Calculator<T extends Number> implements CalculatorInterface<T> {

	@Override
	public T add(T a, T b) {
		
		// using doubles for better precision
		Number ret = a.doubleValue() + b.doubleValue();
		
		if(!(a instanceof Double) && !(a instanceof Float)) {
			ret = Math.floor(ret.doubleValue());
			ret = Math.round(ret.doubleValue());
		}

		return (T) ret;
	}
	
	@Override
	public T subtract(T a, T b) {
		Number ret = a.doubleValue() - b.doubleValue();

		if(!(a instanceof Double) && !(a instanceof Float)) {
			ret = Math.floor(ret.doubleValue());
			ret = Math.round(ret.doubleValue());
		}

		return (T) ret;
	}
	
	@Override
	public T multiply(T a, T b) {
		Number ret = a.doubleValue() * b.doubleValue();

		if(!(a instanceof Double) && !(a instanceof Float)) {
			ret = Math.floor(ret.doubleValue());
			ret = Math.round(ret.doubleValue());
		}

		return (T) ret;
	}

	@Override
	public T divide(T a, T b) {
		Number ret = a.doubleValue() / b.doubleValue();

		if(!(a instanceof Double) && !(a instanceof Float)) {
			ret = Math.floor(ret.doubleValue());
			ret = Math.round(ret.doubleValue());
		}

		return (T) ret;
	}

}
