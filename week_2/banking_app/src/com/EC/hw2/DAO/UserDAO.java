package com.EC.hw2.DAO;

import com.EC.hw1.Model.User;

public interface UserDAO {
	
	public boolean usernameExist(String username);

	public boolean applyForAccount(User u);
	
	public boolean assignBanker(int c_id);
	
	public User getUser(String username);
}
