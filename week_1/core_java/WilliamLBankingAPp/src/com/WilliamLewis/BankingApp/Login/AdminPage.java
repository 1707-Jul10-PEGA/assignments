package com.WilliamLewis.BankingApp.Login;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

import com.WilliamLewis.BankingApp.BankData.BankData;
import com.WilliamLewis.BankingApp.BankData.Accounts.Account;


public class AdminPage extends JFrame{
	

	Container panel = getContentPane();
	
	
	public AdminPage(){
		super("Accounts");
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		panel.setLayout(new GridLayout(10, 10));
		JButton accountButton;
		
		for(Account acc : BankData.getInstance().getAccountList())
		{
			accountButton = new JButton(acc.getAccountHolder() + " 's Account");
			panel.add(accountButton);
			accountButton.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e) {
					AccountPage accpage = new AccountPage(acc.getAccountHolder(), "admin");
					dispose();
					
				}
			});
		}
		pack();
		setVisible(true);
		
	}

}
