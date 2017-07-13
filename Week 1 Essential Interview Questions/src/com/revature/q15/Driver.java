package com.revature.q15;

public class Driver {
	public static void main(String[] args) {
		ImplementTest i = new ImplementTest();
		int addRes = (int)i.add(123, 234);
		int subRes = (int)i.sub(12, 354);
		int divRes = (int)i.div(1441, 253);
		int multRes = (int)i.mult(12, 31);
		
		System.out.print("Sum: " + addRes + "\nDifference: " + subRes + "\nQuotient: " + divRes + "\nProduct: " + multRes);
	}
}
