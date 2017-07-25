//Carson Stephens

package com.cts.driver;

import java.sql.SQLException;
import java.util.ArrayList;
//import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Random;

import com.cts.dao.*;
import com.cts.pojo.*;

public class Driver
{
	static BankingDaoImpl b = new BankingDaoImpl();
	static Scanner scan = new Scanner(System.in);
	
	public static void loginUI()
	{
		try
		{
			while (true)
			{
				int intinput = 0;
				String strinput = "";
				System.out.println("\t1: LOGIN");
				System.out.println("\t2: REGISTER");
				System.out.println("\t3: LOGS");
				System.out.println("\t0: QUIT");
				intinput = scan.nextInt();
				scan.nextLine();
				switch (intinput)
				{
					case 1:
						System.out.println("ENTER USERNAME AND PASSWORD BELOW");
						System.out.print("USERNAME: ");
						strinput = scan.nextLine();
						Userpass u = b.getUserpass(strinput);
						System.out.print("PASSWORD: ");
						strinput = scan.nextLine();
						if (null == u)
						{
							System.out.println("INCORRECT USERNAME/PASSWORD");
						}
						else if ("Admin".equals(u.getType()))
						{
							Admin a = b.loginAdmin(u.getUsername(), strinput);
							if (a == null)
							{
								System.out.println("INCORRECT USERNAME/PASSWORD");
							}
							else
							{
								System.out.println("WELCOME, " + a.getFirstname() + " " + a.getLastname());
								adminUI(a);
							}
						}
						else if ("Employee".equals(u.getType()))
						{
							Employee e = b.loginEmployee(u.getUsername(), strinput);
							if (e == null)
							{
								System.out.println("INCORRECT USERNAME/PASSWORD");
							}
							else
							{
								System.out.println("WELCOME, " + e.getFirstname() + " " + e.getLastname());
								employeeUI(e);
							}
						}
						else if ("Customer".equals(u.getType()))
						{
							Customer c = b.loginCustomer(u.getUsername(), strinput);
							if (c == null)
							{
								System.out.println("INCORRECT USERNAME/PASSWORD");
							}
							else
							{
								System.out.println("WELCOME, " + c.getFirstname() + " " + c.getLastname());
								customerUI(c);
							}
						}
						
						break;
					
					case 2:
						registerUI();
						
						break;
					
					case 3:
						b.printLogs();
						break;
						
					case 0:
						
						b.disconnect();
						System.exit(1);
						
					default:
						System.out.println("INVALID INPUT");
						break;
						
				}
			}
		} catch (SQLException exc)
		{
			// TODO Auto-generated catch block
			exc.printStackTrace();
		}
	}
	
	public static void registerUI()
	{
		try
		{
			while (true)
			{
				scan.reset();
				System.out.println("ENTER ACCOUNT INFORMATION BELOW");
				System.out.print("USERNAME: ");
				String strinput = scan.nextLine();
				Userpass u = b.getUserpass(strinput);
				if (u == null)
				{
					Customer c = new Customer();
					c.setUsername(strinput);
					System.out.print("PASSWORD: ");
					strinput = scan.nextLine();
					c.setPassword(strinput);
					System.out.print("FIRST NAME: ");
					strinput = scan.nextLine();
					c.setFirstname(strinput);
					System.out.print("LAST NAME: ");
					strinput = scan.nextLine();
					c.setLastname(strinput);
					List<Employee> es = b.getAllEmployees();
					Random rand = new Random();
					int randomEmp = rand.nextInt(es.size()) + 1;
					c.setEmployee(randomEmp);
					b.saveCustomer(c);
					System.out.println("REGISTRATION COMPLETE");
					
					return;
				}
				else
				{
					System.out.println("USERNAME ALREADY REGISTERED");
				}
				
			}
		} catch (SQLException exc)
		{
			// TODO Auto-generated catch block
			exc.printStackTrace();
		}
	}
	
