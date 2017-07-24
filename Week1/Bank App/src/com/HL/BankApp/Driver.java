package com.HL.BankApp;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Serializable;
import java.util.Scanner;
import org.apache.log4j.Logger;

public class Driver implements Serializable {

	public static File file = new File("C:\\Users\\hungl\\Desktop\\data.txt");
	public static String[] nameList = new String[99];
	public static String[] typeList = new String[99];
	public static String[] balanceList = new String[99];
	public static String[] requests = new String[99];
	public static int userid;
	public static int numOfUser = 5;


	public static void main(String[] args) {
		Driver myApp = new Driver();
		myApp.myText();
		myApp.myReader();
		while(true) {
			String name = myApp.inputName();
			String myStr = myApp.login(name);

			switch (myStr) {
			case ("admin"): {
				Admin admin = new Admin(name);
				admin.menu();
				break;

			}
			case ("employee"): {
				Employee employee = new Employee(name);
				employee.menu();
				break;
			}
			case ("customer"): {
				Customer customer = new Customer(name, balanceList[userid]);
				customer.menu();
				break;
			}
			default: {
				System.out.println("Error: Account accountType not found\n");
				break;
			}
			}

		}

	}

	private String inputName() {
		System.out.println("Welcome!\nPlease enter your name: ");
		Scanner scan = new Scanner(System.in);
		String name = scan.nextLine();
		return name;
	}

	private String login(String name) {
		for (int i = 0; i < nameList.length; i++) {
			if (name.equals(nameList[i])) {
				userid = i;
			}
		}

		if (userid == 0 && !"Admin".equals(name) && !"".equals(name)) {
			System.out.println(name +"'s temporary account is created.");
			typeList[numOfUser] = "customer";
			nameList[numOfUser] = name;
			balanceList[numOfUser] = "null";
			requests[numOfUser] = "null";
			userid = numOfUser;
			numOfUser++;
		} else if ("".equals(name)) {
			System.out.println("Error: Invalid username");
			return "null";
		}

		return typeList[userid];
	}

	private void myReader() {
		try (BufferedReader br = new BufferedReader(new FileReader(file))) {
			String line;
			int i = 0;
			while ((line = br.readLine()) != null) {
				String[] read = line.split(";");

				typeList[i] = read[0];
				nameList[i] = read[1];
				balanceList[i] = read[2];
				requests[i] = read[3];

				i++;
			}
			i = 0;
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public void myText() {
		String admin = "admin;Admin;null;null";
		String employee1 = "employee;Employee1;null;null";
		String employee2 = "employee;Employee2;null;null";
		String customer1 = "customer;Customer1;8000;null";
		String customer2 = "customer;Customer2;50000;null";

		String[] userlist = { admin, employee1, employee2, customer1, customer2 };

		BufferedWriter bw = null;
		FileWriter fw = null;
		try {
			if (!file.exists()) {
				file.createNewFile();
			}

			fw = new FileWriter(file);
			bw = new BufferedWriter(fw);

			for (int i = 0; i < userlist.length; i++) {
				bw.write(userlist[i]);
				bw.newLine();
			}

			bw.close();
			fw.close();

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
