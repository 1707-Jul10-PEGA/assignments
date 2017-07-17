package com.jntm.banking.users;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.io.Serializable;
import java.util.ArrayList;

import org.apache.log4j.Logger;

public abstract class User implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String fName = "";
	private String lName = "";
	private String username = "";
	private String password = "";
	private String userID = "";
	private String type = "";
	private static Logger log = Logger.getRootLogger();

	private static int userCount = 0;

	public static ArrayList<User> userList = new ArrayList<User>();

	public User(String fName, String lName, String username, String password, String userID, String type) {
		this.fName = fName;
		this.lName = lName;
		this.username = username;
		this.password = password;
		this.userID = userID;
		this.type = type;
		log.trace("New User Created.");
	}

	public static void writeUsers() {
		log.trace("Users being saved to file.");
		String filename = "userList.txt";

		PrintWriter pw;
		try {
			pw = new PrintWriter(filename);
			pw.close();
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		try {
			FileOutputStream fos = new FileOutputStream(filename);
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			for (User x : userList) {
				oos.writeObject(x);
			}
			oos.close();
			System.out.println("Users have been saved successfully!");

		} catch (IOException e) {
			System.out.println("WriteUsers filewriting failed.");
			e.printStackTrace();
		}

		userList.clear();

	}

	public static void readUsers() {
		log.trace("Users being read into memory.");
		userList.clear();

		String filename = "userList.txt";

		try {

			FileInputStream fis = new FileInputStream(filename);
			ObjectInputStream ois = new ObjectInputStream(fis);

			boolean gate = true;
			while (gate) {

				Object obj = ois.readObject();

				if (obj != null) {
					String type = ((User) obj).getType();

					if ("Customer".equals(type)) {
						userList.add(((Customer) obj));
						User.setUserCount(User.getUserCount() + 1);
					} else if ("Employee".equals(type)) {
						userList.add(((Employee) obj));
						User.setUserCount(User.getUserCount() + 1);
					} else if ("Admin".equals(type)) {
						userList.add(((Admin) obj));
						User.setUserCount(User.getUserCount() + 1);
					} else {
						System.out.println("Type is failing");
					}

					userCount++;
				} else {

					gate = false;
				}

			}
			ois.close();
			System.out.println("Users read successfully!");

			PrintWriter pw;
			try {
				pw = new PrintWriter(filename);
				pw.close();
			} catch (FileNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

		} catch (IOException | ClassNotFoundException e) {
			// e.printStackTrace();
		}

	}

	public static void addToUserList(User u) {
		userList.add(u);
	}

	public static int getUserCount() {
		return userCount;
	}

	public static void setUserCount(int userCount) {
		User.userCount = userCount;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getUserID() {
		return userID;
	}

	public void setUserID(String userID) {
		this.userID = userID;
	}

	public String getfName() {
		return fName;
	}

	public void setfName(String fName) {
		this.fName = fName;
	}

	public String getlName() {
		return lName;
	}

	public void setlName(String lName) {
		this.lName = lName;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
