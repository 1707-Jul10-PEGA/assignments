package com.dpq17.driver;

import java.util.Scanner;

public class InterestCalc {
	
	private Scanner scan;
	private double interest;
	private double principal;
	private double rate;
	private double time;

	public InterestCalc() {
		scan = new Scanner(System.in);
		System.out.println("Input principal now");
		this.setPrincipal(scan.nextDouble());
		System.out.println("Thank you, now input the interest rate");
		this.setRate(scan.nextDouble());
		System.out.println("Thank you, now input the duration in years");
		this.setTime(scan.nextDouble());
		this.calc();
		System.out.println("Thank you, your interest is: ");
		System.out.println(this.getInterest());
	}
	
	public Scanner getScan() {
		return scan;
	}

	public void setScan(Scanner scan) {
		this.scan = scan;
	}

	public double getInterest() {
		return interest;
	}

	public void setInterest(double interest) {
		this.interest = interest;
	}

	public double getPrincipal() {
		return principal;
	}

	public void setPrincipal(double principal) {
		this.principal = principal;
	}

	public double getRate() {
		return rate;
	}

	public void setRate(double rate) {
		this.rate = rate;
	}

	public double getTime() {
		return time;
	}

	public void setTime(double time) {
		this.time = time;
	}

	public void calc() {
		double prod = this.getPrincipal() * this.getRate() * this.getTime();
		this.setInterest(prod);
	}
	
	public static void main(String[] args) {
		InterestCalc ic = new InterestCalc();
	}

}
