package com.WL.q1;
import java.util.Arrays;
public class QuestionOne {
	//Perform a bubble sort on the following integer array: 1,0,5,6,3,2,3,7,9,8,4
	
	public static void main(String[] args) {
		int input[] = {1,0,5,6,3,2,3,7,9,8,4};
		while(!(makePass(input) == 0))
		{	
		}
	}
	public static int makePass(int[] myArray)
	{
		int swaps = 0;
		int size = myArray.length;
		for(int i = 0; i < size-1 ; i++ )
		{
		if(myArray[i] > myArray[i+1])
		{
			int temp = myArray[i];
			myArray[i] = myArray[i+1];
			myArray[i+1] = temp;
			swaps++;
		}
		}
		System.out.println(Arrays.toString(myArray));
		return swaps;
	}

}
