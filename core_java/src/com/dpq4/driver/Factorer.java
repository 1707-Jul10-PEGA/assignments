package com.dpq4.driver;

public class Factorer {
	
	private int num;		//not the most creative naming convention, I know
	
	public Factorer() {
		num = 10;		//nice round number for the default
		this.doit();		//just do it
	}
	
	public Factorer(int in) {
		num = in;
		this.doit();
	}

	public int getNum() {		//getter and setter
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}
	
	public void doit() {
		int labrat = 1;
		for(int x = 1; x <= this.getNum(); x++) {
			labrat *= x;
		}
		this.setNum(labrat);
	}
	
	@Override
	public String toString() {		//I wanted to be able to print it, so I overrode the toString
		String out = new String("");
		out += this.getNum();
		return out;
	}
	
	public static void main(String[] args) {
		Factorer justTheFacts = new Factorer();
		System.out.println(justTheFacts.toString());
	}
}
