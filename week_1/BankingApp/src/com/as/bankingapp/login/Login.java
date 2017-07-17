package com.as.bankingapp.login;

import java.util.Iterator;
import java.util.List;

import com.as.bankingapp.user.User;

public class Login {

	public static User login(String user, String pass, List<User> l) {
		Iterator<User> iter = l.iterator();
		User activeUser = null;
		while (iter.hasNext()) {
			User u = iter.next();
			if (u.getUserName().equals(user)) {
				if (u.getPassword().equals(pass)) {
					activeUser = u;
				}
			}
		}
		return activeUser;
	}
}
