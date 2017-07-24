package com.WilliamLewis.BankingApp.Login;

import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;

import com.WilliamLewis.BankingApp.BankData.BankData;
import com.WilliamLewis.BankingApp.BankData.Accounts.Account;
import com.WilliamLewis.BankingApp.Users.Customer;
import com.WilliamLewis.BankingApp.Users.Employee;

public class CustomerPage extends JFrame {

	Container panel = getContentPane();
	JButton home;
	public CustomerPage(Integer userID) {
		super("Accounts");
		
		
		ArrayList<Account> myAccs = BankData.getInstance().getHolderAccounts(userID);
		String myCust = BankData.getInstance().getUserByID(userID).getFirstName();
		
	
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		panel.setLayout(new GridLayout(10, 10));
		JButton accountButton;
		for (Account acc : myAccs) {
			accountButton = new JButton(myCust + "'s Account");
			panel.add(accountButton);
			accountButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					AccountPage accpage = new AccountPage(userID, acc.getAccountNumber());
					dispose();

				}
			});
		}
		JButton submitAccountRequest = new JButton("Request Account");
		panel.add(submitAccountRequest);
		submitAccountRequest.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			//	myCustomer.submitApplication();

			}
		});
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
