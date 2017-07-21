package com.dpq2.driver;

public class Fibonacci {
	
	private int[] sequence;
	
	private int limit;
	
	public Fibonacci() {
		this.limit = 25;		//didn't use the setters here, but it should be fine
		this.sequence = new int[limit];
		this.maths();
	}
	
	public Fibonacci(int in) {
		this.limit = in;
		this.sequence = new int[limit];
		this.maths();
	}
	
	public int[] getSequence() {		//getters and setters
		return sequence;
	}

	public void setSequence(int[] sequence) {
		this.sequence = sequence;
	}

	public int getLimit() {
		return limit;
	}

	public void setLimit(int limit) {
		this.limit = limit;
	}

	public void maths() {		//it does math and the British have the most delightful ways of saying things
		if (this.getLimit() < 1) {		//gotta cover those edge cases
			this.setSequence(null);
		}
		else if (this.getLimit() == 1) {
			this.getSequence()[0] = 0;
		}
		else if (this.getLimit() == 2) {
			this.getSequence()[0] = 0;
			this.getSequence()[1] = 1;
		}
		else {
			this.getSequence()[0] = 0;
			this.getSequence()[1] = 1;
			for(int x = 2; x < this.getLimit(); x++) {
				this.getSequence()[x] = this.getSequence()[x-1] + this.getSequence()[x-2];
			}
		}
	}
	
	@Override
	public String toString() {
		String out = new String("");
		for(int x = 0; x < this.getLimit(); x++) {
			out += this.getSequence()[x] + ", ";
		}
		return out;
	}
	
	public static void main(String[] args) {
		Fibonacci fibber = new Fibonacci(25);
		System.out.println(fibber.toString());
	}
}
