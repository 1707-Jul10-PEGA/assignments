package com.dpq18.driver;

import java.util.ArrayList;

public class ActualCap extends AbstractCap {
	
	private String s;

	public ActualCap() {
		this.setS("Captain America");
	}
	
	public ActualCap(String in) {
		this.setS(in);
	}

	public String getS() {
		return s;
	}

	public void setS(String s) {
		this.s = s;
	}

	@Override
	public boolean capCheck() {
		for(int x = 0; x < this.getS().length(); x++) {
			if (Character.isUpperCase(this.getS().charAt(x))) {
				return true;
			}
		}
		return false;
	}

	@Override
	public String capAll() {
		ArrayList<Character> temp = new ArrayList<Character>();
		for(int x = 0; x < this.getS().length(); x++) {
			if (Character.isLowerCase(this.getS().charAt(x))) {
				temp.add(Character.toUpperCase(this.getS().charAt(x)));
			}
			else {
				temp.add(this.getS().charAt(x));
			}
		}
		String out = "";
		for (Character c: temp) {
			out += c;
		}
		return out;
	}

	@Override
	public void intUp() {
		Integer out = new Integer(this.getS());
		out += 10;
		System.out.println("" + out);
	}

	public static void main(String[] args) {
		ActualCap ac = new ActualCap();
		System.out.println(ac.capCheck());
		System.out.println(ac.capAll());
		ac.setS("15");
		ac.intUp();
	}

}
