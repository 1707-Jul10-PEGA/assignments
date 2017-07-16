package com.rb.driver;

import com.rb.users.*;

import java.util.Scanner;

public class Driver {
	
	public static Scanner SCAN;
	
	public static void main(String[] args) {
		
		SCAN = new Scanner(System.in);
		
		Driver bankSystem = new Driver();
		
		bankSystem.mainMenu();
		
		SCAN.close();
	}
	
	private void mainMenu(){
		
		boolean loop = true;
		
		Bank.getBank();
		
		User activeUser = null;
		
		do {
			
			
			
			if(activeUser == null){
				activeUser = LoginMenu.logIn();
			}else{
				
				switch ( activeUser.getAccess() ){
				case 0:
					CustomerMenu.customerMenu((Customer) activeUser);
					break;
				case 1:
					EmployeeMenu.employeeMenu((Employee) activeUser);
					break;
				case 2:
					AdminMenu.adminMenu((Admin) activeUser);
					break;
				default:
					
					break;
				}
				
				System.out.println("Logging out.\n");
				if (activeUser.getAccess() == 2) {
					System.out.println("Stop system?\n");
					System.out.println("  1 - Continue");
					System.out.println("  2 - Shut down");
					
					int reply = 0;
					
					try{
						reply = SCAN.nextInt();
					}catch (Exception e){
						// TODO add log here
					}finally{
						SCAN.nextLine();
					}
					if (reply==2){
						loop = false;
					}
				}
				activeUser = null;
			}
			
		} while (loop);
		
	}
	
}
