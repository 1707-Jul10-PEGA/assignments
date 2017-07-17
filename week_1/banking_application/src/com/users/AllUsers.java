package com.users;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


//Singleton
public class AllUsers implements Serializable {
	/*
	 *
	 * 
	 */
	private static final long serialVersionUID = -5609146294385770843L;
	private static AllUsers inst;
	private static boolean created = false;
	// we don't want the same users
	public static List< Set<User> > users;
	private static String fileName = "AllUsers.txt";
	public static final int CUSTOMER_INDEX = 0;
	public static final int EMPLOYEE_INDEX = 1;
	public static final int ADMIN_INDEX = 2;
	public static int UID = 0;
	private AllUsers() {
		users = new ArrayList<>();
		// Customers
		users.add(new HashSet<User>());
		// Employee 
		users.add(new HashSet<User>());
		// Admin
		users.add(new HashSet<User>());
		
	}

	//lazy
	public static synchronized AllUsers getInstance() {
		if (created) {
			return inst;
		} else {
			inst = new AllUsers();
			created = true;
			return inst;
		}
	}
	public static void writeAllUsers(){
		try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileName))){
			oos.writeObject(users);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public static void readAllUsers() throws FileNotFoundException{
		try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileName))){
			AllUsers.users = (List< Set<User> >)ois.readObject();
			created=true;
		} catch (FileNotFoundException e) {
			throw e; // We want the caller to handle the error.
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	
}
