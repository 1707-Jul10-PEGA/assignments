package com.WilliamLewis.BankingApp.Login;

import javax.swing.*;

import com.WilliamLewis.BankingApp.Applications.AccountApplication;
import com.WilliamLewis.BankingApp.BankData.BankData;
import com.WilliamLewis.BankingApp.BankData.Accounts.Account;
import com.WilliamLewis.BankingApp.Users.Customer;

import java.awt.*;
import java.awt.event.*;

public class AccountApplicationPage extends JFrame {
		JButton approve;
		JButton deny;
		Container panel = getContentPane();
		
		public AccountApplicationPage(Account acc){
			super(acc.getMyOwner().getFirstName() + "'s account Application");
			
			this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			panel.setLayout(new GridLayout(2, 2));
			
			approve = new JButton("Approve");
			deny = new JButton("Deny");
			
			panel.add(approve);
			panel.add(deny);
			
			approve.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e) {
					BankData.getInstance().approveApplication(acc);
					dispose();
				}
				
			});
			deny.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e) {
					BankData.getInstance().removeApp(acc);
					dispose();
				}
				
			});
			pack();
			setVisible(true);
			
			
		
		}
}
