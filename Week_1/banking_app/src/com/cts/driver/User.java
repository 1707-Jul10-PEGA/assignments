package com.cts.driver;

import java.io.Serializable;
import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.File;
import java.io.FileWriter;
import java.io.FileNotFoundException;
import java.io.IOException;
import org.apache.log4j.Logger;

public class User implements Login, Serializable
{
	protected static Logger log = Logger.getRootLogger();
	
	private static final long serialVersionUID = 1L;
	public String fname;
	public String lname;
	public boolean loggedin;
	public String username;
	public String password;
	public String type;
	public Account account;
	public String employee;
	public ArrayList<String> customers;
	public ArrayList<Account> accounts;
	
	
	public ArrayList<String> getCustomers()
	{
		return customers;
	}

	public void setCustomers(ArrayList<String> customers)
	{
		this.customers = customers;
	}
	
	public ArrayList<Account> getAccounts()
	{
		return accounts;
	}

	public void setAccounts(ArrayList<Account> accounts)
	{
		this.accounts = accounts;
	}

	public String getEmployee()
	{
		return employee;
	}

	public void setEmployee(String employee)
	{
		this.employee = employee;
	}

	public String getFname()
	{
		return fname;
	}

	public void setFname(String fname)
	{
		this.fname = fname;
	}

	public String getLname()
	{
		return lname;
	}

	public void setLname(String lname)
	{
		this.lname = lname;
	}

	public boolean isLoggedin()
	{
		return loggedin;
	}

	public void setLoggedin(boolean loggedin)
	{
		this.loggedin = loggedin;
	}

	public String getUsername()
	{
		return username;
	}

	public void setUsername(String username)
	{
		this.username = username;
	}

	public String getPassword()
	{
		return password;
	}

	public void setPassword(String password)
	{
		this.password = password;
	}

	public String getType()
	{
		return type;
	}

	public void setType(String type)
	{
		this.type = type;
	}


	public Account getAccount()
	{
		return account;
	}

	public void setAccount(Account account)
	{
		this.account = account;
	}

	public void login(String uinput, String pinput)
	{	
		log.info("LOGIN ATTEMPT FROM " + uinput + ":" + pinput);
		if (loggedin)
		{
			log.error("USER " + uinput + " IS ALREADY LOGGED IN");
			return;
		}
		//Name of the file to open
		String filename = "Data.txt";
				
		//Reference file one line at a time
		String line = "";
				
		try
		{
			//Read text file
			FileReader fr = new FileReader(filename);
			
			//Wrap FileReader in BufferedReader
			BufferedReader br = new BufferedReader(fr);
			
			customers = new ArrayList<String>();
			accounts = new ArrayList<Account>();
			
			while ((line = br.readLine()) != null)
			{
				String[] data = line.split(":");
				if (data.length >= 5)
				{
					if ("Customer".equals(data[4]) && data.length == 9)
					{
						if (uinput.equals(data[8]))
						{
							String customer = data[0];
							customers.add(customer);
							float balance = Float.parseFloat(data[5]);
							Account acc = new Account(balance);
							acc.setApplied(Boolean.parseBoolean(data[6]));
							acc.setAccepted(Boolean.parseBoolean(data[7]));
							accounts.add(acc);
						}
					}
					if (uinput.equals(data[0]) && pinput.equals(data[1]))
					{
						username = data[0];
						password = data[1];
						fname = data[2];
						lname = data[3];
						type = data[4];
						loggedin = true;
						log.info("LOGIN ATTEMPT SUCCESSFUL");
						if ("Customer".equals(type))
						{
							float balance = Float.parseFloat(data[5]);
							Account acc = new Account(balance);
							acc.setApplied(Boolean.parseBoolean(data[6]));
							acc.setAccepted(Boolean.parseBoolean(data[7]));
							account = acc;
							employee = data[8];
						}
					}
				}
			}
			
			br.close();
			fr.close();
		}
		
		//Make sure that the file could be found
		catch(FileNotFoundException e)
		{
			log.fatal("UNABLE TO FIND FILE");
		}
		
		//Make sure that the file could be read
		catch(IOException e)
		{
			log.fatal("UNABLE TO OPEN FILE");
		}
		
		if (!loggedin)
		{
			log.error("INCORRECT USERNAME/PASSWORD");
			return;
		}
		
		return;
	}
	
