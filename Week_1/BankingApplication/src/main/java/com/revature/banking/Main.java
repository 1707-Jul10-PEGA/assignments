package com.revature.banking;


import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;


public class Main {
	static Logger Log = Logger.getRootLogger();
	public static ArrayList<User> customerBA = new ArrayList<User>();
	public static ArrayList<User> employeeBA = new ArrayList<User>();
	public static ArrayList<User> adminBA = new ArrayList<User>();
	public static ArrayList<Application> application = new ArrayList<Application>();
	private Scanner input = new Scanner(System.in);
	public UserFactory uFactory = new UserFactory();
	private BankAccountFactory bFactory = new BankAccountFactory();
	
	public static ArrayList<BankAccount> bankAcc = new ArrayList<BankAccount>();
	
	public Main() {
		init();
	}
	
	public void init() {
		Log.trace("Main Init()");
		System.out.println("   _____________________________");
		System.out.println("===|                           |===");
		System.out.println("===|    Welcome to SomeBank    |===");
		System.out.println("===|___________________________|===\n");
		readCustomerFile();
		readEmployeeFile();
		readAdministratorFile();
		readBankAccountFile();
		Log.trace("Finish running Init");
	}
	
	public void run() {
		Log.trace("Main Run()");
		boolean isRunning = true;
		while(isRunning) {
			User currentUser = getUser();
			if(currentUser != null) {
				System.out.println("Welcome " + currentUser.getFirstName() + " " + currentUser.getLastName() + "!");
				switch(currentUser.getType()) {
				case "customer":
					CustomerMenu((Customer)currentUser);
					break;
				case "employee":
					employeeMenu((Employee)currentUser);
					break;
				case "admin":
					adminMenu((Administrator)currentUser);
					break;
				}
				
			}
			System.out.println("Do you want to exit the program? [y|n]");
			if("y".equals(input.nextLine())) {
				System.out.println("Exiting......");
				Log.trace("Exiting.....\nPrint all list:\n Customer:\n" + customerBA + "\nEmployee:\n" + employeeBA + "\nAdministrator:\n" + adminBA);
				writeFiles();
				isRunning = false;
			}
			
		}
	}
	
