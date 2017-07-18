package com.interfaces.login_implement;

import java.io.FileNotFoundException;
import java.util.Set;

import org.apache.log4j.Logger;

import com.interfaces.Login;
import com.users.AllUsers;
import com.users.User;

public class BasicLogin implements Login{

	private Logger log = Logger.getRootLogger();
	@Override
	public User login(String userName, String password) {
		AllUsers.getInstance();
		try {
			AllUsers.readAllUsers();
		} catch (FileNotFoundException e) {
			log.fatal("User database not found! (AllUsers.txt)");
			e.printStackTrace();
		}
		for(Set<User> l1 : AllUsers.users){
			for(User usr : l1){
				if(usr.getUserName().equals(userName) && usr.getPassword().equals(password)){
					return usr;
				}
			}
		}
		System.out.println("  ** Incorrect username or password.");
		log.warn("Incorrect login, username: "  + userName + " , password: " + password);
		return null;
	}


}
