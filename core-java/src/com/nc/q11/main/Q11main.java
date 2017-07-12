package com.nc.q11.main;
import com.nc.q11.support.*;

public class Q11main {
	public static void main(String[] args) {
		Q11support numbers = new Q11support();
		
		System.out.println("This is the first float-variable from another package: " + numbers.getNum1());
		System.out.println("This is the second float-variable from another package: " + numbers.getNum2());
	}
}
