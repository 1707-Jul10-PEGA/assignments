package com.dpq6.driver;

public class EvenModder {
	
	private int oddish;
	private boolean even = false;
	
	public EvenModder() {	//constructors
		this.setOddish(7);		//it's a good number, okay?
		this.canItEven();
	}
	
	public EvenModder(int evenOdder) {
		this.setOddish(evenOdder);
		this.canItEven();
	}

	public int getOddish() {		//getters and setters
		return oddish;
	}

	public void setOddish(int oddish) {
		this.oddish = oddish;
	}
	
	public boolean isEven() {
		return even;
	}

	public void setEven(boolean even) {
		this.even = even;
	}

	public void canItEven() {
		if(this.getOddish() == 0) {
			//if you put in 0 as the original int we don't want to claim 0 is even
		}
		else {
			String cuttable = "" + this.getOddish();			//first we make our int a String
			String chunk = "";									//then we prepare a container for the final char of our Stringified int
			chunk += cuttable.charAt(cuttable.length() - 1);	//then we cut the final char off into our container
			Integer eger = new Integer(chunk);					//we make the single char String into an Integer
			this.setOddish(eger.intValue());					//then we replace our original int with only its final digit
			if (this.getOddish() == 2 || this.getOddish() == 4 || this.getOddish() == 6 || this.getOddish() == 8 || this.getOddish() == 0) {
				this.setEven(true);		//finally, we compare the last digit to all even single digits (0 stands in for 10)
			}
		}
	}
	
	@Override
	public String toString() {
		String trueFalse = new String("");
		trueFalse += this.isEven();
		return trueFalse;
	}
	
	public static void main(String[] args) {
		EvenModder neverMod1 = new EvenModder();
		EvenModder neverMod2 = new EvenModder(0);
		EvenModder neverMod3 = new EvenModder(4);
		System.out.println(neverMod1.toString());	//should return false false true
		System.out.println(neverMod2.toString());
		System.out.println(neverMod3.toString());
	}
}
