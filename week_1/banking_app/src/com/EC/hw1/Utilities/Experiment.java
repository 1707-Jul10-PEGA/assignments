package com.EC.hw1.Utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;
import java.util.Map;

import com.EC.hw1.Model.Admin;
import com.EC.hw1.Model.Customer;
import com.EC.hw1.Model.Employee;
import com.EC.hw1.Model.User;

public class Experiment {

	public static void main(String[] args) {
		Map<String,User> localDB = new HashMap<String,User>();
		Customer c = new Customer();
		Employee e = new Employee();
		Admin a = new Admin();
		
		localDB.put("ejchen", c);
		localDB.put("Josh", e);
		localDB.put("Amelia", a);
		
		System.out.println(localDB);
		c.setFirstName("Elliot Chen");
		writePerson(c);
		Customer d = (Customer) readPerson();
		System.out.println(d.getFirstName());
		
	}
	
	public static void writePerson(User p) {
		String filename = "Users/ejchen.txt";
		try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename))) {
			oos.writeObject(p);
			System.out.println("Successfully wrote to text file");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static User readPerson() {
		String filename = "Users/ejchen.txt";
		try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename))) {
			User person = (User) ois.readObject();
			return person;
		} catch(FileNotFoundException e){
			e.printStackTrace();
		}catch(ClassNotFoundException e){
			e.printStackTrace();
		}catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	
}
