package com.MS.Q13.driver;

public class Pyramid {

	public static void main(String[] args) {
		boolean displaynum = false;
		int countnum = 1;
		for(int i = 1;i < 5; i++)
		{
			countnum = i;
			while(countnum>0)
			{
				System.out.print(displaynum ? 1 + " ": 0 + " ");
				displaynum = !displaynum;
				countnum--;
			}
			System.out.println("\n");
				
		}

	}

}