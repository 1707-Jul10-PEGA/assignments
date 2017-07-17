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
		try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileName))) {
			oos.writeObject(user);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void writeUserList(List<User> userList) {
		try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileName))) {
		
			// write every user in the list to the file
			for(User u : userList) {
				oos.writeObject(u);
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
			Driver.serviceLog.eof("Reached end of file for users.txt");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		return recoverUserList;
	}

}