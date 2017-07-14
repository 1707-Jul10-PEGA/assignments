package q12;

public class EnhancedFor {

	public static void main(String[] args) {
		
		int[] numbers = new int[100];
		
		for(int i = 1; i <= 100; i++){
			numbers[i-1] = i;
		}
		
		for(int x:numbers){
			System.out.println(x);
		}
	}
}
