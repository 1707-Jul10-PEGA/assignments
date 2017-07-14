package q01;

public class Bubble_sort_main {

	public static void main(String[] args){
		int numbers[] = {1,0,5,6,3,2,3,7,9,8,4};
		
		System.out.println("------ Bubble Sort -------\n"
						+"Array before bubble sort: ");
		print_array(numbers);
		
		bubblesort(numbers);
		System.out.println("\nArray after bubble sort: ");
		print_array(numbers);
			
				
	}
	
	/*
	 * sorts array with bubble sort
	 * @param int[] numbers array to sort
	 */
	private static void bubblesort(int[] numbers){
		
		for(int i = 0;i < numbers.length;i++){
			for(int j = 0;j < (numbers.length-1);j++){
				
				//swaps if needed
				if( numbers[j] > numbers[j+1]){
					System.out.println( numbers[j] + " " + numbers[j+1]);
					numbers[j] = numbers[j] + numbers[j + 1];
					numbers[j+1] = numbers[j] - numbers[j+1];
					numbers[j] = numbers[j] - numbers[j+1];
					System.out.println( "-" + numbers[j] + " " + numbers[j+1]);
				}
			}
		}
	}
	

	/*
	 * prints out values of the array
	 * @param numbers array to be printed
	 */
	public static void print_array(int[] numbers){
		for(int i = 0;i < numbers.length;i++){
			
			System.out.print(numbers[i] + " ");
		}
	}
}
