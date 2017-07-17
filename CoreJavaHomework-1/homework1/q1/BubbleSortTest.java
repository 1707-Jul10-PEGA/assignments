package q1;

/*
 * Q1: Perform a bubble sort on the following integer array: 1,0,5,6,3,2,3,7,9,8,4
 */

public class BubbleSortTest {

	public static void main(String[] args) {
		int values[] = { 1, 0, 5, 6, 3, 2, 3, 7, 9, 8, 4};
		
		
		//print array
		System.out.println("Original Order: ");
		for(int number: values) {
			System.out.print(number + " ");
		}
		
		//sort array
		BubbleSort.bubbleSort(values);
		
		//print sorted array
		System.out.println("\nSorted Order: ");
		for(int number: values) {
			System.out.print(number + " ");	
		}
		
	}

}
