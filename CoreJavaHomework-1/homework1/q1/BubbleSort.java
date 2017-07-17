package q1;

public class BubbleSort {
	
	public static void bubbleSort(int[] array) {
		int lastPosition;
		int index;
		int temp;
		/*
		 * The outer loop positions "lastPostion" at the last element to
		 * compare during each pass through the array. Initially "lastPosition"
		 * is the index of the last element in the array. During each iteration
		 * it is decreased by one.
		 */
		for(lastPosition = array.length - 1; lastPosition >= 0 ; lastPosition--) {
			/*
			 * The inner loop steps through the array, comparing each element with
			 * its neighbor. All of the elements from index 0 through "lastPosition"
			 * are involved in the comparison. If the Elements are out of order,
			 * then they are swapped.
			 */
			for (index = 0; index <= lastPosition - 1; index++ ) {
				if (array[index] > array[index+1]) {
					//swap elements
					temp = array[index];
					array[index] = array[index + 1];
					array[index + 1]= temp;
				}
			}
		}
	}
}
