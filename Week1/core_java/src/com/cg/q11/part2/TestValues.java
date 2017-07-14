package com.cg.q11.part2;

import com.cg.q11.part1.FloatValues;

public class TestValues {
	public static void main(String[] args) {
		
		//Access a class from a different package, requires improvements
		FloatValues floatValues = new FloatValues();
		
		//Test getters from class floatvalues
		System.out.println(floatValues.getF1());
		System.out.println(floatValues.getF2());
	}
}
