package com.WilliamLewis.BankingApp.Login;

import javax.swing.*;

import com.WilliamLewis.BankingApp.BankData.BankData;
import com.WilliamLewis.BankingApp.BankData.Accounts.Account;

import java.awt.*;
import java.awt.event.*;

public class AccountPage extends JFrame {
	JButton deposit;
	JButton withdraw;
	JButton viewBalance;
	JButton goBack;
	JTextField inputValue;
	Container panel = getContentPane();

	public AccountPage(Integer userID, Integer accID) {
		super("Welcome to your accounts Page");
		Account currentAcc = BankData.getInstance().getAccount(accID);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		panel.setLayout(new GridLayout(10, 10));

		deposit = new JButton("Deposit");
		withdraw = new JButton("Withdraw");
		viewBalance = new JButton("viewBalance");
		inputValue = new JTextField(15);
		goBack = new JButton("To Accounts");

		panel.add(deposit);
		panel.add(withdraw);
		panel.add(viewBalance);
		panel.add(inputValue);
		panel.add(goBack);

		withdraw.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Account acc = BankData.getInstance().getAccount(accID);
				String amount = inputValue.getText();
				Double myDouble = Double.parseDouble(amount);
				acc.withdraw(myDouble);
			}
		});
		deposit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Account acc = BankData.getInstance().getAccount(accID);
				String amount = inputValue.getText();
				Double myDouble = Double.parseDouble(amount);
				acc.deposit(myDouble);

			}
		});
		viewBalance.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Account acc = BankData.getInstance().getAccount(accID);
				double myInt = acc.getAccountBalance();
				inputValue.setText("" + myInt);

			}
		});
		goBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MainMenu back = new MainMenu(userID);
				dispose();

			}
		});
		pack();
		setVisible(true);
	}

}
