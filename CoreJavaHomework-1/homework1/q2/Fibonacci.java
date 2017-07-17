package q2;

/*
 * Q2: Write a program to display the first 25 Fibonacci numbers beginning at 0.
 */

public class Fibonacci {
	
	public static int fibSequence(int num){
		
		if(num == 0) {
			return 0;
		} else if (num == 1) {
			return 1;
		} else {
			return fibSequence(num - 1) + fibSequence(num - 2);
		}
			
	}
	
	public static void main(String args[]) {
		
		System.out.println("The First 25 Numbers in the Fibonacci Sequence are:\n");
		
		for( int i = 0; i < 25 ; i++ ) {
			if (i < 24) {
				System.out.print(fibSequence(i) + ", ");
			} else {
				System.out.print(fibSequence(i) + ".");
			}
		}
	}
	

}
