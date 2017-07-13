package com.WL.q2;

public class QTwo {
	//Display the first 25 Fib numbers starting at 0 and 1.
	
	public static void main(String[] args) {
		int myInt = 25;
		printFib(myInt);
		sassyAnswer(myInt);
	}
	//Assuming we begin with both values as 0.
	public static void sassyAnswer(int length){
		for(int i = 0; i < length+1; i++)
			System.out.print(0 + " ");
	}
	
	//assuming start values are 0, and 1.
	public static void printFib(int i)
	{
		int a = 0;
		int b = 1;
		int count = 0;
		do{
			System.out.print(a + " ");
			int temp = a + b;
			a = b;
			b = temp;
			count++;
		}while(count < i);
		System.out.println(" ");
	}

}
