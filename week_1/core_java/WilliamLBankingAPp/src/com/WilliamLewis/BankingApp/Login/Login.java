package com.WilliamLewis.BankingApp.Login;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import org.apache.log4j.Logger;

public class Login {
	private static Logger log = Logger.getRootLogger();
	public static void run() {
		Scanner scan;
		try {
			scan = new Scanner(new File("C:\\Users\\William\\assignments\\week_1\\core_java\\WilliamLBankingAPpsrc\\Users.txt"));
		} 
		//If the file isn't found, we should return something to say make a user!
		catch (FileNotFoundException e) {
			e.printStackTrace();
			return;
		}
		Scanner keyboard = new Scanner(System.in);
		String user = scan.nextLine();
		String pass = scan.nextLine(); // looks at selected file in scan

		String inpUser = keyboard.nextLine();
		String inpPass = keyboard.nextLine(); // gets input from user

		if (inpUser.equals(user) && inpPass.equals(pass)) {
			log.info("your login message");
		}
		else if(inpUser.equals(user))
		{
			log.info("Invalid password");
		}

		else {
			log.info("Unrecognized user.");
		}
		
		scan.close();
		keyboard.close();
	}
}


