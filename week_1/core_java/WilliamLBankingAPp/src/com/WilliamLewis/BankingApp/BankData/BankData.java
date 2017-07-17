package com.WilliamLewis.BankingApp.BankData;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.WilliamLewis.BankingApp.Applications.AccountApplication;
import com.WilliamLewis.BankingApp.BankData.Accounts.Account;
import com.WilliamLewis.BankingApp.Serializers.BankDataSerializer;
import com.WilliamLewis.BankingApp.Users.Admin;
import com.WilliamLewis.BankingApp.Users.Customer;
import com.WilliamLewis.BankingApp.Users.Employee;
import com.WilliamLewis.BankingApp.Users.User;

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

	public void addApp(AccountApplication aa) {
		distributeApplication(aa);
	}

	public void removeApp(AccountApplication aa) {
		for (AccountApplication a : this.currentApplications) {
			if (aa.equals(a))
				;
			currentApplications.remove(a);
		}
	}

	private static Logger log = Logger.getRootLogger();

	private BankData() {
		log.trace("Building initial Hashmap");
		this.accountData = new HashMap<Integer, Account>();
		this.accountIDs = new HashMap<String, Integer>();
		this.currentEmployees = new ArrayList<Employee>();
		this.currentAdmins = new ArrayList<Admin>();
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
        if(serialize.readBankData(filename) == null)
        {
        	log.error("No Bank File Found");
        	return;
        }
        theBank = serialize.readBankData(filename);
        log.trace("Data has been read from: " + filename);
	}
	public void saveData(){
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

	public void distributeApplication(AccountApplication aa) {
		if (this.currentEmployees.isEmpty()) {
			log.debug("No Existing Employees to take Application");
			return;
		} else
			this.leastApplications().addApplication(aa);
	}

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
	// public void addUser(User user, String type)
	// {
	// switch(type)
	// {
	// case "admin":
	// {
	// this.currentAdmins.add((Admin) user);
	// }
	// break;
	// case "employee":
	// this.currentEmployees.add((Employee) user);
	// break;
	// case "customer":
	// this.currentCustomers.add((Customer) user);
	// break;
	// }
	// }

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
			if (name.equals(x.Username) && password.equals(x.getPassword())) {
				return x;
			}

		}
		log.error("No Such Customer");
		return null;
	}

}