	public static void adminUI(Admin a)
	{
		try
		{
			while (true)
			{
				scan.reset();
//				String strinput;
//				Double douinput;
				int intinput;
				System.out.println("\t1: VIEW USERS");
				System.out.println("\t2: APPROVE APPLICATION");
				System.out.println("\t3: REJECT APPLICATION");
				System.out.println("\t4: EDIT USER (DOES NOT WORK 100%)");
				System.out.println("\t5: LOGOUT");
				System.out.println("\t0: QUIT");
				intinput = scan.nextInt();
				scan.nextLine();
				switch (intinput)
				{
					case 1:
						List<Admin> as = b.getAllAdmins();
						System.out.println("\nADMINS");
						System.out.format("%3s%25s%25s%25s%25s\n", "ID", "USERNAME", "PASSWORD", "FIRST NAME", "LAST NAME");
						for (Admin ait : as)
						{
							System.out.format("%3d%25s%25s%25s%25s\n", ait.getId(), ait.getUsername(), ait.getPassword(), ait.getFirstname(), ait.getLastname());
						}
						List<Employee> es = b.getAllEmployees();
						System.out.println("\nEMPLOYEES");
						System.out.format("%3s%25s%25s%25s%25s\n", "ID", "USERNAME", "PASSWORD", "FIRST NAME", "LAST NAME");
						for (Employee eit : es)
						{
							System.out.format("%3d%25s%25s%25s%25s\n", eit.getId(), eit.getUsername(), eit.getPassword(), eit.getFirstname(), eit.getLastname());
						}
						List<Customer> cs = b.getAllCustomers();
						System.out.println("\nCUSTOMERS");
						System.out.format("%3s%25s%25s%25s%25s%25s\n", "ID", "USERNAME", "PASSWORD", "FIRST NAME", "LAST NAME", "EMPLOYEE ASSIGNMENT");
						for (Customer cit : cs)
						{
							Employee e = b.getEmployee(cit.getEmployee());
							System.out.format("%3d%25s%25s%25s%25s%25s\n", cit.getId(), cit.getUsername(), cit.getPassword(), cit.getFirstname(), cit.getLastname(), e.getUsername());
							List<Account> acs = b.getAllCustomerAccounts(cit.getId());
							System.out.format("\t%12s%25s%18s%25s\n", "ACCOUNT ID", "TYPE", "BALANCE", "STATUS");
							for (Account acit : acs)
							{
								String status = "";
								if (acit.getApplied() == 1)
								{
									status = "Applied";
								}
								else if (acit.getApproved() == 1)
								{
									status = "Approved";
								}
								System.out.format("\t%12d%25s%18.2f%25s\n", acit.getId(), acit.getType(), acit.getBalance(), status);
							}
							System.out.println();
						}
						break;
						
					case 2:
						System.out.print("ENTER CUSTOMER'S ID TO APPROVE APPLICATION: ");
						intinput = scan.nextInt();
						scan.nextLine();
						Customer c1 = b.getCustomer(intinput);
						if (c1 != null)
						{
							b.approve(a, c1);
						}
						else
						{
							System.out.println("CUSTOMER DOES NOT EXIST");
						}
						break;
					
					case 3:
						System.out.print("ENTER CUSTOMER'S ID TO REJECT APPLICATION: ");
						intinput = scan.nextInt();
						scan.nextLine();
						Customer c2 = b.getCustomer(intinput);
						if (c2 != null)
						{
							b.approve(a, c2);
						}
						else
						{
							System.out.println("CUSTOMER DOES NOT EXIST");
						}
						break;
						
					case 4:
						String strinput;
						System.out.println("\t1: EDIT ADMIN");
						System.out.println("\t2: EDIT EMPLOYEE");
						System.out.println("\t3: EDIT CUSTOMER");
						int intinput2 = scan.nextInt();
						scan.nextLine();
						switch (intinput2)
						{
							case 1:
								System.out.print("ENTER ADMIN'S ID TO EDIT: ");
								intinput2 = scan.nextInt();
								scan.nextLine();
								Admin ae = b.getAdmin(intinput2);
								if (ae != null)
								{
									System.out.println("\t1: EDIT USERNAME");
									System.out.println("\t2: EDIT PASSWORD");
									System.out.println("\t3: EDIT FIRST NAME");
									System.out.println("\t4: EDIT LAST NAME");
									System.out.println("\t5: EDIT PRIVILEGE");
									System.out.println("\t6: DELETE");
									int intinput3 = scan.nextInt();
									scan.nextLine();
									switch (intinput3)
									{
										case 1:
											System.out.print("ENTER NEW USERNAME: ");
											strinput = scan.nextLine();
											Userpass u = b.getUserpass(strinput);
											if (u == null)
											{
												ae.setUsername(strinput);
												b.updateAdmin(ae);
												System.out.println("ADMIN UPDATED");
											}
											else
											{
												System.out.println("USER ALREADY EXISTS");
											}
											break;
											
										case 2:
											System.out.print("ENTER NEW PASSWORD: ");
											strinput = scan.nextLine();
											ae.setPassword(strinput);
											b.updateAdmin(ae);
											System.out.println("ADMIN UPDATED");
											break;
										
										case 3:
											System.out.print("ENTER NEW FIRST NAME: ");
											strinput = scan.nextLine();
											ae.setFirstname(strinput);
											b.updateAdmin(ae);
											System.out.println("ADMIN UPDATED");
											break;
											
										case 4:
											System.out.print("ENTER NEW LAST NAME: ");
											strinput = scan.nextLine();
											ae.setLastname(strinput);
											b.updateAdmin(ae);
											System.out.println("ADMIN UPDATED");
											break;
											
										case 5:
											System.out.println("\t1: SET TO EMPLOYEE");
											System.out.println("\t2: SET TO CUSTOMER");
											int intinput4 = scan.nextInt();
											scan.nextLine();
											switch (intinput4)
											{
												case 1:
													b.deleteAdmin(ae.getId());
													Employee e = new Employee(0, ae.getUsername(), ae.getPassword(), ae.getFirstname(), ae.getLastname());
													b.saveEmployee(e);
													System.out.println("ADMIN CHANGED TO EMPLOYEE");
													break;
													
												case 2:
													u = b.getUserpass(ae.getUsername());
													u.setType("Customer");
													b.updateUserpass(u, ae.getUsername());
													b.deleteAdmin(ae.getId());
													List<Account> acs = new ArrayList<Account>();
													es = b.getAllEmployees();
													Random rand = new Random();
													int randomEmp = rand.nextInt(es.size()) + 1;
													Customer c = new Customer(0, ae.getUsername(), ae.getPassword(), ae.getFirstname(), ae.getLastname(), randomEmp, acs);
													b.saveCustomer(c);
													System.out.println("ADMIN CHANGED TO CUSTOMER");
													break;
												
												default:
													System.out.println("INVALID INPUT");
													break;
											}
										
										case 6:
											b.deleteAdmin(ae.getId());
											System.out.println("ADMIN DELETED");
											break;
										
										default:
											System.out.println("INVALID INPUT");
											break;
									}
								}
								break;
								
							case 2:
								System.out.print("ENTER EMPLOYEE'S ID TO EDIT: ");
								intinput2 = scan.nextInt();
								scan.nextLine();
								Employee ee = b.getEmployee(intinput2);
								if (ee != null)
								{
									System.out.println("\t1: EDIT USERNAME");
									System.out.println("\t2: EDIT PASSWORD");
									System.out.println("\t3: EDIT FIRST NAME");
									System.out.println("\t4: EDIT LAST NAME");
									System.out.println("\t5: EDIT PRIVILEGE");
									System.out.println("\t6: DELETE");
									int intinput3 = scan.nextInt();
									scan.nextLine();
									switch (intinput3)
									{
										case 1:
											System.out.print("ENTER NEW USERNAME: ");
											strinput = scan.nextLine();
											Userpass u = b.getUserpass(strinput);
											if (u == null)
											{
												ee.setUsername(strinput);
												b.updateEmployee(ee);
												System.out.println("EMPLOYEE UPDATED");
											}
											else
											{
												System.out.println("USER ALREADY EXISTS");
											}
											break;
											
										case 2:
											System.out.print("ENTER NEW PASSWORD: ");
											strinput = scan.nextLine();
											ee.setPassword(strinput);
											b.updateEmployee(ee);
											System.out.println("EMPLOYEE UPDATED");
											break;
										
										case 3:
											System.out.print("ENTER NEW FIRST NAME: ");
											strinput = scan.nextLine();
											ee.setFirstname(strinput);
											b.updateEmployee(ee);
											System.out.println("EMPLOYEE UPDATED");
											break;
											
										case 4:
											System.out.print("ENTER NEW LAST NAME: ");
											strinput = scan.nextLine();
											ee.setLastname(strinput);
											b.updateEmployee(ee);
											System.out.println("EMPLOYEE UPDATED");
											break;
											
										case 5:
											System.out.println("\t1: SET TO ADMIN");
											System.out.println("\t2: SET TO CUSTOMER");
											int intinput4 = scan.nextInt();
											scan.nextLine();
											switch (intinput4)
											{
												case 1:
													b.deleteEmployee(ee.getId());
													a = new Admin(0, ee.getUsername(), ee.getPassword(), ee.getFirstname(), ee.getLastname());
													b.saveAdmin(a);
													System.out.println("EMPLOYEE CHANGED TO ADMIN");
													break;
													
												case 2:
													u = b.getUserpass(ee.getUsername());
													u.setType("Customer");
													b.updateUserpass(u, ee.getUsername());
													b.deleteAdmin(ee.getId());
													List<Account> acs = new ArrayList<Account>();
													es = b.getAllEmployees();
													Random rand = new Random();
													int randomEmp = rand.nextInt(es.size()) + 1;
													Customer c = new Customer(0, ee.getUsername(), ee.getPassword(), ee.getFirstname(), ee.getLastname(), randomEmp, acs);
													b.saveCustomer(c);
													System.out.println("EMPLOYEE CHANGED TO CUSTOMER");
													break;
												
												default:
													System.out.println("INVALID INPUT");
													break;
											}
										
										case 6:
											b.deleteEmployee(ee.getId());
											System.out.println("ADMIN DELETED");
											break;
										
										default:
											System.out.println("INVALID INPUT");
									}
								}
						}
						break;
					
					case 5:
						System.out.println("LOGGING OUT...");
						
						return;
					
					case 0:
						
						b.disconnect();
						System.exit(1);
						break;
					
					default:
						System.out.println("INVALID INPUT");
						break;
				}
			}
		}
		catch (SQLException exc)
		{
			// TODO Auto-generated catch block
			exc.printStackTrace();
		}
	}
	
