package q1BubbleSort;

public class BubbleSortClass {

	// 1, 0, 5, 6, 3, 2, 3, 7, 9, 8, 4
	public static int[] bubbleSort (int arrIn[])
	{
		int x;
		int y;
		int arrOut[] = arrIn;
		for(x = arrOut.length - 1; x > 0; x--)
		{
			for(y = 0; y < x; y++)
			{
				if(arrOut[y] > arrOut[y+1])
				{
					swapPositions(y,  y+1,  arrOut[y], arrOut[y+1], arrOut);
					printArray(arrOut, arrOut.length);
				}
			}
		}
		return arrOut;
	}
	public static void printArray (int arrIn[], int length)
	{
		for(int x = 0; x < length; x++)
		{
			System.out.print(arrIn[x] + " ");
		}
		System.out.println();
	}
	public static void swapPositions(int pos1, int pos2, int dat1, int dat2, int arrIn[])
	{
		arrIn[pos2] = dat1;
		arrIn[pos1] = dat2;	
	}
	public static void main(String[] args)
	{
		//declaration and instantiation for the array
		int myArray[] = new int [] {1, 0, 5, 6, 3, 2, 3, 7, 9, 8, 4};
		
		System.out.println("Hello! I will sort your array using the bubble method. Here's the unsorted array: ");
		printArray(myArray, myArray.length);
		System.out.println("Now I will sort.");
		bubbleSort(myArray);
		printArray(myArray, myArray.length);
		System.out.println("Thank you!");
	
	}

}