	public void logout()
	{
		log.info("LOGOUT ATTEMPT FROM " + username);
		if (loggedin)
		{
			log.info("LOGOUT ATTEMPT SUCCESSFUL");
			loggedin = false;
			username = null;
			password = null;
			fname = null;
			lname = null;
			type = null;
			account = null;
			employee = null;
			return;
		}
		else
		{
			log.error("UNSUCCESSFUL LOGOUT FROM " + username);
			return;
		}
	}
	
	public void updateCustomer()
	{
		log.info("UPDATE ATTEMPT FROM CUSTOMER " + username);
		if (loggedin)
		{
			if ("Customer".equals(type))
			{
				//Name of the file to open
				String filename = "Data.txt";
						
				//Reference file one line at a time
				String line = "";
				
				String oldcontent = username + ":" + password + ":" + fname + ":" + lname + ":" + type;
				
				if (account.isAccepted())
				{
					account.setApplied(true);
				}
				
				String newcontent = oldcontent + ":" + account.getBalance() + ":" + account.isApplied() + ":" + account.isAccepted() + ":" + employee;
				
						
				try
				{
					File file = new File(filename);
		            BufferedReader reader = new BufferedReader(new FileReader(file));
		             String oldtext = "";
		             while((line = reader.readLine()) != null)
		             {
		                 oldtext += line + "\r\n";
		                 if (line.contains(oldcontent))
		                 {
		                	 oldcontent = line;
		                 }
		             }
		             reader.close();
		            
		             //To replace a line in a file
		             String newtext = oldtext.replaceAll(oldcontent, newcontent);
		            
		             FileWriter writer = new FileWriter("Data.txt");
		             writer.write(newtext);
		             writer.close();
		             log.info("UPDATE ATTEMPT SUCCESSFUL");
		         }
				
				//Make sure that the file could be found
				catch(FileNotFoundException e)
				{
					log.fatal("UNABLE TO FIND FILE");
					return;
				}
				
				//Make sure that the file could be read
				catch(IOException e)
				{
					log.fatal("UNABLE TO OPEN FILE");
					return;
				}
			}
			else
			{
				log.error("USER " + username + " IS NOT A CUSTOMER");
			}
		}
		else
		{
			log.error("USER " + username + " IS NOT CURRENTLY LOGGED IN");
		}
	}
	
	public void deposit (float d)
	{
		log.info("DEPOSIT ATTEMPT FROM USER " + username);
		if (loggedin)
		{
			System.out.println(type);
			if ("Customer".equals(type))
			{
				log.info("DEPOSITING $" + d + " TO ACCOUNT");
				if (d > 0)
				{
					if (account.isAccepted())
					{
						account.balance += d;
						log.info("DEPOSIT ATTEMPT SUCCESSFUL");
						updateCustomer();
					}
					else
					{
						log.error("ACCOUNT HAS NOT BEEN APPROVED");
					}
				}
				else
				{
					log.error("DEPOSIT IS NOT POSITIVE");
				}
			}
			else
			{
				log.error("USER " + username + " IS NOT A CUSTOMER");
			}
		}
		else
		{
			log.error("USER " + username + " IS NOT CURRENTLY LOGGED IN");
		}
	}
	
	public void withdraw (float w)
	{
		log.info("WITHDRAW ATTEMPT FROM USER " + username);
		if (loggedin)
		{
			if ("Customer".equals(type))
			{
				log.info("WITHDRAWING $" + w + " FROM ACCOUNT");
				if (w > 0)
				{
					if (account.isAccepted())
					{
						account.balance -= w;
						log.info("WITHDRAW ATTEMPT SUCCESSFUL");
						updateCustomer();
					}
					else
					{
						log.error("ACCOUNT HAS NOT BEEN APPROVED");
					}
				}
				else
				{
					log.error("WITHDRAWAL IS NOT POSITIVE");
				}
			}
			else
			{
				log.error("USER " + username + " IS NOT A CUSTOMER");
			}
		}
		else
		{
			log.error("USER " + username + " IS NOT CURRENTLY LOGGED IN");
		}
	}
	
