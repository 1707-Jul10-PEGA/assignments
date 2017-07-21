package com.dpq1.driver;

public class BubbleSort {
	
	private int[] sorted;
	
	public static void main(String[] args) {
		int[] in = {1,0,5,6,3,2,3,7,9,8,4};		//no args constructor would do this, but I wanted to make it easy for you to change parameters
		BubbleSort example = new BubbleSort(in);
		System.out.println(example.toString());
	}
	
	public BubbleSort() {
		int[] unsorted = {1,0,5,6,3,2,3,7,9,8,4};	//by default uses array in assignment
		this.sorted = this.sort(unsorted);	//constructor will sort to minimize commands needed to utilize class
	}
	
	public BubbleSort(int[] input) {	//more flexible constructor
		int[] unsorted = input;
		this.sorted = this.sort(unsorted);
	}
	
	public int[] sort(int[] input) {
		boolean changed = false;	//tracks whether a swap happened or not in the pass
		int[] sorted = input;
		for (int x = 0; x < sorted.length; x++) {
			if (x == sorted.length - 1) {
					if (changed = true) {
						x = 0;		//resets the loop if there was a swap this pass
						changed = false;
					}
				}
			else if (sorted[x] > sorted[x+1]) {
				int temp = sorted[x];
				sorted[x] = sorted[x+1];
				sorted[x+1] = temp;
				changed = true;
			}
		}
		return sorted;
	}
	
	@Override
	public String toString() {
		String out = new String("The array has been sorted to: ");
		for (int x: this.sorted) {
			out += x + ", ";	//builds a string from the array
		}
		return out;
	}
}
