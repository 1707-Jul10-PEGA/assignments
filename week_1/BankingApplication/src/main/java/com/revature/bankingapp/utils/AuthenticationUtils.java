package com.revature.bankingapp.utils;

import java.awt.PageAttributes;
import java.util.ArrayList;

import com.revature.bankingapp.entities.person.Person;

public class AuthenticationUtils {

	public static boolean checkUsernameAvailability(String username) {

		if (username.equals("Martin")) {
			return false;
		}

		return true;
	}
	
	public boolean authenticateUser(String username, String password) {
		
		Person p = new Person();
		
		SerializePerson serializer = new SerializePerson();
		
		
		
		
		return true;
	}
	
	
	
	

	public ArrayList<String> getUsernameList() {
		ArrayList<String> usernameList = new ArrayList<String>();

		return usernameList;
	}

}
