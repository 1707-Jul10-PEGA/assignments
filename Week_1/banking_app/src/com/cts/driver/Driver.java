//Carson Stephens
//Banking App

package com.cts.driver;

import java.util.Scanner;

public class Driver
{
	public static void main(String[] args)
	{
		User u = new User();
		System.out.println("WELCOME");
		Scanner scan = new Scanner(System.in);
		int input = 0;
		while (true)
		{
			while (!u.isLoggedin())
			{
				System.out.print("USERNAME: ");
				String uinput = scan.nextLine();
				System.out.print("PASSWORD: ");
				String pinput = scan.nextLine();
				u.login(uinput, pinput);
			}
			while (u.isLoggedin())
			{
				if ("Customer".equals(u.getType()))
				{
					System.out.println("1: VIEW BALANCE");
					System.out.println("2: DEPOSIT");
					System.out.println("3: WITHDRAW");
					System.out.println("4: APPLY FOR ACCOUNT");
					System.out.println("5: LOGOUT");
					System.out.println("0: QUIT");
					input = scan.nextInt();
					scan.nextLine();
					switch (input)
					{
						case 1:
							u.printAccount();
							break;
						case 2:
							System.out.print("DEPOSIT AMOUNT: ");
							u.deposit(scan.nextFloat());
							scan.nextLine();
							break;
						case 3:
							System.out.print("WITHDRAW AMOUNT: ");
							u.withdraw(scan.nextFloat());
							scan.nextLine();
							break;
						case 4:
							u.apply();
							break;
						case 5:
							u.logout(); 
							break;
						case 0:
							scan.close();
							return;
						default:
							System.out.println("INVALID INPUT");
							break;
					}
				}
				if ("Employee".equals(u.getType()))
				{
					System.out.println("1: VIEW CUSTOMERS");
					System.out.println("2: ACCEPT APPLICATION");
					System.out.println("3: REJECT APPLICATION");
					System.out.println("4: LOGOUT");
					System.out.println("0: QUIT");
					input = scan.nextInt();
					scan.nextLine();
					switch (input)
					{
						case 1:
							u.printCustomers();
							break;
						case 2:
							System.out.println("ENTER USERNAME TO ACCEPT");
							u.accept(scan.nextLine());
							scan.nextLine();
							break;
						case 3:
							System.out.println("ENTER USERNAME TO REJECT");
							u.reject(scan.nextLine());
							scan.nextLine();
							break;
						case 4:
							u.logout();
							break;
						case 0:
							scan.close();
							return;
						default:
							System.out.println("INVALID INPUT");
					}
				}
				if ("Admin".equals(u.getType()))
				{
					System.out.println("1: VIEW USERS");
					System.out.println("2: EDIT USER");
					System.out.println("3: LOGOUT");
					System.out.println("0: QUIT");
					input = scan.nextInt();
					scan.nextLine();
					switch (input)
					{
						case 1:
							u.printAll();
							break;
						case 2:
							u.editAccounts();
							break;
						case 3:
							u.logout();
							break;
						case 0:
							scan.close();
							return;
						default:
							System.out.println("INVALID INPUT");
							break;
					}
				}
			}
		}
	}
}
