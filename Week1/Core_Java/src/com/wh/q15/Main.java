package com.wh.q15;

public class Main {
    public static void main(String[] args) {
	Q15b q = new Q15b();
	System.out.println("Adding 4 and 10 using + : " + (4 + 10));
	System.out.println("Adding 4 and 10 using q.addition : " + q.addition(4, 10));
	System.out.println("Subtracting 4 and 10 using + : " + (4 - 10));
	System.out.println("Subtracting 4 and 10 using q.subtraction : " + q.subtraction(4, 10));
    }
}