	public void writeFiles() {
		Log.trace("Writing All File");
		try {
			BufferedWriter bw = new BufferedWriter(new FileWriter("src/main/resources/customer.txt"));
			for(User c: customerBA) {
				Customer thisCustomer = (Customer) c;
				String acctList = "";
				for(int i = 0; i <  thisCustomer.getAcctIndex().size(); i++) {
					if(i == thisCustomer.getAcctIndex().size()-1) {
						acctList += thisCustomer.getAcctIndex().get(i);
					}
					else {
						acctList += thisCustomer.getAcctIndex().get(i) + "-";
					}
					
				}
				bw.write(thisCustomer.getFirstName() + ":" + thisCustomer.getLastName()+ ":" + thisCustomer.getAge() 
					+ ":" + thisCustomer.getPhone() + ":" + thisCustomer.getAddress() + ":" +
					thisCustomer.getUsername() + ":" + thisCustomer.getPassword() + ":" + acctList);
				bw.newLine();
			}
			bw.close();
			
			bw = new BufferedWriter(new FileWriter("src/main/resources/employee.txt"));
			for(User c: employeeBA) {
				Employee thisEmployee = (Employee) c;
				String acctList = "";
				for(int i = 0; i <  thisEmployee.getCustomerList().size(); i++) {
					if(i == thisEmployee.getCustomerList().size()-1) {
						acctList += thisEmployee.getCustomerList().get(i);
					}
					else {
						acctList += thisEmployee.getCustomerList().get(i) + "-";
					}
					
				}
				bw.write(thisEmployee.getFirstName() + ":" + thisEmployee.getLastName()+ ":" + thisEmployee.getAge() 
					+ ":" + thisEmployee.getPhone() + ":" + thisEmployee.getAddress() + ":" +
					thisEmployee.getUsername() + ":" + thisEmployee.getPassword() + ":" + acctList);
				bw.newLine();
			}
			bw.close();
			
			bw = new BufferedWriter(new FileWriter("src/main/resources/admin.txt"));
			for(User c: adminBA) {
				Administrator thisAdmin = (Administrator) c;
				bw.write(thisAdmin.getFirstName() + ":" + thisAdmin.getLastName()+ ":" + thisAdmin.getAge() 
					+ ":" + thisAdmin.getPhone() + ":" + thisAdmin.getAddress() + ":" +
					thisAdmin.getUsername() + ":" + thisAdmin.getPassword() + ":" + 0);
				bw.newLine();
			}
			bw.close();
			
			bw = new BufferedWriter(new FileWriter("src/main/resources/account.txt"));
			for(BankAccount ba: bankAcc) {
				if("saving".equals(ba.getType())) {
					bw.write(ba.getAcctName()+" "+ba.getBalance()+ " " + ba.getType() + " " + (((SavingAccount) ba).getInterest()));
				}
				else {
					bw.write(ba.getAcctName()+" "+ba.getBalance()+ " " + ba.getType() + " " + 0);
				}
				bw.newLine();
			}
			bw.close();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	private void adminMenu(Administrator currentUser) {
		Log.trace("Main AdminMenu");
		int runNum = 0;
		boolean isRunning = true;
		while(isRunning) {
			
			Log.trace("isRunning in adminMenu: " + runNum);
			runNum++;
			
			System.out.println("What do you want to do? [1]view all Account balances [2]modify account "
					+ "[3]check applications [4]logout");
			int i = Integer.parseInt(input.nextLine());
			switch(i) {
				case 1:
					for(User user: Main.getCustomerBA()) {
						Customer customer = (Customer)user;
						System.out.println("\t" + customer.getFirstName() + " " + customer.getLastName());
						for(Integer acc: customer.getAcctIndex()) {
							System.out.print("\t\t[" + acc + "]" + bankAcc.get(acc));
						}
					}
					break;
				case 2:
					System.out.println("Which account would you like to modify?");
					for(User user: Main.getCustomerBA()) {
						Customer customer = (Customer)user;
						System.out.println("\t" + customer.getFirstName() + " " + customer.getLastName());
						for(Integer acc: customer.getAcctIndex()) {
							System.out.print("\t\t[" + acc + "]" + bankAcc.get(acc));
						}
					}
					int accNum = Integer.parseInt(input.nextLine());
					BankAccount current = bankAcc.get(accNum);
					SavingAccount save;
					System.out.println(current);
					if(current.getType().equals("saving")) {
						save = (SavingAccount) current;
						System.out.println("What would you like to modify? [1]account name [2]balance [3]type [4]savingInterest");
						int choice = Integer.parseInt(input.nextLine());
						switch(choice) {
						case 1:
							System.out.println("Enter new account name: ");
							String name = input.nextLine();
							save.setAcctName(name);
							Main.bankAcc.set(accNum, save);
							break;
						case 2:
							System.out.println("Enter new balance: ");
							double balance = Double.parseDouble(input.nextLine());
							save.setBalance(balance);
							Main.bankAcc.set(accNum, save);
							break;
						case 3:
							if(current.getType().equals("saving")) {
								System.out.println("Are you sure you want to change this account to a checking account? [y|n]");
								if(input.nextLine().equals("y")) {
									Main.bankAcc.set(accNum, new BankAccountFactory().createBankAccount(
											save.getAcctName(), "checking", save.getBalance(), save.getInterest()));
								}
							}
							else {
								System.out.println("Are you sure you want to change this account to a saving account? [y|n]");
								if(input.nextLine().equals("y")) {
									System.out.println("Enter new interest: ");
									double interest = Double.parseDouble(input.nextLine());
									Main.bankAcc.set(accNum, new BankAccountFactory().createBankAccount(
											save.getAcctName(), "checking", save.getBalance(), interest));
								}
							}
							
							break;
						case 4:
							System.out.println("Enter new interest: ");
							double interest = Double.parseDouble(input.nextLine());
							save.setInterest(interest);
							Main.bankAcc.set(accNum, save);
							break;
						}
					}
					
					break;
				case 3:
					boolean done = false;
					while(!done) {
						System.out.println("Looking at application....");
						if(application.size() < 1)
						{
							System.out.println("No Application to check.");
							done = true;
							break;
						}
						System.out.println(getApplication());
						System.out.println("What would you like to do? [1]approve [2]deny [3]quit");
						int choice = Integer.parseInt(input.nextLine());
						switch(choice) {
						case 1:
							currentUser.approveApplication(0);
							break;
						case 2:
							currentUser.denyApplication(0);
							break;
						case 3:
							done= true;
							break;
							}
					}
					break;
				case 4:
					System.out.println("GoodBye");
					isRunning = false;
					break;	
			}
		}

		
	}

	private void employeeMenu(Employee currentUser) {
		Log.trace("Main employeeMenu");
		int runNum = 0;
		boolean isRunning = true;
		while(isRunning) {
			
			Log.trace("isRunning in employeeMenu: " + runNum);
			runNum++;
			
			System.out.println("What do you want to do? [1]view all customer Account balances [2]check applications [3]logout");
			int i = Integer.parseInt(input.nextLine());
			switch(i) {
				case 1:
					for(Integer index: currentUser.getCustomerList()) {
						Customer customer = (Customer) customerBA.get(index);
						System.out.println("\t" + customer.getFirstName() + " " + customer.getLastName());
						for(Integer acc: customer.getAcctIndex()) {
							System.out.print("\t\t[" + acc + "]" + bankAcc.get(acc));
						}
					}
					break;
				case 2:
					boolean done = false;
					while(!done) {
						System.out.println("Looking at application....");
						if(application.size() < 1)
						{
							System.out.println("No Application to check.");
							done = true;
							break;
						}
						System.out.println(getApplication());
						System.out.println("What would you like to do? [1]approve [2]deny [3]quit");
						int choice = Integer.parseInt(input.nextLine());
						switch(choice) {
						case 1:
							currentUser.approveApplication(0);
							break;
						case 2:
							currentUser.denyApplication(0);
							break;
						case 3:
							done= true;
							break;
							}
					}
					break;
				case 3:
					System.out.println("You have Logout!\nGoodBye");
					isRunning = false;
					break;	
			}
		}
		
	}

	private void CustomerMenu(Customer currentUser) {
		Log.trace("Main CustomerMenu");
		boolean isRunning = true;
		int accountId;
		while(isRunning) {
			System.out.println("What do you want to do? [1]view all balances [2]deposit "
					+ "[3]withdraw [4]apply for an account [5]logout");
			int i = Integer.parseInt(input.nextLine());
			switch(i) {
				case 1:
					currentUser.displayAccounts();
					break;
				case 2:
					System.out.println("Which account would you like to deposit to?");
					if(!currentUser.displayAccounts()) {
						break;
					}
					accountId = Integer.parseInt(input.nextLine());
					if(currentUser.hasAccount(accountId)) {
						System.out.println("How much do you want to deposit?");
						double amount = Double.parseDouble(input.nextLine());
						currentUser.deposit(accountId, amount);
						System.out.println(Main.getBankAcc().get(accountId));
					}
					else {
						System.out.println("Invalid Input");
					}
					break;
				case 3:
					System.out.println("Which account would you like to withdraw from?");
					if(!currentUser.displayAccounts()) {
						break;
					}
					accountId = Integer.parseInt(input.nextLine());
					if(currentUser.hasAccount(accountId)) {
						System.out.println("How much do you want to withdraw?");
						double amount = Double.parseDouble(input.nextLine());
						currentUser.withdraw(accountId, amount);
						System.out.println(Main.getBankAcc().get(accountId));
					}
					else {
						System.out.println("Invalid Input");
					}
					
					break;
				case 4:
					currentUser.applyForAccount();
					break;
				case 5:
					System.out.println("GoodBye");
					isRunning = false;
					break;
			}	
		}

		
	}

	public User getUser() {
		Log.trace("Main getUser");
		String uName;
		String pWord;
		ArrayList<User> ba = customerBA; // copy of customerBA, employeeBA, or adminBA
		boolean invalidInput = true;
		while(invalidInput) {
			System.out.println("Please enter a number for type of account: [1] customer, [2] employee, [3] administrator, [4] new user, [5] exit");
			int type = Integer.parseInt(input.nextLine());
			//check if input value is lower than 1 or higher than 4. Input error message if true!
			
			if (type > 0 && type < 4){
				System.out.println("Username:");
				uName = input.nextLine();
				System.out.println("Password:");
				pWord = input.nextLine();
				switch(type) {
					case 2:
						ba = employeeBA;
						break;
					case 3:
						ba = adminBA;
						break;
				}
				for(int i = 0; i < ba.size(); i++) {
					if(ba.get(i).login(uName,pWord)) {
						return ba.get(i);
					}
				}
				System.out.println("\n|     User not found!     |\n");
			}
			else if(type == 4) {
				return uFactory.createUserWithConsoleInput(customerBA.size());
			}
			else if(type == 5) {
				return null;
			}
			System.out.println("Error: Invalid Input!");
		}
		return null;
		
	}
	
	public int readCustomerFile(){
		Log.trace("Main readCustomerFile()");
		int index = customerBA.size();
		String[] data = null;
		try{
			Scanner sc = new Scanner(new FileReader("src/main/resources/customer.txt"));
			while(sc.hasNext()) {
				data = sc.nextLine().split(":");
				ArrayList<Integer> accountIndex = new ArrayList<Integer>();
				if(data.length >= 8) {
					String[] acctIndex = data[7].split("-");
					for(String s: acctIndex) {
						accountIndex.add(Integer.parseInt(s));
					}
				}
				
				
				uFactory.createUser("customer", data[0], data[1], Integer.parseInt(data[2]),data[3],data[4],data[5],data[6], accountIndex,customerBA.size());
				index++;
			}
		}
		catch(Exception e) {
			System.out.println("Read Customer File Fail!\n");
			e.printStackTrace();
		}
		return index;
	}
	
	public void readEmployeeFile(){
		Log.trace("Main readEmployeeFile");
		String[] data = null;
		try {
			Scanner sc = new Scanner(new FileReader("src/main/resources/employee.txt"));
			
			while(sc.hasNext()) {
				data = sc.nextLine().split(":");
				ArrayList<Integer> accountIndex = new ArrayList<Integer>();
				if(data.length >= 8) {
					String[] acctIndex = data[7].split("-");
					for(String s: acctIndex) {
						accountIndex.add(Integer.parseInt(s));
					}
				}
				
				uFactory.createUser("employee", data[0], data[1], Integer.parseInt(data[2]),data[3],data[4],data[5],data[6], accountIndex,-1);
			}
		}
		catch(Exception e) {
			System.out.println("Read Employee File Fail!\n");
			e.printStackTrace();
		}
	}
	
	public void readAdministratorFile(){
		Log.trace("Main readAdministratorFile");
		String[] data = null;
		try {
			Scanner sc = new Scanner(new FileReader("src/main/resources/admin.txt"));
			
			while(sc.hasNext()) {
				data = sc.nextLine().split(":");
				ArrayList<Integer> accountIndex = new ArrayList<Integer>();
				if(data.length >= 7) {
					String[] acctIndex = data[7].split("-");
					for(String s: acctIndex) {
						accountIndex.add(Integer.parseInt(s));
					}
				}

				uFactory.createUser("admin", data[0], data[1], Integer.parseInt(data[2]),data[3],data[4],data[5],data[6], accountIndex,-1);
			}
			sc.close();
		}
		catch(Exception e) {
			System.out.println("Read Admin File Fail!\n");
			Log.trace("Read AdminFile Fail!");
			e.printStackTrace();
		}
	}
	
	public void readBankAccountFile() {
		try {
			Scanner sc = new Scanner(new FileReader("src/main/resources/account.txt"));
			while(sc.hasNext()) {
				String[] line = sc.nextLine().split(" ");
				bFactory.createBankAccount(line[0],line[2], Double.parseDouble(line[1]), Double.parseDouble(line[3]));
			}
		}
		catch(Exception e) {
			System.out.println("Read BankAccount File Fail!\n");
			Log.trace("Read BankAccount File Fail!");
			e.printStackTrace();
		}
	}
		
	/**
	 * Get the first application in the ArrayList
	 * @return the first application
	 */
	public Application getApplication() {
		return application.get(0);
	}
	
	public static ArrayList<User> getCustomerBA() {
		return customerBA;
	}

	public static void setCustomerBA(ArrayList<User> customerBA) {
		Main.customerBA = customerBA;
	}
	
	public ArrayList<User> addUserToCustomerBA(User user){
		customerBA.add(user);
		return customerBA;
	}
	
	public ArrayList<User> addUserToEmployeeBA(User user){
		employeeBA.add(user);
		return employeeBA;
	}
	public ArrayList<User> addUserToAdministratorBA(User user){
		adminBA.add(user);
		return adminBA;
	}

	public static ArrayList<User> getEmployeeBA() {
		return employeeBA;
	}

	public static void setEmployeeBA(ArrayList<User> employeeBA) {
		Main.employeeBA = employeeBA;
	}

	public static ArrayList<User> getAdminBA() {
		return adminBA;
	}

	public static void setAdminBA(ArrayList<User> adminBA) {
		Main.adminBA = adminBA;
	}


	public static ArrayList<BankAccount> getBankAcc() {
		return bankAcc;
	}

	public static void setBankAcc(ArrayList<BankAccount> bankAcc) {
		Main.bankAcc = bankAcc;
	}

	public static void main(String[] args) {
		String log4jConfigPath = "C:\\Users\\hy150\\Desktop\\Revature\\workspace\\BankingApplication\\src\\main\\resources\\log4j.properties";
		PropertyConfigurator.configure(log4jConfigPath);
		Main main = new Main();
		main.run();
	}
}
