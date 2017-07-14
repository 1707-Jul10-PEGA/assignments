package q09;
import java.util.*;

public class Prime_numbers {

	public static void main(String[] args){
	
		ArrayList<Integer> my_ints = new ArrayList<Integer>();
		

		for(int i = 1;i <= 100; i++){
			my_ints.add(i);
		}
		
		print_primes(my_ints);
		
		
		
	}
	
	public static void print_primes(ArrayList<Integer> my_ints){
		
		boolean is_prime;
		
		for(int i = 0;i < my_ints.size(); i++){
		
			is_prime = true;
			for(int j = 2;j < my_ints.get(i); j++){
				
				if( my_ints.get(i) % j == 0){
					is_prime = false;
					break;
				}
			}
			
			if(is_prime)
				System.out.println(my_ints.get(i));
			
			
		}
	}
}
