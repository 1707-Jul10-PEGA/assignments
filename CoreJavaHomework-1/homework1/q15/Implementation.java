package q15;

public class Implementation implements MathMethod{
	
	public int add(int a, int b ) {
		return a + b;
	}
	public int sub(int a, int b ) {
		return a - b;
	}
	public int mult(int a, int b ) {
		return a * b;
	}
	public int div(int a, int b ) {
		return a / b;
	}
	
	private static int a = 6;
	private static int b = 2;
	
	
	public static void main(String[] args) {
		
		
		Implementation x = new Implementation();
		System.out.println(a + " + " + b + " = " + x.add(a, b)); 
		System.out.println(a + " - " + b + " = " + x.sub(a, b)); 
		System.out.println(a + " * " + b + " = " + x.mult(a, b)); 
		System.out.println(a + " / " + b + " = " + x.div(a, b)); 
		
		
		
	}
}
