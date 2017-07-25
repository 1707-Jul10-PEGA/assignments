package com.WilliamLewis.BankingApp.BankData;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;

import com.WilliamLewis.BankingApp.BankData.Accounts.Account;
import com.WilliamLewis.BankingApp.JDBC.DoAs.AccountImplementDOA;
import com.WilliamLewis.BankingApp.JDBC.DoAs.UserImplementDOA;
import com.WilliamLewis.BankingApp.Users.User;
/**
 * BankData is the class that does most of the heavy lifting and all the information storage,
 * it is this class that is read upon start and written to .txt at program end
 * Tracks Accounts, all Users, the pairings of accounts to their IDs and all current applications to be processed.
 * @author William
 * Refactor note: Find a way to do this project without a singleton.
 */
public class BankData implements Serializable {
	private static BankData theBank;

	private Map<Integer, User> mapUserIDToUser;
	private ArrayList<Account> currentAccounts;
	private ArrayList<Account> currentApplications;
	
	private static final long serialVersionUID = 7526472295622776147L;
	private String filename = "BankData.txt";
	
	private static Logger log = Logger.getRootLogger();

	private BankData() {		
		this.currentApplications = new ArrayList<Account>();
		this.currentAccounts = new ArrayList<Account>();
		this.mapUserIDToUser = new HashMap<Integer, User>();
		log.trace("Empty BankData build");
	}
	

	public static BankData getInstance() {
		if (theBank == null) {
			log.trace("Rebuilding BankData ..");
			theBank = new BankData();
				log.debug("Starting DB inititalize");
				theBank.initializeFromDB();
				log.debug("DB accessed");
			
			log.trace("Returning Bank");
			return theBank;
		}
		return theBank;
	}


	
	private void initializeFromDB(){
		log.debug("Hello");
		ArrayList<User> myUsers;
		try {
			//log.debug("DataBank is Calling get all Users");
			myUsers = UserImplementDOA.getInstance().getAllUsers();
			for(User us : myUsers){
				this.mapUserIDToUser.put(us.getUserID(), us);
				log.debug("user added");
				}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			log.debug("Failed to retrieve all users");
			e.printStackTrace();
		}
		//log.debug("Successfully got all users, attempting to build hashmap");
		
		try {
			//log.debug("Built hashmap, attempting to get all Accounts");
			this.currentAccounts = AccountImplementDOA.getInstance().getAllActiveAccounts();
			log.debug("Added all accounts");
		} catch (SQLException e) {
			log.debug("failed to retrieve all active accounts");
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try{
			this.currentApplications = AccountImplementDOA.getInstance().getAllPendingAccounts();
		}catch (SQLException e) {
			log.debug("failed to retrieve Pending Accounts");
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		//Populate Users
		//THEN populate accounts, as account creation relies on looking at the userlist
		
	}


	public Account getAccount(Integer accID) {
		for(Account x : this.currentAccounts){
			if(x.getAccountNumber() == accID)
			{
				return x;
			}
		}
		log.debug("Cannot get account from BankData List");
		return null;

	}

	public ArrayList<Account> getAccountList() {
		return this.currentAccounts;
	}

	/**
	 * 
	 * @param acc
	 *            Take a newly created account object to be added to our List of
	 *            Accounts
	 * @param key
	 *            Associated value, based on the AccountID
	 */
	public void addAccount(Account acc, Integer key) {
		log.debug("Size of map before adding account: " + this.currentAccounts.size());
		if(acc.getOwnerID() == -1)
		{
			log.error("Invalid account (No owner in Database!)");
			return;
		}
		this.currentAccounts.add(acc);
		this.mapUserIDToUser.put(acc.getOwnerID(), acc.getMyOwner());
		try {
			AccountImplementDOA.getInstance().createAccount(acc, acc.getOwnerID(), acc.getAccountManagerID());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			log.error("Faild to add new account to Database");
			e.printStackTrace();
		}
		log.debug("Successfully added the following account: " + acc.toString());
		log.debug("Size of map after adding account: " + this.currentAccounts.size());

	}
	public void updateAccount(Account acc, Integer accID)
	{
		
		//Get the account and remove it, then add this updated account in
		this.currentAccounts.remove(this.getAccount(accID));
		this.currentAccounts.add(acc);
		
	}


	
	/*
	 * The following methods all work to keep track of applications for an account
	 * Refactor note: perhaps move these to the AcountApplication class, or some helper class.
	 */
	public void addApp(Account acc) {
		this.currentApplications.add(acc);
	}
	/**
	 * Removes application from the BankData lists and from the relevant employee;=
	 * @param aa acountapplication to be removed GUI
	 */
	public void removeApp(Account aa) {
		
				currentApplications.remove(aa);
			
	}

	public void approveApplication(Account acc) {
		//Add a call to the AccountDoA
		try {
			AccountImplementDOA.getInstance().approveAccount(acc);
			currentAccounts.add(acc);
			currentApplications.remove(acc);
		} catch (SQLException e) {
			log.error("BankData struggled to approve this account!");
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public ArrayList<Account> getCurrentApplicationAccounts() {
		return currentApplications;
	}
	
	
	public void addUser(User user){
		try {
			this.mapUserIDToUser.put(UserImplementDOA.getInstance().getUserIdOnLogin(user.getUsername(), user.getPassword()), user);
		} catch (SQLException e) {
			log.error("OH JEEZ WE COULDN'T ADD THAT USER IN BANKDATA FOR YOU");
			e.printStackTrace();
		}
	}
	public User getUserByID(Integer userID){
		if(this.mapUserIDToUser.get(userID) == null)
		{
			log.error("Could not get User from our userlist to tie to this account");
		}
		return this.mapUserIDToUser.get(userID);
	}
	//Returns false if this exists
	public boolean freeID(Integer idToCheck){
		for(Account acc: currentAccounts)
		{
			if(idToCheck == acc.getAccountNumber())
			{
				return false;
			}
		}
		return true;
	
	}
	public ArrayList<Account> getHolderAccounts(Integer userID)
	{
		ArrayList<Account> myAccs = new ArrayList<Account>();
		for(Account ee : this.currentAccounts)
		{
			if(userID == ee.getAccountHolderID())
			{
				myAccs.add(ee);
			}
		}
		
		return myAccs;
	}
	public ArrayList<Account> getManagedAccounts(Integer userID)
	{
		ArrayList<Account> myAccs = new ArrayList<Account>();
		for(Account ee : this.currentAccounts)
		{
			if(userID == ee.getAccountManagerID())
			{
				myAccs.add(ee);
			}
		}
		
		return myAccs;
	}

}
