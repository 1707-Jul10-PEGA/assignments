package q1;

public class BubbleSort {
	
	
	public static void main(String args[]){
		int[] toSort = {1,0,5,6,3,2,3,7,9,8,4};
		
		// print initial array state
		System.out.print(toSort[0]);
		for(int i = 1; i < toSort.length; i++){
			System.out.print(", " + toSort[i]);
		}
		// move to new line
		System.out.println("\n");
		
		boolean done = true;
		do{
			done = true;
			for(int i = 1; i < toSort.length; i++){
				if(toSort[i-1] > toSort[i]){
					int temp = toSort[i];
					toSort[i] = toSort[i-1];
					toSort[i-1] = temp;
					done = false;
				}
			}
		}while(!done);
		
		System.out.print(toSort[0]);
		for(int i = 1; i < toSort.length; i++){
			System.out.print(", " + toSort[i]);
		}
	}
}
