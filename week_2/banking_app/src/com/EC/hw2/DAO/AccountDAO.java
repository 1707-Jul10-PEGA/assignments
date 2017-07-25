package com.EC.hw2.DAO;

import java.util.Date;

public interface AccountDAO {
	
	public Date getLastLogin(String username);
	
	public boolean updateLastLogin(int u_id);
	
	
	
}
