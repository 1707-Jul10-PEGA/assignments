package com.revature.bankingapp.main;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

import com.revature.bankingapp.entities.person.Customer;
import com.revature.bankingapp.entities.person.Person;
import com.revature.bankingapp.interfaces.AuthenticationInterface;
import com.revature.bankingapp.utils.Serializer;

public class Authentication implements AuthenticationInterface {

	@Override
	public <T> Person userAuthentication(String username, String password,String type)throws FileNotFoundException, ClassNotFoundException, IOException {
		
		Serializer serializer = new Serializer<>();
		
		ArrayList<T> personList = new ArrayList<T>();
		personList = (ArrayList<T>) serializer.getPersonDatabase(type);
					
		for (T p : personList) {

			if (((Person) p).getUsername().equals(username)) {
				if (((Person) p).getPassword().equals(password)) {
					return (Person) p;
				}
			}

		}
		
		
		
		return null;

	}

	@Override
	public int loginAttemptsViolation() {
		// TODO Auto-generated method stub
		return 0;
	}

}
