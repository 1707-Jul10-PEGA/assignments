package com.HL.q1;

public class Question1 
{
	public static void bubbleSort(int[] arr)
	{
		int temp=0;
		for(int i=0; i<arr.length; i++)
		{
			for(int j=1; j<arr.length; j++)
			{
				if(arr[j-1] > arr[j])
				{
					temp = arr[j-1];
					arr[j-1] = arr[j];
					arr[j] = temp;
				}
			}
		}
	}
	public static void main(String[] args)
	{
		int[] myArr = new int[]{1,0,5,6,3,2,3,7,9,8,4};
		System.out.println("My array:");
		for(int i=0; i<myArr.length; i++)
		{
			System.out.print(myArr[i]+" ");
		}
		bubbleSort(myArr);
		System.out.println();
		System.out.println("My array after bubble sort:");
		for(int i=0; i<myArr.length; i++)
		{
			System.out.print(myArr[i]+" ");
		}
	}
	
}
