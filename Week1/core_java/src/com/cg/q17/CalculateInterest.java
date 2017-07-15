package com.cg.q17;

import java.util.Scanner;

public class CalculateInterest {

	// Variables
	private double interest;
	private double principal;
	private double rate;
	private int time;
	private Scanner scan;

	/* Constructor, ask user for the required input 
	 * sets the values for principal, rate, and time
	 * Calculate interest
	 */
	public CalculateInterest() {
		scan = new Scanner(System.in);
		principal = getInputDouble("Enter principal:");
		time = getInputInt("Enter life of the loan(years):");
		rate = getInputDouble("Enter rate:");

		interest = principal * time * rate;
		scan.close();
	}

	//Getters: Interest, principal, rate, and time
	public double getInterest() {
		return interest;
	}
	public double getPrincipal() {
		return principal;
	}
	public double getRate() {
		return rate;
	}
	public int getTime() {
		return time;
	}
	
	//Setters: Interest, principal, rate, and time
	public void setInterest(double interest) {
		this.interest = interest;
	}
	public void setPrincipal(double principal) {
		this.principal = principal;
	}
	public void setRate(double rate) {
		this.rate = rate;
	}
	public void setTime(int time) {
		this.time = time;
	}

	/*Uses str paramenter to print it the console
	 * returns the value enter as long as it's a double
	 */
	public Double getInputDouble(String str) {

		try {
			System.out.print(str);
			return Double.parseDouble(scan.nextLine());
		} catch (NumberFormatException e) {
			return getInputDouble(str);
		}

	}

	/*Uses str paramenter to print it the console
	 * returns the value enter as long as it's a int
	 */
	public int getInputInt(String str) {
		try {
			System.out.print(str);
			return Integer.parseInt(scan.nextLine());
		} catch (NumberFormatException e) {
			return getInputInt(str);
		}
	}
}
