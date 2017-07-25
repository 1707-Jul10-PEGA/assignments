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
			accountButton.setPreferredSize(new Dimension(160, 60));
			panel.add(accountButton);
			accountButton.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e) {
					AccountPage accpage = new AccountPage(userID, acc.getAccountNumber());
					dispose();
					
				}
			});
		}
		for(Account acc : BankData.getInstance().getCurrentApplicationAccounts())
		{
			myCust = BankData.getInstance().getUserByID(acc.getAccountHolderID()).getFirstName();
			accountButton = new JButton(myCust + " 's Account Application");
			accountButton.setPreferredSize(new Dimension(160, 60));
			panel.add(accountButton);
			accountButton.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e) {
					AccountApplicationPage accpage = new AccountApplicationPage(acc);
					//dispose();
					
				}
			});
		
		}
		home = new JButton("Login");
		home.setPreferredSize(new Dimension(160, 60));
		panel.add(home);
		home.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				LoginGUI back = new LoginGUI();
				dispose();
			}
		});
		pack();
		setLocationRelativeTo(null);
		setVisible(true);
		
	}

}
