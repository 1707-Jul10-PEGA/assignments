package com.dpq5.driver;

//Ready for some Warhammer references?

public class Choppa {
	
	private int idx;	//boring variable names, but the assignment was specific
	private String str;
	
	public Choppa() {
		this.setIdx(7);		//this should turn the orcish battlecry into a crying sound
		this.setStr("Waaaaaaaaaagh");
		this.hackett();		//let's just do all the work at once
	}
	
	public Choppa(int n, String in) {	//in case you want to set your own inputs
		this.setIdx(n);
		this.setStr(in);
		this.hackett();
	}

	public int getIdx() {		//getters and setters
		return idx;
	}

	public void setIdx(int idx) {
		this.idx = idx;
	}

	public String getStr() {
		return str;
	}

	public void setStr(String str) {
		this.str = str;
	}
	
	public void hackett() {		//Oops, stray Mass Effect reference
		String holdThisPlease = "";		//temp String so we don't butcher str until we've taken all we want from it
		for (int x = 0; x < this.getIdx(); x++) {
			holdThisPlease += this.getStr().charAt(x);	//we're going to build our subString us a character at a time
		}
		this.setStr(holdThisPlease);
	}
	
	public static void main(String[] args) {
		Choppa bigun = new Choppa();	//just put your inputs in those parentheses if you want
		System.out.println(bigun.getStr());
	}

}
