package com.MS.Q1.driver;

public class Bubble {
	
	
	/*The actual bubblesort algorithm. Runs through an array of x integers x times
	 * ordering 2 integers at a time. Uses the temporary variable "swapper" as a 
	 * storage variable.
	 */
	public void BubbleSort(int[] x)
	{
		for(int c = 1; c < x.length; c++)
		{
		for(int i = 1; i < x.length; i++)
			{
				int swapper;
				if(x[i-1] > x[i])
				{
					swapper = x[i-1];
					x[i-1] = x[i];
					x[i] = swapper;
				}
			}
		}
	}
	/*
	 * Displays the selected array on the console in the format of 
	 * "x[0] x[1] x[2]..."
	 */
	public void Display(int[] x)
	{
		for(int i = 0; i < x.length; i++)
		{
			System.out.print(x[i] + " ");
		}
	}
	
	/*
	 * Main function. Simply sets up a new object to perform the functions
	 * and then runs the contained methods.
	 */
	public static void main(String[] args)
	{
		Bubble Q1 = new Bubble();
		
		int[] Sortee = {1, 0, 5, 6, 3, 2, 3, 7, 9, 8, 4};
		Q1.BubbleSort(Sortee);
		Q1.Display(Sortee);
	}

}
