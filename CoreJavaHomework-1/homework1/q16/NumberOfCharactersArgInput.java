package q16;

/*
 * Write a program to display the number of characters for a string input.
 * The sting should be entered as a command line argument using(String[] args) 
 */

public class NumberOfCharactersArgInput {
	
	public static void main(String[] args) {
		int count = 0;
		for(int i = 0; i < args.length; i++) {
			count = args[i].length() + count;
			count = count + 1; //account for whitespace - hello world.
			
		}
		// remove offset counter by 1.
		// since last word does not have space at the end.
		count = count - 1;  
		System.out.println("The Number of Characters is: " + count);
		
	}

}
