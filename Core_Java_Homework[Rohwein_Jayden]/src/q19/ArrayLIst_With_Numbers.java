package q19;
import java.util.*;

public class ArrayLIst_With_Numbers {
	
	public static void main(String args[]){
		
		ArrayList<Integer> my_nums = new ArrayList<Integer>();
		
		
		int even_sum = 0;
		int odd_sum = 0;
		boolean is_prime;
		
		for(int i = 0; i < 10;i++){
			my_nums.add(i+1);
			
			System.out.print(my_nums.get(my_nums.size()-1) + " ");
			
			if(my_nums.get(my_nums.size()-1) % 2 == 0){
				even_sum+= my_nums.get(my_nums.size()-1);
			}else{
				odd_sum += my_nums.get(my_nums.size()-1);
			}
			
			
			is_prime = true;
			for(int j = 2;j < my_nums.get(my_nums.size()-1); j++){
				if(my_nums.get(my_nums.size()-1) % j == 0){
					is_prime = false;
					break;
				}
			}
			
			if(is_prime)
				my_nums.remove(my_nums.size()-1);
			
			
		}
		
		System.out.println("\neven sum: " + even_sum + "| odd sum:" + odd_sum + 
							"\nremaining: " + my_nums.toString());
		
			
					
	}
}
		
	
