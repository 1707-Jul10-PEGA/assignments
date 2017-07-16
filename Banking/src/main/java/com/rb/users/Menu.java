package com.rb.users;

import static com.rb.driver.Driver.SCAN;

public abstract class Menu {
	
	protected static int readInput(){
		
		int input = -1;
		
		try {
			input = SCAN.nextInt();
		} catch (Exception e) {
			// TODO logging
		}finally{
			SCAN.nextLine();
		}
		
		return input;
	}
	
	
	protected static double readAmount(){
		
		double input = -1.0;
		
		try {
			input = SCAN.nextDouble();
		} catch (Exception e) {
			// TODO logging
		}finally{
			SCAN.nextLine();
		}
		
		return input;
	}
	
	protected static String readString(){
		String input = null;
		
		try{
			input = SCAN.nextLine();
		}catch (Exception e){
			// TODO logging
		}
		
		return input;
		
	}
	
}
