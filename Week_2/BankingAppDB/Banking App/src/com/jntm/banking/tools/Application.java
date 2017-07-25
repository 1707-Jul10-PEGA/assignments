package com.jntm.banking.tools;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import org.apache.log4j.Logger;

import com.jntm.banking.database.ConnectionFactory;

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

	public static void readApplications() throws SQLException {
		log.trace("Applications read into memory.");
		appList.clear();

		Connection conn = ConnectionFactory.getInstance().getConnection();

		String insertSQL = "";

		Statement state = conn.createStatement();

		insertSQL = "SELECT * FROM bank_application";
		ResultSet rs = state.executeQuery(insertSQL);
		
		while (rs.next()) {
			Application a = new Application(rs.getString(2), rs.getString(4));
			a.setAppID(rs.getString(3));
			appList.add(a);
		}
		
//		String filename = "applicationList.txt";
//
//		try {
//			FileInputStream fis = new FileInputStream(filename);
//			ObjectInputStream ois = new ObjectInputStream(fis);
//
//			boolean gate = true;
//			while (gate) {
//				Object obj = ois.readObject();
//
//				if (obj != null) {
//					appList.add((Application) obj);
//					appNum++;
//				} else {
//					gate = false;
//				}
//
//			}
//			ois.close();
//			System.out.println("Applications read successfully!");
//
//			PrintWriter pw;
//			try {
//				pw = new PrintWriter(filename);
//				pw.close();
//			} catch (FileNotFoundException e1) {
//				e1.printStackTrace();
//			}
//
//		} catch (IOException | ClassNotFoundException e) {
//			// e.printStackTrace();
//		}

	}

	public static void writeApplications() throws SQLException {
		log.trace("Application saved to file.");
		
		Connection conn = ConnectionFactory.getInstance().getConnection();
		
		for (Application x : Application.appList) {
			
			//String insertSQL = "Update bank_application set user_id=?,realAppid=?,empID=? where app_id=?"; 
			String insertSQL = "INSERT into bank_application (user_id, realAppID,empID) values((Select user_id from bank_user where realuserID =?),?,?)";
			PreparedStatement stmt = conn.prepareStatement(insertSQL);

			stmt.setString(1, x.getUserID());
			stmt.setString(2, x.getAppID());
			stmt.setString(3, x.getEmpID());
			
			stmt.close();
		}
		conn.close();
		
//		String filename = "applicationList.txt";
//
//		PrintWriter pw;
//		try {
//			pw = new PrintWriter(filename);
//			pw.close();
//		} catch (FileNotFoundException e1) {
//			e1.printStackTrace();
//		}
//
//		try {
//			FileOutputStream fos = new FileOutputStream(filename);
//			ObjectOutputStream oos = new ObjectOutputStream(fos);
//			for (Application x : appList) {
//				oos.writeObject(x);
//			}
//			oos.close();
//			System.out.println("Applications have been saved successfully!");
//
//		} catch (IOException e) {
//			System.out.println("WriteApplications filewriting failed.");
//			e.printStackTrace();
//		}

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
