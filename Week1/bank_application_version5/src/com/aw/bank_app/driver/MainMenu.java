package com.aw.bank_app.driver;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import testingSomethingOut.KID;

public class MainMenu 
{
	public static void Login(String user, String pass, Client c) throws ClassNotFoundException
	{
				try {
					FileInputStream fi = new FileInputStream(new File(user+pass+".txt")); //JohnSmith.txt
			        ObjectInputStream oi = new ObjectInputStream(fi);
			        
			        
			        Program.cUserPass = (Client) oi.readObject();
			        if(Program.cUserPass.cStatus == false){
			        	Program.cUserPass = null;
			        }
			        
			        
					oi.close();
			        fi.close();
				} catch (FileNotFoundException e) {
				} catch (IOException e) {
				}
	}
	public static void Register(String user, String pass) throws IOException
	{
		Client c = new Client(user, pass, false, 0,"client");
		FileOutputStream f = new FileOutputStream(new File(user+pass+".txt"));
		ObjectOutputStream o = new ObjectOutputStream(f);
		
		
		try {
			o.writeObject(c);
			o.close();
			f.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
		
	
	
	public static boolean isValidLogin(String user, String pass)
	{
		try {
			FileInputStream fi = new FileInputStream(new File(user+pass+".txt")); //JohnSmith.txt
	        ObjectInputStream oi = new ObjectInputStream(fi);
			
			
			oi.close();
	        fi.close();
	        return true;
		} catch (FileNotFoundException e) {
			return false;
		} catch (IOException e) {
			return false;
		}
		
	}
	
	public static void SuccessfulTransaction(Client c) throws IOException{
		//Deletes Old File
		File dFile = new File(c.getUser()+c.getPass()+".txt");
		dFile.delete();
		
		//Creates New File
		FileOutputStream f = new FileOutputStream(new File(c.getUser()+c.getPass()+".txt"));
		ObjectOutputStream o = new ObjectOutputStream(f);
		
		
		try {
			o.writeObject(c);
			o.close();
			f.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void ReviewApplication(String user) throws IOException, ClassNotFoundException {
		try {
			File folder = new File("C:/Users/Wong/Documents/workspace-sts-3.8.4.RELEASE/final_application/");
			File[] listOfFiles = folder.listFiles();
			
			String fileMatch = "";
			for(File f: listOfFiles){
				if(f.getName().contains(user)){
					fileMatch = f.getName();
				}
			}
			
			
			FileInputStream fi = new FileInputStream(new File(fileMatch)); 
			ObjectInputStream oi = new ObjectInputStream(fi);
        
			Client c;
			c = (Client) oi.readObject();
			System.out.println(c.deserialize());
			System.out.println("[1] to enable account, [0] to disable account");
			
			Scanner scan = new Scanner(System.in);
			int i = Integer.parseInt(scan.next());
     
			if(i == 0){
				c.cStatus = false;
				SuccessfulTransaction(c);
			} else if(i == 1){
				c.cStatus = true;
				SuccessfulTransaction(c);
			}
			System.out.println("Updated! User info is now: " + c.deserialize());
        	oi.close();
        	fi.close();
		} catch (FileNotFoundException e) {
		} catch (IOException e) {
		}
	}
	public static void ReviewInformation(String user) throws IOException, ClassNotFoundException {
		try {
			File folder = new File("C:/Users/Wong/Documents/workspace-sts-3.8.4.RELEASE/final_application/");
			File[] listOfFiles = folder.listFiles();
			
			String fileMatch = "";
			for(File f: listOfFiles){
				if(f.getName().contains(user)){
					fileMatch = f.getName();
				}
			}
			
			
			FileInputStream fi = new FileInputStream(new File(fileMatch)); 
			ObjectInputStream oi = new ObjectInputStream(fi);
        
			Client c;
			c = (Client) oi.readObject();
			System.out.println("Current Account Information: " + c.deserialize());
			
        	oi.close();
        	fi.close();
		} catch (FileNotFoundException e) {
		} catch (IOException e) {
		}
	}
	
	
	public static void AdminEdit(String user) throws IOException, ClassNotFoundException {
		try {
			File folder = new File("C:/Users/Wong/Documents/workspace-sts-3.8.4.RELEASE/final_application/");
			File[] listOfFiles = folder.listFiles();
			
			String fileMatch = "";
			for(File f: listOfFiles){
				if(f.getName().contains(user)){
					fileMatch = f.getName();
				}
			}
			
			
			FileInputStream fi = new FileInputStream(new File(fileMatch)); 
			ObjectInputStream oi = new ObjectInputStream(fi);
        
			Client c;
			c = (Client) oi.readObject();
			System.out.println(c.deserialize());
			System.out.println("[1] Edit account, [0] to Back");
			
			Scanner scan = new Scanner(System.in);
			int i = Integer.parseInt(scan.next());
			int j;
			
			double currentBalance = c.cBalance;
			if(i == 0){
				
			} else if(i == 1){
				System.out.println("[1] Edit Name," + " [2] Edit Pass," + " [3] Status," + " [4] Balance,"+ " [5]Role");
				j = Integer.parseInt(scan.next());
				switch(j){
					case 1: System.out.println("Select a new name");
							c.cUsername = scan.next();
							break;
					case 2: System.out.println("Select a new pass");
							c.cPassword = scan.next();
							break;
					case 3: System.out.println("Select a new status [1] for enable, [0] for disable");
							int currentStatus = Integer.parseInt(scan.next());
							if(currentStatus == 1){
								c.cStatus = true;
							} else { 
								c.cStatus = false;
							}
							break;
					case 4: System.out.println("Select a new balance");
							c.cBalance = Double.parseDouble(scan.next());
							break;
					case 5: System.out.println("Select a new role ('client', 'employee', 'admin')");
							c.cRole = scan.next();
							break;
					case 0: break;
				}
				SuccessfulTransaction(c);
				System.out.println("Updated! User info is now: " + c.deserialize());
			}
			
        	oi.close();
        	fi.close();
		} catch (FileNotFoundException e) {
		} catch (IOException e) {
		}
	}
	
	public static void Save() throws IOException{
		Client Addy = new Client("Addy", "Wong", true, 1000, "admin"); //Set the final one to determine role
		
		FileOutputStream f = new FileOutputStream(new File("AddyWong.txt"));
		ObjectOutputStream o = new ObjectOutputStream(f);
		
		
		try {
			o.writeObject(Addy);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		try {
			o.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		try {
			f.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
