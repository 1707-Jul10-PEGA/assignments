package com.aw.q2;

public class Fibonacci {
	 
	public static void main(String[] args) {
{
			int fibonacciNumbers, i = 0, firstValue = 0, secondValue = 1, Next;
			fibonacciNumbers = 25;  // Place the number of fibonacci numbers you want
			while(i < fibonacciNumbers)  { //i will keep c
				if(i <= 1) {
					Next = i; 
				}
				else  {
	                Next = firstValue + secondValue;
	                firstValue = secondValue;
	                secondValue = Next;
				}
				System.out.println(Next);
				i++;
			}
		}
}
}
//Explaining my code
//i is initially 0 
//next references i
//everything is 0 so it skips past the else and then the output is initialized as 0
//the i++ at the end sets the value to 1 but the value is still <= 1 so it gets printed out again which then recycles it back up
//the value is now 2 which is greater than 1 which causes everything to get skipped to else where next is converted to the sum of first and second which is then 