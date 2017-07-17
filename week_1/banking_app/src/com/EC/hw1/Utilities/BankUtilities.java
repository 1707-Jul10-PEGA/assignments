package com.EC.hw1.Utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.DirectoryNotEmptyException;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.util.LinkedList;
import java.util.List;

import org.apache.log4j.Logger;

import com.EC.hw1.Model.Customer;
import com.EC.hw1.Model.Employee;
import com.EC.hw1.Model.User;

public class BankUtilities {
	
	public static Logger log = Logger.getRootLogger();
	
	// Write and update user's txt file

	public static boolean writeUser(User u) {
		String filename = "Users/" + u.getUserName() + ".txt";
		try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename))) {
			oos.writeObject(u);
			log.trace("Successfully wrote " + u.getUserName() + " account to a file in Users/");
			return true;
		} catch (IOException e) {
			log.error("Failed to write user " + u.getUserName() + " to a file in User/",e);
			return false;
			//e.printStackTrace();
		}
	}

	public static boolean writeEmployee(Employee emp) {
		String filename = "Employees/" + emp.getUserName() + ".txt";
		try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename))) {
			oos.writeObject(emp);
			log.trace("Successfully wrote " + emp.getUserName() + " account to a file in Employees/");
			return true;
		} catch (IOException e) {
			log.error("Failed to write user " + emp.getUserName() + " to a file in User/",e);
			return false;
			//e.printStackTrace();
		}
	}

	// read user text files
	public static User readUser(String path) {
		
		String filename = null;
		if(path.contains(".txt")){
			filename = path;
		}else{
			filename = "Users/" + path + ".txt";
		}
		
		try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename))) {
			User u = (User) ois.readObject();
			log.trace("Found " + path + " account");
			return u;
		} catch (FileNotFoundException e) {
			System.out.println("User does not exist.");
			log.error("Failed readUser(): "+ path + " text file",e);
		} catch (IOException e) {
			log.error("Failed readUser(): "+ path + " text file",e);
			//e.printStackTrace();
		} catch (ClassNotFoundException e) {
			log.error("Failed readUser(): "+ path + " text file",e);
			//e.printStackTrace();
		}
		log.trace("File " + path + " does not exist");
		return null;
	}

	// assign customer to a banker randomly
	public static boolean assignBanker(Customer c) {
		File folder = new File("Employees/");
		File[] listOfFiles = folder.listFiles();
		List<Employee> empList = new LinkedList<Employee>();
		for (File emp : listOfFiles) {
			try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(emp.getPath()))) {
				Employee e = (Employee) ois.readObject();
				empList.add(e);
			} catch (FileNotFoundException e) {
				log.error("Could not load employees for assignBanker",e);
			} catch (IOException e) {
				log.error("Could not load employees for assignBanker",e);
			} catch (ClassNotFoundException e) {
				log.error("Could not load employees for assignBanker",e);
			}
		}
		if (empList.size() == 0) {
			log.error("Cannot submit application because there are no employees");
			return false;
		}

		int random = (int) (Math.random() * (empList.size() - 1));
		empList.get(random).getCustList().add(c);
		// update bank
		System.out.println("Your personal banker name is: " + empList.get(random).getFirstName() + " "
				+ empList.get(random).getLastName());
		BankUtilities.writeUser(empList.get(random));
		BankUtilities.writeEmployee(empList.get(random));
		log.trace(empList.get(random).getFirstName() + " received a customer's application");
		log.trace(c.getUserName() + " applied for an account");
		return true;

	}

	//Delete a user by path
	public static boolean deleteUser(Path path){
		
		try {
		    Files.delete(path);
		    log.trace("Deleted path: " + path);
		    return true;
		} catch (NoSuchFileException e) {
		    log.error(path + ": no such" + " file or director%n",e);
		    return false;
		} catch (DirectoryNotEmptyException e) {
		    log.error(path+": not empty%n", e);
		    return false;
		} catch (IOException e) {
		    // File permission problems are caught here.
		    log.error("Failed to delete path to user", e);
		    return false;
		}
	}
	
	//return true if file exist, otherwise return false
	public static boolean accountExist(String username) {

		Customer c2 = (Customer) BankUtilities.readUser(username);
		if (c2 == null) {
			log.trace(username + "'s account does not have an account");
			return false;
		} else {
			log.trace(username + "'s account does have an account");
			return true;
		}

	}

}
