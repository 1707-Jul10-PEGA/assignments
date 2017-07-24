package com.WilliamLewis.BankingApp.Driver;

import org.apache.log4j.Logger;

import com.WilliamLewis.BankingApp.BankData.BankData;
import com.WilliamLewis.BankingApp.Login.LoginGUI;

public class Driver {
	private static Logger log = Logger.getRootLogger();

	public static void main(String[] args) {
		log.debug("Some message");

		
		LoginGUI  main = new LoginGUI();
		
		
//		Runtime.getRuntime().addShutdownHook(new Thread(new Runnable() {
//
//	        	public void run() {
//	        	BankData.getInstance().saveData();
//	        }
//	    }));
	}

	
	

}
