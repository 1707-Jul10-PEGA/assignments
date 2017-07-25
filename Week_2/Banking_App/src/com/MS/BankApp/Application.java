package com.MS.BankApp;

import java.io.FileReader;
import com.MS.OJDBC.*;
import java.sql.*;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;
import org.apache.log4j.Logger;


public class Application implements Serializable{
	
	public static File file = new File("src\\com\\MS\\BankApp\\data.txt");
	public static String[] namelist = new String[20];
	public static String[] privlist = new String[20];
	public static String[] acctlist = new String[20];
	public static String[] checlist = new String[20];
	public static String[] savlist = new String[20];
	public static String[] assignedto = new String[20];
	public static String[] requests = new String[20];
	public static int userid;
	public static int newusercount = 6;
	
	final static Logger logger = Logger.getLogger(Application.class);


	/*
	 * Sets up and reads starting filler data. Then loops forever in the main function.
	 */
	public static void main(String[] args) {
		//Generate log for each customer request
		Application bankapp = new Application();
		//bankapp.generateFiller();
		bankapp.readFiller();
		
		/*
		 * Asks for username credentials. Once those are delivered, it transfers
		 * to a menu of the specific user type. While the admins and employees
		 * are set at the start, any new usernames are registered as new customers.
		 * If null (or "") is entered as a username, the program rejects it.
		 */
		for(;;)
		{
		String name = bankapp.inputName();
		String priv = bankapp.login(name);
		
		switch(priv)
		{
		case("admin"):
		{
			Admin admin = new Admin(name);
			admin.menu();
			break;
			
		}
		case("employee"):
		{
			Employee employee = new Employee(name);
			employee.menu();
			break;
		}
		case("customer"):
		{
			Customer customer = new Customer(name, acctlist[userid], checlist[userid], savlist[userid]);
			customer.menu();
			break;
		}
		default:
		{
			logger.error("Error: Account privileges not found\n");
			break;
		}
		}
		
		}
		
		

	}
	/*
	 * Basic function that scans for and returns a username.
	 */
	private String inputName() {
		// TODO Auto-generated method stub
		logger.info("Please type in username: ");
		Scanner scan = new Scanner(System.in);
		String name = scan.nextLine();
		//scan.close();
		
		return name;
	}
	