	public static void employeeUI(Employee e)
	{
		try
		{
			while (true)
			{
				scan.reset();
				int intinput;
				System.out.println("\t1: VIEW CUSTOMERS");
				System.out.println("\t2: APPROVE APPLICATION");
				System.out.println("\t3: REJECT APPLICATION");
				System.out.println("\t4: LOGOUT");
				System.out.println("\t0: QUIT");
				intinput = scan.nextInt();
				scan.nextLine();
				switch (intinput)
				{
					case 1:
						List<Customer> cs = b.viewOwnCustomers(e);
						System.out.println("\nCUSTOMERS");
						System.out.format("%3s%25s%25s%25s%25s\n", "ID", "USERNAME", "PASSWORD", "FIRST NAME", "LAST NAME", "EMPLOYEE ASSIGNMENT");
						for (Customer cit : cs)
						{
							System.out.format("%3d%25s%25s%25s%25ss\n", cit.getId(), cit.getUsername(), cit.getPassword(), cit.getFirstname(), cit.getLastname());
							List<Account> acs = b.getAllCustomerAccounts(cit.getId());
							System.out.format("\t%12s%25s%18s%25s\n", "ACCOUNT ID", "TYPE", "BALANCE", "STATUS");
							for (Account acit : acs)
							{
								String status = "";
								if (acit.getApplied() == 1)
								{
									status = "Applied";
								}
								else if (acit.getApproved() == 1)
								{
									status = "Approved";
								}
								System.out.format("\t%12d%25s%18.2f%25s\n", acit.getId(), acit.getType(), acit.getBalance(), status);
							}
							System.out.println();
						}
						break;
					
					case 2:
						System.out.print("ENTER CUSTOMER'S ID TO APPROVE APPLICATION: ");
						intinput = scan.nextInt();
						scan.nextLine();
						Customer c1 = b.getCustomer(intinput);
						if (c1 != null)
						{
							b.approve(e, c1);
						}
						else
						{
							System.out.println("CUSTOMER DOES NOT EXIST");
						}
						break;
					
					case 3:
						System.out.print("ENTER CUSTOMER'S ID TO REJECT APPLICATION: ");
						intinput = scan.nextInt();
						scan.nextLine();
						Customer c2 = b.getCustomer(intinput);
						if (c2 != null)
						{
							b.approve(e, c2);
						}
						else
						{
							System.out.println("CUSTOMER DOES NOT EXIST");
						}
						break;
					
					case 4:
						System.out.println("LOGGING OFF...");
						
						return;
					
					case 0:
						
						b.disconnect();
						System.exit(1);
					
					default:
						System.out.println("INVALID INPUT");
				}
			}
			
		}
		catch (SQLException exc)
		{
			// TODO Auto-generated catch block
			exc.printStackTrace();
		}
	}
	
