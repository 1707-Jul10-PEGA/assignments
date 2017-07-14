package com.EC.hw1.driver;

import java.util.Scanner;

import com.EC.hw1.Model.Customer;
import com.EC.hw1.Model.User;

public class Driver {

	//private Set<Employee> empList = new HashSet<Employee>();

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		boolean valid = true;
		printWelcome();
		
		while (valid) {
			
			if(scan.hasNextInt()){
				int tmp = scan.nextInt();
				if(tmp>=1&&tmp<=3){
					//swtich case
					switch(tmp){
					case 1:
						login();
						break;
					case 2:
						//createAccount();
						break;
					case 3:
						scan.close();
						System.exit(0);
					}
				}else{
					printWelcome();		

				}
			}else{
				printWelcome();
				//clear invalid input
				scan.next();
			}
		}

	}

	private static void login() {
		
		boolean valid = true;
		printLogin();
		
		while (valid) {
			Scanner scan = new Scanner(System.in);
			if(scan.hasNextInt()){
				int tmp = scan.nextInt();
				if(tmp>=1&&tmp<=3){
					//swtich case
					switch(tmp){
					case 1:
						scan.close();
						customer();
						break;
					case 2:
						//employee();
						break;
					case 3:
						//admin();
					}
				}else{
					printLogin();		

				}
			}else{
				printLogin();
				//clear invalid input
				scan.next();
			}
		}

		
	}
	
	private static void customer() {
		Customer c = (Customer)getUserAccount();
		
		
	}

	private static void printLogin() {
		System.out.println("Please pick a number between 1-3 to continue");
		System.out.println("(1)Customer");
		System.out.println("(2)Employee");
		System.out.println("(3)Admin"); 		
	}

	private static void printWelcome(){
		System.out.println("Please pick a number between 1-3 to continue");
		System.out.println("(1)Login");
		System.out.println("(2)New Customer");
		System.out.println("(3)Close App");
	}
	
	private static User getUserAccount(){
		Scanner scan = new Scanner(System.in);
		System.out.println("Please enter your user name");
		String username = scan.next();
		System.out.println("Please enter your user password");
		String password = scan.next();
		
	}
	
	
}
