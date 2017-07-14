package com.aq.q15.driver;

public interface Calculator <T extends Number>{
	public T add(T a, T b);
	public T sub(T a, T b);
	public T mul(T a, T b);
	public T div(T a, T b);
}
