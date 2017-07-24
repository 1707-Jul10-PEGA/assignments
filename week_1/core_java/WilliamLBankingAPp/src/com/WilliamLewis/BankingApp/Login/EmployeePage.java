package com.WilliamLewis.BankingApp.Login;

import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;

import com.WilliamLewis.BankingApp.Applications.AccountApplication;
import com.WilliamLewis.BankingApp.BankData.BankData;
import com.WilliamLewis.BankingApp.BankData.Accounts.Account;
import com.WilliamLewis.BankingApp.Users.Employee;

public class EmployeePage extends JFrame{
	
	JButton home;
	Container panel = getContentPane();
	
	
	public EmployeePage(Integer userID){
		super("Accounts");
		ArrayList<Account> myAccs = BankData.getInstance().getManagedAccounts(userID);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		panel.setLayout(new GridLayout(10, 10));
		JButton accountButton;
		String myCust; 
		
		for(Account acc : myAccs)
		{
			myCust = BankData.getInstance().getUserByID(acc.getAccountHolderID()).getFirstName();

			accountButton = new JButton(myCust + " 's Account");
			panel.add(accountButton);
			accountButton.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e) {
					AccountPage accpage = new AccountPage(userID, acc.getAccountNumber());
					dispose();
					
				}
			});
		}
//		for(AccountApplication aa : myEmployee.pendingApplications)
//		{
//			accountButton = new JButton(aa.getAccountHolder().getUsername() + " 's Account Application");
//			panel.add(accountButton);
//			accountButton.addActionListener(new ActionListener(){
//				public void actionPerformed(ActionEvent e) {
//					AccountApplicationPage accpage = new AccountApplicationPage(aa.getAccountHolder());
//					//dispose();
//					
//				}
//			});
		
//		}
		home = new JButton("Back");
		panel.add(home);
		home.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				MainMenu back = new MainMenu(userID);
				dispose();
			}
		});
		pack();
		setVisible(true);
		
	}

}
