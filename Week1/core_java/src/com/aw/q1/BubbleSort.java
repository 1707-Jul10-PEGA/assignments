package com.aw.q1;
//Perform a bubble sort on the following integer array: 1 , 0 , 5 , 6 , 2 , 3 , 7 , 9 , 8 , 4

public class BubbleSort { //Declaring the class

	 public static void main(String[]args){
		int [] list = {1, 0 , 5 , 6 , 3 , 2, 3, 7, 9, 8, 4};
		sort(list);
		for (int numberAtLocation = 0; numberAtLocation<list.length;numberAtLocation++) //prints out each number one at a time
			System.out.println(list [numberAtLocation] );
	}
	//Values I need to actually arrange. It's in the form of an array
	//Need cycle through each of the values
	//Need to compare one value with the other value
	//Switch a value with another value only if that value is larger
	public static void sort(int[]list){
	for (int next = 1; next < list.length; next++){ //Lets you know how many times you need to move through the numbers. You already "moved" through the numbers once since you're starting at 1.
		for (int numberAtLocation = 0; numberAtLocation < list.length - next; numberAtLocation++){ //While the above loop is tracking the number of movements, this loop will be cycling through the actual numbers
			if (list [numberAtLocation] > list [numberAtLocation +1]) {
				//Under the condition where the first number is bigger than the 2nd, you need to swap
				//In order to swap, you need to have something reference the values so remember to make another variable
				int original = list [numberAtLocation];
				list [numberAtLocation] = list[numberAtLocation+1]; //This will cause the thing being compared to have a value equivalent to the number next to it
				list [numberAtLocation+1] = original; //This will cause the number 2nd number to take on the value of the number it was originally compared to
			}
}
}
}
}
// First for loop starts at 1
// Causes next for loop to proc
// It procs its if statement and compares 1 to 0
// Because 1 is bigger, original gets set to 1, number at that location becomes 0 and number at that new location becomes 1
// The numberatLocation spot we are now at is 1
// The next value is now 2
//2 is still less than length than the full length
// list [numberAtLocation] should be at the second spot at this given point