package com.EC.hw1.Utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.LinkedList;
import java.util.List;

import com.EC.hw1.Model.Customer;
import com.EC.hw1.Model.Employee;
import com.EC.hw1.Model.User;

public class BankUtilities {

	// Write and update user's txt file

	public static void writeUser(User u) {
		String filename = "Users/" + u.getUserName() + ".txt";
		try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename))) {
			oos.writeObject(u);
			System.out.println("Successfully wrote to text file");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void writeEmployee(Employee emp) {
		String filename = "Employees/" + emp.getUserName() + ".txt";
		try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename))) {
			oos.writeObject(emp);
			System.out.println("Successfully wrote to text file");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	// read user text files
	public static User readUser(String username) {
		String filename = "Users/" + username + ".txt";
		try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename))) {
			User u = (User) ois.readObject();
			return u;
		} catch (FileNotFoundException e) {
			System.out.println("User does not exist.");
			// e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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

			} catch (IOException e) {

			} catch (ClassNotFoundException e) {

			}
		}
		if (empList.size() == 0) {
			return false;
		}

		int random = (int) (Math.random() * (empList.size() - 1));
		empList.get(random).getCustList().add(c);
		// update bank
		System.out.println("Your personal banker name is: " + empList.get(random).getFirstName() + " "
				+ empList.get(random).getLastName());
		BankUtilities.writeUser(empList.get(random));
		BankUtilities.writeEmployee(empList.get(random));
		return true;

	}
}
