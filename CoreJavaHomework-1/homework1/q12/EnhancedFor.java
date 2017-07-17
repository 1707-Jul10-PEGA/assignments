package q12;

public class EnhancedFor {

	public static void main(String[] args) {
		int[] numbers = new int [100];
		int filler = 1;
		for (int i = 0; i <= 99; i++) {
			numbers[i] = filler;
			filler++;	
		}
		
		for(int n:numbers) {
			if(n % 2 == 0) {
				System.out.println(n);
			}
		}
	}
}
