package com.WilliamLewis.BankingApp.BankData;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.WilliamLewis.BankingApp.AccountFactory.AccountFactory;
import com.WilliamLewis.BankingApp.Applications.AccountApplication;
import com.WilliamLewis.BankingApp.BankData.Accounts.Account;
import com.WilliamLewis.BankingApp.Serializers.BankDataSerializer;
import com.WilliamLewis.BankingApp.Users.Admin;
import com.WilliamLewis.BankingApp.Users.Customer;
import com.WilliamLewis.BankingApp.Users.Employee;
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
	private Map<Integer, Account> accountData;
	private ArrayList<Employee> currentEmployees;
	public ArrayList<Admin> currentAdmins;
	private Map<String, Integer> accountIDs;
	private ArrayList<AccountApplication> currentApplications;
	private ArrayList<Customer> currentCustomers;
	private static final long serialVersionUID = 7526472295622776147L;
	private String filename = "BankData.txt";
	private static Logger log = Logger.getRootLogger();

	private BankData() {
		log.trace("Building initial Hashmap");
		this.accountData = new HashMap<Integer, Account>();
		this.accountIDs = new HashMap<String, Integer>();
		this.currentEmployees = new ArrayList<Employee>();
		this.currentAdmins = new ArrayList<Admin>();
		this.currentCustomers = new ArrayList<Customer>();
		this.currentApplications = new ArrayList<AccountApplication>();
	}

	public static BankData getInstance() {
		if (theBank == null) {
			log.trace("Rebuilding BankData");
			theBank = new BankData();
			theBank.initializeData();
			return theBank;
		}
		return theBank;
	}

	// May be a call to the serializer later to retrieve data from .txt file
	private void initializeData() {
		BankDataSerializer serialize = new BankDataSerializer();
		if (serialize.readBankData(filename) == null) {
			log.error("No Bank File Found");
			return;
		}
		theBank = serialize.readBankData(filename);
		log.trace("Data has been read from: " + filename);
	}

	public void saveData() {
		BankDataSerializer serialize = new BankDataSerializer();
		serialize.writeBankData(theBank, filename);
		log.trace("Data has been saved to: " + filename);
	}

	public boolean checkID(Integer key) {
		return this.accountData.containsKey(key);
	}

	public Account getAccount(Integer key) {
		return this.accountData.get(key);
	}

	public ArrayList<Account> getAccountList() {
		ArrayList<Account> myArray = new ArrayList<Account>();
		myArray.addAll(this.accountData.values());
		return myArray;
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
		log.debug("Size of map before adding account: " + this.accountData.size());
		this.accountData.put(key, acc);
		this.accountIDs.put(acc.getAccountHolder(), key);
		log.debug("Successfully added the following account: " + acc.toString());
		log.debug("Size of map after adding account: " + this.accountData.size());

	}

	/**
	 * a
	 * 
	 * @param acc
	 *            --Account with updated values to be updated in the map
	 * @param key
	 *            -- Key of the account
	 */
	public void updateAccount(Account acc, Integer key) {
		this.accountData.remove(key);
		this.accountData.put(key, acc);
	}

	
	/*
	 * The following methods all work to keep track of applications for an account
	 * Refactor note: perhaps move these to the AcountApplication class, or some helper class.
	 */
	//Purely for quick reference 
	public void addApp(AccountApplication aa) {
		distributeApplication(aa);
	}
	/**
	 * Removes application from the BankData lists and from the relevant employee;=
	 * @param aa acountapplication to be removed
	 */
	public void removeApp(AccountApplication aa) {
		for (AccountApplication a : this.currentApplications) {
			if (aa.equals(a)) {

				currentApplications.remove(a);
				break;
			}
		}
		for (Employee e : this.currentEmployees) {
			for (AccountApplication eaa : e.pendingApplications) {
				if (aa.equals(eaa)) {
					e.pendingApplications.remove(eaa);
					break;
				}
			}
		}

	}

	public void approveApplication(AccountApplication aa) {
		// Call factory and create account, store that integer in the arraylist,
		// and give the customer an account ID to manage
		// of accounts to manage
		aa.getAccountHolder().addAccountID(AccountFactory.createAccount(aa.getAccountType(), aa.getAccountHolder().getUsername()));
		theBank.removeApp(aa);
		log.debug("Successfully approved " + aa.getAccountHolder().getUsername() + "'s application for a "
				+ aa.getAccountType() + " account");

	}
	/**
	 * Finds the employee with the least Applications to process and gives them the passed application
	 * @param aa
	 */
	public void distributeApplication(AccountApplication aa) {
		if (this.currentEmployees.isEmpty()) {
			log.debug("No Existing Employees to take Application");
			return;
		} else
			this.leastApplications().addApplication(aa);
		this.currentApplications.add(aa);
	}

	//Logic for finding the least burdened employee from the list
	public Employee leastApplications() {
		if (this.currentEmployees.isEmpty()) {
			log.debug("No Existing Employees to take Application");
			return null;
		}

		Employee least = this.currentEmployees.get(0);
		for (Employee e : this.currentEmployees) {
			if (least.getPendingApplications().size() > e.getPendingApplications().size()) {
				least = e;
			}
		}
		return least;
	}
	/**
	 * Used by the GUI to return accounts relevent to the current user
	 * @param cust
	 * @return
	 */
	public AccountApplication getAccApp(Customer cust) {
		for (AccountApplication aa : this.currentApplications) {
			if (aa.getAccountHolder().equals(cust)) {
				return aa;
			}
		}
		log.error("This customer does not have any active applications.");
		return null;
	}
	
	//End Application Methods

	//Methods for obtaining staff from the list based on username and password match
	public Employee getEmployee(String name, String password) {
		for (Employee x : this.currentEmployees) {
			if (name.equals(x.Username) && password.equals(x.getPassword())) {
				return x;
			}

		}
		log.error("No Such Employee");
		return null;
	}

	public Customer getCustomer(String name, String password) {
		for (Customer x : this.currentCustomers) {
			if (name.equals(x.getUsername()) && password.equals(x.getPassword())) {
				return x;
			}

		}
		log.error("No Such Customer");
		return null;
	}

	//Some useful getters and 'adders'

	public ArrayList<AccountApplication> getCurrentApplications() {
		return currentApplications;
	}

	public void addAdmin(Admin user) {
		this.currentAdmins.add(user);
	}

	public void addEmployee(Employee user) {
		this.currentEmployees.add(user);
	}

	public void addCustomer(Customer user) {
		this.currentCustomers.add(user);
	}

	public Integer getAccountID(String Username) {
		return this.accountIDs.get(Username);
	}

}
