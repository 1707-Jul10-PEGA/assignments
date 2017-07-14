package com.nc.q13;

public class Q13 {
	public static void main(String[] args) {
		//To print out either 0 or 1
		int flag = 0;
		//For new line
		for(int x = 1; x <= 4; x++)
		{
			//The number of 1s or 0s equal to the row number
			for(int y = 1; y <= x; y++)
			{
				//Alternate between zero and one to print
				if(flag == 0)
				{
					System.out.print(flag);
					flag = 1;
				}
				else
				{
					System.out.print(flag);
					flag = 0;
				}
			}
			//When it is done printing 1s or 0s, then it will print a new line
			System.out.print("\n");
		}
	}
}
