package com.MS.Q4.driver;

public class Factorial {

	/*
	 * The doFact function takes a placeholder value (set to 1 initially) and multiplies it
	 * by the inverse of the iteration (meaning it starts at the input integer) and counts down
	 * to 0. To be frank, it could have stopped at i>1, but checks for i>0 are faster.
	 */
	public int doFact(int input)
	{
		int placeholder = 1;
		for(int i = input; i > 0; i--)
		{
			placeholder = placeholder * i;
		}
		return placeholder;
	}
	/*
	 * The main function sets up the number you wish to factorial along with an output integer slot.
	 * It then performs the output and displays both the input number as well as its factorial.
	 */
	public static void main(String[] args) {
		int fact = 5;
		int output;
		Factorial Example = new Factorial();
		output = Example.doFact(fact);
		System.out.println("Your number was: " + fact);
		System.out.println("Its factorial is: " + output);

	}

}