	public void apply()
	{
		log.info("APPLICATION ATTEMPT FROM USER " + username);
		if (loggedin)
		{
			if ("Customer".equals(type))
			{
				if (!account.isAccepted() && !account.isApplied())
				{
					log.info("APPLICATION ATTEMPT SUCCESSFUL");
					account.setApplied(true);
					updateCustomer();
				}
				else if (account.isAccepted())
				{
					log.error("ACCOUNT ALREADY APPROVED");
				}
				else
				{
					log.error("ACCOUNT ALREADY APPLIED");
				}
			}
			else
			{
				log.error("USER " + username + " IS NOT A CUSTOMER");
			}
		}
		else
		{
			log.error("USER " + username + " IS NOT CURRENTLY LOGGED IN");
		}
	}
	
	public void printAccount()
	{
		log.info("PRINT ATTEMPT FROM USER " + username);
		if (loggedin)
		{
			if ("Customer".equals(type))
			{
				System.out.println("\t$" + account.getBalance());
				log.info("PRINT ATTEMPT SUCCESSFUL");
			}
			else
			{
				log.error("USER " + username + " IS NOT A CUSTOMER");
			}
		}
		else
		{
			log.error("USER " + username + " IS NOT CURRENTLY LOGGED IN");
		}
	}
	
	public void printCustomers()
	{
		log.info("PRINT ATTEMPT FROM USER " + username);
		if (loggedin)
		{
			if ("Employee".equals(type))
			{
				for (int i = 0; i < customers.size(); i++)
				{
					System.out.println(customers.get(i) + "\t$" + accounts.get(i).getBalance() + "\tAPPLIED: " + accounts.get(i).isApplied() + "\tACCEPTED: " + accounts.get(i).isAccepted());
				}
				log.info("PRINT ATTEMPT SUCCESSFUL");
			}
			else
			{
				log.error("USER " + username + " IS NOT AN EMPLOYEE"); 
			}
		}
		else
		{
			log.error("USER " + username + " IS NOT CURRENTLY LOGGED IN");
		}
	}
	
	public void accept(String customer)
	{
		log.info("ACCEPT ATTEMPT FROM USER " + username);
		if (loggedin)
		{
			if ("Employee".equals(type))
			{
				for (int i = 0; i < customers.size(); i++)
				{
					if (customers.get(i).equals(customer))
					{
						if (accounts.get(i).isApplied())
						{
							if (!accounts.get(i).isAccepted())
							{
								accounts.get(i).setAccepted(true);
								log.info("ACCEPT ATTEMPT SUCCESSFUL");
								updateEmployee();
							}
							else
							{
								log.error("APPLICATION ALREADY ACCEPTED");
							}
						}
						else
						{
							log.error("APPLICATION NOT SENT");
						}
					}
				}
			}
			else
			{
				log.error("USER " + username + " IS NOT AN EMPLOYEE");
			}
		}
		else
		{
			log.error("USER " + username + " IS NOT CURRENTLY LOGGED IN");
		}
	}
	
	public void reject(String customer)
	{
		log.info("REJECT ATTEMPT FROM USER " + username);
		if (loggedin)
		{
			if ("Employee".equals(type))
			{
				for (int i = 0; i < customers.size(); i++)
				{
					if (customers.get(i).equals(customer))
					{
						if (accounts.get(i).isApplied())
						{
							if (!accounts.get(i).isAccepted())
							{
								accounts.get(i).setApplied(false);
								accounts.get(i).setAccepted(false);
								log.info("REJECT ATTEMPT SUCCESSFUL");
								updateEmployee();
							}
							else
							{
								log.error("APPLICATION ALREADY ACCEPTED");
							}
						}
						else
						{
							log.error("APPLICATION NOT SENT");
						}
					}
				}
			}
			else
			{
				log.error("USER " + username + " IS NOT AN EMPLOYEE");
			}
		}
		else
		{
			log.error("USER " + username + " IS NOT CURRENTLY LOGGED IN");
		}
	}
	
