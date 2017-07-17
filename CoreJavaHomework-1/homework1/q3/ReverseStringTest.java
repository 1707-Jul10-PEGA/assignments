package q3;

// Reverse a String without using reverse function.
// input: Hello World

public class ReverseStringTest {


	public static void main(String[] args) {

		String demo ="Hello World";	
		System.out.println(demo);
		reverseString(demo);

	}
	
	public static void reverseString(String array) {
		String result = new String();
		int length = array.length();
		for( int i = (length - 1); i >= 0; --i) {
			result += array.charAt(i);
		}	
		//array += array.substring(length);	
		System.out.println(result);
		
	}
	

}
