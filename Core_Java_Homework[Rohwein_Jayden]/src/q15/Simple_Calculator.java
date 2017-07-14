package q15;

public class Simple_Calculator implements Calculator {
	
	
	public static void main(String[] args){
		
		Simple_Calculator my_calc = new Simple_Calculator();
		
		System.out.println(" 6 + 3  = " + my_calc.addition(6,3));

		System.out.println(" 6 - 3 = " + my_calc.subtraction(6,3));

		System.out.println(" 6 * 3 = " + my_calc.mutliplication(6,3));

		System.out.println(" 6 / 3 = " + my_calc.division(6,3));
		
	}
	
	public int addition(int x, int y){
		return x + y;
	};
	public int subtraction(int x,int y){
		return x-y;
	};
	public int mutliplication(int x, int y){
		return x*y;
	};
	public int division(int x,int y){
		return x/y;
	};
}
