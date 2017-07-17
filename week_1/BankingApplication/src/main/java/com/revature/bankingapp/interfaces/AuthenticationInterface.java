package com.revature.bankingapp.interfaces;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

import com.revature.bankingapp.entities.person.Person;

public interface AuthenticationInterface {

	
	public <T> Person userAuthentication(String username, String password, String type) throws FileNotFoundException, ClassNotFoundException, IOException;
	
	public int loginAttemptsViolation();
	
	
}
