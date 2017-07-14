package q17;
import java.util.Scanner;

public class Interest_Calculator {

	private static int time,principal;
	private static float interest,rate;
	
	public static void main(String[] args){
		
		
		boolean b = true;
		
		while(b){
		try{
			b = false;
			get_user_input();
		
		} catch(Exception e){
			System.out.println("invalid input try again");
			b = true;
		}
		
		}
				
		interest = rate * time * principal;
		
		System.out.println("interest accrued: $" + interest);
							
	}
	
	private static void get_user_input(){
		
		Scanner my_Scanner = new Scanner(System.in);
		
		System.out.println( ">>--- Interest Calculator -------------------------\n"
						   +">> Principle ( in whole dollars)"
						   + ">>Rate per months"
						   + ">>Time in months ");
		
		System.out.println("please enter months:");
		time = my_Scanner.nextInt();
		
		System.out.println("please enter principal:");
		principal = my_Scanner.nextInt();
		
		System.out.println("please enter interest rate:");
		rate = my_Scanner.nextFloat();
		
	}
	
}
