package com.revature.banking;

import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.sql.Statement;


public class Main{
	static Logger Log = Logger.getRootLogger();
	public static ArrayList<User> customerBA = new ArrayList<User>();
	public static ArrayList<User> employeeBA = new ArrayList<User>();
	public static ArrayList<User> adminBA = new ArrayList<User>();
	public static ArrayList<Application> application = new ArrayList<Application>();
	private Scanner input = new Scanner(System.in);
	public static UserFactory uFactory = new UserFactory();
	public static Connection conn = null;
	private static BankAccountFactory bFactory = new BankAccountFactory();
	
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
		conn = ConnectionFactory.getInstance().getConnection();
		//readCustomerFile();
		//readEmployeeFile();
		//readAdministratorFile();
		//readBankAccountFile();
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
					+ "[3]check applications [4]manage customer-employee [5]logout");
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
						System.out.println("What would you like to modify? [1]account name [2]balance [3]type [4]Interest");
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
											save.getAcctName(), "checking", save.getBalance(), save.getInterest(),accNum,save.getCID()));
								}
							}
							else {
								System.out.println("Are you sure you want to change this account to a saving account? [y|n]");
								if(input.nextLine().equals("y")) {
									System.out.println("Enter new interest: ");
									double interest = Double.parseDouble(input.nextLine());
									Main.bankAcc.set(accNum, new BankAccountFactory().createBankAccount(
											save.getAcctName(), "checking", save.getBalance(), interest, accNum,save.getCID()));
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
					System.out.println("What is the customer id?");
					int c1 = Integer.parseInt(input.nextLine());
					System.out.println("What is the employee id?");
					int e1 = Integer.parseInt(input.nextLine());
					currentUser.setEmployeeToCustomer(c1,e1);
					break;	
				case 5:
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
			Log.trace("User Input:" + type);
			if (type > 0 && type < 4){
				Log.trace("User Login");
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
				Log.trace("Attempting Login");
				int UID = login(uName,pWord);
				if(UID > -1) {
					try {
						Log.trace("returning user: " + UID);
						return getUserFromDB(UID);
					} catch (SQLException e) {
						e.printStackTrace();
					}
				}
//				for(int i = 0; i < ba.size(); i++) {
//					if(ba.get(i).login(uName,pWord)) {
//						return ba.get(i);
//					}
//					Log.trace("Login-Loop search user:"+ i);
//				}
				
				Log.trace("User Not Found in Login: " + UID);
				System.out.println("\n|     User not found!     |\n");
			}
			else if(type == 4) {
				User u = uFactory.createUserWithConsoleInput(customerBA.size());
				try {
					if(u != null) {
						u.saveUser();
					}
				} catch (SQLException e) {
					System.out.println("Error: User not add to DB: "+ u);
					e.printStackTrace();
				}
				return u;
			}
			else if(type == 5) {
				return null;
			}
			System.out.println("Error: Invalid Input!");
		}
		return null;
		
	}
	
	public int login(String username, String password) {
		Main.Log.trace("Login: " + username + ":" + password);
		try {
			Connection conn = ConnectionFactory.getInstance().getConnection();
			String sql = "select USERID, password from bank_user where username =  \'" + username + "\'";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			Statement s = conn.createStatement();
			ResultSet rs = s.executeQuery(sql);
			while(rs.next()) {
				Main.Log.trace("ResultSet?: " + rs.getInt(1) + " " + rs.getString(2) );
				if(password.equalsIgnoreCase(rs.getString(2))) {
					return rs.getInt(1);
				}
			}
		} catch (SQLException e) {	
			e.printStackTrace();
		}
		
		return -1;
	}
/*	
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
				
				
				uFactory.createUser("customer", data[0], data[1], Integer.parseInt(data[2]),data[3],data[4],data[5],data[6], accountIndex,customerBA.size(),-1);
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
				
				uFactory.createUser("employee", data[0], data[1], Integer.parseInt(data[2]),data[3],data[4],data[5],data[6], accountIndex,-1, -1);
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

				uFactory.createUser("admin", data[0], data[1], Integer.parseInt(data[2]),data[3],data[4],data[5],data[6], accountIndex,-1,-1);
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
				getbFactory().createBankAccount(line[0],line[2], Double.parseDouble(line[1]), Double.parseDouble(line[3]));
			}
		}
		catch(Exception e) {
			System.out.println("Read BankAccount File Fail!\n");
			Log.trace("Read BankAccount File Fail!");
			e.printStackTrace();
		}
	}*/
		
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
	
	public User getUserFromDB(int id) throws SQLException{
		Connection conn = ConnectionFactory.getInstance().getConnection();
		String sql = "select * from BANK_USER U where U.USERID = " + id;
		Statement s = conn.createStatement();
		ResultSet rs = s.executeQuery(sql);
		String type = "";
		while(rs.next()) {
			if(rs.getInt(7) == 0) {
				type = "admin";
			}
			else if(rs.getInt(7) == 1) {
				type = "employee";
			}
			else if(rs.getInt(7) == 2) {
				type = "customer";
			}
			return Main.uFactory.createUser(type, rs.getString(2), rs.getString(3), rs.getInt(4), rs.getString(5), rs.getString(6), 
					rs.getString(8),rs.getString(9), null, -1, rs.getInt(1));
		}
			
		return null;

	}
	

	public static void main(String[] args) {
		String log4jConfigPath = "C:\\Users\\hy150\\Desktop\\Revature\\workspace\\BankingApplication\\src\\main\\resources\\log4j.properties";
		PropertyConfigurator.configure(log4jConfigPath);
		Main main = new Main();
		main.run();
	}

	public static BankAccountFactory getbFactory() {
		return bFactory;
	}

	public void setbFactory(BankAccountFactory bFactory) {
		this.bFactory = bFactory;
	}
}