	public void updateEmployee ()
	{
		log.info("UPDATE ATTEMPT FROM EMPLOYEE " + username);
		if (loggedin)
		{
			if ("Employee".equals(type))
			{
				//Name of the file to open
				String filename = "Data.txt";
						
				//Reference file one line at a time
				String line = "";
				
				ArrayList<String> oldcontent = new ArrayList<String>();
				ArrayList<String> newcontent = new ArrayList<String>();
				
				for (int i = 0; i < customers.size(); i++)
				{
					String c = customers.get(i);
					oldcontent.add(c);
				}
				
						
				try
				{
					File file = new File(filename);
		            BufferedReader reader = new BufferedReader(new FileReader(file));
		            String oldtext = "";
		            while((line = reader.readLine()) != null)
		            {
		                oldtext += line + "\r\n";
		                for (int i = 0; i < oldcontent.size(); i++)
		                {
		                	if (line.contains(oldcontent.get(i)))
		                	{
		                		int n = 6;
		                		for (int j = 0; j < line.length(); j++)
		                	    {
		                	        if (line.charAt(j) == ':')
		                	        {
		                	            n--;
		                	            if (n == 0)
		                	            {
		                	                String a = line.substring(0, j) + ":" + accounts.get(i).isApplied() + ":" + accounts.get(i).isAccepted() + ":" + username;
		                	                newcontent.add(a);
		                	            }
		                	        }
		                	    }
		                		oldcontent.set(i, line);
		                		System.out.println(oldcontent.get(i));
		                	}
		                }
		            }
		            reader.close();
		            
		            //To replace a line in a file
		            String newtext = oldtext;
		            for (int i = 0; i < oldcontent.size(); i++)
		            {
		            	newtext = newtext.replaceAll(oldcontent.get(i), newcontent.get(i));
		            }
		            FileWriter writer = new FileWriter("Data.txt");
		            writer.write(newtext);
		            writer.close();
		            log.info("UPDATE ATTEMPT SUCCESSFUL");
		         }
				
				//Make sure that the file could be found
				catch(FileNotFoundException e)
				{
					log.fatal("UNABLE TO FIND FILE");
					return;
				}
				
				//Make sure that the file could be read
				catch(IOException e)
				{
					log.fatal("UNABLE TO OPEN FILE");
					return;
				}
			}
			else
			{
				log.error("USER " + username + " IS NOT A CUSTOMER");
			}
		}
		else
		{
			log.error("USER " + username + " IS NOT CURRENTLY LOGGED IN");
		}
	}
	
	public void printAll()
	{
		log.info("PRINT ATTEMPT FROM USER " + username);
		if (loggedin)
		{
			if ("Admin".equals(type))
			{
				//Name of the file to open
				String filename = "Data.txt";
						
				//Reference file one line at a time
				String line = "";
				
				try
				{
					//Read text file
					FileReader fr = new FileReader(filename);
					
					//Wrap FileReader in BufferedReader
					BufferedReader br = new BufferedReader(fr);
					
					while ((line = br.readLine()) != null)
					{
						String[] data = line.split(":");
						for (int i = 0; i < data.length; i++)
						{
							System.out.print(data[i] + "\t\t");
						}
						System.out.println();
					}
					log.info("PRINT ATTEMPT SUCCESSFUL");
					br.close();
					fr.close();
				}
				
				//Make sure that the file could be found
				catch(FileNotFoundException e)
				{
					log.fatal("UNABLE TO FIND FILE");
					return;
				}
				
				//Make sure that the file could be read
				catch(IOException e)
				{
					log.fatal("UNABLE TO OPEN FILE");
					return;
				}
			}
			else
			{
				log.error("USER " + username + " IS NOT AN ADMIN");
			}
		}
		else
		{
			log.error("USER " + username + " IS NOT CURRENTLY LOGGED IN");
		}
	}
	
	public void editAccounts()
	{
		log.info("EDIT ATTEMPT FROM USER " + username);
		
	}
}
