package com.nc.q11.main;
import com.nc.q11.support.*;

public class Q11main {
	public static void main(String[] args) {
		//create object
		Q11support numbers = new Q11support();
		//access data
		System.out.println("This is the first float-variable from another package: " + numbers.getNum1());
		System.out.println("This is the second float-variable from another package: " + numbers.getNum2());
	}
}