	public static void customerUI(Customer c)
	{
		try
		{
			while (true)
			{
				scan.reset();
				int intinput;
				System.out.println("\t1: VIEW BALANCES");
				System.out.println("\t2: APPLY FOR ACCOUNT");
				System.out.println("\t3: DEPOSIT");
				System.out.println("\t4: WITHDRAW");
				System.out.println("\t5: LOGOUT");
				System.out.println("\t0: QUIT");
				intinput = scan.nextInt();
				scan.nextLine();
				switch (intinput)
				{
					case 1:
						List<Account> acs = b.getAllCustomerAccounts(c.getId());
						System.out.format("\t%12s%25s%18s%25s\n", "ACCOUNT ID", "TYPE", "BALANCE", "STATUS");
						for (Account acit : acs)
						{
							String status = "";
							if (acit.getApplied() == 1)
							{
								status = "Applied";
							}
							else if (acit.getApproved() == 1)
							{
								status = "Approved";
							}
							System.out.format("\t%12d%25s%18.2f%25s\n", acit.getId(), acit.getType(), acit.getBalance(), status);
						}
						System.out.println();
						break;
					
					case 2:
						System.out.println("1: CHECKING");
						System.out.println("2: SAVINGS");
						int intinput1 = scan.nextInt();
						scan.nextLine();
						
						switch(intinput1)
						{
							case 1:
								b.apply(c, "Checking");
								break;
							
							case 2:
								b.apply(c, "Savings");
								break;
								
							default:
								System.out.println("INVALID INPUT");
								break;
						}
						break;
					
					case 3:
						System.out.print("ENTER ACCOUNT ID TO DEPOSIT INTO: ");
						int account = scan.nextInt();
						scan.nextLine();
						System.out.print("ENTER AMOUNT TO DEPOSIT: ");
						double d = scan.nextDouble();
						b.deposit(c, account, d);
						break;
						
					case 4:
						System.out.print("ENTER ACCOUNT ID TO DEPOSIT INTO: ");
						account = scan.nextInt();
						scan.nextLine();
						System.out.print("ENTER AMOUNT TO DEPOSIT: ");
						double w = scan.nextDouble();
						b.withdraw(c, account, w);
						break;
					
					case 5:
						System.out.println("LOGGING OFF...");
						
						return;
					
					case 0:
						
						b.disconnect();
						System.exit(1);
					
					default:
						System.out.println("INVALID INPUT");
				}
			}
			
		}
		catch (SQLException exc)
		{
			// TODO Auto-generated catch block
			exc.printStackTrace();
		}
	}
	
	public static void main(String[] args)
	{
		System.out.println("WELCOME TO BANKING APP V2: SQL EDITION");
		loginUI();
	}
	
}
