package com.dv.bankingapp;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class SerializeUser {

	private String fileName = "src/com/dv/bankingApp/users.txt";
	
	public void writeUser(User user) {
		System.out.println("Writing user to file ... ");
		try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileName))) {
			oos.writeObject(user);
			System.out.println("Successfully wrote user to file!");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void writeUserList(List<User> userList) {
		System.out.println("Writing users to file ... ");
		try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileName))) {
			for(User u : userList) {
				oos.writeObject(u);
				System.out.println("Successfully wrote user to file!");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public User readUser() {
		try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileName))) {
			User u = (User) ois.readObject();
			return u;
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return null;
	}

	public List<User> readUserList() {
		boolean loop = true;
		List<User> recoverUserList = new ArrayList<User>(); 
	
		try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileName))) {
		
			// read users from file, add them to recoverUserList and return the list
			while(loop) {
			
				User u = (User) ois.readObject();

				if(u != null) {
					recoverUserList.add(u);
				}
				
				else {
					loop = false;
				}
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("Reached end of file!");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		return recoverUserList;
	}
}
