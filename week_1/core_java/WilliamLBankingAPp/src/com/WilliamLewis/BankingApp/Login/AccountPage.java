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

	public AccountPage(String accountName, String role) {
		super(accountName);
		Integer currentAcc = BankData.getInstance().getAccountID(accountName);
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
				Account acc = BankData.getInstance().getAccount(currentAcc);
				String amount = inputValue.getText();
				Double myDouble = Double.parseDouble(amount);
				acc.withdraw(myDouble);
			}
		});
		deposit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Account acc = BankData.getInstance().getAccount(currentAcc);
				String amount = inputValue.getText();
				Double myDouble = Double.parseDouble(amount);
				acc.deposit(myDouble);

			}
		});
		viewBalance.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Account acc = BankData.getInstance().getAccount(currentAcc);
				double myInt = acc.getAccountBalance();
				inputValue.setText("" + myInt);

			}
		});
		goBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String[] info = role.split(":");
				switch (info[0].toLowerCase()) {
				case "admin":
					AdminPage admin = new AdminPage();
					dispose();
				case "employee":
					EmployeePage emp = new EmployeePage(info[1], info[2]);
					dispose();
				case "customer":
					CustomerPage cs = new CustomerPage(info[1], info[2]);
				}

				AdminPage admin = new AdminPage();
				dispose();

			}
		});
		pack();
		setVisible(true);
	}

}
