package com.WilliamLewis.BankingApp.Driver;

import java.util.ArrayList;

import javax.sound.midi.MidiDevice.Info;

import org.apache.log4j.Logger;

import com.WilliamLewis.BankingApp.AccountFactory.AccountFactory;
import com.WilliamLewis.BankingApp.Applications.AccountApplication;
import com.WilliamLewis.BankingApp.BankData.BankData;
import com.WilliamLewis.BankingApp.BankData.Accounts.Account;
import com.WilliamLewis.BankingApp.Login.AdminPage;
import com.WilliamLewis.BankingApp.Login.LoginGUI;
import com.WilliamLewis.BankingApp.Login.MainMenu;
import com.WilliamLewis.BankingApp.Users.Admin;
import com.WilliamLewis.BankingApp.Users.Employee;

public class Driver {
	private static Logger log = Logger.getRootLogger();

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		log.debug("Some message");
		//LoginGUI myLogin = new LoginGUI();
		//AdminPage myAdmin = new AdminPage();
		LoginGUI  main = new LoginGUI();
		log.trace(BankData.getInstance().currentAdmins.size());
		
		
		Runtime.getRuntime().addShutdownHook(new Thread(new Runnable() {

	        public void run() {
	        	BankData.getInstance().saveData();
	        }
	    }));
	}
	
	
	public static void initTestBank()
	{
		BankData.getInstance();

		AccountFactory.createAccount("basic", "TestAccount");
		Employee Master = new Employee("UserName" , "emp");
		submitApplication("SuperAccount", "basic");
		submitApplication("LessSuperAccount", "basic");
		Master.approveAll();
		
		
		Admin headHoncho = new Admin();
		headHoncho.seeAllAccounts();
		
		log.trace(BankData.getInstance().currentAdmins.size());
	}
	public static void submitApplication(String name, String type){
		BankData.getInstance().addApp(new AccountApplication(name, type));
	}
	
	

}
