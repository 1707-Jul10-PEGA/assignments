package com.WilliamLewis.BankingApp.Login;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

import com.WilliamLewis.BankingApp.Applications.AccountApplication;
import com.WilliamLewis.BankingApp.BankData.BankData;
import com.WilliamLewis.BankingApp.BankData.Accounts.Account;


public class AdminPage extends JFrame{
	
	JButton home;
	Container panel = getContentPane();
	
	
	public AdminPage(Integer userID){
		super("Accounts");
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		panel.setLayout(new GridLayout(10, 10));
		JButton accountButton;
		String myCust;
		for(Account acc : BankData.getInstance().getAccountList())
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
//		for(AccountApplication aa : BankData.getInstance().getCurrentApplications())
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
//		
//		}
		home = new JButton("Login");
		panel.add(home);
		home.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				LoginGUI back = new LoginGUI();
				dispose();
			}
		});
		pack();
		setVisible(true);
		
	}

}
