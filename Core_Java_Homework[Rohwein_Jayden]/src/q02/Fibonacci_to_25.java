package q02;

public class Fibonacci_to_25 {
	
	
	public static void main(String[] args){
		
		int a = 0;
		int b = 1;
		
		
		//shows first 25
		for(int i = 1;i <= 25;i++){
			
			System.out.println( i + ". " + a);
			
			//adds the previous term to current term
			b = b+a;
			a = b-a;
			
		}
	}
}
