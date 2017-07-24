package com.WilliamLewis.BankingApp.Users;

import java.util.List;

import com.WilliamLewis.BankingApp.BankData.BankData;
import com.WilliamLewis.BankingApp.BankData.Accounts.Account;
/**
 * This implementation makes no use of User, but it's on the refactoring list to make a general user that
 * each specific type of user extends, should help clean up a lot of redundent code, and simplify logic for GUI.
 * @author William
 *Some things to note about all three implemented users
 *All of them add themselves to the BankData upon creation
 *All of them have a means to access accounts, Customer and Employee hold accountIDs to access acounts relevent to them
 *
 */
public abstract class User {
	private String Username;
	private String password;
	private String FirstName;
	private String LastName;
	private Integer userID;
	
	public User(){
		{
			BankData.getInstance().addUser(this);
		}
		
	}
	public User(String username, String password, String firstName, String lastName)
	{
		this.setUsername(username);
		this.setPassword(password);
		this.setFirstName(firstName);
		this.setLastName(lastName);
		BankData.getInstance().addUser(this);
	}
	public User(Integer userID, String username, String password, String firstName, String lastName)
	{
		this.setUsername(username);
		this.setPassword(password);
		this.setFirstName(firstName);
		this.setLastName(lastName);
		this.setUserID(userID);
		BankData.getInstance().addUser(this);
	}
	
	public String getUsername() {
		return Username;
	}
	protected void setUsername(String username) {
		Username = username;
	}
	public String getPassword() {
		return password;
	}
	protected void setPassword(String password) {
		this.password = password;
	}
	public String getFirstName() {
		return FirstName;
	}
	protected void setFirstName(String firstName) {
		FirstName = firstName;
	}
	public String getLastName() {
		return LastName;
	}
	protected void setLastName(String lastName) {
		LastName = lastName;
	}
	public Integer getUserID() {
		return userID;
	}
	protected void setUserID(Integer userID) {
		this.userID = userID;
	}
	

}
