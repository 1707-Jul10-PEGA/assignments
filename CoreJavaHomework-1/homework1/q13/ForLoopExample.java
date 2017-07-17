package q13;

/*
 *	Display the triangle on the console as follows using any type of loop.
 *	Do NOT use a simple group of print statements to accomplish this.
 *
 * 	0
 * 	1	0
 * 	1	0	1
 * 	0	1	0	1
 * 
 */

public class ForLoopExample {

	public static void main(String[] args) {
		for(int x = 1; x <= 4; x++) { // Upper Bound
			for(int y = 1; y <= x; y++) { // Lower Bound
				System.out.print(((x + y) % 2) + " ");
			}
			System.out.println(" \n"); // Line Separation
		}
			
	}
}
