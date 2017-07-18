package com.aw.bank_app.driver;

public class Actions {

	public void ResetUsernameAndPassword(String username, String password){
		username = "";
		password = "";
		return {username, password};
	}
}
