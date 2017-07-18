package com.aw.bank_app.driver;
import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;

public class Program
{
	public static String userInput;
	public static int userCommand;
	
	public static Client cUserPass;
	public static boolean isLoggedIn = false;
	//All 3 roles will be saved into Client class into the field called "cRole"
	//public static Employee eUserPass; 
	//public static Admin aUserPass;
	
	public static void main(String[]args) throws ClassNotFoundException, IOException
	{
		while(true)
		{
			if(isLoggedIn){
				CheckRole();
			} else {
				StartBanking();
			}
		}
	}
	public static void StartBanking() throws ClassNotFoundException, IOException
	{
	System.out.println("Welcome to the Wong Bank! Would you like to [1] Login or [2] Register or [0] Exit?");
	MainMenu.Save();  //Used to initially plug in an Employee and Admin account
	Scanner scan = new Scanner(System.in);
	userCommand = Integer.parseInt(scan.next());
	String username = "";
	String password = "";
	switch (userCommand)
		{
			case 1:	System.out.println("Please enter your username");
					username = scan.next();
					System.out.println("Please enter your password");
					password = scan.next();
					System.out.println("Logging in with your username: " + username + ", password: " + password);			
					if (MainMenu.isValidLogin(username, password))
						try {
							MainMenu.Login(username, password, cUserPass);
							if(cUserPass != null){
								isLoggedIn = true;
								System.out.println("Login Successful!");
							} else {
								System.out.println("Your account has not been verified!");
							}
							break;
						} catch (Exception e) {
							e.printStackTrace();
						}
					else 
					{
						System.out.println("Invalid credentials...returning to Welcome screen");
						break;
					}	
			case 2: System.out.println("Registering... Please enter a new Username");
					username = scan.next();
					System.out.println("Please enter your new password");
					password = scan.next();
					MainMenu.Register(username, password);
					System.out.println("Successfully created user: " + username + ", with the password: " + password);	
					break;
			case 0: System.out.println("Thank you for visiting the Wong Bank! Goodbye");	
					System.exit(0);
		}
	}
	
	public static void CheckRole() throws ClassNotFoundException, IOException{
		Scanner scan;
		//System.out.println(cUserPass.deserialize());
		//Client
		if(cUserPass.getcRole().equals("client")){
			double cashAmount = 0;
			System.out.println("Hi " + cUserPass.getUser() + "(Client) " + ", would you like to [1] Make a Deposit or [2] Make a Withdrawl or [0] Logout?");
			scan = new Scanner(System.in);
			userCommand = Integer.parseInt(scan.next());
			switch(userCommand){
			case 1: System.out.println("How much would you like to deposit?");
					cashAmount = Double.parseDouble(scan.next());
					cUserPass.ModifyCash(cashAmount);
					System.out.println("You have deposited " + cashAmount + ". Your new total is " + cUserPass.getBalance());
					break;
			case 2: System.out.println("How much would you like to withdraw?");
					cashAmount = Double.parseDouble(scan.next());
					cUserPass.ModifyCash(-cashAmount); 		
					System.out.println("You have withdrawn " + cashAmount + ". Your new total is " + cUserPass.getBalance());
					break;
			case 0: System.out.println("You have logged out. Thank you for visiting the Wong Bank! Goodbye");
					isLoggedIn = false;
			}
		//Employee
		} else if (cUserPass.getcRole().equals("employee")){
			String user;
			System.out.println("Hi " + cUserPass.getUser()+ "(Employee) " + ", would you like to [1] Review Applications,  [2] Review Information [0] Logout?");
			scan = new Scanner(System.in);
			userCommand = Integer.parseInt(scan.next());
			switch(userCommand){
				case 1: System.out.println("Who account do you want to approve or reject? Please enter their first name...");
					user = scan.next();
					MainMenu.ReviewApplication(user);
					//System.out.println("You have deposited " + user + ". Your new total is " + cUserPass.getBalance());
					break;
				case 2: System.out.println("Who's account summary do you want to review? Please enter their first name...");
					user = scan.next();
					MainMenu.ReviewInformation(user);
					break;
				case 0: System.out.println("You have logged out. Thank you for visiting the Wong Bank! Goodbye");
					isLoggedIn = false;	
			}
		} else {
		//Admin
			String user;
			System.out.println("Hi " + cUserPass.getUser()+ "(Admin) " + ", [1] Edit Account or [0] Logout?");
			scan = new Scanner(System.in);
			userCommand = Integer.parseInt(scan.next());
			switch(userCommand){
				case 1: System.out.println("Which account do you want to edit? Please enter first name");
					user = scan.next();
					MainMenu.AdminEdit(user);
					break;
				case 0: System.out.println("You have logged out. Thank you for visiting the Wong Bank! Goodbye");
					isLoggedIn = false;	
			}
		}
		
	}
}
	