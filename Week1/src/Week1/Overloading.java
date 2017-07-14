package Week1;

import java.util.List;

public class Overloading implements Interface1, Interface2{
	private List<String> myStrings;

	public static void main(String[] args) {

		int i;
		i = 5;
		i = 10;
		test(1.0);
	}
	
	public static void test(int i) {
		System.out.println("1");
		
	}
	public static void test(long l) {
		System.out.println("2");
	}
	
	public static void test(double l) {
		System.out.println("3");
	}

	@Override
	public void someMethods() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void someMethod() {
		// TODO Auto-generated method stub
		
	}
}
