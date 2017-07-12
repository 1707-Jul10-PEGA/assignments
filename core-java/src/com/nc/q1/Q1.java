package com.nc.q1;

public class Q1 
{
	public static void main(String[] args) {
		//The list of numbers to bubble sort
		int[] list = {1,0,5,6,3,2,3,7,9,8,4};
		//To hold a number in the array
		int temp = 0;
		//infinite loop because I don't know how many loops the program needs to do
		for(;;)
		{
			//To see if any numbers switched
			int test = 0;
			//To go through all of the numbers
			for(int x = 0; x <= 9; x++)
			{
				//Compares adjacent numbers
				if (list[x] > list[x+1])
				{
					//Switch adjacent numbers
					temp = list[x];
					list[x] = list[x+1];
					list[x+1] = temp;
					test++;
				}
			}
			//If it goes through the loop without switching then it stops the loop
			if(test == 0)
			{
				break;
			}
		}
		//Display results
		for(int z = 0; z <= 10; z++)
		{
			System.out.print(list[z] + ", ");
		}
	}
}