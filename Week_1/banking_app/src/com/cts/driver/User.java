package com.cts.driver;

import java.io.Serializable;
import java.util.Scanner;
import org.apache.log4j.Logger;

public class User implements Login, Serializable
{
	private static Logger log = Logger.getRootLogger();
	
	private static final long serialVersionUID = 1L;
	String fname;
	String lname;
	public transient int ssn;
	boolean loggedin;
	String username;
	String password;
	
	public void login()
	{
		Scanner scan = new Scanner(System.in);
		System.out.println("To log in, enter your username and password below");
		System.out.print("Username: ");
		String uinput = scan.nextLine();
		log.info("READ USERNAME AS " + uinput);
		System.out.print("Password: ");
		String pinput = scan.nextLine();
		log.info("READ PASSWORD AS " + pinput);
		log.info("LOGIN ATTEMPT WITH " + uinput + ":" + pinput);
		scan.close();
	}
	
	int[] array = new int[0];
	
	public void logout()
	{
		log.info("LOGOUT ATTEMPT FROM " + username + ":" + password);
		if (loggedin)
		{
			loggedin = false;
			System.out.println("Successfully logged out.");
			log.info("SUCCESSFUL LOGOUT FROM " + username + ":" + password);
		}
		else
		{
			log.error("UNSUCCESSFUL LOGOUT FROM " + username + ":" + password);
		}
	}
	
}
