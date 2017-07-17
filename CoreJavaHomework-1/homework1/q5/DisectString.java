package q5;

import java.util.Scanner;

public class DisectString {

	public static void main(String[] args) {
		System.out.print("Enter a String: ");
		Scanner n = new Scanner(System.in);
		String string = n.nextLine();
		System.out.print("\nEnter an Index: ");
		Integer index = n.nextInt();
		String result = disect( string, index );
		System.out.println(result);

	}
	
	public static String disect(String str, Integer idx) {
		String result = "";
		for(int i = 0; i <= (idx-1); i++) {
			result = result + str.charAt(i);				
		}	
		return result;
	
	}

}
