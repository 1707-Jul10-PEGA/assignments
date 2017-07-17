package com.MS.BankApp;

import java.io.FileReader;
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
		bankapp.generateFiller();
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

		try (BufferedReader br = new BufferedReader(new FileReader(file))) {
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
		       
		      /* logger.debug("Read: privileges=" + privlist[i] + " name=" + namelist[i]
		    		   + " acctno=" + acctlist[i] + " checking=" + checlist[i] + " savings="
		    		   + savlist[i] + " assignedto=" + assignedto[i] + " request to open="
		    		   +requests[i]);*/
		       i++;
		    }
		    i=0;
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
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
		
		String admin = "admin:Alice:0:null:null:null:null";
		String employee1 = "employee:Bob:0:null:null:null:null";
		String employee2 = "employee:Charlie:0:null:null:null:null";
		String customer1 = "customer:Dave:1:100000:null:Bob:null:";
		String customer2 = "customer:Erin:2:50.5:300:Bob:null";
		String customer3 = "customer:Frank:0:null:null:Bob:null";
		
		
		
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
		
	}

}
