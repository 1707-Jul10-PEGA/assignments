package q04;

public class N_Factorial {
	
	public static void main(String[] args){
		
		for(int n = 0; n <= 10; n++){
			System.out.println("N: " + n + " |Factorial N: " + factorial(n));
		}
	}
	
	public static int factorial(int n){
		if( n <= 1){
			return 1;
		}else 
			return n * factorial(n-1);
		
	}
	

}