	/*
	 * Checks the privileges of the login name. Returns null if invalid username.
	 */
	public String login(String name) {
		// TODO Auto-generated method stub
		
		for(int i = 0; i<newusercount; i++)
		{
			if(name.equals(namelist[i]))
			{
				userid = i;
			}
		}
		
		//Check if username is new
		if(userid==0 && !"Alice".equals(name) && !"".equals(name))
		{
			logger.info("Creating new user with name: "+ name);
			privlist[newusercount] = "customer";
			namelist[newusercount] = name;
		    acctlist[newusercount] = "0";
		    checlist[newusercount] = "null";
		    savlist[newusercount] = "null";
		    assignedto[newusercount] = "Charlie";
		    requests[newusercount] = "null";
		    userid = newusercount;
		    
		    
		    UserDAO dao = new UserDAO();
		    try {
				dao.saveUser(Integer.toString(newusercount+1), namelist[newusercount], 
				privlist[newusercount], acctlist[newusercount], checlist[newusercount], 
				savlist[newusercount], assignedto[newusercount], requests[newusercount]);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		    newusercount++;
		}
		else if("".equals(name))
		{
			logger.error("Error: Invalid username");
			return "null";
		}
		logger.debug("Logged on as " + privlist[userid]);
		return privlist[userid];
	}

	/*
	 * Reads the inputted filler data. Sets up the variables used later.
	 */
	public void readFiller() {

		/*try (BufferedReader br = new BufferedReader(new FileReader(file))) {
		    String line;
		    int i = 0;
		    while ((line = br.readLine()) != null) {
		       String[] readline = line.split(":");
		       
		       privlist[i] = readline[0];
		       namelist[i] = readline[1];
		       acctlist[i] = readline[2];
		       checlist[i] = readline[3];
		       savlist[i] = readline[4];
		       assignedto[i] = readline[5];
		       requests[i] = readline[6];
		       
		       logger.debug("Read: privileges=" + privlist[i] + " name=" + namelist[i]
		    		   + " acctno=" + acctlist[i] + " checking=" + checlist[i] + " savings="
		    		   + savlist[i] + " assignedto=" + assignedto[i] + " request to open="
		    		   +requests[i]);
		       i++;
		    }
		    i=0;
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		
		Connection conn = null;
		Statement stmt;
		ResultSet rs = null;
		
		//Load from the database
		conn = ConnectionFactory.getInstance().getConnection();
		String sql;
		sql = "SELECT * FROM USERS";
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			int dbrcounter = 0;
			while(rs.next())
			{
				namelist[dbrcounter] = rs.getString("NAME");
				privlist[dbrcounter] = rs.getString("PRIV");
				acctlist[dbrcounter] = rs.getString("ACCTNO");
				checlist[dbrcounter] = rs.getString("CHECKING");
				savlist[dbrcounter]  = rs.getString("SAVINGS");
				assignedto[dbrcounter] = rs.getString("ASSIGNEDTO");
				requests[dbrcounter] = rs.getString("REQUESTS");
				dbrcounter++;
			}
			newusercount = dbrcounter;
			System.out.println("Current number of users: " + dbrcounter);
			dbrcounter = 0;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
	}


	/*
	 * Generates filler data and creates all present admins and employees. Also
	 * generates a few starter customer accounts with assorted values present.
	 */
	public void generateFiller()
	{
		//profile name{String PRIVILEGES, String NAME, String #ofACCOUNTS, String CHECKING, String SAVINGS
		//				String ASSIGNEDTO, String REQUEST}
		Connection conn = null;
		Statement stmt;
		
		/*String admin = "admin:Alice:0:null:null:null:null";
		String employee1 = "employee:Bob:0:null:null:null:null";
		String employee2 = "employee:Charlie:0:null:null:null:null";
		String customer1 = "customer:Dave:1:100000:null:Bob:null:";
		String customer2 = "customer:Erin:2:50.5:300:Bob:null";
		String customer3 = "customer:Frank:0:null:null:Bob:checking";
		
		
		
		String[] userlist = {admin, employee1, employee2, customer1, customer2, customer3};
		
		BufferedWriter bw = null;
		FileWriter fw = null;
		try 
		{
			if (!file.exists()) 
			{
			     file.createNewFile();
			}

		
			fw = new FileWriter(file);
			bw = new BufferedWriter(fw);


		
			for(int i=0;i<userlist.length;i++)
			{
				bw.write(userlist[i]);
				bw.newLine();
			}
			
			bw.close();
			fw.close();
		
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		*/
		conn = ConnectionFactory.getInstance().getConnection();
		
		//Check for connection and drop/create table. Can be excluded at later stages for persistence
		try {
			System.out.println("Is connection closed? " + conn.isClosed());
			stmt = conn.createStatement();
			String sql;
			sql = "DROP TABLE USERS";
			stmt.executeUpdate(sql);
			logger.debug("Dropped table USERS");
			
			sql = "DROP TABLE LOGGER";
			stmt.executeUpdate(sql);
			logger.debug("Dropped table LOGGER");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			stmt = conn.createStatement();
			String sql = "CREATE TABLE USERS (ID INT, NAME VARCHAR(30), PRIV VARCHAR(10), ACCTNO VARCHAR(2), CHECKING VARCHAR(10), " +
							"SAVINGS VARCHAR(10), ASSIGNEDTO VARCHAR(30), REQUESTS VARCHAR(10), PRIMARY KEY (ID))";
			stmt.executeUpdate(sql);
			logger.debug("Created table USERS");
			
			sql = "CREATE TABLE LOGGER (LOGID NUMBER(10), TIMEST TIMESTAMP, ACTION VARCHAR(20), USR VARCHAR(30), AFFUSR VARCHAR(30), ACCT VARCHAR(10), AMOUNT VARCHAR(10))";
			stmt.executeUpdate(sql);
			logger.debug("Created table LOGGER");
		} catch (SQLException e1) {
					// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		
		//Insert the preset data for admins (name/priv only)
		UserDAO dao = new UserDAO();
		
		try {
			dao.saveUser("1","Alice", "admin", "", "", "", "", "");
			dao.saveUser("2", "Bob", "employee", "", "", "", "", "");
			dao.saveUser("3", "Charlie", "employee", "", "", "", "", "");
			dao.saveUser("4", "Dave", "customer", "1", "100000", "null", "Bob", "null");
			dao.saveUser("5", "Erin", "customer", "2", "50.5", "300", "Bob", "null");
			dao.saveUser("6", "Frank", "customer", "0", "null", "null", "Bob", "checking");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		/*try {
			stmt = conn.createStatement();
			String sql;
			sql = "INSERT INTO USERS (NAME, PRIV) VALUES ('Alice', 'admin')";
			stmt.executeUpdate(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		
		//Insert the preset data for employees (name/priv only)
		
		/*try {
			stmt = conn.createStatement();
			String sql;
			sql = "INSERT INTO USERS (NAME, PRIV) VALUES ('Bob', 'employee')";
			stmt.executeUpdate(sql);
			
			sql = "INSERT INTO USERS (NAME, PRIV) VALUES ('Charlie', 'employee')";
			stmt.executeUpdate(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		
		//Insert the preset data for customers (all data fields)
		
		/*try {
			stmt = conn.createStatement();
			String sql;
			sql = "INSERT INTO USERS (NAME, PRIV, ACCTNO, CHECKING, SAVINGS, ASSIGNEDTO, REQUESTS)"+
			"VALUES ('Dave', 'customer', 1, 100000, null, 'Bob', null)";
			stmt.executeUpdate(sql);
			
			sql = "INSERT INTO USERS (NAME, PRIV, ACCTNO, CHECKING, SAVINGS, ASSIGNEDTO, REQUESTS)"+
					"VALUES ('Erin', 'customer', 2, 50.5, 300, 'Bob', null)";
			stmt.executeUpdate(sql);
			
			sql = "INSERT INTO USERS (NAME, PRIV, ACCTNO, CHECKING, SAVINGS, ASSIGNEDTO, REQUESTS)"+
					"VALUES ('Frank', 'customer', 0, null, null, 'Bob', 'checking')";
			stmt.executeUpdate(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		
		
	}

}
