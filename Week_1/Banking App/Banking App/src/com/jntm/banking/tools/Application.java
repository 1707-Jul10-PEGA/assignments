package com.jntm.banking.tools;

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

public class Application implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String userID;
	private String empID;
	private String appID;
	private static int appNum = 0;
	private static Logger log = Logger.getRootLogger();

	public static ArrayList<Application> appList = new ArrayList<Application>();

	public Application(String userID, String empID) {
		this.userID = userID;
		this.empID = empID;
		this.appID = appNum + 100 + "";
		appNum++;
		log.trace("Application Created.");
	}

	public static void readApplications() {
		log.trace("Applications read into memory.");
		appList.clear();

		String filename = "applicationList.txt";

		try {
			FileInputStream fis = new FileInputStream(filename);
			ObjectInputStream ois = new ObjectInputStream(fis);

			boolean gate = true;
			while (gate) {
				Object obj = ois.readObject();

				if (obj != null) {
					appList.add((Application) obj);
					appNum++;
				} else {
					gate = false;
				}

			}
			ois.close();
			System.out.println("Applications read successfully!");

			PrintWriter pw;
			try {
				pw = new PrintWriter(filename);
				pw.close();
			} catch (FileNotFoundException e1) {
				e1.printStackTrace();
			}

		} catch (IOException | ClassNotFoundException e) {
			// e.printStackTrace();
		}

	}

	public static void writeApplications() {
		log.trace("Application saved to file.");
		String filename = "applicationList.txt";

		PrintWriter pw;
		try {
			pw = new PrintWriter(filename);
			pw.close();
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		}

		try {
			FileOutputStream fos = new FileOutputStream(filename);
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			for (Application x : appList) {
				oos.writeObject(x);
			}
			oos.close();
			System.out.println("Applications have been saved successfully!");

		} catch (IOException e) {
			System.out.println("WriteApplications filewriting failed.");
			e.printStackTrace();
		}

		appList.clear();
	}

	public static void addtoAppList(Application app) {
		appList.add(app);
	}

	public String getUserID() {
		return userID;
	}

	public void setUserID(String userID) {
		this.userID = userID;
	}

	public String getAppID() {
		return appID;
	}

	public void setAppID(String appID) {
		this.appID = appID;
	}

	public static int getAppNum() {
		return appNum;
	}

	public static void setAppNum(int appNum) {
		Application.appNum = appNum;
	}

	public String getEmpID() {
		return empID;
	}

	public void setEmpID(String empID) {
		this.empID = empID;
	}

	public String toString() {
		return "Application #" + this.getAppID() + " submitted by " + this.getUserID() + ".";
	}

}
